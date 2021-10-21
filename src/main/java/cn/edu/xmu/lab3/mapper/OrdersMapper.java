package cn.edu.xmu.lab3.mapper;

import cn.edu.xmu.lab3.model.OrderItemPo;
import cn.edu.xmu.lab3.model.OrdersPo;
import cn.edu.xmu.lab3.model.OrdersWithOrderItemPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    List<OrdersPo> findOrders(OrdersPo ordersPo);

    List<OrderItemPo> findOrderItem(OrderItemPo orderItemPo);

    List<OrdersWithOrderItemPo> findOrdersAssociatedInSQL(OrdersPo ordersPo);
}
