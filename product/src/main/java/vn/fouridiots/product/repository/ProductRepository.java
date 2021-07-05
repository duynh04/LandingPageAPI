package vn.fouridiots.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.fouridiots.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
