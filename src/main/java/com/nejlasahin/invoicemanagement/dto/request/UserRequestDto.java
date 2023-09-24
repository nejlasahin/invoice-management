package com.nejlasahin.invoicemanagement.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema
public class UserRequestDto {

    @Schema(example = "johndoe@invoice.com", description = "this filed use to pass email")
    private String email;

    @Schema(example = "456789", description = "this filed use to pass password")
    private String password;
}
