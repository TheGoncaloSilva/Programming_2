package Aula_04_ex_4_7;
/**
 * Tipo de dados representando uma fracão.
 * Nesta versão pretende-se garantir um invariante (interno) mais forte:
 * as frações armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * AVISO: Vários métodos podem dar erros devidos a overflow.
 * (Não deve haver problemas com numeradores e denominadores até 46430.)
 *
 * @author João Manuel Rodrigues
 * 2007--2018
 */

// public class Fraction
// trocar com o comparable para dizer que é preciso comparar os elementos. Usando isto é possivel usar a função Arrays.sort
public class Fraction implements Comparable<Fraction>
{
  private int num;
  private int den, maxDiv;
  public static Fraction ZERO = new Fraction(0, 1);
  public static Fraction ONE = new Fraction(1, 1);

  /** Cria uma nova fração a partir de um par (numerador, denominador).
   *  @param num numerador da nova fração.
   *  @param den denominador da nova fração.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num1, int den1) {
    assert den1 != 0; // check precondition
    this.num = num1;
    this.den = den1;
    invariant();
    this.maxDiv = maxDiv(num1, den1);
	num /= maxDiv;
	den /= maxDiv;
    assert invariant(); // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * Ã‰ para testar em asserções nos métodos.
   */
  public boolean invariant() {
	if(den < 0) {
		num *= -1;
		den *= -1;
	}
    return den > 0 && den != 0;   // O denominador não pode ser nulo!
  }
  
  //method to calculate all common divisors
  // of two given numbers
  // a, b --> input integer numbers
  public int maxDiv(int n1, int n2) {
	  
	  if(n1 == 0) return n2; // if numerator is 0, return denominator
	  
	  int r=0, a, b;
	  a = (n1 > n2) ? n1 : n2; // n1 is greater number  
	  b = (n1 < n2) ? n1 : n2; // n2 is smaller number  
	  r = b;
	  
	  while(a % b != 0)  
	  {  
		  r = a % b;  
		  a = b;  
		  b = r;  
	  }		
	  return r > 0 ? r : -r;  
  }

  /** Converte uma string numa fração.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fração válida.
   *  @return fração correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length == 2) ? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica d=1
    return new Fraction(n, d);
  }

  /** Converte a fração numa string.
   *  @return string com a representação desta fração.
   */
  public String toString() {
    // Com um invariante mais forte, podemos simplificar este método!
    String s;
    assert invariant();
    s = num + "/" + den;
    /*if (den > 0)
      s = num + "/" + den;
    else
      s = (-num) + "/" + (-den);*/
    return s;
  }

  /** Devolve o numerador da fração.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fração.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fração por outra (this * b).
   *  @param b multiplicando.
   *  @return fração produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    int n = num * b.num;
    int d = den * b.den;
    Fraction p = new Fraction(n, d); // product
    return p;
  }

  /** Adiciona esta fração com outra (this + b).
   *  @param b fração a adicionar a esta.
   *  @return fração soma de this + b.
   */
  public Fraction add(Fraction b) {
    int n = num * b.den + den * b.num;
    int d = den * b.den;
    Fraction s = new Fraction(n, d); // sum
    return s;
  }

  public Fraction divide(Fraction b) {
	assert invariant();
	assert b.invariant();
	int n = den * b.num;
	int d = num * b.den;
	double result;
	if(n >= d) {
		result = n / d;
		//assert result * (d) == (n) : "Problemas na divisão"; --> Test if the result isn't 0
	}else {
		result = d / n;
		//assert result * (n) == (d) : "Problemas na divisão"; --> Test if the result isn't 0
	}
	return new Fraction(num * b.den, den * b.num);
  }

  public Fraction subtract(Fraction b) {
	int n = num * b.den - den * b.num;
	int d = den * b.den;
	assert n + den * b.num == num * b.den : "Problemas na subtração";
	Fraction s = new Fraction(n, d);
	return s;
  }

  public boolean equals(Fraction b) {
	//return b.num == num && b.den == den;
	  return b.num / b.den == num / den;
  }

  public int compareTo(Fraction b) {
	  int op1 = b.num / b.den;
	  int op2 = num / den;
	  if(op1 > op2) return -1;
	  else if(op1 == op2) return 0;
	  else return 1;
  }

}
