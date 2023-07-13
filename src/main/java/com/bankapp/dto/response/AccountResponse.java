package com.bankapp.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Shilov Maxim
 */

public record AccountResponse(UUID id, String accountNumber, UUID clientId, String currencyCode,
                              BigDecimal currentBalance, LocalDate openDate, LocalDate closeDate, boolean active) {

}
