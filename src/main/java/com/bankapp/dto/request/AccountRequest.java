package com.bankapp.dto.request;

import com.bankapp.validation.annotation.UuidCheck;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.UUID;

import static com.bankapp.dto.util.OpenApiConstants.*;

/**
 * @author Shilov Maxim
 */

public record AccountRequest(@Schema(defaultValue = ACCOUNT_NUMBER) @NotEmpty String accountNumber,
                             @Schema(defaultValue = CLIENT_ID) @UuidCheck UUID clientId,
                             @Schema(defaultValue = CURRENCY_CODE) @Size(min = 3, max = 3) String currencyCode,
                             Instant openDate, Instant closeDate) {

}
