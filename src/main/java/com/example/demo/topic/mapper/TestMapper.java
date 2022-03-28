package com.example.demo.topic.mapper;

import com.example.demo.topic.vo.TopicVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    List<TopicVO> selectTopicsList();
    TopicVO selectOneTopic(String title);   // Topic 한개 가져오기
    int insertTopic(TopicVO topicVO);   // insert Topic
    int deleteTopic(String title);  // Topic 삭제
}
