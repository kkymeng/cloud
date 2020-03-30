package com.db.cloud.service.impl;

import com.db.cloud.dao.JumpPageDao;
import com.db.cloud.entity.po.Address;
import com.db.cloud.service.IJumpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunkk
 * @description 跳转实现服务
 */
@Service
public class JumpPageService implements IJumpPageService {

    @Autowired
    private JumpPageDao jumpPageDao;

    @Override
    public Address getAddressByCode(String code) {
        return jumpPageDao.getAddressByCode(code);
    }
}
