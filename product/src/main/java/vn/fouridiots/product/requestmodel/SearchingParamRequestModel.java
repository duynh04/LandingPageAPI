package vn.fouridiots.product.requestmodel;

import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * @author DUY
 */
@Data
public class SearchingParamRequestModel {

    private List<String> category;
    private List<Short> power;
    private List<Short> flux;

    private short size;
}
