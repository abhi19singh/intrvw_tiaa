package com.tiaa;

public class MainClass {

	public static void main(String[] args) throws Exception{
		if(args.length < 3) {
			throw new InvalidNumberOfArguments("Minimum three aruments are required");
		}
		int bolts = Integer.parseInt(args[0]);
		int machines = Integer.parseInt(args[0]);
		int timeToCompleteProduct = Integer.parseInt(args[0]);
		SharedRawMaterial wareHouse = new SharedRawMaterial(bolts, machines, timeToCompleteProduct);
		wareHouse.startProcessing();
		System.out.println("Total number of product assembled "+ wareHouse.getTotalProducts());
		System.out.println("Time to assemble "+ wareHouse.getTotalProducts() + " products is "+ (wareHouse.getTotalProducts() * timeToCompleteProduct));
	}

}
