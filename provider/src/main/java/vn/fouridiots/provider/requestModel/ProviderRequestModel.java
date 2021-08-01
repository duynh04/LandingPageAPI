package vn.fouridiots.provider.requestModel;

import lombok.Data;

/**
 * @author BachCC
 */
@Data
public class ProviderRequestModel {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String taxCode;
    private String status;
}
