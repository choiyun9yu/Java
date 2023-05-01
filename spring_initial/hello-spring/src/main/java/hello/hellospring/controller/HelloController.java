package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

        @GetMapping("hello") // 이렇게 하면 '/hello' 로 들어온 경우 아래 메소드를 실행시켜 준다.
        public String hello(Model model){
            model.addAttribute("data","hello!!");
            return "hello";
        }

        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
            model.addAttribute("name", name);
            return "hello-template";
    }

        @GetMapping("hello-string")
        @ResponseBody
        public String helloString(@RequestParam("name") String name) {
            return "hello " + name;
        }
}
