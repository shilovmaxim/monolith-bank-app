package com.bankapp.service.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Shilov Maxim
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultConstants {

    public static final String CURRENCY = "USD";
    public static final BigDecimal BALANCE = BigDecimal.ZERO;
    public static final int PERIOD = 10;
    public static final String BANK_IDENTIFIER = "13579";
    public static final String FAILED_TRANSFER_STATUS_ID = "1L";
    public static final String SUCCESS_TRANSFER_STATUS_ID = "2L";
    public static final String CARD_TRANSFER_TYPE_ID = "1L";
    public static final String DEPOSIT_TRANSFER_TYPE_ID = "2L";
    public static final int BALANCE_THRESHOLD = 0;
    public static final Long FAILED_STATUS_ID = 1L;
    public static final Long SUCCESS_STATUS_ID = 2L;
}
