package Pets;
public class Dog extends Pet {

	Dog() {
				
	}
	
	public Dog(String name, int HP){
		super(name,HP);
		this.description = this.name+"�ǹ���";
	}

	public String getDescription() {
		return this.description;
	}

}
