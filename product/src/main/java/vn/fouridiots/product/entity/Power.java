package vn.fouridiots.product.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * @author DUY
 */
@Data
@Entity
@Table(name = "power")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private short value;
}
