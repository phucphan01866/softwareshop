package com.webcuoiky.softwareshop.repository;

import com.webcuoiky.softwareshop.model.Order_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<Order_items, Integer> {
}
