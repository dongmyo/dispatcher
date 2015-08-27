package com.nhnent.dispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SignInController {
    @Resource
    Map<String, String> langMap;


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam("id") String id,
                         HttpSession session) {
        if(!langMap.containsKey(id)) {
            throw new UserNotFoundException();
        }

        session.setAttribute("id", id);
        return "redirect:/?lang=" + langMap.get(id);
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public String signout(HttpSession session) {
        session.removeAttribute("id");
        return "redirect:/login";
    }

}
