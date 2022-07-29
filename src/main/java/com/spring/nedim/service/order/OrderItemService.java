package com.spring.nedim.service.order;

import com.spring.nedim.entity.order.Order;
import com.spring.nedim.entity.order.OrderItem;
import com.spring.nedim.entity.order.OrderItemRepository;
import com.spring.nedim.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
