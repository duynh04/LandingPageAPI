package vn.fouridiots.provider.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

//CREATE BY BACHCC
@Entity
@Table(name = "provider")
@Getter
@Setter
@NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long id;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "provider_email")
    private String providerEmail;

    @Column(name = "provider_address")
    private String providerAddress;

    @Column(name = "provider_taxCode")
    private String providerTaxCode;

    @Column(name = "provider_status")
    private String providerStatus;

    @Column(name = "isDelete")
    private Boolean isDelete;
}
