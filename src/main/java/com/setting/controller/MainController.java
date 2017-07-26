package com.setting.controller;

import com.setting.service.PluginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

/**
 * Created by Jinuk on 2017-07-07.
 */

@Controller // 아래의 클래스가 컨트롤러임을 선언
public class MainController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PluginService service;

    @RequestMapping(value = "/", method = RequestMethod.GET) // 괄호안(value 경로)에 해당하는 파일들에 아래 메서드를 적용한다.
    public String list(Locale locale){
        logger.info("Welcome home! The client locale is {}.", locale);
        //logger.debug("debug");

        return "Plugin/Login";
        //return "index"; // 컨트롤러 실행시 매핑 위치에 연결되어야 할 파일명 반환
    }

    @RequestMapping(value = "/Plugin/Login", method = RequestMethod.GET)
    public void LoginGET(){
        logger.info("===============|Login GET Page|===============");
    }

    @RequestMapping(value = "/Plugin/Login", method = RequestMethod.POST)
    public String LoginPOST(@RequestParam("id") String id, Model model){
        logger.info("===============|Login POST Page|===============");
        logger.info(id);
        model.addAttribute(service.id(id));
        return "Board/ListBoard";
    }

    /*@RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("spring", "spring"); // 첫번째 인수를 두번째 인수를 별칭으로 보낸다.
        return "hello";
    }*/

    /*  데이터 모델이 특정 이름을 가진 View로 전달되어 사용할 수 있도록 처리해주는 메서드 */
    /*public ModelAndView springWebSample() {
        String message = "First smaple with the spring Framework";
        // 리턴값의 첫번째 매개변수에 해당하는 파일을 찾아 세번째 변수를 두번째 모델의 이름으로 전달한다.
        return new ModelAndView("spring", "message", message);
    }*/

}
