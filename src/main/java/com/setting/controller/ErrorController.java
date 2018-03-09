package com.setting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ErrorPage")
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/throwable")
    public String throwable(HttpServletRequest request,Model model){
        logger.info("throwable");
        pageErrorLog(request);
        model.addAttribute("msg","throwable ���� �߻�");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/exception")
    public String exception(HttpServletRequest request,Model model){
        logger.info("exception");
        pageErrorLog(request);
        model.addAttribute("msg","exception ���� �߻�");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/400")
    public String pageError400(HttpServletRequest request,Model model){
        logger.info("400 error");
        pageErrorLog(request);
        model.addAttribute("msg","�߸��� ��û�Դϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/403")
    public String pageError403(HttpServletRequest request,Model model){
        logger.info("403 error");
        pageErrorLog(request);
        model.addAttribute("msg","������ �����Ǿ����ϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/404")
    public String pageError404(HttpServletRequest request,Model model){
        logger.info("404 error");
        pageErrorLog(request);
        model.addAttribute("msg","��û�Ͻ� �������� �������� �ʽ��ϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/405")
    public String pageError405(HttpServletRequest request,Model model){
        logger.info("405 error");
        pageErrorLog(request);
        model.addAttribute("msg","��û�� �޼ҵ尡 ������ �ʽ��ϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/415")
    public String pageError415(HttpServletRequest request,Model model){
        logger.info("415 error");
        pageErrorLog(request);
        model.addAttribute("msg","��û�� ��û�� ���������� �������� �ʴ� �������� �Ǿ� �ֽ��ϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/500")
    public String pageError500(HttpServletRequest request,Model model){
        logger.info("500 error");
        pageErrorLog(request);
        model.addAttribute("msg","������ ������ ������ϴ�.");
        return "/ErrorPage/Error";
    }

    @RequestMapping(value = "/503")
    public String pageError503(HttpServletRequest request,Model model){
        logger.info("503 error");
        pageErrorLog(request);
        model.addAttribute("msg","���񽺸� ����� �� �����ϴ�.");
        return "/ErrorPage/Error";
    }

    private void pageErrorLog(HttpServletRequest request){
        logger.info("status_code: " + request.getAttribute("javax.servlet.error.status_code"));
        logger.info("exception_type: " + request.getAttribute("javax.servlet.error.exception_type"));
        logger.info("message: " + request.getAttribute("javax.servlet.error.message"));
        logger.info("request_uri: " + request.getAttribute("javax.servlet.error.request_uri"));
        logger.info("exception: " + request.getAttribute("javax.servlet.error.exception"));
        logger.info("servlet_name: " + request.getAttribute("javax.servlet.error.servlet_name"));
    }
}
