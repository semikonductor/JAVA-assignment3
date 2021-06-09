package Decorator.Hair;

import Pets.Pet;

public class GoldenHair extends PetHairDecorator{
	
	public GoldenHair(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("Ã«·¢È¾½ð ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
