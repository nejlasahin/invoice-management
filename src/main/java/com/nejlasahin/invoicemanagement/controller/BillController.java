package com.nejlasahin.invoicemanagement.controller;

import com.nejlasahin.invoicemanagement.dto.request.BillRequestDto;
import com.nejlasahin.invoicemanagement.dto.response.BillResponseDto;
import com.nejlasahin.invoicemanagement.enumeration.BillMessage;
import com.nejlasahin.invoicemanagement.enumeration.BillStatus;
import com.nejlasahin.invoicemanagement.generic.RestResponse;
import com.nejlasahin.invoicemanagement.service.BillService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
@SecurityRequirement(name = "in-memory")
@Tag(name = "Bill", description = "Endpoints for managing bill")
public class BillController {

    private final BillService billService;

    @PostMapping("/create")
    public ResponseEntity create(Authentication authentication, @RequestBody BillRequestDto request) {
        BillResponseDto billResponseDto = billService.create(authentication, request);
        if (billResponseDto.getStatus().equals(BillStatus.APPROVED)) {
            return new ResponseEntity<>(RestResponse.of(billResponseDto, BillMessage.SUCCESS), HttpStatus.OK);
        }

        return new ResponseEntity<>(RestResponse.error(billResponseDto, BillMessage.FAILED), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all/{status}")
    public ResponseEntity getAll(@PathVariable("status") BillStatus status) {
        return new ResponseEntity<>(RestResponse.of(billService.getAll(status), BillMessage.SUCCESS), HttpStatus.OK);
    }
}
