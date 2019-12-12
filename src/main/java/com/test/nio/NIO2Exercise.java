package com.test.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2Exercise {

	
	static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		Map<String, LocalDate> tabDetails = new HashMap<>(); 
		tabDetails =getExpiredTablets("Tablet.txt", "India");
		System.out.println("Expired Tablet Details are " + tabDetails);
		
		getFileswithjava("src").forEach(System.out::println);
        findFiles("Tablet.txt","src/main/resources/");
	}
public static Map<String,LocalDate>getExpiredTablets(String filename, String manufacturer) {
	Map<String, LocalDate> tabDetails = new HashMap<>();
	try(Stream<String>datarepo = Files.lines(Paths.get("src/main/resources/", filename))){
		
		tabDetails = datarepo.map(NIO2Exercise :: getTabletDetails).filter(t ->t.getManifacturer().equals(manufacturer)).filter(t->t.getExDate().isBefore(LocalDate.now()))
		        .collect(Collectors.toMap(Tablet::getName,Tablet::getExDate));   
		
		//return tabDetails;
		
	}catch(IOException ex) {
		System.out.println(ex);
	}
	
	return tabDetails;
	
}

public static Tablet getTabletDetails(String data){
	
	String[] details= data.split(",");
	LocalDate expireData = LocalDate.parse(details[3],format);
	Tablet t = new Tablet(details[0],details[1],details[2],expireData);
	
	return t;
	
}

public static List<Path> getFileswithjava(String dirpath) {
	List<Path> fileWithJava = null;
	try(Stream<Path>path = Files.walk(Paths.get(dirpath))){
		
		System.out.println("*** Files ending with .java are ****");
		
		fileWithJava =path.filter(p->p.toString().endsWith(".java")).collect(Collectors.toList());
		return fileWithJava;
	}catch(IOException ex) {
		System.out.println(ex);
	}
	return fileWithJava;
}

static void findFiles(String file, String absPath) {
try(Stream<Path>path = Files.walk(Paths.get(absPath))){
		
		System.out.println("*** Files in abspath  are ****");
		
		path.filter(p->p.getFileName().toString().equals(file)).forEach(System.out::println);
}catch(IOException ex) {
	System.out.println(ex);
}
}	
}
