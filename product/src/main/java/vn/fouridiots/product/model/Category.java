package vn.fouridiots.product.model;

import lombok.Data;

import javax.persistence.*;

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
