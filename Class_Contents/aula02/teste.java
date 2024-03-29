/**
   A coin with a monetary value.
*/

/*
   TODO: Add a static variable that counts the number of coin objects
   that have been constructed. Add a static method objectCount that
   reports the count.
*/

public class Coin
{
   /**
      Constructs a coin.
      @param aValue the monetary value of the coin.
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }
   
   /**
      Returns a string representation of the object.
      @return name and value of coin
   */
   public String toString()
   {
      return "Coin[value=" + value + ",name=" + name + "]";
   }

   private double value;
   private String name;
   private static int count;
   
   static objectCount(){ return count; }
   
   public static int check(int dimes, int quarters)
   {
      Coin[] coins = new Coin[dimes + quarters];
      count = coins.length;
      for (int i = 1; i <= dimes; i++)
         coins[i] = new Coin(0.10, "dime");
      for (int i = 1; i <= quarters; i++)
         coins[dimes] = new Coin(0.25, "quarter");
      return Coin.objectCount();
   }
}