package vn.fouridiots.product.specification;

import java.util.List;
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
     * Category filter
     * @param name Category name
     */
    public static Specification<Product> hasCategory(List<String> name) {
        return (root, query, builder) -> {
            if(name != null) {
                Join<Product, Category> categoryJoin = root.join(Product_.category, JoinType.LEFT);
                return categoryJoin.get(Category_.name).in(name);
            }
            return null;
        };
    }

    /**
     * Power filter
     * @param power power value
     */
    public static Specification<Product> hasPower(List<Short> power) {
        return (root, query, builder) -> {
            if(power != null) {
                Join<Product, Power> powerJoin = root.join(Product_.power, JoinType.LEFT);
                return powerJoin.get(Power_.value).in(power);
            }
            return null;
        };
    }

    /**
     * luminous flux filter
     * @param flux luminous flux value
     */
    public static Specification<Product> hasFlux(List<Short> flux) {
        return (root, query, builder) -> {
            if(flux != null) {
                Join<Product, LuminousFlux> luminousFluxJoin = root.join(Product_.luminousFlux, JoinType.LEFT);
                return luminousFluxJoin.in(flux);
            }
            return null;
        };
    }
}
