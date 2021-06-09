package Decorator.Hair;

import Pets.Pet;

public abstract class PetHairDecorator extends Pet {
	protected Pet decoratedHairPet;
	public PetHairDecorator() {
		
	}
		
	public PetHairDecorator(Pet pet) {
		super(pet);
		this.decoratedHairPet = pet;
		this.description = this.description + "�� ��������������������";
	}
	
	public String decoratorDes() {
		return null;
	}
	
	public String getDescription() {
		return this.description;
	}

}
