package vn.fouridiots.provider.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fouridiots.provider.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    //CREATE BY BACHCC
    Page<Provider> findAllByproviderName(String nameProvider, Pageable pageable);

    //CREATE BY BACHCC
    Page<Provider> findAllBytaxCode(String taxCode, Pageable pageable);

    //CREATE BY BACHCC
    Provider findAllByisDeleteIsFalseAndIdIs(Long id);
}
