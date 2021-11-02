package com.example.axiswebclient.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 预约订单
 * @author 源助力好还是贪食好
 * @date 2021/10/29 21:08
 */
@Data
public class Order {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String userPhone;

    private Integer registrationId;

    private String department;

}
