package Pets;
public class Dog extends Pet {

	Dog() {
				
	}
	
	public Dog(String name, int HP){
		super(name,HP);
		this.description = this.name+"สวนทนท";
	}

	public String getDescription() {
		return this.description;
	}

}
