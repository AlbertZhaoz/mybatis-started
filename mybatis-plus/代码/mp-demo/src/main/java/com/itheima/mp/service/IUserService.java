package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import org.springframework.stereotype.Service;

/**
 * ClassName:IUserService
 * Package:com.itheima.mp.service
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/6/2024 12:39 PM
 * @Version 1.0
 */
public interface IUserService extends IService<User> {
    void deductionBalance(Long userId, Integer money);
}
