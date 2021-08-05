package vn.fouridiots.product.model;

import javax.persistence.*;
import lombok.*;

/**
 * @author DUY
 * @author ThanhHN
 */
@Data
@Entity
@Table(name = "product")
@NamedEntityGraph(
        name = "product-eager-fetch",
        attributeNodes = {
                @NamedAttributeNode("category"),
                @NamedAttributeNode("power"),
                @NamedAttributeNode("luminousFlux"),
                @NamedAttributeNode("productImage")
        }
)

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "image_id",
            referencedColumnName = "id"
    )
    private ProductImage productImage;

    @Column(length = 50)
    private String name;

    @Column(length = 250)
    private String description;

    @Column
    private int amount;

    @Column(length = 50)
    private String Ip;
}
