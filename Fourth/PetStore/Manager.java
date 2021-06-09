package PetStore;
import java.util.ArrayList;
import java.util.Scanner;

import Decorator.Hair.HairClean;
import Decorator.Hair.HairDecoratorPattern;
import IO.LockOutPutTxtFile;
import Pets.Pet;

public class Manager {
	static Scanner input = new Scanner(System.in);
	private volatile static Manager manager;
	private PetStore employer;
	ArrayList<PetCare> allPetCare = new ArrayList<PetCare>();
	ArrayList<HairDecoratorPattern> allHairDecPet = new ArrayList<HairDecoratorPattern>();
    private Manager (){}
    
    public static Manager getManager() {
	    if (manager == null) {  
	        synchronized (Manager.class) {
		        if (manager == null) {  
		            manager = new Manager();  
		           
		        }
	        }
	    } 
	    return manager;  
    }
    
	public PetStore getEmployer() {
		return employer;
	}

	public void setEmployer(PetStore employer) {
		this.employer = employer;
	}
    

    public void serve(Pet pet) {
    	System.out.print("\n���ã���ӭ���٣�\n��ѡ������Ҫ�ķ���\n");
    	int choose;
		do{
			System.out.print("\n�����˵���\n1.��������\n2.������ϴ��\n3.�������޼�ë��\n4.������ë��Ⱦɫ\n5.���������ͷ��\n6.�����ﴩЬ\n7.�˳�\n��ѡ�������");
			choose = input.nextInt();
			if(choose == 1) {
				this.parkPet(pet);
			}
			else if(choose == 2 || choose == 3 || choose == 4){
				this.PetHairDecorator(pet, choose);
			}
			else if(choose == 5 || choose == 6) {
				this.PetClothesDecorator(pet, choose);
			}
			else {
				break;
			}
		}while(choose != 7);
		System.out.print("\n�����˳����̵꣡����\n");
    }
    
    private void PetClothesDecorator(Pet pet, int choose) {
		// TODO Auto-generated method stub
		
	}


	private void PetHairDecorator(Pet pet, int point) {
		// TODO Auto-generated method stub
		HairDecoratorPattern chooseHDP = chooseHDP();
		chooseHDP.setPet(pet);
		chooseHDP.setPetHairDecoratorPoint(point);
		// �����߳�  ë��װ��
		Thread petCleanT = new Thread(chooseHDP);
		petCleanT.start();
	}
	
	private HairDecoratorPattern chooseHDP() {
		boolean flag = false;
		HairDecoratorPattern chooseHDP = null;
		for(HairDecoratorPattern hdp: allHairDecPet) {
			if(hdp.statu) {
				flag = true;
				chooseHDP = hdp;
				break;
			}
		}
		if(flag) {
			
		}
		else {
			chooseHDP = new HairDecoratorPattern();
			allHairDecPet.add(chooseHDP);
		}
		return chooseHDP;
	}
	

	private void parkPet(Pet pet) {
		System.out.println("��������������ʱ����������������");
		int time = input.nextInt();
		boolean flag = false;
		PetCare choosePC = null;
		for(PetCare pc: allPetCare) {
			if(pc.statu) {
				flag = true;
				choosePC = pc;
				break;
			}
		}
		if(flag) {
			
		}
		else {
			choosePC = new PetCare();
			allPetCare.add(choosePC);
		}
		choosePC.pet = pet;
		choosePC.time = time;
		// �����߳�  ���г������
		Thread petCareT = new Thread(choosePC);
		petCareT.start();
	}

	public void report() {
		LockOutPutTxtFile logTxt = new LockOutPutTxtFile(this.employer.name+".txt");
		System.out.print(logTxt.read(0, 0, 0));
    }

}
