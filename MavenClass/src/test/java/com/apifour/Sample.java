package com.apifour;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Datum;
import com.pojo.Root;
import com.pojo.Support;

public class Sample {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File file = new File("C:\\Users\\SR JAGADEESH\\eclipse-workspace\\MavenClass\\src\\test\\resources\\user1.json");
		ObjectMapper mapper = new ObjectMapper();
		List<Datum> data = new ArrayList<Datum>();
		Datum d1 = new Datum(7, "michael.lawson@reqres.in", "Michael", "Lawson",
				"https://reqres.in/img/faces/7-image.jpg");
		Datum d2 = new Datum(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson",
				"https://reqres.in/img/faces/8-image.jpg");
		data.add(d1);
		data.add(d2);
		List<Support> l = new ArrayList<Support>();
		Support s = new Support( "https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
		l.add(s);
		Root r = new Root(2, 6, 12, 2, data, l);
		mapper.writeValue(file, r);
		System.out.println("done");

	}
}
