package vn.fouridiots.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import vn.fouridiots.product.model.Product;

import java.util.List;

/**
 * @author DUY
 * @author ThanhNT
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
}
