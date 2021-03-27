package Aula_03_ex_3_5;

public class testezinho {

	public static void main(String[] args) {
		String[] rooms = new String[8];
		rooms[0] = "teste1";
		rooms[1] = "teste2";
		rooms[2] = "teste3";
		rooms[3] = "teste4";
		rooms[4] = "teste5";
		rooms[5] = "teste6";
		rooms[6] = "teste7";
		rooms[7] = "teste8";
		
		for(int i = 0; i < 8; i++ ) {
			System.out.println(rooms[i]);
		}
		String[] rooms2 = new String[rooms.length+4];
		
		rooms2 = rooms;
		
		rooms2[8] = "teste9";
		rooms2[9] = "teste10";
		rooms2[10] = "teste11";
		rooms2[11] = "teste12";
		for(int i = 0; i < 12; i++ ) {
			System.out.println(rooms2[i]);
		}

	}

}
