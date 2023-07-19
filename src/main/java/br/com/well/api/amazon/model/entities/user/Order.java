package br.com.well.api.amazon.model.entities.user;

import java.time.Instant;
import java.util.List;

import br.com.well.api.amazon.model.entities.AbstractEntity;
import br.com.well.api.amazon.model.entities.product.ProductCart;
import br.com.well.api.amazon.model.entities.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AMZ_ORDER")
public class Order extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Column(name = "MOMENT")
    private Instant moment;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "ID_ORDER_USER", referencedColumnName = "ID")
    private User client;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<ProductCart> productOrderList;
}
