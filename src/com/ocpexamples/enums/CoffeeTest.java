package com.ocpexamples.enums;


enum CoffeeType {
    ESPRESSO, LATTE, AMERICANO, CAPPUCCINO;
}

enum CoffeeSize {
    SMALL(8), MEDIUM(10), LARGE(12), GRANDE(14);
    
    private int ounces;
    
    CoffeeSize(int ounces){
	this.ounces=ounces;
    }

    /**
     * @return the ounces
     */
    public int getOunces() {
        return ounces;
    }
}

class Coffee {

    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(CoffeeType t, CoffeeSize s) {
	this.size=s;
	this.type=t;
    }
    
    public Coffee(){}

    
    /**
     * @return the type
     */
    public CoffeeType getType() {
        return type;
    }

    
    /**
     * @return the size
     */
    public CoffeeSize getSize() {
        return size;
    }
    
    @Override
    public String toString() {
       
        return  "This drink is a " + type + " size " + size;
    }

}

public class CoffeeTest {
    
    CoffeeType cType;
    CoffeeSize cSize;

    public static void main(String[] args) {
	Coffee order1= new Coffee(CoffeeType.AMERICANO, CoffeeSize.LARGE);
	Coffee order2= new Coffee(CoffeeType.LATTE, CoffeeSize.LARGE);
	
	System.out.println(order1 + " ounces: "+order1.getSize().getOunces());
	System.out.println(order2);
	

    }

}
