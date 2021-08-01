package vn.fouridiots.product.specification;

import java.util.Optional;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import vn.fouridiots.product.model.*;
import vn.fouridiots.product.model.Category_;
import vn.fouridiots.product.model.LuminousFlux_;
import vn.fouridiots.product.model.Power_;
import vn.fouridiots.product.model.Product_;


/**
 * Product specification
 * @author DUY
 */
public class ProductSpecification {

    /**
     * Lọc sản phẩm bằng Category
     * @param name Category name
     */
    public static Specification<Product> hasCategory(Optional<String> name) {
        return (root, query, builder) -> {
            if(name.isPresent()) {
                Join<Product, Category> join = root.join(Product_.category, JoinType.LEFT);
                return builder.equal(join.get(Category_.name), name.get());
            }
            return null;
        };
    }

    /**
     * Lọc sản phẩm bằng power
     * @param power power value
     */
    public static Specification<Product> hasPower(Optional<Short> power) {
        return (root, query, builder) -> {
            if(power.filter(f -> f > 0).isPresent()) {
                Join<Product, Power> join = root.join(Product_.power, JoinType.LEFT);
                return builder.equal(join.get(Power_.value), power.get());
            }
            return null;
        };
    }

    /**
     * Lọc sản phẩm bằng luminous flux
     * @param flux luminous flux value
     */
    public static Specification<Product> hasFlux(Optional<Short> flux) {
        return (root, query, builder) -> {
            if(flux.filter(f -> f > 0).isPresent()) {
                Join<Product, LuminousFlux> join = root.join(Product_.luminousFlux, JoinType.LEFT);
                return builder.equal(join.get(LuminousFlux_.value), flux.get());
            }
            return null;
        };
    }
}
