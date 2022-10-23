package com.example.axiswebclient.controller;

import com.example.axiswebclient.entity.Registration;
import com.example.axiswebclient.service.OrderService;
import com.example.axiswebclient.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author jingwen
 * @Description
 * @DATE 2021/10/31 18:46
 */
@RestController
public class IndexController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/index")
    public String sayHello(){
        return "index.html";
    }

    @RequestMapping("/queryRegistrationByDateAndDepartment")
    public String queryRegistrationByDateAndDepartmentController(String dateString,String department){
        System.out.println("用户查询 时间:"+dateString+", 科室:"+department+" 可预约的号码");
        //SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String dateString=fm.format(registration.getDate());
        String res=registrationService.queryRegistrationByDateAndDepartmentFunction(dateString,department);
        System.out.println("res:"+res);
        return res;
    }

    @RequestMapping("/insertOrderFunction")
    public String insertOrderFunctionController(String userPhone,String dateString,String department){
        System.out.println("用户:"+userPhone+"  预约科室:"+department+" ,时间:"+dateString);
        String res=orderService.insertOrderFunction(userPhone,dateString,department);
        System.out.println("res:"+res);
        return res;
    }

    @RequestMapping("/deleteOrderByPhoneFunction")
    public String deleteOrderByPhoneFunctionController(String userPhone){
        System.out.println("用户:"+userPhone+"  取消预约");
        String res=orderService.deleteOrderByPhoneFunction(userPhone);
        System.out.println("res:"+res);
        return res;
    }


}
