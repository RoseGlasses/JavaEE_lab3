package cn.edu.xmu.lab3.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "订单")
public class OrdersRetVo {

    private static Logger logger = LoggerFactory.getLogger(OrdersVo.class);

    private Integer id;
    private String orderSn;
    private Integer pid;
    private Integer orderType;
    private Integer state;
    private Integer subState;
    private String gmtCreate;
    private String gmtModified;
    private String confirmTime;
    private Integer originPrice;
    private Integer discountPrice;
    private Integer freightPrice;
    private Integer rebateNum;
    private String message;
    private Integer regionId;
    private String address;
    private String mobile;
    private String consignee;
    private Integer couponId;
    private Integer groupId;
    private Integer presaleId;
    private String shipmentSn;
    private List<OrderItemRetVo> orderItemList;

    /**
     * 由Vo对象创建Orders对象
     * @return Orders对象
     */
    public OrdersRetVo(Orders orders){
        this.id=orders.getId();
        this.orderSn=orders.getOrderSn();
        this.pid=orders.getPid();
        this.orderType=orders.getOrderType();
        this.state=orders.getState();
        this.subState=orders.getSubState();
        this.gmtCreate=orders.getGmtCreate();
        this.gmtModified=orders.getGmtModified();
        this.confirmTime=orders.getConfirmTime();
        this.originPrice=orders.getOriginPrice();
        this.discountPrice=orders.getDiscountPrice();
        this.freightPrice=orders.getFreightPrice();
        this.rebateNum=orders.getRebateNum();
        this.message=orders.getMessage();
        this.regionId=orders.getRegionId();
        this.address=orders.getAddress();
        this.mobile=orders.getMobile();
        this.consignee=orders.getConsignee();
        this.groupId=orders.getGroupId();
        this.presaleId=orders.getPresaleId();
        this.shipmentSn=orders.getShipmentSn();

        if (null != orders.getOrderItemList()) {
            List<OrderItemRetVo> orderItemList = new ArrayList<>(orders.getOrderItemList().size());

            for (OrderItem orderItem : orders.getOrderItemList()) {
                OrderItemRetVo orderItemVo = new OrderItemRetVo(orderItem);
                orderItemList.add(orderItemVo);
            }
            this.orderItemList = orderItemList;
        }
    }

}
