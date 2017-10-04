package com.logui.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jcifs.smb.SmbFile;

import java.io.IOException;
public class TomcatLogsImport {
	

	private static void doReadWriteTextFile() {

	try {
	//	SmbFile fileToRead = new SmbFile("smb://52.52.40.38/)

	// input/output file names
	//String inputFileName = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\logs\\tomcat8-stderr.2017-09-29.txt";
	//inputFileName = inputFileName.replaceAll(" ", "//");
	//String inputFileName = "D:\\demo1.txt"; 
	String outputFileName = "D:\\tomcat8.txt";
	// Create FileReader Object
	//FileReader inputFileReader = new FileReader(inputFileName);
	FileReader outputFileReader = new FileReader(outputFileName);

	// Create Buffered/PrintWriter Objects
	BufferedReader inputStream = new BufferedReader(outputFileReader);
	//PrintWriter outputStream = new PrintWriter(outputFileReader);

	// Keep in mind that all of the above statements can be combined
	// into the following:
	//BufferedReader inputStream = new BufferedReader(new FileReader("README_InputFile.txt"));
	//PrintWriter outputStream = new PrintWriter(new FileWriter("ReadWriteTextFile.out"));

	//outputStream.println("+---------- Testing output to a file ----------+");
	//outputStream.println();
	Scanner scanner = new Scanner(System.in);
	List<String> list=new ArrayList<>();
	 while(scanner.hasNextLine()){
	     list.add(scanner.nextLine()); 

	 }
	String inLine = null;

	while ((inLine = inputStream.readLine()) != null) {
	System.out.println(inLine);
	}

	//outputStream.println();
	//outputStream.println("+---------- Testing output to a file ----------+");

	//outputStream.close();
	inputStream.close();

	} catch (IOException e) {

	System.out.println("IOException:");
	e.printStackTrace();

	}

	}


	public static void main(String[] args) {
	doReadWriteTextFile();
	}

	}

	

