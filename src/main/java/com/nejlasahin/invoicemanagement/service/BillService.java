package com.nejlasahin.invoicemanagement.service;

import com.nejlasahin.invoicemanagement.converter.BillConverter;
import com.nejlasahin.invoicemanagement.dto.request.BillRequestDto;
import com.nejlasahin.invoicemanagement.dto.response.BillResponseDto;
import com.nejlasahin.invoicemanagement.entity.Bill;
import com.nejlasahin.invoicemanagement.entity.Product;
import com.nejlasahin.invoicemanagement.entity.User;
import com.nejlasahin.invoicemanagement.enumeration.BillStatus;
import com.nejlasahin.invoicemanagement.enumeration.ProductMessage;
import com.nejlasahin.invoicemanagement.enumeration.UserMessage;
import com.nejlasahin.invoicemanagement.exceptions.ProductNotFoundException;
import com.nejlasahin.invoicemanagement.exceptions.UserNotFoundException;
import com.nejlasahin.invoicemanagement.repository.BillRepository;
import com.nejlasahin.invoicemanagement.repository.ProductRepository;
import com.nejlasahin.invoicemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillService {
    @Value("${invoice.management.app.limit}")
    private BigDecimal APP_LIMIT;

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BillConverter billConverter;

    public BillResponseDto create(Authentication authentication, BillRequestDto request) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(UserMessage.USER_NOT_FOUND));
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(ProductMessage.PRODUCT_NOT_FOUND));

        BigDecimal totalAmount = billRepository.sumByStatusAndUser(user.getId(), BillStatus.APPROVED);
        BigDecimal calculateAmount = totalAmount.add(request.getBillAmount());
        BillStatus status = getStatus(calculateAmount);
        String billNo = UUID.randomUUID().toString();
        Bill saveBill = billRepository.save(BillConverter.toBill(user, product, billNo, request.getBillAmount(), status));
        return BillConverter.toBillResponseDto(saveBill);
    }

    private BillStatus getStatus(BigDecimal calculateAmount) {
        BillStatus status;
        if (calculateAmount.compareTo(APP_LIMIT) > 0) {
            status = BillStatus.NOT_APPROVED;
        } else {
            status = BillStatus.APPROVED;
        }
        return status;
    }

    public List<BillResponseDto> getAll(BillStatus status) {
        List<Bill> bills = billRepository.findAllByStatus(status);
        return BillConverter.toBillResponseDtoList(bills);
    }
}
