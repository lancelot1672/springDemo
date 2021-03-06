package com.example.demo.topic.service;

import com.example.demo.topic.mapper.TestMapper;
import com.example.demo.topic.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Override
    public TopicVO selectOneTopic(String title) {return testMapper.selectOneTopic(title);}

    @Override
    public int insertTopic(TopicVO topicVO) {return testMapper.insertTopic(topicVO);};

    @Override
    public int deleteTopic(String title){
        return testMapper.deleteTopic(title);
    }

    @Override
    public int updateTopic(String new_title, String description, String title){
        return testMapper.updateTopic(new_title, description, title);
    }
}
