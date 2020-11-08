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
    public static int min(int a, int b, int c) {
        if ((a < b) & (a < c)){
            return a;
        }else if ((b < a) & (b < c)){
            return b;
        }else{
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}

//}

