package vn.fouridiots.provider.interfaceMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.fouridiots.provider.model.Provider;
import vn.fouridiots.provider.requestModel.ProviderRequestModel;

/**
 * @author BachCC
 */
@Mapper
public interface ProviderMapper {

    @Mappings({
            @Mapping(target = "name", source = "providerRequestModel.name"),
            @Mapping(target = "email", source = "providerRequestModel.email"),
            @Mapping(target = "address", source = "providerRequestModel.address"),
            @Mapping(target = "taxCode", source = "providerRequestModel.taxCode"),
            @Mapping(target = "status", source = "providerRequestModel.status")
    })
    Provider providerMapper(ProviderRequestModel providerRequestModel, Long id);
}
