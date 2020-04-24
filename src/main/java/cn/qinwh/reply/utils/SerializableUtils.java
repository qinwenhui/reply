package cn.qinwh.reply.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtils {
	//String和byte[]转换时要使用iso-8859-1编码，不然会默认utf-8导致转换时byte[]改变使反序列化失败

	//序列化
	public static String serializable(Object obj){
		String result = "";
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			result = baos.toString("iso-8859-1");
			oos.close();
			baos.close();
		} catch (IOException e) {
			System.out.println("序列化失败"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	//反序列化
	public static Object deserializable(String s){
		Object obj = null;
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(s.getBytes("iso-8859-1"));
			ObjectInputStream ois = new ObjectInputStream(bais);
			obj = ois.readObject();
			ois.close();
			bais.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("反序列化失败"+e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args){
	}
}
