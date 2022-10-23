package com.example.axiswebclient.service;

import lombok.SneakyThrows;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

import javax.xml.namespace.QName;

/**
 * @author jingwen
 * @Description
 * @DATE 2021/10/31 17:50
 */
@org.springframework.stereotype.Service
public class RegistrationService {
    String webServiceUrl = "http://localhost:8080/services/RegistrationService?wsdl";
    String queryRegistrationByDateAndDepartment="queryRegistrationByDateAndDepartment";

    @SneakyThrows
    public String queryRegistrationByDateAndDepartmentFunction(String dateString,String department) {
        if(dateString.equals(""))
            return "日期格式错误,";
        else if(department.equals(""))
            return "请输入科室信息";
        System.out.println("开始远程调用 "+queryRegistrationByDateAndDepartment);
        Object objects[]=new Object[]{dateString,department};
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setOperationName(new QName(queryRegistrationByDateAndDepartment)); // 设置调用方法名
        call.setTargetEndpointAddress(webServiceUrl); // 设置调用的url
        // 执行调用,数组元素与被调用方法的参数列表一一对应，参数可以少传（需要为引用类型按null处理）但不能多传
        return call.invoke(objects).toString();
    }

    @Test
    public void registrationTest(){
        System.out.println(queryRegistrationByDateAndDepartmentFunction("2021-10-31","外科"));
    }
}
