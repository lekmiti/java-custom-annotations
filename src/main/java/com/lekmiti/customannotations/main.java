package com.lekmiti.customannotations;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws JsonSerializeException, IOException {
        Student student = new Student()
                .setFirstName("Wafa")
                .setLastName("Lekmiti")
                .setAge(22)
                .setCours("Languages")
                .setAddress("Paris")
                .build();
        JsonSerializer serializer = new JsonSerializer();
        serializer.serialize(student);
    }
}
