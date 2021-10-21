package cn.edu.xmu.lab3.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("OrderItemPo")
public class OrderItemPo {

    private Integer id;

    private Integer orderId;

    private Integer skuId;

    private Integer quantity;

    private Integer price;

    private Integer discount;

    private String name;

    private Integer couponActId;

    private Integer beShareId;

    private Date gmtCreate;

    private Date gmtModified;
}
