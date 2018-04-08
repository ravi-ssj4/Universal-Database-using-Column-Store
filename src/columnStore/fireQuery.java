package columnStore;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

public class fireQuery {
	
	//select from on or multiple table without any condition
	public void selectAll(String[] table,Connection conn) throws Exception
	{
		List<String>[] a= new List[table.length];
		int size=0;
		for(int i=0;i<table.length;i++)
		{
			 
			 String query="SELECT "+table[i]+" FROM "+table[i];
			 PreparedStatement preparedStatement = conn.prepareStatement(query);
			 ResultSet rs=preparedStatement.executeQuery();
			 List<String> l=new ArrayList<String>();
			 
			 while(rs.next())
				 {
					 l.add(rs.getString(1));
					
				 }
			 size=l.size();
			 a[i]=l;
		}
		for(int i=0;i<table.length;i++)
		{
			 System.out.print(table[i]+" ");	
		}
		 System.out.println("....................................................");	
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				 System.out.print(a[j].get(i)+" ");	
			}
			System.out.println("");
			
		}
		
	}
	public void oneTableWithCondn(String table,Connection conn,String operation,String value) throws Exception
	{
			String op = operation;
			
			 try{
			        Integer.parseInt(value);
			        Float.parseFloat(value);
			    }
			 catch(NumberFormatException e){
			        //not int,not float
			    	String temp="\"";
			    	temp=temp+value;
			    	temp=temp+"\"";
			    	value=temp;
			    }
			
			
			 
			 String query="SELECT "+table+" FROM "+table+" WHERE "+table+op+value;
			 PreparedStatement preparedStatement = conn.prepareStatement(query);
			 ResultSet rs=preparedStatement.executeQuery();
			 while(rs.next())
			 {
				 
				 System.out.println(rs.getString(1));
			 }
		
	}
	
	public void selectAggregateFunction(String[] table,Connection conn) throws Exception
	{
		for(int i=0;i<table.length;i++)
		{
			 String query="SELECT SUM(salary) FROM "+table[i];
			 PreparedStatement preparedStatement = conn.prepareStatement(query);
			 ResultSet rs=preparedStatement.executeQuery();
			 rs.next();
				 System.out.println(rs.getString(1));
		}
	}
	public void twoTable(String DisplayTable,String ConditionTable,String operation,String value,Connection conn) throws Exception
	{
		String op = operation;
		
			 String query="SELECT id FROM "+ConditionTable+" WHERE "+ConditionTable+op+value;
			 PreparedStatement preparedStatement = conn.prepareStatement(query);
			 ResultSet rs=preparedStatement.executeQuery();
			 
			 String fetchedID="(";
			 while(rs.next())
			 {
				 fetchedID=fetchedID+rs.getInt(1)+",";
			 }
			 fetchedID=fetchedID.substring(0,fetchedID.length()-1);
			 fetchedID=fetchedID+")";
			
			 
			 String query2="SELECT "+DisplayTable+" FROM "+DisplayTable+" WHERE id IN"+fetchedID;
			 PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
			 ResultSet rs2=preparedStatement2.executeQuery();
			 while(rs2.next())
			 {
				 System.out.println(rs2.getString(1));
			 }
		
	}
	public void query() throws Exception
	{
		SQLConn sqlconn=new SQLConn();
		Connection conn=sqlconn.createConn();
		String table[]= {"Customer_Name","Sales","State"};
		String table2="Sales";
		String table3="State";
		
		//selectAll(table,conn);
		oneTableWithCondn(table3,conn,"=","Tamil Nadu");
		//selectAggregateFunction(table,conn);
		//twoTable(table3,table2,">","1000",conn);
	}
	
}