package md5;

import java.security.MessageDigest;

public class Md5JdkUtil {
	
	//byte数组转16进制字符串
	public static String convertByteToHexString(byte[] bytes){
		String result="";
		for(int i=0;i<bytes.length;i++){
			int temp = bytes[i] & 0xff;
			String tempHex = Integer.toHexString(temp);
			if(tempHex.length()<2){
				result +="0"+tempHex;
			}else{
				result +=tempHex;
			}
		}
		return result;
	}
	
	
	public static String md5jdk(String message){
		String temp ="";
		try{
			//创建一个md5转换器
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");
			//将需要转换的字符串转为字符数组并使用MD5转换器对其进行加密，然后存入新的字符数组中
			byte[] encodeMd5Digest = md5Digest.digest(message.getBytes());
			//调用上方的字符数组转16进制字符串的方法，将获得的对象进行转换
			temp = convertByteToHexString(encodeMd5Digest);
		} catch(Exception e){
			e.printStackTrace();
		}
		return temp;
	}

}
