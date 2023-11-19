package vn.fouridiots.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ThanhHN
 */
@Data
@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 250)
    private String link;
}
