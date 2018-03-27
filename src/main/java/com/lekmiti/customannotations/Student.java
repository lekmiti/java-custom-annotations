package com.lekmiti.customannotations;

public class Student {

    @JsonKey
    private String firstName;

    @JsonKey
    private String lastName;

    private int age;

    @JsonKey("class")
    private String course;

    @IgnoreField
    private String address;

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;

    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;

    }

    public Student setCours(String course) {
        this.course = course;
        return this;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    public Student build() {
        return this;
    }

}
