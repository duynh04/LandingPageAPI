package vn.fouridiots.provider.dto;

import lombok.Data;

@Data
public class ProviderDto {
    private Long id;
    private String providerName;
    private String providerEmail;
    private String providerAddress;
    private String providerTaxCode;
    private String providerStatus;
}
