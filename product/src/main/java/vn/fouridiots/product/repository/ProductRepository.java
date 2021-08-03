package vn.fouridiots.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.fouridiots.product.model.Product;

/**
 * @author DUY
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @EntityGraph("product-eager-fetch")
    Page<Product> findAll(Pageable pageable);

    @EntityGraph("product-eager-fetch")
    Page<Product> findAll(Specification<Product> product, Pageable pageable);
}
