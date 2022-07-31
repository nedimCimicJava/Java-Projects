package com.spring.nedim.controller.order;

import com.spring.nedim.entity.order.OrderItem;
import com.spring.nedim.service.order.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderItems")
    public String allOrderItems(Model model){
        List<OrderItem> orderItems = orderItemService.showAllOrderItems();
        model.addAttribute("narudzbe", orderItems);
        return "order_item";
    }
}
