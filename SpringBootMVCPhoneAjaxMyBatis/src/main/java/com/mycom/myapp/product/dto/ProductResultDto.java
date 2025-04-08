package com.mycom.myapp.product.dto;

import java.util.List;

public class ProductResultDto {
    private String result;
    private List<ProductDto> list;
    private int count;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ProductDto> getList() {
        return list;
    }

    public void setList(List<ProductDto> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
