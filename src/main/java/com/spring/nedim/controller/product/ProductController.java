package com.spring.nedim.controller.product;

import com.spring.nedim.entity.product.Product;
import com.spring.nedim.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("proizvodi", products);
        return "product";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product")Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
}


