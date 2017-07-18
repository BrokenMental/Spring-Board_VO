package com.setting.controller;

import com.setting.domain.SettingVO;
import com.setting.service.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by Jinuk on 2017-07-17.
 */
@Controller
@RequestMapping(value = "/Board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    SettingService service;

    @RequestMapping(value = "/ListBoard", method = RequestMethod.GET)
    public void ListBoardGET(SettingVO set, Model model, Locale locale) throws Exception{
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("list", service.list(set));
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.GET)
    public void NewBoardGET() throws Exception{
        logger.info("===============|BOARD GET|===============");

        //return "Board/NewBoard"; // void가 아닌 다른 타입으로 반환형을 선언할 경우 필요
    }

    @RequestMapping(value = "/NewBoard", method = RequestMethod.POST)
    public String NewBoardPOST(SettingVO set) throws Exception{
        logger.info("==============|BOARD POST|===============");

        service.write(set);
        return "redirect:/";
    }

    @RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
    public void ReadBoardGET(@RequestParam("idx") int idx, Model model) throws Exception{
        logger.info("==============|BORAD READ|===============");
        model.addAttribute(service.read(idx));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
    public void ModifyBoardGET(int idx, Model model) throws  Exception{
        logger.info("============|BOARD MODIFY GET|=============");
        logger.info("idx : "+ idx);
        model.addAttribute(service.read(idx));
    }

    @RequestMapping(value = "/ModifyBoard", method = RequestMethod.POST)
    public String ModifyBoardPOST(SettingVO set) throws Exception{
        logger.info("============|BOARD MODIFY POST|=============");
        service.modify(set);
        return "redirect:/";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String RemoveBoard() throws Exception{
        return null;
    }
}
