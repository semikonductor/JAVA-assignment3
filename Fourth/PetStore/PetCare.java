package PetStore;
import java.util.ArrayList;

import IO.LockOutPutTxtFile;
import Pets.Pet;

public class PetCare implements Runnable {
	public boolean statu=true;
	public int time;
	public Pet pet;
	ArrayList<PetFeed> allPetFeed = new ArrayList<PetFeed>();
	private LockOutPutTxtFile logTxt;
	
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setBusy();
		// ���п���
		// д���̵���־�ļ� ��ʼ���ж� this.pet �Ŀ�����
		// д�����ݸ�ʽ ʱ�� ��Ա ���� ���� ��������
		logTxt = new LockOutPutTxtFile(pet.storeName+".txt");
		logTxt.write(" "+this+" "+this.pet.name+" ���ڱ�����״̬\n");
		while(this.time-- != 0) {
			try {
				Thread.sleep(1000);
				this.pet.HP--;
				if(this.pet.HP <= this.pet.MaxHP * 0.3) {
						// д���̵���־�ļ�  this.pet ������׼������Ͷι
						// д�����ݸ�ʽ ʱ�� ��Ա ���� ���� ��������			
						logTxt.write(" "+this+" "+this.pet.name+" �ڿ����У����ڼ���״̬��׼��Ͷιʳ��\n");
						this.feedPet();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ������ʱ���������߳���
		// ����Ļ����� xx ���￴��ʱ�䵽ʱ����������
		// д���̵���־�� xx ���￴��ʱ�䵽ʱ����������
		logTxt.write(" "+this+" "+this.pet.name+" ��������������ȡ��\n");
		System.out.print(" "+this+" "+this.pet.name+" ������������ȡ��\n");
		this.setFree();
	}
	
	private void feedPet() {
		// ���Ȳ��ҿ��е�PetFeed
		boolean flag = false;
		PetFeed choosePF = null;
		for(PetFeed pf: allPetFeed) {  
			if(pf.statu) {
				flag = true;
				choosePF = pf;
				break;
			}
		}
		if(flag) {
			
		}
		else {
			// �ִ��PetFeed������æ״̬�����½�һ����������һ��
			choosePF = new PetFeed();
			allPetFeed.add(choosePF);
		}
		// ����ι���ĳ���
		choosePF.feed(pet);
		// �����߳�  ���г���ι��
		Thread petCareT = new Thread(choosePF);
		petCareT.start();
	}
	
}
