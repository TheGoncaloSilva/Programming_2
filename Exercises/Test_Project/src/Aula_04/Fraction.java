package Aula_04;

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

public class Fraction
{
  private int num;
  private int den;

  /** Cria uma nova fração a partir de um par (numerador, denominador).
   *  @param num numerador da nova fração.
   *  @param den denominador da nova fração.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num, int den) {
    assert den != 0; // check precondition
    this.num = num;
    this.den = den;
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
		assert result * (d) == (n) : "Problemas na divisão";
	}else {
		result = d / n;
		assert result * (n) == (d) : "Problemas na divisão";
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
	return den;
    //...
  }

}
