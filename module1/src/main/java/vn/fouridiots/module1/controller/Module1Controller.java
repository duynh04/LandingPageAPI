package vn.fouridiots.module1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/module1")
public class Module1Controller {

    @GetMapping("")
    public Map<String, Integer> getModule1() {
       Map<String, Integer> m = new HashMap<>();
       m.put("a", 1);
       m.put("b", 2);
       m.put("c", 3);
       return m;
    }
}