package vn.fouridiots.product.model;

import javax.persistence.*;

import lombok.Data;

/**
 * @author DUY
 */
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;
}
