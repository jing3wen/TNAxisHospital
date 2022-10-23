package main.java.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import main.java.entity.Order;
import main.java.entity.Registration;
import main.java.mapper.MysqlFunction;
import main.java.mapper.OrderMapper;
import main.java.mapper.RegistrationMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;


/**
 * @author jingwen
 * @Description
 * @DATE 2021/10/29 18:31
 */

@WebService
public class OrderService {
    SqlSession sqlSession=MysqlFunction.getSqlSession();
    OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
    RegistrationMapper registrationMapper=sqlSession.getMapper(RegistrationMapper.class);

    /**
     * @Description 添加预约订单
     * @Author jingwen
     * @Date 2021/10/31 17:22
     **/
    public String insertOrder(String userPhone,String dateString,String department){
        System.out.println("客户端申请预约: userPhone:"+userPhone+";dateString:"+dateString+";department:"+department);
        Date inputDate = new RegistrationService().dateStringToDate(dateString);
        Registration registrationFind=registrationMapper.queryRegistrationByDateAndDepartment(inputDate,department);
        if(registrationFind.getRemaining()<1) return "号码已经放完，请另选日期";
        Order order=new Order();
        order.setUserPhone(userPhone);
        order.setDepartment(department);
        order.setRegistrationId(registrationFind.getId());
        order.setDate(new Date());
        System.out.println("添加预约订单:"+order.toString());
        orderMapper.insertSelective(order);
        //预测成功后，registration表中对应预约号剩余数Remaining-1
        registrationMapper.updateRemainingWhenInsertOrder(order.getRegistrationId());
        sqlSession.commit();
        return "预约成功";
    }

    /**
     * @Description 取消预约订单
     * @Author jingwen
     * @Date 2021/10/31 17:21
     **/
    public String deleteOrderByPhone(String userPhone){
        System.out.println("用户申请取消预约: userPhone:"+userPhone);
        Order order=orderMapper.selectOrderByUserPhone(userPhone);
        if(order!=null){
            //System.out.println(order.toString());
            //说明该用户已经预约，准备取消预约
            orderMapper.delectOrderById(order.getId());
            sqlSession.commit();
            return "取消预约成功";
        }
        return "此号码尚未预约";
    }


    @Test
    public void testFunction(){

        String res=insertOrder("12345678912","2021-10-31","内科");
        System.out.println();
    }

}
