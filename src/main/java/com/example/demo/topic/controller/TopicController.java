package com.example.demo.topic.controller;

import com.example.demo.topic.service.TestService;
import com.example.demo.topic.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TestService testService;
    //Autowired를 안했을 때 오류가 났었다. (NullPointerException

    //@PathVariable 을 이용한 경로 변수

    @RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
    public ModelAndView getTopic(@PathVariable String topicId){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(topicId);
        modelAndView.setViewName("topic");

        //글 목록
        List<TopicVO> list = testService.selectTopicsList();
        
        //해당 topic에 대한 내용
        TopicVO topic = testService.selectOneTopic(topicId);
        //View
        modelAndView.addObject("topicList", list);
        modelAndView.addObject("topic", topic);
        return modelAndView;
    }
}
