package Decorator.Hair;

import Pets.Pet;

public class HairCut extends PetHairDecorator{
	
	public HairCut(Pet pet) {
		super(pet);
		this.description = this.description + "�޼�ë�� ";
	}
	
	public String decoratorDes() {	
		return "��ë��";
	}
	
	public String getDescription() {
		return this.description;
	}
}
