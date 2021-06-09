package Decorator.Hair;

import IO.LockOutPutTxtFile;
import Pets.Pet;

public class HairDecoratorPattern implements Runnable {
	public boolean statu=true;
	private LockOutPutTxtFile logTxt;
	private Pet pet;
	private int petHairDecoratorPoint;

	public int getPetHairDecoratorPoint() {
		return petHairDecoratorPoint;
	}

	public void setPetHairDecoratorPoint(int petHairDecoratorPoint) {
		this.petHairDecoratorPoint = petHairDecoratorPoint;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public boolean setBusy() {
		this.statu = false;
		return this.statu;
	}
	
	public boolean setFree() {
		this.statu = true;
		return this.statu;
	}
	
	private void decorator() {
		switch(this.petHairDecoratorPoint) {
		case 2:
			this.pet = new HairClean(this.pet);
			break;
		case 3:
			this.pet = new HairCut(this.pet);
			break;
		case 4:
			this.pet = new RedHair(this.pet);
			break;
		}
		
	}

	@Override
	public void run() {
		this.setBusy();
		logTxt = new LockOutPutTxtFile(this.pet.storeName+".txt");
		this.decorator();
		logTxt.write(" "+this+" "+this.pet.name+" "+this.pet.decoratorDes()+" "+this.pet.description+"\n");	
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logTxt.write(" "+this+" "+this.pet.name+" "+this.pet.decoratorDes()+"Íê±Ï\n");
		this.setFree();
	}

}
