package cn.edu.xmu.lab3.dao;

import cn.edu.xmu.lab3.model.*;
import cn.edu.xmu.lab3.mapper.OrdersMapper;
import cn.edu.xmu.lab3.util.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDao {
    private Logger logger = LoggerFactory.getLogger(OrdersDao.class);

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 用 OrdersPo 对象找 Orders 对象
     * @param ordersPo 条件对象，仅有索引的值可以作为条件
     * @param withItem 是否带关联的OrderItem（有性能问题，不要一次返回太多Orders对象）
     * @return Orders对象列表，带关联的OrderItem返回
     */
    public ReturnObject<List<Orders>> findOrdersAssociatedInSQL(OrdersPo ordersPo, Boolean withItem) {
        logger.info("findOrders: ordersPo = " + ordersPo + " withItem = " + withItem);
        List<OrdersWithOrderItemPo> ordersWithOrderItemPos = ordersMapper.findOrdersAssociatedInSQL(ordersPo);
        logger.info("findOrdersWithOrderItem: ordersWithOrderItemPos = " + ordersWithOrderItemPos);
        List<Orders> retOrders = new ArrayList<>();

        if (ordersWithOrderItemPos.size() != 0) {
            Orders orders = new Orders(ordersWithOrderItemPos.get(0));
            List<OrderItem> orderItemList = new ArrayList<>();
            for (OrdersWithOrderItemPo ordersWithOrderItemPo : ordersWithOrderItemPos) {
                orderItemList.add(new OrderItem(ordersWithOrderItemPo));
            }
            orders.setOrderItemList(orderItemList);
            retOrders.add(orders);
        }
        logger.info("findOrders: retOrders = " + retOrders + ", withItem =" + withItem);
        return new ReturnObject<>(retOrders);
    }

    /**
     * 用 OrdersPo 对象找 Orders 对象
     * @param ordersPo 条件对象，仅有索引的值可以作为条件
     * @param withItem 是否带关联的OrderItem（有性能问题，不要一次返回太多Orders对象）
     * @return Orders对象列表，带关联的OrderItem返回
     */
    public ReturnObject<List<Orders>> findOrdersAssociatedInDao(OrdersPo ordersPo, Boolean withItem) {
        logger.info("findOrders: ordersPo = " + ordersPo + " withItem = " + withItem);
        List<OrdersPo> ordersPos = ordersMapper.findOrders(ordersPo);
        logger.info("findOrders: ordersPos = " + ordersPos);
        List<Orders> retOrders = new ArrayList<>(ordersPos.size());
        OrderItemPo orderItemPo = null;

        if (withItem) {
            orderItemPo = new OrderItemPo();
        }

        for (OrdersPo ordersItem : ordersPos) {
            Orders item = new Orders(ordersItem);
            if (withItem) {
                orderItemPo.setOrderId(ordersItem.getId());
                List<OrderItemPo> orderItemPos = ordersMapper.findOrderItem(orderItemPo);
                List<OrderItem> orderItemList = new ArrayList<>(orderItemPos.size());
                for (OrderItemPo orderItemPo1 : orderItemPos) {
                    OrderItem orderItem = new OrderItem(orderItemPo1);
                    orderItemList.add(orderItem);
                }
                item.setOrderItemList(orderItemList);
            }
            retOrders.add(item);
        }
        logger.info("findOrders: retOrders = " + retOrders + ", withItem =" + withItem);
        return new ReturnObject<>(retOrders);
    }
}
