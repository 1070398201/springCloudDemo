package com.gcy.member.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {

    @Value("${server.port}")
    private String serverPort;


    /**
     * 会员服务提供的接口
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(Integer userId) {
        return "每特教育,端口号:" + serverPort;
    }


}
