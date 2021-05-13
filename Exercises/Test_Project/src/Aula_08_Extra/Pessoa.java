package Aula_08_Extra;

import java.util.Date;

import Aula_04.Data;

public class Pessoa implements Comparable<Pessoa>{
	private Data Data;
	private String Nome;
	
	public Pessoa(){}
	
	public Pessoa(Data data, String name){
		this.Data = data;
		this.Nome = name;
	}
	
	public String toString() {
		//return String.format("%04d-%02d-%02d", Data, Nome);
		return String.format("%s - %s", Data.toString(), Nome);
	}

	@Override
	public int compareTo(Pessoa o) {
		if(Data.mes() == o.Data.mes()) {
			if(Data.dia() == o.Data.mes())
				return 0;
			else if(Data.dia() < o.Data.mes())
				return -1;
			else
				return 1;
		}else if(Data.mes() < o.Data.mes())
			return -1;
		else 
			return 1;
	}
}
