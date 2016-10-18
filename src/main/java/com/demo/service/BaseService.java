package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qiutian on 16-10-15.
 */
@Service
public class BaseService {

    @Resource(name="jdbcTemplate")
    protected JdbcTemplate jdbc;
}
