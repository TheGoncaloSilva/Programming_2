package Aula_03_ex_3_5;

public class Room {
	private String place;
	private Point cie, csd;
	
	public Room() {} // Construtor por omissão
	
	public Room(Point csd, Point cie, String place) {
		this.place = place;
		this.cie = cie;
		this.csd = csd;
	}
	
	public String roomType() { return place; }
	public Point bottomLeft(){ return cie;	}
	public Point topRight() { return csd; }
	public Point geomCenter() { return new Point((topRight().x() + bottomLeft().y()/2), (topRight().y() + bottomLeft().x()/2)); }
	public double area() {
		double result = (topRight().x() - bottomLeft().x()) * (topRight().y() - bottomLeft().y());
		
		/* Not needed
		if(result < 0)
			result *= (-1);*/
		
		return  result;
		}
}
