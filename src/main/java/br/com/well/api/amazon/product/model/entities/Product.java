package br.com.well.api.amazon.product.model.entities;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.well.api.amazon.product.model.enums.EnumPlateCategory;
import br.com.well.api.amazon.product.model.enums.EnumPlateSize;
import br.com.well.api.amazon.user.model.enums.EnumMessageTypeUser;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "AMZ_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DISCOUNT")
    private Double discount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URI")
    private String imageUri;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "PLATE_SIZE")
    @Enumerated(EnumType.STRING)
    private EnumPlateSize plateSize;

    @Column
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "AMZ_PLATE_CATEGORIES")
    @ElementCollection(targetClass = EnumPlateCategory.class)
    private List<EnumPlateCategory> categoryList;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private Instant createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private Instant updatedAt;

    @Transient
    private EnumMessageTypeProduct messageType;
}
