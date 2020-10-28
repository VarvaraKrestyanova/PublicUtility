package com.MyTests;

public class Test1 {
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
    }
}

