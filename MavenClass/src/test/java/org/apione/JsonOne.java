package org.apione;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonOne {
public static void main(String[] args) throws IOException, ParseException {
	FileReader reader = new FileReader("C:\\Users\\SR JAGADEESH\\eclipse-workspace\\MavenClass\\src\\test\\resources\\Employee.json");
JSONParser j = new JSONParser();
Object obj = j.parse(reader);
JSONObject o = (JSONObject)obj;
Object object = o.get("data");
Object object2 = o.get("support");
JSONObject jAddress = (JSONObject)object;
JSONObject jAddress1 = (JSONObject)object2;
Object userId = jAddress.get("id");
System.out.println(userId);
Object url = jAddress1.get("url");
System.out.println(url);






}
}
