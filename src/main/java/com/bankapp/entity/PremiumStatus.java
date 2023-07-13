package com.bankapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "premium_status", schema = "public")
public class PremiumStatus {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "premiumStatus",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    private List<Product> products;
}
