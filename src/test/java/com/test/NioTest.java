package com.test;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.test.nio.Tablet;
import com.test.nio.NIO2Exercise;
import com.test.nio.NIO2ExerciseExtend;


//@RunWith(MockitoJUnitRunner.class)
public class NioTest {

	
	@Mock
	NIO2Exercise nio2ex;
	
	@InjectMocks
	NIO2ExerciseExtend nio2Extend;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getFilesEndwithjava() {
		
		Assert.assertEquals("src/main/java/com/test/BankDepositExercise.java",nio2Extend.getFilesEndwithjava().get(0).toString());
	    
	}
	
	@Test(expected=RuntimeException.class)
	public void getExpiredTablets() {
	doThrow(RuntimeException.class).when(nio2ex.getExpiredTablets("Tablet1.txt", "India"));
	verify(nio2ex,atLeast(0)).getExpiredTablets("Tablet1.txt", "India");
	}
	
	


}
