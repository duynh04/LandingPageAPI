package vn.fouridiots.product.model;

import javax.persistence.*;

import lombok.Data;
/**
 * @author DUY
 */
@Data
@Entity
@Table(name = "luminous_flux")
public class LuminousFlux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private short value;
}
