package br.com.well.api.amazon.model.entities.product;

import br.com.well.api.amazon.model.entities.AbstractEntity;
import br.com.well.api.amazon.model.entities.product.ProductCart;
import br.com.well.api.amazon.model.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AMZ_CART")
public class Cart extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart", orphanRemoval = false)
    private List<ProductCart> productCartList;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "ACTIVE")
    private boolean active;
}
