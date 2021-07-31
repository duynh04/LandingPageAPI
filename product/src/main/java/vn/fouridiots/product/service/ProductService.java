package vn.fouridiots.product.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.EntityGraph;
import vn.fouridiots.product.model.Product;

import java.util.List;

/**
 * @author DUY
 * @author ThanhNT
 */
public interface ProductService {

    @EntityGraph(value = "product-eager-fetch", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Product> findProductBy(Predicate predicate);
}
