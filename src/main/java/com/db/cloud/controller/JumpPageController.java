package com.db.cloud.controller;

import com.db.cloud.common.Result;
import com.db.cloud.common.ResultUtil;
import com.db.cloud.entity.po.Address;
import com.db.cloud.service.IJumpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/getAdder")
    public Result<Address> getAdderByCode(@RequestParam("adderCode")String code){
        Address address = new Address();
        address = jumpPageService.getAddressByCode(code);
        return ResultUtil.success(address);
    }
}
