package codecheck;

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
         out.println("B) removeSecond -------------------");
         while (lst.size() >= 2) {
            lst.removeSecond();
            lst.show("B1) lst");
         }
         lst.addLast(111); // add after removing
         lst.show("B2) lst");
         lst.addFirst(222); // add after removing
         lst.show("B3) lst");
         break;

      case "C":
         out.println("C) copyToArray -------------------");
         String[] a0 = { "A", "B" };
         out.printf("C1) return: %d\n", lst0.copyToArray(a0) );
         out.printf("C2) a0: %s\n", Arrays.toString(a0) );
         lst0.show("C3) lst0");
         out.printf("C4) return: %d\n", lst1.copyToArray(a0) );
         out.printf("C5) a0: %s\n", Arrays.toString(a0) );
         lst1.show("C6) lst1");
         Integer[] a;
         a = new Integer[lst.size() + 2];
         out.printf("C7) return: %d\n", lst.copyToArray(a) );
         out.printf("C8) a: %s\n", Arrays.toString(a) );
         lst.show("C9) lst");
         a = new Integer[5];
         out.printf("C10) return: %d\n", lst.copyToArray(a) );
         out.printf("C11) a: %s\n", Arrays.toString(a) );
         lst.show("C12) lst");
         break;

      case "D":
         out.println("D) removeElem -------------------");
         String one = new String(lst1.first());
         lst1.removeElem(one);
         lst1.show("D1) lst1");

         lst.removeElem(2);
         lst.show("D2) lst");
         lst.removeElem(lst.first());
         lst.show("D3) lst");
         lst.removeElem(lst.last());
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