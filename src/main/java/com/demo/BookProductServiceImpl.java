package com.demo;

/**
 * Created by qiutian on 16-9-9.
 */
public class BookProductServiceImpl extends BaseProductServiceImpl {

    public Product getNewProduct() {
        //product = new Product();
        product.setProductName("论程序员的自我修养");
        product.setProductNo("ISBN 999");
        return product;
    }

}
