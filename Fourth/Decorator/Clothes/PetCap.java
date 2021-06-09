package Decorator.Clothes;

import Pets.Pet;

public class PetCap extends PetClothesDecorator{

	public PetCap(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("´÷Ã± ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
