package javaStreamsPackage;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.List;
import java.util.function.Predicate;

public class JavaStreamsMain {

	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList(ArrayString.austin);
		double doubleArray[] = ArrayDouble.doubleArray;
		
		// 1-1
		
		List<String> newList1 = stringList
				.stream()
				.filter(x -> x.length() > 8)
				.collect(Collectors.toList());
		
		System.out.println(String.format("1-1: Number of words longer than 8 characters: %d.", newList1.size()));
		
		// 1-2
		
		List<String> newList2 = stringList
				.stream()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(String.format("1-2: Number of unique words is: %d.", newList2.size()));
		
		// 1-3
		
		List<String> newList3 = stringList
				.stream()
				.filter(x -> x.length() < 4)
				.collect(Collectors.toList());
		
		System.out.println(String.format("1-3: Number of words shorter than 4 characters: %d.", newList3.size()));
		
		// 1-4
		
		List<String> newList4 = stringList
				.stream()
				.filter(x -> x.length() > 8)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(String.format("1-4: Number of unique words longer than 8 characters: %d.", newList4.size()));
		
		// 1-5
		
		double newList5 = stringList
				.stream()
				.mapToInt(x -> x.length())
			    .average()
			    .getAsDouble();
		
		System.out.println(String.format("1-5: The average word length in the array is: %.2f.", newList5));
		
		// 1-6
		
		int newList6 = stringList
				.stream()
				.mapToInt(x -> x.length())
				.sum();
		
		System.out.println(String.format("1-6: There are %d characters in the entire array.", newList6));
		
		// 1-7
		
		Predicate<String> longerThan12 = x -> x.length() > 12;
		Predicate<String> shorterThan2 = x -> x.length() < 2;
		
		List<String> newList7_1 = stringList
				.stream()
				.filter(longerThan12)
				.collect(Collectors.toList());
		
		if (newList7_1.size() > 0) {
			System.out.print("1-7: Not all words are shorter than 12 characters.");
		} else {
			System.out.print("1-7: All words are shorter than 12 characters");
		}
		
		List<String> newList7_2 = stringList
				.stream()
				.filter(shorterThan2)
				.collect(Collectors.toList());
		
		if (newList7_2.size() > 0) {
			System.out.println(" All words are longer than 2 characters.");
		} else {
			System.out.println(" Not all words are longer than 2 characters");
		}
		
		// 2-1
		
		DoubleStream myDoubleStream1 = Arrays.stream(doubleArray);
				
		double newList8[] = myDoubleStream1
				.filter(x -> x > 1000)
				.toArray();
		
		System.out.println(String.format("\n2-1: There are %d numbers in doubleArray that are greater than 1000.", newList8.length));
		
		// 2-2
		
		DoubleStream myDoubleStream2 = Arrays.stream(doubleArray);
		
		int newList9[] = myDoubleStream2
				.mapToInt(x -> (int)Math.round(x))
				.filter(x -> x < 1000)
				.filter(x -> x % 3 == 0)
				.distinct()
				.toArray();
		
		System.out.println("2-2: " + Arrays.toString(newList9));
		
		// 2-3
		
		DoubleStream myDoubleStream3 = Arrays.stream(doubleArray);
		
		double newList10 = myDoubleStream3
				.filter(x -> x < 500)
				.sum();
		
		System.out.println(String.format("2-3: Sum of all numbers lower than 500: %.2f.", newList10));
		
		// 2-4
		
		DoubleStream myDoubleStream4 = Arrays.stream(doubleArray);
		
		double newList11 = myDoubleStream4
				.filter(x -> x > 2000)
				.filter(x -> x < 3000)
				.average()
				.getAsDouble();
		
		System.out.println(String.format("2-4: Average of numbers between 2000 and 3000: %.2f.", newList11));
		
		// 2-5
		
		DoubleStream myDoubleStream5 = Arrays.stream(doubleArray);
		
		double newList12_1 = myDoubleStream5
				.max()
				.getAsDouble();
		
		System.out.print(String.format("2-5: Max value: %.2f.", newList12_1));
		
		DoubleStream myDoubleStream6 = Arrays.stream(doubleArray);
		
		double newList12_2 = myDoubleStream6
				.min()
				.getAsDouble();
		
		System.out.println(String.format(" Min value: %.2f.", newList12_2));
		
		// 3-1
		
		MyObject objArray[] = generateObj();
		
		List<MyObject> myObjectList = Arrays.asList(objArray);
		
		List<MyObject> newList13 = myObjectList
				.stream()
				.filter(x -> x.getValue() > 20)
				.collect(Collectors.toList());
		
		System.out.println(String.format("\n3-1: Number of objects with value greater than 20: %d.", newList13.size()));
		
		for (int i = 0; i < newList13.size(); i++) {
			System.out.print(newList13.get(i).toString() + " ");
		}
		
		// 3-2
		
		double newList14 = myObjectList
				.stream()
				.mapToDouble(x -> x.getValue())
				.average()
				.getAsDouble();
		
		System.out.println(String.format("\n3-2: Average value: %.2f.", newList14));
		
		// 3-3
		
		List<MyObject> newList15 = myObjectList
				.stream()
				.filter(x -> x.getBool() == true)
				.collect(Collectors.toList());
		
		for (int i = 0; i < newList15.size(); i++) {
			newList15.get(i).setName("this is true");
		}
		
		for (int i = 0; i < newList15.size(); i++) {
			System.out.print("3-3: " + newList15.get(i).toString() + " ");
		}
 
	}
	
	public static MyObject[] generateObj() {
		
		boolean bool;
		
		MyObject objArray[] = new MyObject[50];
		
		for (int i = 0; i < 50; i++) {
			
			int randInt = (int)(Math.random() * 51 + 1);
			String randString = generateString();
			
			int rand = (int)(Math.random() * (1 + 1));
			
			if (rand == 0) {
				bool = false;
			} else {
				bool = true;
			}
			
			MyObject newObj = new MyObject(bool, randInt, randString);
			
			objArray[i] = newObj;
			
		}
		
		return objArray;
		
	}
	
	public static String generateString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
		
		StringBuilder sb = new StringBuilder(6); 
		  
        for (int i = 0; i < 6; i++) { 
        	
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            sb.append(AlphaNumericString.charAt(index));
            
        } 
  
        return sb.toString(); 
	}

}
