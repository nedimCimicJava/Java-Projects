package com.spring.nedim.service.order;

import com.spring.nedim.entity.order.Order;
import com.spring.nedim.entity.order.OrderItem;
import com.spring.nedim.entity.order.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getOrderItemsByOrder(Order order){
        return orderItemRepository.findOrderItemsByOrder(order);
    }

    public List<OrderItem> showAllOrderItems(){
        return orderItemRepository.findAll();
    }
}
