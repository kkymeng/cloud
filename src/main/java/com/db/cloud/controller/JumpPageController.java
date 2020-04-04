package com.db.cloud.controller;

import com.db.cloud.common.Result;
import com.db.cloud.common.ResultUtil;
import com.db.cloud.entity.po.Address;
import com.db.cloud.service.IJumpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 首页跳转服务
 * @author yunkk
 * @version 1.0
 * @date 2020/3/26 16:44
 */
@RestController
@RequestMapping(value = "/navigation")
public class JumpPageController {

    @Autowired
    private IJumpPageService jumpPageService;
    /**
     * 通过code查询地址对应信息
     * @param code
     * @return 接口地址信息
     */
    @PostMapping("/getAddr")
    public Result<Address> getAdderByCode(@RequestParam("adderCode")String code){
        Address address = new Address();
        address = jumpPageService.getAddressByCode(code);
        return ResultUtil.success(address);
    }

    /**
     * 获取所有Address接口
     */
    @GetMapping("/getAllAddr")
    public Result<List<Address>> getAllAddr(){
        List<Address> addressList = jumpPageService.getAllAddress();
        return ResultUtil.success(addressList);
    }

    /**
     * 获取随机地址接口
     */
    @GetMapping("/getRoundAddr")
    public Result<Address> getRoundAddr(){
        Address address = jumpPageService.getRoundAddr();
        return ResultUtil.success(address);
    }
}
