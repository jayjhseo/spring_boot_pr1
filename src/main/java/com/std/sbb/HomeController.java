package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.AWTEventMulticaster.add;
import static javax.swing.UIManager.put;

@Controller
public class HomeController {
    private int i;

    public HomeController() {
        i = -1;
    }
    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }
    @GetMapping("home/main2")
    @ResponseBody
    public String ShowMain2() {
        return "반갑습니다.";
    }
    @GetMapping("home/main3")
    @ResponseBody
    public String ShowMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int ShowMain4() {
        i++;
        return i;
    }
    @GetMapping("home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a+b;
    }
    @GetMapping("home/minus")
    @ResponseBody
    public int showMinus(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a-b;
    }
    @GetMapping("home/multiply")
    @ResponseBody
    public int showMultiply(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a*b;
    }
    @GetMapping("home/divide")
    @ResponseBody
    public int showDivide(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a/b;
    }
    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean returnBoolean () {
        return true;
    }
    @GetMapping("/home/returnPi")
    @ResponseBody
    public double returnPi() {
        return Math.PI;
    }
    @GetMapping("/home/returnInt")
    @ResponseBody
    public int[] returnList() {
        int[] arr = new int[]{10,20,30};
        return arr;
    }
    @GetMapping("/home/returnList")
    @ResponseBody
    public List<Integer> returnIntList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        return list;
    }

}



class Car {
    private int id;
    private int speed;
    private String name;
    private List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.relatedIds = relatedIds;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }
}
@Getter
@Setter
@AllArgsConstructor
class CarV2 {
    private int id;
    private int speed;
    private String name;
    private List<Integer> relatedIds;
}

