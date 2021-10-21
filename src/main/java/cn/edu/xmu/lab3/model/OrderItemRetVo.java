package cn.edu.xmu.lab3.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "商品规格视图对象")
public class OrderItemRetVo {

    @ApiModelProperty(value = "规格序号")
    private Integer skuId;

    @ApiModelProperty(value = "规格id")
    private Integer orderId;

    @ApiModelProperty(value = "描述")
    private String name;

    @ApiModelProperty(value = "描述")
    private Integer quantity;

    @ApiModelProperty(value = "零售价")
    private Integer price;

    @ApiModelProperty(value = "促销价")
    private Integer discount;

    @ApiModelProperty(value = "零售价")
    private Integer couponActId;

    @ApiModelProperty(value = "规格状态")
    private Integer beShareId;

    /**
     * 由Vo对象创建OrderItem对象
     * @return OrderItem对象
     */
    public OrderItemRetVo(OrderItem orderItem) {
        this.skuId = orderItem.getSkuId();
        this.orderId = orderItem.getOrderId();
        this.name = orderItem.getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.discount = orderItem.getDiscount();
        this.couponActId = orderItem.getCouponActId();
        this.beShareId = orderItem.getBeShareId();
    }
}
