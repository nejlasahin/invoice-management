package com.nejlasahin.invoicemanagement.dto.response;

import com.nejlasahin.invoicemanagement.enumeration.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillResponseDto {
    String email;
    String productName;
    BigDecimal billAmount;
    BillStatus status;
}
