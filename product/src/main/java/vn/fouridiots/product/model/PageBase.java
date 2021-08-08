package vn.fouridiots.product.model;

import lombok.Data;

import java.util.List;

@Data
public class PageBase<T> {

    List<T> contents;
    Integer currentPage;
    Integer sizePage;
    Integer totalPages;
    Integer totalElements;
    Integer numberOfElements;
}
