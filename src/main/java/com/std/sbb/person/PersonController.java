package com.std.sbb.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    List<Person> people;
//    boolean checkId;

    PersonController() {
        people = new ArrayList<>();
//        checkId = false;
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
        boolean removed = people.removeIf(person -> person.getId() == id);
         if (removed == false) {
             return "%d번 사람이 존재하지 않습니다.".formatted(id);
         }
         return "%d번 사람이 삭제되었습니다.".formatted(id);

//        *for문 이용한 삭제 리팩토링후*
//        Person person = getPeopleList(id);
//        if (person == null) {
//            return "%d번 사람이 존재하지 않습니다.".formatted(id);
//        }
//        System.out.println(person);
//        people.remove(person);
//        return "%d번 사람이 제거되었습니다.".formatted(person.getId());

//        *for문 이용한 삭제 리팩토링 전*
//        for (int i = 0; i < people.size(); i++) {
//            Person person = people.get(i);
//            if (person.getId() == id) {
//                people.remove(person);
//                checkId = true;
//                System.out.println(person);
//                return "%d번 사람이 제거되었습니다.".formatted(person.getId());
//            }
//        }
    }

    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String modifyPerson(int id, String name, int age) {
         Person found = people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
         if (found == null) {
             return "%d번 사람이 존재하지 않습니다.".formatted(id);
         }
         return "%d번 사람이 수정되었습니다.".formatted(id);
//        *for문 이용한 수정 리팩토링후*
//        Person person = getPeopleList(id);
//        if (person == null) {
//            return "%d번 사람이 존재하지 않습니다.".formatted(id);
//        }
//        person.setId(id);
//        person.setName(name);
//        person.setAge(age);
//        return "%d번 사람이 수정되었습니다.".formatted(person.getId());

//        *for문 이용한 수정 리팩토링 전*
//        for (int i = 0; i < people.size(); i++) {
//            Person person = people.get(i);
//            if (person.getId() == id) {
//                checkId = true;
//                person.setId(id);
//                person.setName(name);
//                person.setAge(age);
//
//                return "%d번 사람이 수정되었습니다.".formatted(person.getId());
//            }
//        }
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> people() {
        return people;
    }

    public Person getPeopleList(int id) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}

