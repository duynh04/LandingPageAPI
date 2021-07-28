package vn.fouridiots.product.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "power_id",
            referencedColumnName = "id"
    )
    private Power power;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "flux_id",
            referencedColumnName = "id"
    )
    private LuminousFlux luminousFlux;
}
