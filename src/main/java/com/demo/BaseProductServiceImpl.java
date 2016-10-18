package com.demo;

//import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created by qiutian on 16-9-9.
 */
public abstract class BaseProductServiceImpl implements ProductService {

    @Autowired
    protected Product product;

    public abstract Product getNewProduct();
}
