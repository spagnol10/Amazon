package br.com.well.api.amazon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AMZ_ORDER")
public class Order extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MOMENT")
    private Instant moment;

    @Column(name = "ORDER_STATUS")
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private User client;

    @OneToMany(mappedBy = "ID.ORDER")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "ORDER", cascade = CascadeType.ALL)
    private Payment payment;

}
