package com.example.demo.topic.service;

import com.example.demo.topic.vo.TopicVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestService {
    public List<TopicVO> selectTopicsList();
    public TopicVO selectOneTopic(String title);
    public int insertTopic(TopicVO topicVO);
    public int deleteTopic(String title);
    int updateTopic(@Param("new_title") String new_title, @Param("description") String description, @Param("title") String title);
}
