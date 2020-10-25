package com.hive;

public class MainClass {
    public static void main(String[] args) {
        //Hive hive = new Hive();

        /*List<Bee> hive = Arrays.asList(
          new QueenBee(true, true, false, false, 1),
          new DroneBee(true, false, true, false, 3),
          new WorkerBee(true, false, false, true, 30),
          new LarvaBee(true, false, false, false, 10)
        );*/

        int hiveNectarValue = 10000;

        QueenBee queenBee = new QueenBee();
        queenBee.beeNectar(true, true, false, false, 1);

        DroneBee droneBee = new DroneBee();
        droneBee.beeNectar(true, false, true, false, 3);

        WorkerBee workerBee = new WorkerBee();
        workerBee.beeNectar(true, false, false, true, 30);

        LarvaBee larvaBee = new LarvaBee();
        larvaBee.beeNectar(true, false, false, false, 10);

        hiveNectarValue -= queenBee.beeNectarValue + droneBee.beeNectarValue + workerBee.beeNectarValue + larvaBee.beeNectarValue;

        System.out.println("There are " + hiveNectarValue + " units of nectar left in the hive.");

        /*Bee queenBee = new Bee(1);
        Bee droneBee = new Bee(2);
        Bee workerBee = new Bee(3);
        Bee larvaBee = new Bee(4);*/
    }
}
