package com.spring.nedim.controller.order;

import com.spring.nedim.entity.order.Order;
import com.spring.nedim.entity.order.OrderItem;
import com.spring.nedim.entity.product.Product;
import com.spring.nedim.service.order.OrderItemService;
import com.spring.nedim.service.order.OrderService;
import com.spring.nedim.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @GetMapping("/orderProduct")
    public String showAddOrderProductForm(Model model){
        List<Product> products = productService.getAllProducts();
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        return "order_product";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(Model model,@ModelAttribute("order") Order order, HttpServletRequest request){
        String proizvod = request.getParameter("proizvod");
        long productId = Long.parseLong(proizvod);
        Product product = productService.getById(productId);
        if (order.getOrderId() == null){
            order = orderService.saveOrder(order);
        }
        orderService.saveOrderItem(order, product);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrder(order);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("order", order);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "order_product";
    }
}


