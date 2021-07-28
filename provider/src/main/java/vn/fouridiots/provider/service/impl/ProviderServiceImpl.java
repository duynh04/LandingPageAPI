package vn.fouridiots.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fouridiots.provider.dto.ProviderDto;
import vn.fouridiots.provider.model.Provider;
import vn.fouridiots.provider.repository.ProviderRepository;
import vn.fouridiots.provider.service.ProviderService;

//CREATE BY BACHCC
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderRepository providerRepository;

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
    public void editProvider(ProviderDto providerDto, Long id) {
        Provider provider = findProviderById(id);
        provider.setProviderAddress(providerDto.getProviderName());
        provider.setProviderAddress(providerDto.getProviderEmail());
        provider.setProviderAddress(providerDto.getProviderAddress());
        provider.setProviderAddress(providerDto.getProviderTaxCode());
        provider.setProviderAddress(providerDto.getProviderStatus());
        this.providerRepository.save(provider);
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
