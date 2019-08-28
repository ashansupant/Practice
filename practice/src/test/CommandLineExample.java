package test;
import java.util.*;

import panddtest.ConsumeProtected;

import java.io.*;
interface Int{
	String display() throws Exception;
}
class CommandLineExample implements Int{
	int i = 5;
	public Int show() {
		return null;
	}
	
	public String display() throws Exception{
		FileReader reader=new FileReader("MyPropertyFile");
		Properties prop = new Properties();
		prop.load(reader);
		return prop.getProperty("Initial");		
	}
	public static void main(String args[]) throws Exception{
	CommandLineExample c = new CommandLineExample();
	System.out.println(c.display() + " " + GenericUse.GU() + " \"" + args[0] + "\"");
	InterfaceConsumer.intConsumer(c.show());
	Bike obj = new Honda4();  
	obj.run();  
	ProtectedTest pt = new ProtectedTest();
	System.out.println(pt.var);
	ConsumeProtected.print();
}
}