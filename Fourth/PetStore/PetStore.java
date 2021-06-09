package PetStore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import Pets.*;

public class PetStore {
	static Scanner input = new Scanner(System.in);
	public String name;
	Manager admin;
	ArrayList<Pet> allPet = new ArrayList<Pet>();
	
	PetStore(){
		
	}
	
	public PetStore(String name){
		this.name = name;
		this.admin = Manager.getManager();
		this.admin.setEmployer(this);
		try {
			RandomAccessFile  petStoreLog= new RandomAccessFile( this.name +".txt","rwd");
			long sTLength;
			sTLength = petStoreLog.length();
			petStoreLog.seek(sTLength);
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			byte[] b = new String(formatter.format(calendar.getTime())+" "+"宠物商店"+this.name+"创立！！！"+"\n").getBytes("utf-8");
			petStoreLog.write(b);
			petStoreLog.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serve(Pet pet) {
		allPet.add(pet);
		pet.storeName = this.name;
		admin.serve(pet);
	}
	
	public void manage() {
		admin.report();
	}
}
