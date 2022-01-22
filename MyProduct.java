package com.bajaj.practice;
import java.util.*;
import java.util.stream.Collectors;
class Product implements Comparable{
	private int id;
	private String laptop;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(int id, String laptop, float price) {
		super();
		this.id = id;
		this.laptop = laptop;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product id "+id+" company "+laptop+" price "+price ;
	}
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		if(this.getPrice() > ( o).getPrice())
			return 1;
		else if(this.getPrice() < ( o).getPrice())
			return -1;
		else
			return 0;
		
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
public class MyProduct {
	public static void main(String[] args) {
		List<Product> productsList=new ArrayList<Product>();
		 	productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",28000f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f));  
	        productsList.add(new Product(6,"Dell Laptop",50000f));
	        //count
	      long count=productsList.stream().filter(Prod -> Prod.getPrice()==28000).count();
	      System.out.println(count);
	      //max price of the laptop in the list 
	      Product productA = productsList.stream().max((product1, product2)->product1.getPrice() > product2.getPrice() ? 1: -1).get();    
	      System.out.println("The product "+productA.getLaptop()+" is with maximum price of "+productA.getPrice());    
	      //min price of the laptop in the list 
	      Product productB=productsList.stream().min((p1,p2)->p1.getPrice()>p2.getPrice()?1:-1).get();
	      System.out.println("The product "+productB.getLaptop()+" is with minimum price of "+productB.getPrice());
	     //filtering according to the name of the laptop
	      productsList.stream().filter(p -> p.getLaptop().equals("Dell Laptop")).forEach(str -> System.out.println(str));
	      Map<Integer,String> ProductMap=productsList.stream().collect(Collectors.toMap(p->p.getId(), p->p.getLaptop()));
	      Iterator<Integer> itr=ProductMap.keySet().iterator();
	      while(itr.hasNext()) {
	    	  int key=(int)itr.next();
	    	  System.out.println("Company of the product "+ProductMap.get(key));
	      }
	      //collectors
	      Double totalPrice3 = productsList.stream()  
                  .collect(Collectors.summingDouble(product->product.getPrice()));  
	      System.out.println(totalPrice3);  
	      
	      
	      //map
	     productsList.stream().map(p -> p.getLaptop().toLowerCase()).forEach(str -> System.out.println(str));
	      //distinct 
	     System.out.println("*********************************************");
	     productsList.stream().map(p -> p.getLaptop().toLowerCase()).distinct().forEach(str -> System.out.println(str));
	      //sorted 
	     productsList.stream().sorted((p1,p2) -> p1.compareTo(p2)).forEach(str -> System.out.println(str));
	}

	
	
}
