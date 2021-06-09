package Decorator.Hair;

import Pets.Pet;

public class HairClean extends PetHairDecorator {
	
	public HairClean() {
		
	}
	
	public HairClean(Pet pet) {
		super(pet);
		this.description = this.description + "��ϴë�� ";
	}
	
	public String decoratorDes() {	
		return "ϴ��";
	}
	
	public String getDescription() {
		return this.description;
	}

}
