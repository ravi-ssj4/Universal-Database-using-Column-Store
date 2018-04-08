package columnStore;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverProgram {
	
	static HashMap<String, String> hashMap = new HashMap<String, String>();
	static ArrayList<String> colnames = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		
		/*XsdReader rr = new XsdReader();
		hashMap = rr.parseSchema();	
		colnames = rr.gettablenames();
		
		for (int counter = 0; counter < colnames.size(); counter++) { 		      
	          System.out.println(colnames.get(counter)); 		
	      }   
		
		JDBCConnection jdbc = new JDBCConnection();
		
		jdbc.doTheJDBCStuffs(hashMap);
		
		enterData data=new enterData();
		data.insertCSV(colnames);
		
		*/
		fireQuery fire=new fireQuery();
		fire.query();
	}
}
