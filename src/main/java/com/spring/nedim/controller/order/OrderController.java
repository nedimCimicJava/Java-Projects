package com.spring.nedim.controller.order;

import com.spring.nedim.entity.order.Order;
import com.spring.nedim.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderProduct")
    public String showAddOrderProductForm(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "order_product";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order")Order order){
        orderService.saveOrder(order);
        return "redirect:/products";
    }
}


