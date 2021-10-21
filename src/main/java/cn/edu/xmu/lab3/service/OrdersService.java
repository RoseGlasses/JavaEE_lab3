package cn.edu.xmu.lab3.service;

import cn.edu.xmu.lab3.dao.OrdersDao;
import cn.edu.xmu.lab3.model.*;
import cn.edu.xmu.lab3.util.ResponseCode;
import cn.edu.xmu.lab3.util.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private Logger logger = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 获取订单信息，用SQL关联
     * @param id 订单id
     * @return 订单对象
     */
    public ReturnObject<VoObject> findOrdersAssociatedInSQL(Integer id) {
        OrdersPo queryObj = new OrdersPo();
        queryObj.setId(id);
        ReturnObject<VoObject> retOrders = null;
        ReturnObject<List<Orders>> returnObject = ordersDao.findOrdersAssociatedInSQL(queryObj, true);
        if (returnObject.getCode().equals(ResponseCode.OK)) {
            if (returnObject.getData().size() == 1) {
                retOrders = new ReturnObject<>(returnObject.getData().get(0));
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject.getCode(), returnObject.getErrmsg());
        }
        return retOrders;
    }

    /**
     * 获取订单信息，在Dao关联
     * @param id 订单id
     * @return 订单对象
     */
    public ReturnObject<VoObject> findOrdersAssociatedInDao(Integer id) {
        OrdersPo queryObj = new OrdersPo();
        queryObj.setId(id);
        ReturnObject<VoObject> retOrders = null;
        ReturnObject<List<Orders>> returnObject = ordersDao.findOrdersAssociatedInDao(queryObj, true);
        if (returnObject.getCode().equals(ResponseCode.OK)) {
            if (returnObject.getData().size() == 1) {
                retOrders = new ReturnObject<>(returnObject.getData().get(0));
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject.getCode(), returnObject.getErrmsg());
        }
        return retOrders;
    }
}
