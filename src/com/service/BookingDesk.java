package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.model.Movie;
import com.model.Snack;

public class BookingDesk implements BookMyShow {	
	
	Scanner sc=new Scanner(System.in);
	
	
	
	public Movie bookTicket(List<Movie> mv)  {
	      Movie fav=null;
	      System.out.println("**************************************************Today's show***************************************************************");
	      
	      for(Movie m:mv) {
	    	  System.out.println("Movie id: "+m.getId()+" Name: "+m.getName()+" Rating: "+m.getRating()+" Genre: "+m.getGenre()+"\nprice: "+m.getPrice());
	    	  
	    	  System.out.println("___________________________________________________________________________________________________________________________________________________________________");
	      }
	      
	      System.out.println("Choose movie from above list\nEnter movie id here: ");
	      int id=sc.nextInt();
	      boolean flag=false;
	      
	      for(Movie m: mv) {
	    	  if(id==m.getId()) {
	    		  fav=m;
	    		  flag=true;
	    		  System.out.println("Movie added to your cart!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    		  return fav;
	    	  }
	      }
	      
	      if(!flag) {
	    	  System.out.println("Enter correct id please!!");
	      }
	      
	      return fav;
	}
	
	public List<Snack> addMeal(List<Snack> sn) {
		 List<Snack> ll=new ArrayList<>();
		 System.out.println("********************************************Today's Menu*********************************************************");
		 
		 for(Snack s:sn) {
			 System.out.println("id: "+s.getId()+" Name: "+s.getName()+" Price: "+s.getPrice()+"\nContent: "+s.getDesc());
			 System.out.println("_________________________________________________________________________________________________________________________________________________________________");
		 }
		 
		 int i=1;
		 while(i<=10) {
			 System.out.println("Choose from above menu\nwhat you want to eat");
			 int id=sc.nextInt();
			 for(Snack s:sn) {
				 if(id==s.getId()) {
					 ll.add(s);
				 }
			 }
			 System.out.println("do you want to add anything?\npress Y to add another meal\nOtherwise press N");
			 char c=sc.next().charAt(0);
			 
			 if(c=='Y') {
				 continue;
			 }else {
				 break;
			 }
		 }
		 return ll;
	  } 
	
	@Override
	public void printDetails(Map<Integer,List> m) {
		  List<Integer> l=new ArrayList<>();
		  m.forEach((k,v)-> {
			  for(Object o:v) {
				  if(o.getClass()==Movie.class) {
					  System.out.println("How many seats you want to book?");
					  int num=sc.nextInt();
					  Movie m1=(Movie) o;
					  int movieCart=m1.getPrice()*num;
					  l.add(movieCart);
					  System.out.println("**************************************************************Booking Details********************************************************************");
				      System.out.println("Movie name: "+m1.getName()+"Movie Genere: "+m1.getGenre());
				      System.out.println("price for movie "+movieCart);
				  }else if(o.getClass()==Snack.class) {
					  Snack s=(Snack) o;
					  
					  System.out.println("************************************************************your meals***********************************************************************");
					  System.out.println("Snack: "+s.getName());
					  int snackCart=s.getPrice();
					  System.out.println("Price for snack"+snackCart);
					  l.add(snackCart);
				  }else {
					  System.out.println("No found any details please check once again!!!");
				  }
			  }
		  });
		  
		  int cart=0;
		  for(Integer i:l) {
			  cart+=i;
		  }
		  
		  System.out.println("____________________________________________________________________________________");
		  System.out.println("Total price: "+cart);
		  System.out.println("_____________________________________________________________________________________");
	    }
	
	@Override
	public void logout() {
		System.out.println("You have sucessfully logged out");	
		System.exit(0);
	}
 }
