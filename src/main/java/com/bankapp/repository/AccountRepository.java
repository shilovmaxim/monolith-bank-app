package com.bankapp.repository;

import com.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Card repository
 *
 * @author Shilov Maxim
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    /**
     * Return account {@link Account} by number.
     *
     * @param number account;
     */
    Optional<Account> findByAccountNumber(String number);

    /**
     * Return list of accounts by client id
     * @param clientId {@link UUID} Client ID
     * @return List of Accounts
     */
    List<Account> findAllByClientId(UUID clientId);

    /**
     * Return list of active accounts {@link Account} with specific client id.
     *
     * @param clientId {@link UUID} client id
     * @return List of {@link Account}
     */
    @Query("from Account a where a.clientId=:clientId and a.active=true")
    List<Account> findAllActiveAccounts(UUID clientId);
}
