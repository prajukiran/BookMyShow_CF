package com.service;

import java.util.List;
import java.util.Map;
import com.model.Movie;
import com.model.Snack;

public interface BookMyShow {

    Movie bookTicket(List<Movie> mv);
	
	List<Snack> addMeal(List<Snack> sn);
	
	void printDetails(Map<Integer,List> m);
	
	void logout();		
	
}
