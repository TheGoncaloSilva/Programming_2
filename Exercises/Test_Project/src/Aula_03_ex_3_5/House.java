package Aula_03_ex_3_5;

public class House {
	private String hab;
	// nDivExtra corresponde �s divis�es extra que vamos usar para calcular a incrementa��o de tamanho no array
	private int nDiv = 8, nDivExtra = 4, count = 0;
	private Room[] rooms;
	
	public House() {} // Construtor por omiss�o
	
	
	public House(String hab) {
		this.hab = hab;
		rooms = new Room[8]; // Inicializar o array com o tamanho 8
	}
	
	public House(String hab, int nDiv, int nDivExtra) {
		this.hab = hab;
		this.nDiv = nDiv; // N�mero m�ximo de divis�es iniciais transmitidos
		this.nDivExtra = nDivExtra; 
		rooms = new Room[(nDiv + 1)]; // Inicializar o array com o n�mero de divis�es da casa
	}
	
	public void addRoom(Room data) { // Adicionar uma nova divis�o
		rooms[count++] = data;
		if(count == rooms.length) {
			nDiv = rooms.length + nDivExtra; // N�mero m�ximo de divis�es com o incremento do array
			Room[] rooms2 = new Room[nDiv]; // Criar um array novo com o tamanho superior ao antigo
			for(int i = 0; i < count; i++) {
				rooms2[i] = rooms[i];
			}
			rooms = rooms2;
		}
	}
	public int size () { return count; }
	public int maxSize() { return nDiv; }
	public Room room(int n) { 
		return rooms[n];}
	
	public double area() {
		double aux = 0;
		for(int i = 0; i < count; i++) {
			aux += rooms[i].area();
		}
		return aux;
	}
	public RoomTypeCount[] getRoomTypeCounts() {
		RoomTypeCount[] result = new RoomTypeCount[size()]; // Inicializar um array com o tamanho do atual array Rooms
		
		for(int i = 0; i < size(); i++) {
			result[i] = new  RoomTypeCount(); // Criar uma nova inst�ncia de cada objeto do array
		}
		int aux = 0;
		boolean write;
		for(int i = 0; i < count; i++) {
			write = false; // reinicia��o de vari�vel
			for(int c = 0; c < result.length - 1; c++) {
				if(rooms[i].roomType().equals(result[c].roomType())) { // se existir um resultado
					System.out.println(rooms[i].roomType());
					result[c].increase(); // aumenta o contador desse resultado
					write = true; // avisa-nos que foi alterado um valor
				}
			}
			if(!write) { // Se n�o existir um resultado
				result[aux++] = new RoomTypeCount(rooms[i].roomType(), 1); // criar um novo resultado
			}
		}
		RoomTypeCount[] temp = new RoomTypeCount[aux]; // Criar uma nova vari�vel para podermos obter o tamanho exato do nosso array
		for(int i = 0; i < aux; i++) {
			temp[i] = result[i];
		}
		result = temp; // reinciar o array result com o tamanho e valores corretos
		
		return result;
	}
	
	public double averageRoomDistance() {
		double dist = 0; 
		int extra = 0;
		for(int i = 0; i < count; i++) {
			for(int j = i + 1; j < count; j++) {
				// calcular a dist�ncia m�dia entre duas divis�es por vez
				dist += rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				extra++; //contar a quantidade de combina��es poss�veis
			}
			
		}
		// devolver a m�dia da dist�ncia entre as divis�es
		return (dist / extra);
	}
}
