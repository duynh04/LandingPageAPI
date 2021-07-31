package vn.fouridiots.provider.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fouridiots.provider.model.Provider;

/**
 * @author BachCC
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Page<Provider> findAllByproviderName(String nameProvider, Pageable pageable);

    Page<Provider> findAllBytaxCode(String taxCode, Pageable pageable);

    Provider findAllByisDeleteIsFalseAndIdIs(Long id);
}
