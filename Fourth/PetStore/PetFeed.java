package PetStore;
import IO.LockOutPutTxtFile;
import Pets.Pet;

public class PetFeed extends Thread{
	public boolean statu=true;
	private LockOutPutTxtFile logTxt;
	Pet pet;	
	
	PetFeed(){
		
	}
	
	public boolean setBusy() {
		this.statu = false;
		return this.statu;
	}
	
	public boolean setFree() {
		this.statu = true;
		return this.statu;
	}
	
	void feed(Pet pet) {
		this.pet = pet;			
	}
	
	public void run() {
		this.setBusy();
		logTxt = new LockOutPutTxtFile(pet.storeName+".txt");
		logTxt.write(" "+this+" "+this.pet.name+" ���ڱ�ι��״̬\n");
		while(pet.HP <= pet.MaxHP * 0.9) {
			// ����ÿ 0.1 ������ 1 HP
			pet.HP++;
			try {
				logTxt.write(" "+this+" "+this.pet.name+" ���ڱ�ι��״̬��HP�ָ�1\n");
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logTxt.write(" "+this+" "+this.pet.name+" ����ι��������HP�ﵽ90%\n");
		this.setFree();
	}
}
