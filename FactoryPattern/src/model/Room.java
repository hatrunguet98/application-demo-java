package model;

public class Room {
    private int numRoom;

    public Room() {
    }

    public Room(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numRoom=" + numRoom +
                '}';
    }
}
