package vn.fouridiots.provider.requestModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BachCC
 */
@Data
@Getter
@Setter
public class ProviderRequestModel {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String taxCode;
    private String status;
}
