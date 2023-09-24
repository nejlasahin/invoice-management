package com.nejlasahin.invoicemanagement.converter;

import com.nejlasahin.invoicemanagement.dto.response.BillResponseDto;
import com.nejlasahin.invoicemanagement.entity.Bill;
import com.nejlasahin.invoicemanagement.entity.Product;
import com.nejlasahin.invoicemanagement.entity.User;
import com.nejlasahin.invoicemanagement.enumeration.BillStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillConverter {

    public static Bill toBill(User user, Product product, String billNo, BigDecimal billAmount, BillStatus status) {
        return Bill.builder()
                .user(user)
                .product(product)
                .billNo(billNo)
                .billAmount(billAmount)
                .status(status)
                .build();
    }

    public static BillResponseDto toBillResponseDto(Bill bill) {
        return BillResponseDto.builder()
                .email(bill.getUser().getEmail())
                .productName(bill.getProduct().getProductName())
                .billAmount(bill.getBillAmount())
                .status(bill.getStatus())
                .build();
    }

    public static List<BillResponseDto> toBillResponseDtoList(List<Bill> bills) {
        if (bills.isEmpty()) {
            return List.of();
        }
        return bills.stream().map(BillConverter::toBillResponseDto).collect(Collectors.toList());
    }

}
