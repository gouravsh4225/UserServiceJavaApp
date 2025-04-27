package com.user.service.UserServiceJavaApp.Controllers;

import com.user.service.UserServiceJavaApp.Model.Home;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {
    @RequestMapping("/")
    public Home Index() {
return new Home("Hello from model");
    }
}
