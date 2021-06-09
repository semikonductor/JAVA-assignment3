package Decorator.Clothes;
import Pets.*;

public class CottonClothes extends PetClothesDecorator{

	public CottonClothes(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("�޵Ĳ��� ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
