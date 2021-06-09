package Pets;

public abstract class Pet {
	public String description ;
	public String name ;
	public String storeName;
	public int MaxHP;
	public int HP;
	public Pet(){
		
	}
	public Pet(String name, int HP){
		this.name = name;
		this.HP = HP;
		this.MaxHP = HP;
	}
	public Pet(Pet pet) {
		this.name = pet.name;
		this.description = pet.description;
		this.storeName = pet.storeName;
		this.HP = pet.HP;
		this.MaxHP = pet.MaxHP;
	}
	public String getDescription() {
		return this.description;
	}
	public String decoratorDes() {	
		return null;
	}
}
