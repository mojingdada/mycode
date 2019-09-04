package com.example.myweb.Service;

import com.example.myweb.dao.TestMapper;
import com.example.myweb.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MySQLTestService {
    @Autowired
    private TestMapper testMapper;  //这里会有报错，不用管

    public List<TestModel> select() {
        return testMapper.select();
    }

    public int insert(String name) {
        return testMapper.insert(name);
    }

}
