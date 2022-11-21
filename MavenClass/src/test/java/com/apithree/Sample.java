package com.apithree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Datum;
import com.pojo.Root;
import com.pojo.Support;

public class Sample {
public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
/*	File file = new File("C:\\Users\\SR JAGADEESH\\eclipse-workspace\\MavenClass\\src\\test\\resources\\course.json");
	ObjectMapper mapper = new ObjectMapper();
	Root e = mapper.readValue(file, Root.class);
	int page = e.getPage();
	System.out.println(page);
	int per_page = e.getPer_page();
	System.out.println(per_page);
	int total = e.getTotal();
	System.out.println(total);
	int total_pages = e.getTotal_pages();
	System.out.println(total_pages);
	ArrayList<Datum> data = e.getData();
	for (Datum x : data) {
		System.out.println(x.getEmail());
		System.out.println(x.getId());
		System.out.println(x.getFirst_name());
		System.out.println(x.getLast_name());
		System.out.println(x.getAvatar());
		
	}
	Support support = e.getSupport();
	System.out.println(support.getUrl());*/
}
}
