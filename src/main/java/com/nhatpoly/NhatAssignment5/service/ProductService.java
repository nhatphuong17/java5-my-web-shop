package com.nhatpoly.NhatAssignment5.service;


import com.nhatpoly.NhatAssignment5.model.Product;


import java.util.List;




public interface ProductService {
    List<Product> findAllProduct();
    Product findProductById(Integer productid);
    void saveProduct(Product product);
    void deleteProduct(Integer productid);



}
