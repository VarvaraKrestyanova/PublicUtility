package com.hive;

public class Bee {
    int makeBabyNectar = 0;
    int coordinationNectar = 0;
    int dieNectar = 0;
    int workNectar = 0;
    int beeNectarValue = 0;

    public int beeNectar(boolean makeBaby, boolean coordination, boolean die, boolean work, int count) {
        if (makeBaby == true){
            makeBabyNectar += 100;
        }

        if (coordination == true){
            coordinationNectar += 50;
        }

        if (work == true){
            workNectar += 30;
        }

        beeNectarValue += (makeBabyNectar + coordinationNectar + dieNectar + workNectar) * count;
        return beeNectarValue;
    }
}
