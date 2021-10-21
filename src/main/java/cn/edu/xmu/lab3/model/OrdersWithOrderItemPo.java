package cn.edu.xmu.lab3.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.util.Date;

@Data
@Alias("OrdersWithOrderItemPo")
public class OrdersWithOrderItemPo {

    // OrdersPo
    private Integer idOfOrders;

    private Integer customerId;

    private Integer shopId;

    private String orderSn;

    private Integer pid;

    private String consignee;

    private Integer regionId;

    private String address;

    private String mobile;

    private String message;

    private Integer orderType;

    private Integer freightPrice;

    private Integer couponId;

    private Integer couponActIdOfOrders;

    private Integer discountPrice;

    private Integer originPrice;

    private Integer presaleId;

    private Integer grouponDiscount;

    private Integer rebateNum;

    private Date confirmTime;

    private String shipmentSn;

    private Integer state;

    private Integer substate;

    private Integer beDeleted;

    private Date gmtCreateOfOrders;

    private Date gmtModifiedOfOrders;

    private Integer grouponId;

    // OrderItemPo
    private Integer idOfOrderItem;

    private Integer orderId;

    private Integer skuId;

    private Integer quantity;

    private Integer price;

    private Integer discount;

    private String name;

    private Integer couponActIdOfOrderItem;

    private Integer beShareId;

    private Date gmtCreateOfOrderItem;

    private Date gmtModifiedOfOrderItem;
}
