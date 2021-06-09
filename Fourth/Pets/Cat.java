package Pets;
public class Cat extends Pet {

	Cat() {
				
	}
	
	public Cat(String name, int HP){
		super(name,HP);
		this.description = this.name+"(è)";
	}

	public String getDescription() {
		return this.description;
	}

}
