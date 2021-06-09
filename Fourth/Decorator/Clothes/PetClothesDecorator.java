package Decorator.Clothes;
import Pets.*;

public abstract class PetClothesDecorator extends Pet {
	protected Pet decoratedHairPet;
	
	
	public PetClothesDecorator(Pet pet) {
		this.decoratedHairPet = pet;
		decoratedHairPet.description.concat("， 进行了以下穿衣操作：");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
	

}
