package Decorator.Hair;

import Pets.Pet;

public class RedHair extends PetHairDecorator{
	
	public RedHair(Pet pet) {
		super(pet);
		this.description = this.description + "ë��Ⱦ�� ";
	}
	
	public String decoratorDes() {	
		return "Ⱦë��";
	}
	
	public String getDescription() {
		return this.description;
	}
}
