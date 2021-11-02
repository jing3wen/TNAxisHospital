package com.example.axiswebclient.service;

import lombok.SneakyThrows;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

import javax.xml.namespace.QName;

/**
 * @author jingwen
 * @Description
 * @DATE 2021/10/31 17:49
 */
@org.springframework.stereotype.Service
public class OrderService {
    String webServiceUrl = "http://localhost:8080/services/OrderService?wsdl";
    String deleteOrderByPhone="deleteOrderByPhone";
    String insertOrder="insertOrder";

    @SneakyThrows
    public String deleteOrderByPhoneFunction(String userPhone){
        Object[] objects=new Object[]{userPhone};
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setOperationName(new QName(deleteOrderByPhone)); // 设置调用方法名
        call.setTargetEndpointAddress(webServiceUrl); // 设置调用的url

        // 执行调用,数组元素与被调用方法的参数列表一一对应，参数可以少传（需要为引用类型按null处理）但不能多传
        return call.invoke(objects).toString();
    }

    @SneakyThrows
    public String insertOrderFunction(String userPhone,String dateString,String department){
        Object[] objects=new Object[]{userPhone,dateString,department};
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setOperationName(new QName(insertOrder)); // 设置调用方法名
        call.setTargetEndpointAddress(webServiceUrl); // 设置调用的url
        // 执行调用,数组元素与被调用方法的参数列表一一对应，参数可以少传（需要为引用类型按null处理）但不能多传
        return call.invoke(objects).toString();
    }

    @Test
    public void orderTest(){

        System.out.println(deleteOrderByPhoneFunction("12345678910"));
        System.out.println(insertOrderFunction("12345678910","2021-10-31","外科"));
    }



}
