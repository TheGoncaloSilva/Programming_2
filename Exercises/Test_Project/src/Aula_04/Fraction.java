package Aula_04;

/**
 * Tipo de dados representando uma frac�o.
 * Nesta vers�o pretende-se garantir um invariante (interno) mais forte:
 * as fra��es armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns m�todos.
 *
 * AVISO: V�rios m�todos podem dar erros devidos a overflow.
 * (N�o deve haver problemas com numeradores e denominadores at� 46430.)
 *
 * @author Jo�o Manuel Rodrigues
 * 2007--2018
 */

public class Fraction
{
  private int num;
  private int den;

  /** Cria uma nova fra��o a partir de um par (numerador, denominador).
   *  @param num numerador da nova fra��o.
   *  @param den denominador da nova fra��o.
   *  <b>Exige (pr�-condi��o):</b> den != 0.
   */
  public Fraction(int num, int den) {
    assert den != 0; // check precondition
    this.num = num;
    this.den = den;
    assert invariant(); // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fra��o.
   * É para testar em asser��es nos m�todos.
   */
  public boolean invariant() {
	if(den < 0) {
		num *= -1;
		den *= -1;
	}
    return den > 0 && den != 0;   // O denominador n�o pode ser nulo!
  }

  /** Converte uma string numa fra��o.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fra��o v�lida.
   *  @return fra��o correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em at� 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length == 2) ? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, sen�o fica d=1
    return new Fraction(n, d);
  }

  /** Converte a fra��o numa string.
   *  @return string com a representa��o desta fra��o.
   */
  public String toString() {
    // Com um invariante mais forte, podemos simplificar este m�todo!
    String s;
    assert invariant();
    s = num + "/" + den;
    /*if (den > 0)
      s = num + "/" + den;
    else
      s = (-num) + "/" + (-den);*/
    return s;
  }

  /** Devolve o numerador da fra��o.
   *  @return numerador desta fra��o.
   */
  public int num() { return num; }

  /** Devolve o denominador da fra��o.
   *  @return denominador desta fra��o.
   */
  public int den() { return den; }

  /** Multiplica esta fra��o por outra (this * b).
   *  @param b multiplicando.
   *  @return fra��o produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    int n = num * b.num;
    int d = den * b.den;
    Fraction p = new Fraction(n, d); // product
    return p;
  }

  /** Adiciona esta fra��o com outra (this + b).
   *  @param b fra��o a adicionar a esta.
   *  @return fra��o soma de this + b.
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
		assert result * (d) == (n) : "Problemas na divis�o";
	}else {
		result = d / n;
		assert result * (n) == (d) : "Problemas na divis�o";
	}
	return new Fraction(num * b.den, den * b.num);
  }

  public Fraction subtract(Fraction b) {
	int n = num * b.den - den * b.num;
	int d = den * b.den;
	assert n + den * b.num == num * b.den : "Problemas na subtra��o";
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
