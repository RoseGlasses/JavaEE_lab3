package cn.edu.xmu.lab3.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "商品规格视图对象")
public class OrderItemVo {

    @ApiModelProperty(value = "规格序号")
    private Integer skuId;
    
    @ApiModelProperty(value = "描述")
    private Integer quantity;

    @ApiModelProperty(value = "零售价")
    private Integer couponActId;

    /**
     * 由Vo对象创建OrderItem对象
     * @return OrderItem对象
     */
    public OrderItem createOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setSkuId(this.skuId);
        orderItem.setQuantity(this.quantity);
        orderItem.setCouponActId(this.couponActId);
        return orderItem;
    }
}
