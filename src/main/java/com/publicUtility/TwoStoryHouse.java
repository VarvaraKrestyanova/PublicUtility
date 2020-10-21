package com.publicUtility;

public class TwoStoryHouse extends House{
    public void countUtilityTwoStoryHouse(float flatsOneRoom, float flatsTwoRooms, float humansPerOneRoomFlat, float humansPerTwoRoomsFlat, float squareOneRoomFlat, float squareTwoRoomsFlat) {
        System.out.println("\n" + "Two-Story House");
        countUtilityValue(flatsOneRoom, flatsTwoRooms, humansPerOneRoomFlat, humansPerTwoRoomsFlat, squareOneRoomFlat, squareTwoRoomsFlat);
    }
}
