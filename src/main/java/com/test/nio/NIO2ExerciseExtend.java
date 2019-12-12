package com.test.nio;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NIO2ExerciseExtend {

	private NIO2Exercise nio2ex;

	public void setNio2ex(NIO2Exercise nio2ex) {
		this.nio2ex = nio2ex;
	}
	public  List<Path> getFilesEndwithjava(){
		return nio2ex.getFileswithjava("src");
	}
	
	public static void main(String[] args) {
		NIO2ExerciseExtend niex = new NIO2ExerciseExtend();
		
		niex.getFilesEndwithjava().forEach(System.out::println);
       // findFiles("Tablet.txt","src/main/resources/");
	}
}
