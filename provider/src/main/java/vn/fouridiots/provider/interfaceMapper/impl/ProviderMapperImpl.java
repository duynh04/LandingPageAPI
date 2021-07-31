package vn.fouridiots.provider.interfaceMapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fouridiots.provider.interfaceMapper.ProviderMapper;
import vn.fouridiots.provider.model.Provider;
import vn.fouridiots.provider.repository.ProviderRepository;
import vn.fouridiots.provider.requestModel.ProviderRequestModel;
import vn.fouridiots.provider.service.impl.ProviderServiceImpl;

/**
 * @author BachCC
 */
@Service
public class ProviderMapperImpl implements ProviderMapper {

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    ProviderServiceImpl providerService;

    @Override
    public Provider providerMapper(ProviderRequestModel providerRequestModel, Long id) {
        if (providerRequestModel == null) {
            return null;
        }
        Provider provider;
        provider = providerService.findProviderById(id);
        provider.setName(providerRequestModel.getName());
        provider.setEmail(providerRequestModel.getEmail());
        provider.setAddress(providerRequestModel.getAddress());
        provider.setTaxCode(providerRequestModel.getTaxCode());
        provider.setStatus(providerRequestModel.getStatus());
        providerRepository.save(provider);
        return provider;
    }
}
