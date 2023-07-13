package com.bankapp.mapper;

import com.bankapp.config.MapperConfig;
import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.entity.Account;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static com.bankapp.service.util.DefaultConstants.PERIOD;

/**
 * @author Shilov Maxim
 */

@Mapper(config = MapperConfig.class)
public interface AccountMapper {

    @Mapping(target = "currentBalance", expression = "java(BigDecimal.ZERO)")
    @Mapping(target = "active", constant = "true")
    Account mapTo(AccountRequest accountRequest);

    @Mapping(target = "openDate", expression = "java(LocalDate.ofInstant(java.time.Instant.now(), java.time.ZoneId.systemDefault()))")
    @Mapping(target = "closeDate", expression = "java(LocalDate.ofInstant(java.time.Instant.now(), java.time.ZoneId.systemDefault()))")
    AccountResponse mapTo(Account account);

    @AfterMapping
    default void setData(@MappingTarget Account account) {
        account.setAccountNumber("12236");
        account.setOpenDate(Instant.now());
        account.setCloseDate(Instant.now().plus(PERIOD, ChronoUnit.YEARS));
    }
}
