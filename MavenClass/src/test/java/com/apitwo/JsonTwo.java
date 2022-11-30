package com.apitwo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTwo {
	public static void main(String[] args) throws IOException, ParseException {
		
	
	FileReader reader =  new FileReader("C:\\Users\\SR JAGADEESH\\eclipse-workspace\\MavenClass\\src\\test\\resources\\Employee1.json");
	JSONParser j = new JSONParser();
	Object obj = j.parse(reader);
	JSONObject o = (JSONObject)obj;
	Object value = o.get("page");
	JSONObject o2 = (JSONObject)obj;
	Object object2 = o.get("support");
	System.out.println(object2);
	System.out.println(value);
	Object objData = o.get("data");
	JSONArray a = (JSONArray)objData;
	for (int i = 0; i < a.size(); i++) {
		Object objList = a.get(i);
		JSONObject j1 = (JSONObject)objList;
		Object o1 = j1.get("first_name");
		System.out.println(o1);
		
	}
	
	JSONObject oj1 = (JSONObject)obj;	
	Object object3 = oj1.get("support");
	JSONArray a5 = (JSONArray)object3;
	for (int s = 0; s < a5.size(); s++) {
		Object object4 = a5.get(s);
		JSONObject j6 = (JSONObject)object4;
		Object object5 = j6.get("url");
		System.out.println(object5);
		
	}
	
	
	
	

}}
