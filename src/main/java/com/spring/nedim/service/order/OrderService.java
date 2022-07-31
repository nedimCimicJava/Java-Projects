package com.spring.nedim.service.order;

import com.spring.nedim.entity.order.*;
import com.spring.nedim.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public OrderItem saveOrderItem(Order order, Product product){
        OrderItemKey orderItemKey = new OrderItemKey();
        orderItemKey.setOrderId(order.getOrderId());
        orderItemKey.setProductId(product.getProductId());
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemKey);
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        return orderItemRepository.save(orderItem);
    }
}
