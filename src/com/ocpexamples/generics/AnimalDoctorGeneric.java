package com.ocpexamples.generics;

import java.util.ArrayList;
import java.util.List;


public class AnimalDoctorGeneric {

    public static void main(String[] args) {
	List<Dog2> dogs = new ArrayList<>(); 
	dogs.add(new Dog2());
	dogs.add(new Dog2());
	
	List<Cat2> cats = new ArrayList<>(); 
	cats.add(new Cat2());
	cats.add(new Cat2());
	cats.add(new Cat2());
	
	List<Bird2> birds = new ArrayList<>(); 
	birds.add(new Bird2());	
	
	List<Animal2> animals = new ArrayList<>(); 
//	animals.add(new Dog2());
//	animals.add(new Dog2());
//	
//	animals.add(new Cat2());
//	animals.add(new Cat2());
//	animals.add(new Cat2());
//	
//	animals.add(new Bird2());	
	
	AnimalDoctorGeneric doctor= new AnimalDoctorGeneric();
//	doctor.checkAnimals(animals);
//	doctor.addAnimal(animals);
//	doctor.checkAnimals(animals);
	System.out.println("--------------- check dogs");
	doctor.checkAnimals(dogs);
	System.out.println("--------------- check cats");
	doctor.checkAnimals(cats);
	
	System.out.println("--------------- add birds to birds list");
	doctor.addAnimal(birds);
	System.out.println("--------------- check birds list");
	doctor.checkAnimals(birds);
	System.out.println("--------------- add bird to animals list");
	doctor.addAnimal(animals);
	System.out.println("--------------- check animals list");
	doctor.checkAnimals(animals);
	
	System.out.println("--------------- adding goldfish via generic method");
	List<GoldFish> goldfish = new ArrayList<>(); 
	doctor.makeArrayList(new GoldFish(), goldfish);
	doctor.checkAnimals(goldfish);
    }
    
    private void addAnimal(List<? super Bird2> animals) {
//	for (Animal2 a : animals) {
	    animals.add(new Bird2());
//	}
    }

    private void checkAnimals(List<? extends Animal2> animals) {
	for (Animal2 animal : animals) {
	   animal.checkup();
	}
    }
    
    public <T> void makeArrayList(T t , List<T> list){
//	List<T> list = new ArrayList<>(); 
	list.add(t);
    }
}

class Cat2 extends Animal2 {

    @Override
    void checkup() {
	System.out.println("Cat checkup");
    }
}

class Dog2 extends Animal2 {

    @Override
    void checkup() {
	System.out.println("Dog checkup");
    }
}

class Bird2 extends Animal2 {

    @Override
    void checkup() {
	System.out.println("Bird checkup");
    }
}

class GoldFish extends Animal2 {

    @Override
    void checkup() {
	System.out.println("Goldfish checkup");
    }
}

abstract class Animal2 {

    abstract void checkup();
}
