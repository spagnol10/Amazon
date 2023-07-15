package br.com.well.api.amazon.product.model.entities;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.well.api.amazon.product.model.enums.EnumPlateCategory;
import br.com.well.api.amazon.product.model.enums.EnumPlateSize;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @CollectionTable(name = "DF_PLATE_CATEGORIES")
    @ElementCollection(targetClass = EnumPlateCategory.class)
    private List<EnumPlateCategory> categoryList;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT")
    private Date updatedAt;

}
