package Aula_03_ex_3_5;

public class RoomTypeCount {
	String roomType;
	int count;
	
	public RoomTypeCount() {} // Construtor por omissão
	
	public RoomTypeCount(String roomType, int count) {
		this.roomType = roomType;
		this.count = count;
	}
	public void increase() { count++;}
	
	public String roomType() {return roomType;}
	public int count() { return count;}
}
