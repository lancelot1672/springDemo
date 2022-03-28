package com.example.demo.topic.controller;

import com.example.demo.topic.service.TestService;
import com.example.demo.topic.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TestService testService;
    //Autowired를 안했을 때 오류가 났었다. (NullPointerException

    // create-process
    @RequestMapping(value = "/create-process", method = RequestMethod.POST)
    public ModelAndView insertTopic(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        // Request getParameter
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        //Topic 생성
        TopicVO topicVO = new TopicVO();
        topicVO.setTitle(title);
        topicVO.setDecription(description);
        
        //추후 변경 - 로그인 세션 기능 구현하고
        topicVO.setAuthor_id("lancelot1672");

        //DB insert
        int i = testService.insertTopic(topicVO);

        // home redirect
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    // delete
    @RequestMapping(value = "/delete/{topicId}", method = RequestMethod.GET)
    public ModelAndView deleteTopic(@PathVariable String topicId){
        ModelAndView modelAndView = new ModelAndView();

        //DB delete
        int i = testService.deleteTopic(topicId);

        // home redirect
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    // update-process
    @RequestMapping(value = "/update-process", method = RequestMethod.GET)
    public ModelAndView update_Topic(@PathVariable String topicId){
        ModelAndView modelAndView = new ModelAndView();

        //DB delete


        // home redirect
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    // update
    @RequestMapping(value = "/update/{topicId}", method = RequestMethod.GET)
    public ModelAndView updateTopic(@PathVariable String topicId){
        ModelAndView modelAndView = new ModelAndView();

        //update 화면


        // home redirect
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
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
