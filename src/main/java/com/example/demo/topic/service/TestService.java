package com.example.demo.topic.service;

import com.example.demo.topic.vo.TopicVO;

import java.util.List;

public interface TestService {
    public List<TopicVO> selectTopicsList();
    public TopicVO selectOneTopic(String title);
    public int insertTopic(TopicVO topicVO);
    public int deleteTopic(String title);
}
