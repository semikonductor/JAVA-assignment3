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
		// 进行看护
		// 写入商店日志文件 开始进行对 this.pet 的看护，
		// 写入数据格式 时间 雇员 宠物 操作 宠物描述
		logTxt = new LockOutPutTxtFile(pet.storeName+".txt");
		logTxt.write(" "+this+" "+this.pet.name+" 处于被看护状态\n");
		while(this.time-- != 0) {
			try {
				Thread.sleep(1000);
				this.pet.HP--;
				if(this.pet.HP <= this.pet.MaxHP * 0.3) {
						// 写入商店日志文件  this.pet 饥饿，准备进行投喂
						// 写入数据格式 时间 雇员 宠物 操作 宠物描述			
						logTxt.write(" "+this+" "+this.pet.name+" 在看护中，处于饥饿状态，准备投喂食物\n");
						this.feedPet();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 看护到时，提醒领走宠物
		// 在屏幕输出： xx 宠物看护时间到时，提醒领走
		// 写入商店日志： xx 宠物看护时间到时，提醒领走
		logTxt.write(" "+this+" "+this.pet.name+" 看护结束，提醒取回\n");
		System.out.print(" "+this+" "+this.pet.name+" 看护结束，请取回\n");
		this.setFree();
	}
	
	private void feedPet() {
		// 首先查找空闲的PetFeed
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
			// 现存的PetFeed都处于忙状态，则新建一个，并保存一下
			choosePF = new PetFeed();
			allPetFeed.add(choosePF);
		}
		// 设置喂养的宠物
		choosePF.feed(pet);
		// 创建线程  进行宠物喂养
		Thread petCareT = new Thread(choosePF);
		petCareT.start();
	}
	
}
