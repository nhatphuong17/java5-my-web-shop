package com.nhatpoly.NhatAssignment5.service;

import com.nhatpoly.NhatAssignment5.model.Product;
import com.nhatpoly.NhatAssignment5.reponseitory.ProductReponseitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServicelmpl implements ProductService {
    @Autowired
    ProductReponseitory repo;
    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) repo.findAll();
    }

    @Override
    public Product findProductById(Integer productid) {

        return  repo.findById(productid).get();
    }

    @Override
    public void saveProduct(Product product) {
        repo.save(product);

    }

    @Override
    public void deleteProduct(Integer id) {
        repo.deleteById(id);

    }
}
