package Decorator.Clothes;
import Pets.Pet;

public class PetShoes extends PetClothesDecorator{

	public PetShoes(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("´©Ð¬ ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
