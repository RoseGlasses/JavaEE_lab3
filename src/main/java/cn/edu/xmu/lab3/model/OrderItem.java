package cn.edu.xmu.lab3.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {

    /**
     * 代理对象
     */
    private OrderItemPo orderItemPo;

    /**
     * 构造函数
     */
    public OrderItem() {
        this.orderItemPo = new OrderItemPo();
    }

    /**
     * 构造函数
     */
    public OrderItem(OrderItemPo orderItemPo) {
        this.orderItemPo = orderItemPo;
    }

    /**
     * 构造函数
     */
    public OrderItem(OrdersWithOrderItemPo ordersWithOrderItemPo) {
        this.orderItemPo = new OrderItemPo();
        orderItemPo.setId(ordersWithOrderItemPo.getIdOfOrderItem());
        orderItemPo.setOrderId(ordersWithOrderItemPo.getOrderId());
        orderItemPo.setSkuId(ordersWithOrderItemPo.getSkuId());
        orderItemPo.setQuantity(ordersWithOrderItemPo.getQuantity());
        orderItemPo.setPrice(ordersWithOrderItemPo.getPrice());
        orderItemPo.setDiscount(ordersWithOrderItemPo.getDiscount());
        orderItemPo.setName(ordersWithOrderItemPo.getName());
        orderItemPo.setCouponActId(ordersWithOrderItemPo.getCouponActIdOfOrderItem());
        orderItemPo.setBeShareId(ordersWithOrderItemPo.getBeShareId());
        orderItemPo.setGmtCreate(ordersWithOrderItemPo.getGmtCreateOfOrderItem());
        orderItemPo.setGmtModified(ordersWithOrderItemPo.getGmtModifiedOfOrderItem());
    }

    public Integer getSkuId() { return orderItemPo.getId(); }

    public void setSkuId(Integer skuId) { orderItemPo.setId(skuId); }

    public Integer getOrderId() { return orderItemPo.getOrderId(); }

    public void setOrderId(Integer orderId) { orderItemPo.setOrderId(orderId); }

    public String getName() { return orderItemPo.getName(); }

    public void setName(String name) { orderItemPo.setName(name); }

    public Integer getQuantity() { return orderItemPo.getQuantity(); }

    public void setQuantity(Integer quantity) { orderItemPo.setQuantity(quantity); }

    public Integer getPrice() { return orderItemPo.getPrice(); }

    public void setPrice(Integer price) { orderItemPo.setPrice(price); }

    public Integer getDiscount() { return orderItemPo.getDiscount(); }

    public void setDiscount(Integer discount) { orderItemPo.setDiscount(discount); }

    public Integer getCouponActId() { return orderItemPo.getCouponActId(); }

    public void setCouponActId(Integer couponActId) { orderItemPo.setCouponActId(couponActId); }

    public Integer getBeShareId() { return orderItemPo.getBeShareId(); }

    public void setBeShareId(Integer beShareId) { orderItemPo.setBeShareId(beShareId); }

    @Override
    public boolean equals(Object o) {
        return orderItemPo.equals(o);
    }

    @Override
    public int hashCode() {
        return orderItemPo.hashCode();
    }

    @Override
    public String toString() {
        return orderItemPo.toString();
    }
}
