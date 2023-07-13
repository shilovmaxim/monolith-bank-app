package com.bankapp.repository;

import com.bankapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Card repository
 *
 * @author Shilov Maxim
 */
public interface CardRepository extends JpaRepository<Card, UUID> {

    /**
     * Return boolean existing Card by card number.
     *
     * @param clientId {@link String} card number
     * @return boolean
     */

    @Query("from Card c where c.account.clientId =:clientId and " +
            "(c.status = 'ACTIVE' or c.status = 'PENDING' or c.status = 'BLOCKED' or c.status = 'EXPIRED')")
    @Transactional
    List<Card> getCardsByClientId(@Param("clientId") UUID clientId);

}
