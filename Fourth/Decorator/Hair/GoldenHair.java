package Decorator.Hair;

import Pets.Pet;

public class GoldenHair extends PetHairDecorator{
	
	public GoldenHair(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("ë��Ⱦ�� ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
