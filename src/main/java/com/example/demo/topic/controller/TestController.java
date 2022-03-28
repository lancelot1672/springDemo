package com.example.demo.topic.controller;

import com.example.demo.topic.service.TestService;
import com.example.demo.topic.service.TestServiceImpl;
import com.example.demo.topic.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    //Autowired를 안했을 때 오류가 났었다. (NullPointerException

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public List<TopicVO> getTopic(){
        List<TopicVO> list = testService.selectTopicsList();
        return list;
    }
}
