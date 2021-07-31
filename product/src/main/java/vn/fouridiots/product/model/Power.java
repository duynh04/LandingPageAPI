package vn.fouridiots.product.model;

import lombok.Data;

import javax.persistence.*;

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
