package com.user;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import com.model.Movie;
import com.model.Snack;
import com.model.User;
import com.service.BookingDesk;
import com.service.BookMyShow;
import java.util.List;

public class Test {

	public static void main(String args[]) {
		
		Scanner s=new Scanner(System.in);
		BookMyShow desk=new BookingDesk();
		
		Map<Integer,List> map=new LinkedHashMap<>();
		
		Movie m1=new Movie(101,"Transformer",250,7.8f,"SCI-FI Action");
		Movie m2=new Movie(102,"The meg",360,8.8f,"Action Thriller");
		Movie m3=new Movie(103,"Lupin",700,9.9f,"Suspense drama");
		Movie m4=new Movie(104,"Journy",200,6.8f,"Adventure");
		
		LinkedList<Movie> mv=new LinkedList<>();
		mv.add(m1);
		mv.add(m2);
		mv.add(m3);
		mv.add(m4);
		
		Snack s1=new Snack(1,"Veg Pizza","Get Fresh veggies & toppins on soft cheesze burst base",199);
		Snack s2=new Snack(2,"Burger","Get cheeze burger & crust",299);
		Snack s3=new Snack(3,"French fries","Hot pepprika sause and fresh fries",99);
		
		ArrayList<Snack> ar=new ArrayList<>();
		ar.add(s1);
		ar.add(s2);
		ar.add(s3);
		
		User u1=new User();
		u1.setUserName("Praju4399");
		u1.setPasword("Bhosale@123");
		
		User u2=new User();
		u2.setUserName("Kiran2310");
		u2.setPasword("Mozar@123");
		
		Queue <User> q=new ArrayDeque<>();
		q.add(u1);
	    q.add(u2);
	    
	    System.out.println("Welcom to \n##############################################################Book_My_Show######################################################");
	    System.out.println("Enter your UserName here");
	    String userName=s.next();
	    boolean f1=false;
	    
	    for(User u:q) {
	    	if(userName.equalsIgnoreCase(u.getUserName())) {
	    		System.out.println("Enter your password here: ");
	    		String pass=s.next();
	    		f1=true;
	    		
	    		if(pass.equals(u.getPasword())) {
	    			
	    			while(true) {
	    				System.out.println("Choose your option from below list");
	    				System.out.println("1.Book your ticket\n2.Add Meal\n3.Print Details\n4.Logout\n");
	    				System.out.println("Enter your choice: ");
	    				int ch=s.nextInt();
	    				
	    				switch(ch) {
	    				    
	    				case 1:
	    					    Movie bk=desk.bookTicket(mv);
	    					    List<Movie> l=new ArrayList<>();
	    					    l.add(bk);
	    					    
	    					    if(l.isEmpty()) {
	    					    System.out.println("Movies not found");
	    					    break;
	    					    }
	    					    else {
	    					    	map.put(1, l);
	    					    }
	    					    break;
	    					    
	    				case 2:
	    					     List<Snack> meal=desk.addMeal(ar);
	    					     if(meal.isEmpty()) {
	    					    	 System.out.println("Not found any meal");
	    					     }else {
	    					    	 map.put(2, meal);
	    					     }
	    					     break;
	    					     
	    				case 3: 
	    					     desk.printDetails(map);
	    					     break;
	    				case 4: 
	    					    desk.logout();
	    				        break;
	    				 default:
	    					    System.out.println("Wrong choice!!!!");
	    				}
	    			}
	    		}else {
	    			System.out.println("Password incorrect");
	    			continue;
	    		}
	    	}else {
	    		continue;
	    	}
	    }
	    if(!f1) {
	    	System.out.println("UserName Incorrect");
	    }
	}
}
 