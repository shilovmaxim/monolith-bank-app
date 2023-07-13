package com.bankapp.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

/**
 * @author Shilov Maxim
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account", schema = "public")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "client_id", unique = true)
    private UUID clientId;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "open_date")
    private Instant openDate;

    @Column(name = "close_date")
    private Instant closeDate;

    @Column(name = "is_active")
    private boolean active;

    @OneToMany(mappedBy = "account",
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @ToString.Exclude
//    TODO Лучше переделать на Set <Card> cards
    private List<Card> cards;
}
