package com.cornez.lab2ex2;

public class Coffee {
    static final double COFFEECOST = 4.00;
    static final double CREAMCOST = 0.50;
    static final double CHOCCOST = 1.00;

    private int coffeeCount;
    private double coffeeCost;
    private double creamCost;
    private double chocolateCost;
    private double totalCost;
    private boolean isChocolate;
    private boolean isCream;


    public Coffee() {
        coffeeCount = 0;
        creamCost = 0.00;
        chocolateCost = 0.00;

    }

    public void addCoffee() {
        coffeeCount++;
    }

    public void removeCoffee() {
        coffeeCount--;
        if (coffeeCount < 0) {
            coffeeCount = 0;
        }

    }

    public Integer getCoffeeCount() {
        return coffeeCount;
    }

    public void addCream() {
        isCream = true;
    }

    public void removeCream() {
        isCream = false;
    }

    public void addChoc() {
        isChocolate = true;
    }

    public void removeChoc() {
        isChocolate = false;
    }

    public double getTotalCost() {
        double total = coffeeCount * COFFEECOST;
       if(isCream == true){
           total += (coffeeCount * CREAMCOST);
       }
       if(isChocolate == true){
           total += (coffeeCount * CHOCCOST);
       }
       return total;
    }

    public String getSummary(){
      String summary = "" ;
      summary = "Add Whipped Cream? ";
      if(isCream == true){
          summary+="yes \n";
      }else{
          summary+="no \n";
      }
      summary += "Add Chocolate? ";
      if(isChocolate == true){
          summary +="yes \n";
      }else{
          summary +="no \n";
      }
      summary+="Quantity: "+getCoffeeCount()+"\n\n";
      summary+="Price $"+getTotalCost()+"\n";
      summary+="Thank you!";
      return summary;
    }


}
