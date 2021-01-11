package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Product;
import util.*;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Aplicamos o map(Aplica uma função a cada elemento da stream
		//-> convertando a list pra stream e depois convertendo para lista
		
		List<String> names = list.stream().map(new UppperCaseName()).collect(Collectors.toList());
		
		names.forEach(System.out::println);
		
	}
}
