package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method= RequestMethod.GET)
    public Map<String, Object> test() {
        Map map = new HashMap<String, Object>();
        map.put("result", "すいようのどようのうしのひ");
        return map;
    }
}
