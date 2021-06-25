package vn.fouridiots.module2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/module2")
public class Module2Controller {
    @GetMapping("")
    public Map<String, Integer> getModule1() {
        Map<String, Integer> m = new HashMap<>();
        m.put("d", 1);
        m.put("e", 2);
        m.put("f", 3);
        return m;
    }
}
