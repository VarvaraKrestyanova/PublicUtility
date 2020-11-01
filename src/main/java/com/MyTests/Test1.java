package com.MyTests;

/*public class Test1 {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        man.wife = woman;
        woman.husband = man;
        System.out.println(man);
    }

    public static class Man {
        int age = 30;
        public int height;
        public Woman wife;

    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }*/

/*
Питомцам нужны люди
*/

class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();
        Woman woman = new Woman();
        cat.owner = woman;
        dog.owner = woman;
        fish.owner = woman;


    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}

//}

