package com.kaushik.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class MapTest {
	public static void main (String[] args) throws IOException{
	String csvFilename = "D:\\sample.csv";
	CSVReader csvReader = null;
	String recipientsList = null;
	ArrayList<String> arlphoneList = new ArrayList<String>();
	ArrayList<String> msgList = new ArrayList<String>();
	 
	try {
		csvReader = new CSVReader(new FileReader(csvFilename));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 List<String[]> lines = csvReader.readAll();
	 for (String[] line : lines) {
     	System.out.println("The content is "+line[0].trim()+"->"+line[1].trim());
     	if (!line[0].startsWith("#"))
     		arlphoneList.add(line[0].trim().toString());
     		msgList.add(line[1].trim().toString());
     }
	 List<List<String>> lists = split(arlphoneList,2);	
	 for (int k =0 ; k<lists.size();k++){
		 String phoneList = lists.get(k).toString();
		 recipientsList = phoneList.substring(1, phoneList.length() - 1).replace(", ", ",");
     	 System.out.println("The recipient List is "+recipientsList);
	 }
	 
	 csvReader.close(); 
	}
	
	public static <T extends Object> List<List<T>> split(List<T> arlphoneList, int targetSize) {
	    List<List<T>> lists = new ArrayList<List<T>>();
	    for (int i = 0; i < arlphoneList.size(); i += targetSize) {
	        lists.add(arlphoneList.subList(i, Math.min(i + targetSize, arlphoneList.size())));
	    }
	    return lists;
	}
}
