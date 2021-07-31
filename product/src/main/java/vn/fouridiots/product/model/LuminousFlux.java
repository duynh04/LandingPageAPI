package vn.fouridiots.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

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
