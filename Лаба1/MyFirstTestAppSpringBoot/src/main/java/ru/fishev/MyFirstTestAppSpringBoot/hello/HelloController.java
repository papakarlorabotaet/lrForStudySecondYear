package ru.fishev.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> list = new ArrayList<String>();
    private HashMap<Integer, String> map = new HashMap<Integer, String>();
    private int countKeyHashMap = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name)  {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "element") String s) {
        if (list.isEmpty()) {
            list.add(s);
            System.out.println("Array list is created"); // да я обманул, да он уже был создан когда собирался проект, но никто этого не узнает
            System.out.println("Array = "+list);
        } else {
            list.add(s);
            System.out.println("Array = "+list);
        }
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return list.toString();
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "element") String s) {
        if (map.isEmpty()) {
            map.put(countKeyHashMap, s);
            System.out.println("Hash map is created"); // да я обманул, да он уже был создан когда собирался проект, но никто этого не узнает
            System.out.println("HashMap = "+map.toString());
            countKeyHashMap++;
        } else {
            map.put(countKeyHashMap, s);
            System.out.println("HashMap = "+ map);
            countKeyHashMap++;
        }
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return map.toString();
    }

    @GetMapping("/show-all-length")
    public String showLengthArrayAndHash() {
        String text = "Длинна массива " + list.size() + "Длинна hashMap " + map.size();
        return text;
    }




}
