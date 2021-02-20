package jd2_hw.spring_mvc_topic8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        System.out.println("----------------welcomePage-------------------------");
        return "welcome";
    }
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String productPage(ModelMap model) {
        System.out.println("----------------productPage-------------------------");
        return "product";
    }
    @RequestMapping(value = {"/help"}, method = RequestMethod.GET)
    public String helpPage(ModelMap model) {
        System.out.println("----------------helpPage-------------------------");
        return "help";
    }
    @RequestMapping(value = {"/aboutus"}, method = RequestMethod.GET)
    public String aboutUsPage(ModelMap model) {
        System.out.println("----------------aboutUsPage-------------------------");
        return "aboutus";
    }
}
