package de.de.de.currency;

public class FloatingPoint {

    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;

        for(double price = 0.10; funds >= price ; price += 0.10){

            funds -= price;
            System.out.println("Funds " + funds  +" Price " +price );
            itemsBought ++;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }
}
