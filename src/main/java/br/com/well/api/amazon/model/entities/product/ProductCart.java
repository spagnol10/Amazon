package br.com.well.api.amazon.model.entities.product;

import br.com.well.api.amazon.model.entities.AbstractEntity;
import br.com.well.api.amazon.model.entities.user.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AMZ_PRODUCT_CART")
public class ProductCart extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "ID_CART", referencedColumnName = "ID")
    @ManyToOne
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER", referencedColumnName = "ID")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "ACTIVE")
    private boolean active = false;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

}