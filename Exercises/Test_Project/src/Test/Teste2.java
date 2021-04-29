package Test;

public class Teste2 {

	public static void main(String[] args) {
		System.out.println(reverseDigits(1234));
		System.out.println(countCaps("John Fitzgerald Kennedy"));

	}
	
	   public static int reverseDigits(int value) {   
	      return reverseAux(value, 0);
	   }

	   public static int reverseAux(int partialValue, int partialReversedValue) {
		   if(partialValue > 0)
			   return reverseAux((partialValue / 10), (partialReversedValue * 10) + (partialValue % 10));
		   else
			   return partialReversedValue;
	   }

	   public static int countCaps(String s) {
		  if(s.length() == 0)
			  return 0;
		  
		  char ch = s.charAt(0);            // the first character of s
		  String tail = s.substring(1);     // the rest of s
		  if (Character.isUpperCase(ch))
			  return 1 + countCaps(tail);
		  else
			  return countCaps(tail);
	   }

	}
