package cn.edu.xmu.lab3.controller;

import cn.edu.xmu.lab3.service.OrdersService;
import cn.edu.xmu.lab3.model.OrdersRetVo;
import cn.edu.xmu.lab3.model.VoObject;
import cn.edu.xmu.lab3.util.ResponseCode;
import cn.edu.xmu.lab3.util.ResponseUtil;
import cn.edu.xmu.lab3.util.ReturnObject;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Api(value = "商品API", tags = "商品API")
@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8")
public class OrdersController {
    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @ApiOperation(value = "获得一个订单对象，用sql关联",  produces="application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "id", value ="订单对象id", required = true)
    })
    @ApiResponses({
    })
    @GetMapping("/sql/{id}")
    public Object getOrdersAssociatedInSQL(@PathVariable("id") Integer id) {
        ReturnObject<VoObject> returnObject = ordersService.findOrdersAssociatedInSQL(id);
        ResponseCode code = returnObject.getCode();
        switch (code) {
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }

    @ApiOperation(value = "获得一个订单对象，在dao层关联",  produces="application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "id", value ="订单对象id", required = true)
    })
    @ApiResponses({
    })
    @GetMapping("/dao/{id}")
    public Object getOrdersAssociatedInDao(@PathVariable("id") Integer id) {
        ReturnObject<VoObject> returnObject = ordersService.findOrdersAssociatedInDao(id);
        ResponseCode code = returnObject.getCode();
        switch (code) {
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }


}
