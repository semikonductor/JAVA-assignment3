package Decorator.Hair;

import Pets.Pet;

public class HairClean extends PetHairDecorator {
	
	public HairClean() {
		
	}
	
	public HairClean(Pet pet) {
		super(pet);
		this.description = this.description + "ÇåÏ´Ã«·¢ ";
	}
	
	public String decoratorDes() {	
		return "Ï´Ôè";
	}
	
	public String getDescription() {
		return this.description;
	}

}
