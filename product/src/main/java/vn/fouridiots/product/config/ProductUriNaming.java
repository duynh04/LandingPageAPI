package vn.fouridiots.product.config;

/**
 * @author DUY
 */
public class ProductUriNaming {
    public final static String API_VERSION = "api/v1";
    public final static String PRODUCT = "/product";

    /**
     * Uri template
     * Example: /product-filter/1?category=n1&?power=v1&flux=v2
     */
    public final static String PRODUCT_FILTER = "/product-filter/{page}";
}
