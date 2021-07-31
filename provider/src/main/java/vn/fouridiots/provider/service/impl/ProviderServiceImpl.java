package vn.fouridiots.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fouridiots.provider.interfaceMapper.impl.ProviderMapperImpl;
import vn.fouridiots.provider.requestModel.ProviderRequestModel;
import vn.fouridiots.provider.model.Provider;
import vn.fouridiots.provider.repository.ProviderRepository;
import vn.fouridiots.provider.service.ProviderService;

/**
 * @author BachCC
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Page<Provider> findAllProvider(Pageable pageable) {
        return providerRepository.findAll(pageable);
    }

    @Override
    public Page<Provider> findProviderByNameProvider(String providerName, Pageable pageable) {
        return providerRepository.findAllByproviderName(providerName, pageable);
    }

    @Override
    public Page<Provider> findProviderByTaxCodeProvider(String taxCodeProvider, Pageable pageable) {
        return providerRepository.findAllBytaxCode(taxCodeProvider, pageable);
    }

    @Override
    public Provider findProviderById(Long id) {
        return providerRepository.findById(id).orElse(null);
    }

    @Override
    public Provider editProvider(ProviderRequestModel providerRequestModel, Long id) {
        ProviderMapperImpl providerMapper = new ProviderMapperImpl();
        return providerMapper.providerMapper(providerRequestModel, id);
    }

    @Override
    public void createProvider(Provider provider) {
        provider = new Provider();
        this.providerRepository.save(provider);
    }

    @Override
    public void deleteProvider(Provider provider) {
        provider.setIsDelete(false);
        providerRepository.save(provider);
    }
}
