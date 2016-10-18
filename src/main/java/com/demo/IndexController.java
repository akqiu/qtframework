package com.demo;

//import javax.inject.Inject;

/**
 * Created by qiutian on 16-9-9.
 */
public class IndexController {

    //@Inject
    public ProductService bookProductService;

    public static void main(String[] args) throws Exception {

        IndexController controller = new IndexController();
        Product p = controller.bookProductService.getNewProduct();
        System.out.println("Product:"+p.toString());

    }
}
