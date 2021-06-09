package Decorator.Hair;

import Pets.Pet;

public class HairCut extends PetHairDecorator{
	
	public HairCut(Pet pet) {
		super(pet);
		this.description = this.description + "ÐÞ¼ôÃ«·¢ ";
	}
	
	public String decoratorDes() {	
		return "¼ôÃ«·¢";
	}
	
	public String getDescription() {
		return this.description;
	}
}
