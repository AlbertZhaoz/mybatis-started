package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserController
 * Package:com.itheima.mp.controller
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/6/2024 12:47 PM
 * @Version 1.0
 */

@Api(tags = "用户管理接口")
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor // Spring 推荐使用构造函数注入，（lombok)这个注解就可以解决写一堆构造函数的问题
public class UserController {
    private final IUserService userService;

    @PostMapping
    @ApiOperation("新增用户")
    // @RequestBody 表示可以接受 JSON 格式的前端提交
    public void saveUser(@RequestBody UserFormDTO userFormDTO){
        userService.save(BeanUtil.toBean(userFormDTO, User.class));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    // @RequestBody 表示可以接受 JSON 格式的前端提交
    public void deleteUser(@PathVariable("id") Long userId){
        userService.removeById(userId);
    }

    // 根据 userId 查询用户
    @GetMapping("/{id}")
    @ApiOperation("查询用户")
    public UserVO getUser(@PathVariable("id") Long userId){
        return BeanUtil.toBean(userService.getById(userId), UserVO.class);
    }

    // 根据 userId 批量查询用户
    @GetMapping
    @ApiOperation("查询用户列表")
    // PathVariable 格式：/users/id
    // RequestParam 格式：/users?id=1
    public List<UserVO> listUser(@RequestParam("ids") List<Long> ids){
        return BeanUtil.copyToList(userService.listByIds(ids), UserVO.class);
    }

    // 根据 id 扣减余额
    @PutMapping("/{id}/deduction/{money}")
    @ApiOperation("扣减余额")
    public void deductionBalance(@PathVariable("id") Long userId, @PathVariable("money") Integer money){
        userService.deductionBalance(userId, money);
    }
}
