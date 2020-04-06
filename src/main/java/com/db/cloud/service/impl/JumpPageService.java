package com.db.cloud.service.impl;

import com.db.cloud.dao.JumpPageDao;
import com.db.cloud.entity.po.Address;
import com.db.cloud.service.IJumpPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    @Override
    public List<Address> getAllAddress() {
        List<Address> addressList = jumpPageDao.getAllAddress();
        if(CollectionUtils.isEmpty(addressList)){
            return addressList;
        }
        Iterator<Address> iterator = addressList.iterator();
        while(iterator.hasNext()){
            Address address = iterator.next();
            if(address.getCode().equals("20180422")){
                iterator.remove();
            }
        }
        return addressList;
    }

    @Override
    public Address getRoundAddr() {
        Address address = new Address();
        List<Address> addressList = jumpPageDao.getAllAddress();
        if(CollectionUtils.isEmpty(addressList)){
            return address;
        }
        address = addressList.get(new Random().nextInt(addressList.size()));
        return address;
    }
}
