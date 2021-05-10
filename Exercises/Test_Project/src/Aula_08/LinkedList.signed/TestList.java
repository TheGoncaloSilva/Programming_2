import static java.lang.System.*;
import java.util.Arrays;

public class TestList
{
   // Lists for testing
   private static LinkedList<String> lst0;
   private static LinkedList<String> lst1;
   private static LinkedList<Integer> lst;

   public static void main(String[] args)
   {
      initLists();
      
      switch (args[0]) {

      case "B":
         out.println("B) addFirst -------------------");
         lst0.addFirst("zero");
         lst0.show("B1) lst0");
         lst1.addFirst("two");
         lst1.show("B2) lst1");
         for(int i=111; i<=113; i++) {
            lst.addFirst(i);
         }
         lst.show("B3) lst");
         break;

      case "C":
         out.println("C) count -------------------");
         out.printf("C1) %d\n", lst0.count("wally") );
         lst0.show("C2) lst0");
         out.printf("C3) %d\n", lst.count(19) );
         out.printf("C4) %d\n", lst.count(2) );
         out.printf("C5) %d\n", lst.count(3) );
         out.printf("C6) %d\n", lst.count(99) );
         lst.show("C7) lst");
         break;

      case "D":
         out.println("D) remove -------------------");
         lst1.remove(0);
         lst1.show("D1) lst1");

         int n = lst.size();
         lst.remove(10);
         lst.show("D2) lst");
         lst.remove(lst.size()-1);
         lst.show("D3) lst");
         lst.remove(0);
         lst.show("D4) lst");
         break;

      default:
         out.println("Unknown");
         exit(1);
      }
   }

   static void initLists() {
      out.println("\nInitializing lists with addLast --- ");
      lst0 = new LinkedList<String>();
      lst1 = new LinkedList<String>();
      lst1.addLast("one");

      lst = new LinkedList<Integer>();
      int[] values = {13, 1, 14, 2, 15, 3, 16, 3, 17, 2, 18, 1, 19};
      for(int i=0; i<values.length; i++) {
         lst.addLast(values[i]);
      }

      lst0.show("lst0");
      lst1.show("lst1");
      lst.show("lst");
   }

}