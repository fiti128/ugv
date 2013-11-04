package rw.ugv.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulateUtil {
	public static List<Timestamp> idList;
	
	{
		idList = new ArrayList<Timestamp>();
		Timestamp newTimestamp;
		long newLong;
		for (int i = 0; i < 100; i++) {
			newLong = 1375692409622L+(i*100000);
			newTimestamp = new Timestamp(newLong);
			idList.add(newTimestamp);
		}
	}
	public static List<String> formList;
	
	{
		formList = new ArrayList<String>();
		formList.add("ВУ-1"); 
		formList.add("ВУ-4");
		formList.add("ВУ-10");
		formList.add("ВУ-70");
		formList.add("ИПВ-1");
		formList.add("ИПВ-2");
		formList.add("ИПВ-3");
		formList.add("ИПВ-4");
		
	}
	
	public static List<String> numDocList;
	
	{
		numDocList = new ArrayList<String>();
		Random ra = new Random(System.currentTimeMillis());
		for (int i = 0; i < 100; i++) {
			numDocList.add(String.valueOf(ra.nextInt(999999)));
		}
		
	}
	
	
	
	public static void main(String... x) {
		System.out.println(System.currentTimeMillis());
	}

}
