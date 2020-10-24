package com.publicUtility;

public class House {

    public float publicUtilityValue;

    public float countUtilityValue(float flatsOneRoom, float flatsTwoRooms, float humansPerOneRoomFlat, float humansPerTwoRoomsFlat, float squareOneRoomFlat, float squareTwoRoomsFlat) throws IllegalArgumentException {

        //EXCEPTION
        float x = flatsOneRoom;
        if (x < 0) {
            throw new IllegalArgumentException("Value of One-Room flat is negative and equals " + x);
        }
        //EXCEPTION


        float square = squareOneRoomFlat * flatsOneRoom + squareTwoRoomsFlat * flatsTwoRooms;
        publicUtilityValue = (flatsOneRoom * humansPerOneRoomFlat + flatsTwoRooms * humansPerTwoRoomsFlat) * (float) 1.5 + square * 2;  //obsluzhivanie lifta and utility per m^2
        System.out.println("Flats: " + flatsOneRoom + " one-room flats, " + flatsTwoRooms + " two-rooms flats. " + "The house's square is " + square + " square meters.");
        System.out.println("Public Utility of the house is " + publicUtilityValue + " rub.");
        return publicUtilityValue;
    }
}
