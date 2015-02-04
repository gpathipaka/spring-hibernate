package com.java.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortingExample {
	
	public static void main(String[] args){
		
		String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"};
		
		Arrays.sort(fruits);
		System.out.println("Arra Sort ..");
		for(String str : fruits){
			System.out.println(str);
		}
		
		List<String> fruitsLst = new ArrayList<String>();
		fruitsLst.add("Pineapple");
		fruitsLst.add("Apple");
		fruitsLst.add("Orange");
		fruitsLst.add("Banana");
		Collections.sort(fruitsLst);
		System.out.println("------------------------------");
		System.out.println("Collection Sort ..");
		for(String str : fruitsLst){
			System.out.println(str);
		}
	}

}
