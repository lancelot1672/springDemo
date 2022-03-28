package com.example.demo.topic.service;

import com.example.demo.topic.mapper.TestMapper;
import com.example.demo.topic.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TopicVO> selectTopicsList() {
        return testMapper.selectTopicsList();
    }
}
