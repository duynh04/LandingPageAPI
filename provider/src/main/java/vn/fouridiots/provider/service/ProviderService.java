package vn.fouridiots.provider.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fouridiots.provider.requestModel.ProviderRequestModel;
import vn.fouridiots.provider.model.Provider;

/**
 * @author BachCC
 */
public interface ProviderService {

    Page<Provider> findAllProvider(Pageable pageable);

    Page<Provider> findProviderByNameProvider(String providerName, Pageable pageable);

    Page<Provider> findProviderByTaxCodeProvider(String taxCodeProvider, Pageable pageable);

    Provider findProviderById(Long id);

    Provider editProvider(ProviderRequestModel providerRequestModel, Long id);

    void createProvider(Provider provider);

    void deleteProvider(Provider provider);
}
