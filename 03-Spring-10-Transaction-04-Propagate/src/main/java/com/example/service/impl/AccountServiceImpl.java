package com.example.service.impl;


import com.example.dao.AccountDao;
import com.example.service.AccountService;
import com.example.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private LocationService locationService;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAccount(String name,String location) {
        accountDao.addAccount(name);

        try {
            locationService.addLocation(location);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
