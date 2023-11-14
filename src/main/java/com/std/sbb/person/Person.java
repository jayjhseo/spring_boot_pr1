package com.std.sbb.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
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
