package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "home";
    }
    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }
}
