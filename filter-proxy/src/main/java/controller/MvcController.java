package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller에 restcontroller를 붙이면 메서드에 @Responsebody를 붙이지 않아도 message converter?로 인식
public class MvcController {
    @GetMapping("/hello")
    public String test() {
        return "Hello World";
    }
}
