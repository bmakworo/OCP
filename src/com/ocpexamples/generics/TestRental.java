package com.ocpexamples.generics;

import java.util.ArrayList;
import java.util.List;

public class TestRental {

    public static void main(String[] args) {
	// Make some cars for pool
	Car c1 = new Car();
	Car c2 = new Car();

	List<Car> carList = new ArrayList<>();
	carList.add(c1);
	carList.add(c2);

	RentalGeneric<Car> rentalGeneric = new RentalGeneric<>(2, carList);
	Car carToRent = rentalGeneric.getRental();
	rentalGeneric.returnRental(carToRent);
	//Add something else in the original car list
//	carList.add(new Object()); //fails can only add Car objects for RentalGeneric<Car>
    }
}

class RentalGeneric<T> {

    int maxNum;
    private List<T> rentalPool;

    public RentalGeneric(int maxNum, List<T> rentalPool) {
	this.maxNum = maxNum;
	this.rentalPool = rentalPool;
    }

    public T getRental() {
	return rentalPool.get(0);
    }

    public void returnRental(T returnThing) {
	rentalPool.add(returnThing);
    }

}

class Car {

}
