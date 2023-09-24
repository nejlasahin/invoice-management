package com.nejlasahin.invoicemanagement.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequestDto {

    @Schema(example = "2", description = "this filed use to pass product info")
    Long productId;

    @Schema(example = "10", description = "this filed use to pass bill amount")
    BigDecimal billAmount;
}
