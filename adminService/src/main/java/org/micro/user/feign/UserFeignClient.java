package org.micro.user.feign;

import org.micro.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 声明需要调用的微服务名称
 */
@FeignClient(name = "userService", fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {
    /**
     * 声明需要调用的微服务接口
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findbyid(@PathVariable("id") int id);
}
