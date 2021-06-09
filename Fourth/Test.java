

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
			System.out.print("\n操作菜单：\n1.创建宠物\n2.创建宠物商店\n3.逛宠物商店\n4.打理宠物商店\n5.退出\n请选择操作：");
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
					System.out.print("\n您已退出！\n");
				default:
			}
		}while(choose != 5);
	}

	private void createPet() {
		int choose;
		System.out.print("\n创建宠物：\n1.创建一只狗\n2.创建一只猫\n3.创建一只鸟\n4.创建一条龙\n5.取消\n请选择操作：");
		choose = input.nextInt();
		System.out.print("请输入宠物名\n");
		String name = input.next();
		System.out.print("请输入HP\n");
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
				System.out.print("\n您已返回上一层菜单！\n");
			default:
		}
		
	}
	
	private void createPetStore() {
		System.out.println("请输入宠物店名：");
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
		System.out.println("逛宠物商店");
		PetStore pS = this.allPetStore.get(this.choosePetStore());
		pS.serve(this.allPet.get(this.choosePet()));
	}
	
	private void managePetStore() {
		System.out.println("管理物商店");
		PetStore pS = this.allPetStore.get(this.choosePetStore());
		pS.manage();
	}
	
	private int choosePetStore() {
		int indexPS = 1;
		for(PetStore pS: this.allPetStore) {
			System.out.println(indexPS+"."+pS.name);
			indexPS++;
		}
		System.out.println("请输入相应序号选择宠物商店：");
		return input.nextInt() - 1;
	}
	
	private int choosePet() {
		int indexP = 1;
		for(Pet p: this.allPet) {
			System.out.println(indexP+"."+p.name);
			indexP++;
		}
		System.out.println("请输入相应序号选择宠物：");
		return input.nextInt() - 1;
	}
	
}
