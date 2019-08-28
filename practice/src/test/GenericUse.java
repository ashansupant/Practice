package test;
import java.util.*;

public class GenericUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GU());
	}	
	public static String GU(){
		List<String> list = new ArrayList<String>();
		list.add("Entered");
		String s = list.get(0);
		return s;
	}

}
