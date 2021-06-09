package IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LockOutPutTxtFile {
	private String filename;
	private RandomAccessFile raf;
	private FileChannel fc;
	FileLock fl;
	
	public LockOutPutTxtFile(String filename){
		this.filename = filename;
	}
	
	public long write(String text) {
		// 使用文件锁 FileLock.lock()进行阻塞式读写文件
		try {
			raf = new RandomAccessFile(this.filename, "rw");
			fc = raf.getChannel();
			fl = fc.lock();
			if(fl != null) {
				long fSize = fc.size();
				fc.position(fSize);
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Log = formatter.format(calendar.getTime())+" "+text;
				fc.write(ByteBuffer.wrap(Log.getBytes("utf-8")));
				fl.release();
				long lateFSize = fc.size();
				fc.close();
				raf.close();
				return  lateFSize - fSize;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public String read(int year, int month, int day) {
		// 使用文件锁 FileLock.lock() 进行阻塞式读取文件
		String logText = null;
		try {
			raf = new RandomAccessFile(this.filename, "rw");
			fc = raf.getChannel();
			fl = fc.lock();
			if(fl != null) {
				long rafLength = raf.length();
				byte[] b = new byte[(int) rafLength];
				raf.read(b);
				logText = new String(b, "utf-8");
				fl.release();
				fc.close();
				raf.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logText;
	}
}
