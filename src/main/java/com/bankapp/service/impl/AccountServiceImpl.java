package com.bankapp.service.impl;

import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.entity.Account;
import com.bankapp.entity.Product;
import com.bankapp.exception.NotFoundException;
import com.bankapp.mapper.AccountMapper;
import com.bankapp.repository.AccountRepository;
import com.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import static com.bankapp.service.util.DefaultConstants.BALANCE;
import static com.bankapp.service.util.DefaultConstants.PERIOD;

/**
 * @author Shilov Maxim
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponse create(AccountRequest accountRequest) {
        Account account = accountRepository.save(accountMapper.mapTo(accountRequest));

        return accountMapper.mapTo(account);
    }

    @Override
    public Account create(UUID clientId, Product product) {
        return Account.builder()
                .accountNumber(String.valueOf(accountRepository.count() + 1))
                .clientId(clientId)
                .currencyCode(product.getCurrencyCode())
                .currentBalance(BALANCE)
                .openDate(Instant.now())
                .closeDate(Instant.now().plus(PERIOD, ChronoUnit.YEARS))
                .active(true)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponse getById(String id) {
        Account account = getById(UUID.fromString(id));

        return accountMapper.mapTo(account);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponse getByNumber(String number) {
        Account account = getByAccountNumber(number);

        return accountMapper.mapTo(account);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountResponse> getAllClientAccounts(String clientId) {
        List<Account> accounts = accountRepository.findAllByClientId(UUID.fromString(clientId));
        checkEmptyListAccounts(accounts);

        return accounts.stream()
                .map(accountMapper::mapTo)
                .toList();
    }

    @Override
    @Transactional
    public List<AccountResponse> getAllActiveClientAccounts(String clientId) {
        List<Account> accounts = accountRepository.findAllActiveAccounts(UUID.fromString(clientId));
        checkEmptyListAccounts(accounts);

        return accounts.stream()
                .map(accountMapper::mapTo)
                .toList();
    }

    @Override
    @Transactional
    public void terminateAccount(String id) {
        Account account = getById(UUID.fromString(id));
        account.setActive(false);
    }

    @Override
    @Transactional
    public void delete(String id) {
        accountRepository.deleteById(UUID.fromString(id));
    }

    private Account getById(UUID id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Account.class, id)
        );
    }

    private Account getByAccountNumber(String number) {
        return accountRepository.findByAccountNumber(number).orElseThrow(
                () -> new NotFoundException(Account.class, number));
    }

    private void checkEmptyListAccounts(List<Account> accounts) {
        if (accounts.isEmpty()) {
            throw new NotFoundException(Account.class);
        }
    }
}
