package Aula_02;

public class Contacto {
	  private String nome;
	  private String telefone;
	  private String email;
	  
	  Contacto(String nome, String telefone){
		  this.nome = nome;
		  this.telefone = telefone;
	  }
	  Contacto(String nome, String telefone, String email){
		  this.nome = nome;
		  this.telefone = telefone;
		  this.email = email;
	  }
	  
	  String nome() { return nome; }
	  
	  String telefone() { return telefone; }
	  
	  String eMail() { return email; }
}
