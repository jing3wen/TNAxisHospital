package main.java.service;

import com.alibaba.fastjson.JSON;
import main.java.entity.Registration;
import main.java.mapper.MysqlFunction;
import main.java.mapper.RegistrationMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jingwen
 * @Description 挂号服务
 * @DATE 2021/10/30 22:34
 */
public class RegistrationService {
     SqlSession sqlSession= MysqlFunction.getSqlSession();
     RegistrationMapper registrationMapper= sqlSession.getMapper(RegistrationMapper.class);


     public String queryALLRegistration(){
         System.out.println("客户端请求:  queryALLRegistration");
         List<Registration> registrationList=registrationMapper.queryALLRegistration();
         if(registrationList.size()>0)
             return "可以预约";
         return "没有数据";
     }

    public String queryRegistrationByDateAndDepartment(String dateString,String department){
         //Registration registration= JSONObject.parseObject(registrationString,Registration.class);
         System.out.println("客户端查询预约号 :"+dateString+";"+department);
         //Date inputDate=getNowDateShort(registration.getDate());
         Date inputDate = dateStringToDate(dateString);
         Registration registration=registrationMapper.queryRegistrationByDateAndDepartment(inputDate,department);
         if(registration!=null&&registration.getRemaining()>0){
             return "可以预约，请输入手机号预约";
         }
         return "暂无预约号";
    }

    /**
     * @Description 日期转换方法，把new Date()转换成yyyy-MM-dd格式
     * @Author jingwen
     * @Date 2021/10/31 9:10
     **/
    public Date dateStringToDate(String dateString){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(currentTime);
        Date currentTime = null;
        try {
            currentTime = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateString2=formatter.format(currentTime);
        Date sqlDate = java.sql.Date.valueOf(dateString2);
        return sqlDate;
    }

    @Test
    public void testRegistrationService(){
        /*
         Date date= new Date();
         Object[] list1=queryALLRegistration();

         for(Object registration:list1)
             System.out.println(registration);
        */
        String res=queryRegistrationByDateAndDepartment("2021-10-31 09:09:10","内科");
        System.out.println(res);

    }
}
