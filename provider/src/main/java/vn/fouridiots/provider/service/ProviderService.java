package vn.fouridiots.provider.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fouridiots.provider.dto.ProviderDto;
import vn.fouridiots.provider.model.Provider;

public interface ProviderService {

    //CREATE BY BACHCC
    Page<Provider> findAllProvider(Pageable pageable);

    //CREATE BY BACHCC
    Page<Provider> findProviderByNameProvider(String providerName, Pageable pageable);

    //CREATE BY BACHCC
    Page<Provider> findProviderByTaxCodeProvider(String taxCodeProvider, Pageable pageable);

    //CREATE BY BACHCC
    Provider findProviderById(Long id);

    //CREATE BY BACHCC
    void editProvider(ProviderDto providerDto, Long id);

    //CREATE BY BACHCC
    void createProvider(Provider provider);

    //CREATE BY BACHCC
    void deleteProvider(Provider provider);
}
