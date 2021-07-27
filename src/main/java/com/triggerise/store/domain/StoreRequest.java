package com.triggerise.store.domain;

import java.util.List;

public class StoreRequest {

    private List<String> productList;

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }
}

