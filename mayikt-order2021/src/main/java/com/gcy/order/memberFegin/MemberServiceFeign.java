package com.gcy.order.memberFegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mayikt-member")
public interface MemberServiceFeign {

    @RequestMapping("/getUser")
    public String getUser(Integer userId);
}
