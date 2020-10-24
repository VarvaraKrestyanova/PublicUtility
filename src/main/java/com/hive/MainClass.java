package com.hive;

import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Hive hive = new Hive("Bee's Hive");

        List<Bee> beesList = Arrays.asList(
          new QueenBee(true, true, false, false, 1);
          new DroneBee(true, false, true, false, 3);
          new WorkerBee();
          new LarvaBee();
        );
    }
}
