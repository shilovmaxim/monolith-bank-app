package com.bankapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "cashback")
    private BigDecimal cashBack;

    @Column(name = "co_brand")
    private String coBrand;

    @Column(name = "is_virtual")
    private boolean virtual;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "card_duration")
    private Integer cardDuration;

    @ManyToOne
    @JoinColumn(name = "premium_id", nullable = false)
    PremiumStatus premiumStatus;

    @ManyToOne
    @JoinColumn(name = "payment_system_id", nullable = false)
    PaymentSystem paymentSystem;

    @OneToMany(mappedBy = "product",
            orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Card> cards;
}
