package utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
 

public class ListObjectConverter {

	// Generic function to convert List of Integer to List of String
		public static <T, U> List<U> convertIntListToStringList(List<T> list, 
											Function<T, U> function)
		{
			return list.stream()
						.map(function)
						.collect(Collectors.toList());
		}
		
		// Generic function to convert List of String to List of Integer 
	    public static <T, U> List<U> 
	    convertStringListToIntList(List<T> listOfString, 
	                               Function<T, U> function) 
	    { 
	        return listOfString.stream() 
	            .map(function) 
	            .collect(Collectors.toList()); 
	    }  
}
