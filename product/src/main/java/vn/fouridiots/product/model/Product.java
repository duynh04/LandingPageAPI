package vn.fouridiots.product.model;

import javax.persistence.*;
import lombok.*;

/**
 * @author DUY
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
}
