

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import Pets.*;
import PetStore.PetStore;


public final class Test {
	static Scanner input = new Scanner(System.in);
	ArrayList<Pet> allPet = new ArrayList<Pet>();
	ArrayList<PetStore> allPetStore = new ArrayList<PetStore>();
	
	public static void main(String[] args) {
		Test test = new Test();
		int choose;
		do{
			System.out.print("\n�����˵���\n1.��������\n2.���������̵�\n3.������̵�\n4.��������̵�\n5.�˳�\n��ѡ�������");
			choose = input.nextInt();
			switch(choose) {
				case 1:
					test.createPet();
					break;
				case 2:
					test.createPetStore();
					break;
				case 3:
					test.shoppingInPetStore();
					break;
				case 4:
					test.managePetStore();
					break;
				case 5:
					System.out.print("\n�����˳���\n");
				default:
			}
		}while(choose != 5);
	}

	private void createPet() {
		int choose;
		System.out.print("\n�������\n1.����һֻ��\n2.����һֻè\n3.����һֻ��\n4.����һ����\n5.ȡ��\n��ѡ�������");
		choose = input.nextInt();
		System.out.print("�����������\n");
		String name = input.next();
		System.out.print("������HP\n");
		int HP = input.nextInt();
		switch(choose) {
			case 1:
				Dog newDog = new Dog(name, HP);
				allPet.add(newDog);
				break;
			case 2:
				Cat newCat = new Cat(name, HP);
				allPet.add(newCat);
				break;
			case 3:
				Bird newBird = new Bird(name, HP);
				allPet.add(newBird);
				break;
			case 4:
				Dragon newDragon = new Dragon(name, HP);
				allPet.add(newDragon);
				break;
			case 5:
				System.out.print("\n���ѷ�����һ��˵���\n");
			default:
		}
		
	}
	
	private void createPetStore() {
		System.out.println("��������������");
		String name = input.next();
		PetStore newPetStore = new PetStore(name);
		this.allPetStore.add(newPetStore);
		try {
			RandomAccessFile  petStoreLog= new RandomAccessFile( name +".txt","rwd");
			long pSLLength = petStoreLog.length();
			byte[] b = new byte[(int) pSLLength];
			petStoreLog.read(b);
			String pSLText = new String(b, "utf-8");
			System.out.println(pSLText);
			petStoreLog.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void shoppingInPetStore() {
		System.out.println("������̵�");
		PetStore pS = this.allPetStore.get(this.choosePetStore());
		pS.serve(this.allPet.get(this.choosePet()));
	}
	
	private void managePetStore() {
		System.out.println("�������̵�");
		PetStore pS = this.allPetStore.get(this.choosePetStore());
		pS.manage();
	}
	
	private int choosePetStore() {
		int indexPS = 1;
		for(PetStore pS: this.allPetStore) {
			System.out.println(indexPS+"."+pS.name);
			indexPS++;
		}
		System.out.println("��������Ӧ���ѡ������̵꣺");
		return input.nextInt() - 1;
	}
	
	private int choosePet() {
		int indexP = 1;
		for(Pet p: this.allPet) {
			System.out.println(indexP+"."+p.name);
			indexP++;
		}
		System.out.println("��������Ӧ���ѡ����");
		return input.nextInt() - 1;
	}
	
}
