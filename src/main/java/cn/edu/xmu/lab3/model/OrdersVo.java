package cn.edu.xmu.lab3.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "订单")
public class OrdersVo {

    private static Logger logger = LoggerFactory.getLogger(OrdersVo.class);

    private List<OrderItemVo> orderItems;
    private String consignee;
    private Integer regionId;
    private String address;
    private String mobile;
    private String message;
    private Integer couponId;
    private Integer presaleId;
    private Integer grouponId;

    /**
     * 由Vo对象创建Orders对象
     * @return Orders对象
     */
    public Orders createOrders(){
        Orders orders = new Orders();
        orders.setConsignee(this.consignee);
        orders.setRegionId(this.regionId);
        orders.setAddress(this.address);
        orders.setMobile(this.mobile);
        orders.setMessage(this.message);
        orders.setCouponId(this.couponId);
        orders.setPresaleId(this.presaleId);
        orders.setGroupId(this.grouponId);

        if (null != this.orderItems) {
            logger.info("createOrders: this.orderItemList = "+this.orderItems);
            List<OrderItem> newOrderItemList = new ArrayList<>(this.orderItems.size());

            for (OrderItemVo orderItemVo : this.orderItems) {
                OrderItem orderItem = orderItemVo.createOrderItem();
                newOrderItemList.add(orderItem);
            }
            orders.setOrderItemList(newOrderItemList);
        }

        return orders;
    }

}
