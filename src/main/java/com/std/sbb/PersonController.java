package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    List<Person> people;
    boolean checkId;
    PersonController() {
        people = new ArrayList<>();
        checkId = false;
    }
    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson(String name, int age) {
        Person p = new Person(name, age);
        people.add(p);
        System.out.println(p);

        return "%d번 사람이 추가되었습니다.".formatted(p.getId());
    }
    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId() == id) {
                people.remove(person);
                checkId = true;
                System.out.println(person);
                return "%d번 사람이 제거되었습니다.".formatted(person.getId());
            }
        } if (checkId != true) {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }
        return null;
    }
    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String modifyPerson(int id, String name, int age) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId() == id) {
                checkId = true;
                person.setId(id);
                person.setName(name);
                person.setAge(age);

                return "%d번 사람이 수정되었습니다.".formatted(person.getId());
            }
        } if (checkId != true) {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }
        return null;
    }
    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> people() {
        return people;
    }
}
@Getter
@AllArgsConstructor
@ToString
@Setter
class Person {
    private static int lastId;
    private int id;
    private String name;
    private int age;

    static {
        lastId = 0;
    }
    public Person(int id) {
        this.id = id;
    }
    public Person(String name, int age) {
        this(++lastId, name, age);
    }
}
