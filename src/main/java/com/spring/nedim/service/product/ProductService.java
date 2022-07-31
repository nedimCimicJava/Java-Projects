package com.spring.nedim.service.product;

import com.spring.nedim.entity.product.Product;
import com.spring.nedim.entity.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getById(long id){
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}