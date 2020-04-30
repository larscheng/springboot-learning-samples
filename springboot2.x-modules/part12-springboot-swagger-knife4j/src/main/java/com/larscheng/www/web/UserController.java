package com.larscheng.www.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.larscheng.www.config.Message;
import com.larscheng.www.pojo.Teacher;
import com.larscheng.www.pojo.User;
import com.larscheng.www.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午7:50
 * @description:
 */
@RestController
@Api(tags = "Tag-用户")
@ApiSort(200)
public class UserController {

    @ApiOperationSupport(author = "zhengql")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对") })
    @ApiOperation(value = "用户列表查询")
    @PostMapping("/user/list")
    public Message<List<User>> userList(@RequestBody UserVo vo){
        List<User> users = new ArrayList<>();
        users.add(new User().setName("asdasdasd"));
        users.add(new User().setName("12312"));
        return new Message<List<User>>().setData(users);
    }
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "username",value = "订单编号-gson"),
            @DynamicParameter(name = "name",value = "订单编号1-gson"),
    })
    @ApiOperation(value = "用户列表查询")
    @ApiOperationSupport(author = "zhengql",ignoreParameters = {"id","age"})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @PostMapping("/user/list2")
    public Message<List<User>> userList2(@RequestBody UserVo vo){
        List<User> users = new ArrayList<>();
        users.add(new User().setName("asdasdasd"));
        users.add(new User().setName("12312"));
        return new Message<List<User>>().setData(users);
    }


    @ApiOperationSupport(author = "zhengql")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @ApiOperation(value = "用户列表查询2")
    @PostMapping("/user/list3")
    public Message<List<User>> userList3(@RequestBody List<UserVo> vos){
        List<User> users = new ArrayList<>();
        users.add(new User().setName("asdasdasd"));
        users.add(new User().setName("12312"));
        return new Message<List<User>>().setData(users);
    }

    @ApiOperationSupport(author = "zhengql",ignoreParameters = {"id","offset","search","searchBgnTime","searchEndTime","sort"})
    @ApiOperation(value = "查询用户")
    @PostMapping("/user/list4")
    public Message<User> queryUser(@RequestBody UserVo vo){
        Message<User> message = new Message<>();
        message.setData(new User().setName("12312312"));
        return message;
    }

    @ApiOperationSupport(author = "zhengql",ignoreParameters = {"id","offset","search","searchBgnTime","searchEndTime","sort"})
    @ApiOperation(value = "查询用户")
    @PostMapping("/user/list5")
    public Message<UserVo> queryUser2(@RequestBody UserVo vo){
        Message<UserVo> message = new Message<>();
        message.setData(vo);
        return message;
    }

    @ApiOperationSupport(author = "zhengql",ignoreParameters = {"id","offset","search","searchBgnTime","searchEndTime","sort"})
    @ApiOperation(value = "查询用户")
    @PostMapping("/user/list6")
    public Teacher queryUser3(@RequestBody User vo){
        return new Teacher();
    }
    @ApiOperationSupport(author = "zhengql",ignoreParameters = {"id","offset","search","searchBgnTime","searchEndTime","sort"})
    @ApiOperation(value = "查询用户")
    @PostMapping("/user/list7")
    public Message<Teacher> queryUser4(@RequestBody User vo){
        return new Message<Teacher>().setData(new Teacher());
    }

}
