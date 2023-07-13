package com.bankapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

/**
 * @author Shilov Maxim
 */

@Entity
@Data
@Table(name = "payment_system", schema = "public")
public class PaymentSystem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "system", nullable = false)
    private String system;

    @OneToMany(mappedBy = "paymentSystem",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    private List<Product> products;
}
