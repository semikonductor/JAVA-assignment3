package Decorator.Clothes;


import Pets.Pet;

public class GolenClothes extends PetClothesDecorator{

	public GolenClothes(Pet pet) {
		super(pet);
		this.decoratedHairPet.description.concat("½ðÉ«µÄ ");
	}
	
	public String getDescription() {
		return this.decoratedHairPet.description;
	}
}
