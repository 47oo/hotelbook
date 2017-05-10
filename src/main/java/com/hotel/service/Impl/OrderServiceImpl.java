package com.hotel.service.Impl;

import com.hotel.common.TimeUtils;
import com.hotel.dao.OrderDAO;
import com.hotel.model.Order;
import com.hotel.model.User;
import com.hotel.request.OrderQueryRequest;
import com.hotel.response.CommonDO;
import com.hotel.response.OrderDO;
import com.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/5/7.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public CommonDO listToAdmin(OrderQueryRequest orderQueryRequest) {
        int size = orderQueryRequest.getSize();
        int start = (orderQueryRequest.getStart()-1)*size;
        List<Order> list = orderDAO.listToAdmin(start,size);
        CommonDO commonDO = new CommonDO();
        commonDO.setData(order2OrderDO(list));
        return commonDO;
    }

    @Override
    public CommonDO listToUser(OrderQueryRequest orderQueryRequest, HttpServletRequest request) {
        CommonDO commonDO = new CommonDO();
        User u = (User) request.getSession().getAttribute("user");
        List<Order> list = orderDAO.listToUser(u.getUsername(), (orderQueryRequest.getStart() - 1) * orderQueryRequest.getSize(), orderQueryRequest.getSize());
        commonDO.setData(order2OrderDO(list));
        return commonDO;
    }

    private List<OrderDO> order2OrderDO(List<Order> list) {
        List<OrderDO> dolist = new ArrayList<>();
        OrderDO orderDO = null;
        for(Order order:list){
            orderDO = new OrderDO();
            orderDO.setRoom_id(order.getRoom_id());
            orderDO.setCitime(TimeUtils.format(order.getCitime(),"yyyy-MM-dd"));
            orderDO.setCotime(TimeUtils.format(order.getCotime(),"yyyy-MM-dd"));
            orderDO.setMoney(order.getMoney());
            orderDO.setOrder_id(order.getOrder_id());
            dolist.add(orderDO);
        }
        return dolist;
    }

}
