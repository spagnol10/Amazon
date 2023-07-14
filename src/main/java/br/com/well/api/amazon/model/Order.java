package br.com.well.api.amazon.model;

import br.com.well.api.amazon.model.AbstractEntity;
import br.com.well.api.amazon.model.Address;
import br.com.well.api.amazon.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

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

    @Column(name = "MOMENT")
    private Instant moment;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "ID_ORDER_USER", referencedColumnName = "ID")
    private User client;
}
