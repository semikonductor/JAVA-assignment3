package Decorator.Hair;

import Pets.Pet;

public class RedHair extends PetHairDecorator{
	
	public RedHair(Pet pet) {
		super(pet);
		this.description = this.description + "Ã«·¢È¾ºì ";
	}
	
	public String decoratorDes() {	
		return "È¾Ã«·¢";
	}
	
	public String getDescription() {
		return this.description;
	}
}
