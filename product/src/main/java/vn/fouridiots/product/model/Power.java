package vn.fouridiots.product.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "power")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private short value;
}
