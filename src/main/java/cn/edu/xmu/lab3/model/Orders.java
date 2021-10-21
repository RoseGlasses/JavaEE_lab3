package cn.edu.xmu.lab3.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders implements VoObject {

    public enum OrderType {
        COMMON(0,"普通"),
        GROUP(1,"团购"),
        PRESALE(2,"预售");

        private static final Map<Integer, OrderType> orderTypeMap;

        static { //由类加载机制，静态块初始加载对应的枚举属性到map中，而不用每次取属性时，遍历一次所有枚举值
            orderTypeMap = new HashMap();
            for (OrderType enum1 : values()) {
                orderTypeMap.put(enum1.code, enum1);
            }
        }

        private int code;
        private String description;

        OrderType(int code, String description) {
            this.code=code;
            this.description=description;
        }

        public static OrderType getStatusByCode(Integer code){
            return orderTypeMap.get(code);
        }

        public Integer getCode(){
            return code;
        }

        public String getDescription() {return description;}

    }
    /**
     * 代理对象
     */
    private OrdersPo ordersPo;

    /**
     * 构造函数
     */
    public Orders() {
        this.ordersPo = new OrdersPo();
    }

    /**
     * 构造函数
     */
    public Orders(OrdersPo ordersPo) {
        this.ordersPo = ordersPo;
    }

    /**
     * 构造函数
     */
    public Orders(OrdersWithOrderItemPo ordersWithOrderItemPo) {
        this.ordersPo = new OrdersPo();
        ordersPo.setId(ordersWithOrderItemPo.getIdOfOrders());
        ordersPo.setCustomerId(ordersWithOrderItemPo.getCustomerId());
        ordersPo.setShopId(ordersWithOrderItemPo.getShopId());
        ordersPo.setOrderSn(ordersWithOrderItemPo.getOrderSn());
        ordersPo.setPid(ordersWithOrderItemPo.getPid());
        ordersPo.setConsignee(ordersWithOrderItemPo.getConsignee());
        ordersPo.setRegionId(ordersWithOrderItemPo.getRegionId());
        ordersPo.setAddress(ordersWithOrderItemPo.getAddress());
        ordersPo.setMobile(ordersWithOrderItemPo.getMobile());
        ordersPo.setMessage(ordersWithOrderItemPo.getMessage());
        ordersPo.setOrderType(ordersWithOrderItemPo.getOrderType());
        ordersPo.setFreightPrice(ordersWithOrderItemPo.getFreightPrice());
        ordersPo.setCouponId(ordersWithOrderItemPo.getCouponId());
        ordersPo.setCouponActId(ordersWithOrderItemPo.getCouponActIdOfOrders());
        ordersPo.setDiscountPrice(ordersWithOrderItemPo.getDiscountPrice());
        ordersPo.setOriginPrice(ordersWithOrderItemPo.getOriginPrice());
        ordersPo.setPresaleId(ordersWithOrderItemPo.getPresaleId());
        ordersPo.setGrouponDiscount(ordersWithOrderItemPo.getGrouponDiscount());
        ordersPo.setRebateNum(ordersWithOrderItemPo.getRebateNum());
        ordersPo.setConfirmTime(ordersWithOrderItemPo.getConfirmTime());
        ordersPo.setShipmentSn(ordersWithOrderItemPo.getShipmentSn());
        ordersPo.setState(ordersWithOrderItemPo.getState());
        ordersPo.setSubstate(ordersWithOrderItemPo.getSubstate());
        ordersPo.setBeDeleted(ordersWithOrderItemPo.getBeDeleted());
        ordersPo.setGmtCreate(ordersWithOrderItemPo.getGmtCreateOfOrders());
        ordersPo.setGmtModified(ordersWithOrderItemPo.getGmtModifiedOfOrders());
        ordersPo.setGrouponId(ordersWithOrderItemPo.getGrouponId());
    }

    /**
     * 由Orders对象创建Vo对象
     */
    @Override
    public Object createVo() {
        return new OrdersRetVo(this);
    }

    /**
     * 获得内部的代理对象
     * @return OrdersPo对象
     */
    public OrdersPo gotOrdersPo(){
        return this.ordersPo;
    }

    public Integer getId() { return ordersPo.getId(); }

    public void setId(Integer id) { ordersPo.setId(id); }

    public String getOrderSn() { return ordersPo.getOrderSn(); }

    public void setOrderSn(String orderSn) { ordersPo.setOrderSn(orderSn); }

    public Integer getPid() { return ordersPo.getPid(); }

    public void setPid(Integer pid) { ordersPo.setPid(pid); }

    public Integer getOrderType() { return ordersPo.getOrderType(); }

    public void setOrderType(Integer orderType) { ordersPo.setOrderType(orderType); }

    public Integer getState() { return ordersPo.getState(); }

    public void setState(Integer state) { ordersPo.setState(state); }

    public Integer getSubState() { return ordersPo.getSubstate(); }

    public void setSubState(Integer subState) { ordersPo.setSubstate(subState); }

    public String getGmtCreate() {
        if (ordersPo.getGmtCreate() != null)
            return ordersPo.getGmtCreate().toString();
        return null;
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void setGmtCreate(String gmtCreate) throws ParseException { ordersPo.setGmtCreate(simpleDateFormat.parse(gmtCreate)); }

    public String getGmtModified() {
        if (ordersPo.getGmtModified() != null)
            return ordersPo.getGmtModified().toString();
        return null;
    }

    public void setGmtModified(String gmtModified) throws ParseException { ordersPo.setGmtModified(simpleDateFormat.parse(gmtModified)); }

    public String getConfirmTime() {
        if (ordersPo.getConfirmTime() != null)
            return ordersPo.getConfirmTime().toString();
        return null;
    }

    public void setConfirmTime(String confirmTime) throws ParseException { ordersPo.setConfirmTime(simpleDateFormat.parse(confirmTime)); }

    public Integer getOriginPrice() { return ordersPo.getOriginPrice(); }

    public void setOriginPrice(Integer originPrice) { ordersPo.setOriginPrice(originPrice); }

    public Integer getDiscountPrice() { return ordersPo.getDiscountPrice(); }

    public void setDiscountPrice(Integer discountPrice) { ordersPo.setDiscountPrice(discountPrice); }

    public Integer getFreightPrice() { return ordersPo.getFreightPrice(); }

    public void setFreightPrice(Integer freightPrice) { ordersPo.setFreightPrice(freightPrice); }

    public Integer getRebateNum() { return ordersPo.getRebateNum(); }

    public void setRebateNum(Integer rebateNum) { ordersPo.setRebateNum(rebateNum); }

    public String getMessage() { return ordersPo.getMessage(); }

    public void setMessage(String message) { ordersPo.setMessage(message); }

    public Integer getRegionId() { return ordersPo.getRegionId(); }

    public void setRegionId(Integer regionId) { ordersPo.setRegionId(regionId); }

    public String getAddress() { return ordersPo.getAddress(); }

    public void setAddress(String address) { ordersPo.setAddress(address); }

    public String getMobile() { return ordersPo.getMobile(); }

    public void setMobile(String mobile) { ordersPo.setMobile(mobile); }

    public String getConsignee() { return ordersPo.getConsignee(); }

    public void setConsignee(String consignee) { ordersPo.setConsignee(consignee); }

    public Integer getCouponId() { return ordersPo.getCouponId(); }

    public void setCouponId(Integer couponId) { ordersPo.setCouponId(couponId); }

    public Integer getGroupId() { return ordersPo.getGrouponId(); }

    public void setGroupId(Integer groupId) { ordersPo.setGrouponId(groupId); }

    public Integer getPresaleId() { return ordersPo.getPresaleId(); }

    public void setPresaleId(Integer presaleId) { ordersPo.setPresaleId(presaleId); }

    public String getShipmentSn() { return ordersPo.getShipmentSn(); }

    public void setShipmentSn(String shipmentSn) { ordersPo.setShipmentSn(shipmentSn); }

    public boolean canEqual(Object other) { return ordersPo.canEqual(other); }

    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() { return orderItemList; }

    public void setOrderItemList(List<OrderItem> orderItemList) { this.orderItemList = orderItemList; }

    @Override
    public int hashCode() { return ordersPo.hashCode(); }

    @Override
    public String toString() { return ordersPo.toString(); }

    @Override
    public boolean equals(Object o) { return ordersPo.equals(((Orders)o).ordersPo); }
}