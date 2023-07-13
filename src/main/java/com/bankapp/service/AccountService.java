package com.bankapp.service;

import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.entity.Account;
import com.bankapp.entity.Product;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

/**
 * service for operations with account
 *
 * @author Shilov Maxim
 */
public interface AccountService {

    /**
     * creating new account by api
     *
     * @param accountRequest (data for creating account)
     * @return new Account
     */
    AccountResponse create(@Valid AccountRequest accountRequest);

    /**
     * creating new account due to creating card
     *
     * @param clientId (data for creating account)
     * @param product (data for creating account)
     * @return {@link Account}
     */
    Account create(UUID clientId, Product product);

    /**
     * Searching for {@link Account} by id
     *
     * @param id of card
     * @return {@link Account}
     */
    AccountResponse getById(String id);

    /**
     * Searching for {@link Account} by number
     *
     * @param number of account
     * @return {@link Account}
     */
    AccountResponse getByNumber(String number);

    /**
     * Searching for {@link List<Account>} by client id
     *
     * @param clientId in cards
     * @return {@link List<Account>}
     */
    List<AccountResponse> getAllClientAccounts(String clientId);

    /**
     * Searching for all ACTIVE {@link List<Account>} by client id
     *
     * @param clientId in cards
     * @return {@link List<Account>}
     */
    List<AccountResponse> getAllActiveClientAccounts(String clientId);

    /**
     * change status to "inactive" by setting false to field boolean "active"
     *
     * @param id of account
     */
    void terminateAccount(String id);

    /**
     * delete account by id
     *
     * @param id of account
     */
    void delete(String id);
}
