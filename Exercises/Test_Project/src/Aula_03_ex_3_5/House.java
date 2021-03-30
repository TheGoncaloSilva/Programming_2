package Aula_03_ex_3_5;

public class House {
	private String hab;
	// nDivExtra corresponde às divisões extra que vamos usar para calcular a incrementação de tamanho no array
	private int nDiv = 8, nDivExtra = 4, count = 0;
	private Room[] rooms;
	
	public House() {} // Construtor por omissão
	
	
	public House(String hab) {
		this.hab = hab;
		rooms = new Room[8]; // Inicializar o array com o tamanho 8
	}
	
	public House(String hab, int nDiv, int nDivExtra) {
		this.hab = hab;
		this.nDiv = nDiv; // Número máximo de divisões iniciais transmitidos
		this.nDivExtra = nDivExtra; 
		rooms = new Room[(nDiv + 1)]; // Inicializar o array com o número de divisões da casa
	}
	
	public void addRoom(Room data) { // Adicionar uma nova divisão
		rooms[count++] = data;
		if(count == rooms.length) {
			nDiv = rooms.length + nDivExtra; // Número máximo de divisões com o incremento do array
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
			result[i] = new  RoomTypeCount(); // Criar uma nova instância de cada objeto do array
		}
		int aux = 0;
		boolean write;
		for(int i = 0; i < count; i++) {
			write = false; // reiniciação de variável
			for(int c = 0; c < result.length - 1; c++) {
				if(rooms[i].roomType().equals(result[c].roomType())) { // se existir um resultado
					System.out.println(rooms[i].roomType());
					result[c].increase(); // aumenta o contador desse resultado
					write = true; // avisa-nos que foi alterado um valor
				}
			}
			if(!write) { // Se não existir um resultado
				result[aux++] = new RoomTypeCount(rooms[i].roomType(), 1); // criar um novo resultado
			}
		}
		RoomTypeCount[] temp = new RoomTypeCount[aux]; // Criar uma nova variável para podermos obter o tamanho exato do nosso array
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
				// calcular a distância média entre duas divisões por vez
				dist += rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				extra++; //contar a quantidade de combinações possíveis
			}
			
		}
		// devolver a média da distância entre as divisões
		return (dist / extra);
	}
}
