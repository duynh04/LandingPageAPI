package vn.fouridiots.provider.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/**
 * @author BachCC
 */
@Entity
@Table(name = "provider")
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long id;

    @Column(name = "provider_name")
    private String name;

    @Column(name = "provider_email")
    private String email;

    @Column(name = "provider_address")
    private String address;

    @Column(name = "provider_taxCode")
    private String taxCode;

    @Column(name = "provider_status")
    private String status;

    @Column(name = "isDelete")
    private Boolean isDelete;
}
