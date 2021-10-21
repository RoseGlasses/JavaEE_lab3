package cn.edu.xmu.lab3.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Data
@Alias("OrdersPo")
public class OrdersPo {

    private Integer id;

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

    private Integer couponActId;

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

    private Date gmtCreate;

    private Date gmtModified;

    private Integer grouponId;

    private List<OrderItemPo> orderItemList;
}
