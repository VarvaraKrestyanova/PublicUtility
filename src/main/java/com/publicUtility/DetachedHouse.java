package com.publicUtility;

public class DetachedHouse extends House {
    public void countUtilityDetachedHouse(float flatsOneRoom, float flatsTwoRooms, float humansPerOneRoomFlat, float humansPerTwoRoomsFlat, float squareOneRoomFlat, float squareTwoRoomsFlat) {
        System.out.println("\n" + "DetachedHouse");
        countUtilityValue(flatsOneRoom, flatsTwoRooms, humansPerOneRoomFlat, humansPerTwoRoomsFlat, squareOneRoomFlat, squareTwoRoomsFlat);
    }
}
