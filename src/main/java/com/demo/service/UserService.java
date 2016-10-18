package com.demo.service;

//import com.demo.data.UserRepository;
import com.demo.data.accountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiutian on 16-9-26.
 */
@Service
public class UserService {

    //@Autowired
    //private UserRepository userRepository;

    public String getUserName(long id){
        //List<accountinfo> lst = userRepository.findByBalance(new Integer(1000));

        //List<accountinfo> findByBalance
        //List<accountinfo> lst = userRepository(new Integer(1000));
        String name = "123";
        return name;
    }


}
