package Pets;
public class Dragon extends Pet {

	Dragon() {
				
	}
	
	public Dragon(String name,int HP){
		super(name,HP);
		this.description = this.name+"(��)";
	}

	public String getDescription() {
		return this.description;
	}

}
