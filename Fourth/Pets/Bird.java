package Pets;
public class Bird extends Pet {

	Bird() {
				
	}
	
	public Bird(String name,int HP){
		super(name,HP);
		this.description = this.name+"(��)";
	}

	public String getDescription() {
		return this.description;
	}

}
