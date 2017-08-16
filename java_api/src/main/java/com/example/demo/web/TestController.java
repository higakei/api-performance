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

    @RequestMapping(method = RequestMethod.GET, path = {"/test2AfterInitialize/{size}", "/test2AfterInitialize"})
    public Map<String, Object> test2AfterInitialize(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse2(size.orElse(10).intValue());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test2ByArray/{size}", "/test2ByArray"})
    public Map<String, Object> test2ByArray(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse3(size.orElse(10).intValue());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test2ByLinkedList/{size}", "/test2ByLinkedList"})
    public Map<String, Object> test2ByLinkedList(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse4(size.orElse(10).intValue());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test2AfterInitialize2/{size}", "/test2AfterInitialize2"})
    public Map<String, Object> test2AfterInitialize2(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse5(size.orElse(10).intValue());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test2ByLinkedList2/{size}", "/test2ByLinkedList2"})
    public Map<String, Object> test2ByLinkedList2(@PathVariable(name = "size", required = false) Optional<Integer> size) {
        return createResponse6(size.orElse(10).intValue());
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

    private Map<String, Object> createResponse2(int size) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>(size);
        for (int i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + (i + 1), "value" + (i + 1));
            list.add(map);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", list);
        return map;
    }

    private Map<String, Object> createResponse3(int size) {

        Map<String, String>[] array = new Map[size];
        for (int i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + (i + 1), "value" + (i + 1));
            array[i] = map;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", Arrays.asList(array));
        return map;
    }

    private Map<String, Object> createResponse4(int size) {

        List<Map<String, String>> list = new LinkedList<Map<String, String>>();
        for (int i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + (i + 1), "value" + (i + 1));
            list.add(map);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", list);
        return map;
    }

    private Map<String, Object> createResponse5(int size) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>(size);
        for (int i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + (i + 1), "value" + (i + 1));
            list.add(i, map);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", list);
        return map;
    }

    private Map<String, Object> createResponse6(int size) {

        List<Map<String, String>> list = new LinkedList<Map<String, String>>();
        for (int i = 0; i < size; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key" + (i + 1), "value" + (i + 1));
            list.add(i, map);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("results", list);
        return map;
    }

}
