package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "すいようのどようのうしのひ");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test2/{size}", "/test2"})
    public Map<String, Object> test2(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse(size.orElse(10).intValue());
    }

    private Map<String, Object> createResponse(int size) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i = 1; i <= size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + i, "value" + i);
            list.add(map);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", list);
        return map;
    }
}
