package com.ocpexamples.generics;

public class AnimalDoctorWithArrays {

    public static void main(String[] args) {
	Dog[] dogs = { new Dog(), new Dog() };
	Cat[] cats = { new Cat(), new Cat(), new Cat() };
	Bird[] birds={new Bird()};
	
	AnimalDoctorWithArrays doctor= new AnimalDoctorWithArrays();
	doctor.checkAnimals(dogs);
	doctor.checkAnimals(cats);
	doctor.checkAnimals(birds);
    }

    private void checkAnimals(Animal[] animals) {
	for (Animal animal : animals) {
	   animal.checkup();
	}
	
    }
    

}

class Cat extends Animal {

    @Override
    void checkup() {
	System.out.println("Cat checkup");
    }
}

class Dog extends Animal {

    @Override
    void checkup() {
	System.out.println("Dog checkup");
    }
}

class Bird extends Animal {

    @Override
    void checkup() {
	System.out.println("Bird checkup");
    }
}

abstract class Animal {

    abstract void checkup();
}