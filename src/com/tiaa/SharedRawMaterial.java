package com.tiaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SharedRawMaterial {
	private Map<String, Integer> workerToProductMap;
	private List<RawMaterial> rawMaterial;
	private RawMaterial currentMaterialOnBelt;
	
	
	public SharedRawMaterial(int bolts, int machines, int timeToCompleteProduct) {
		workerToProductMap = new HashMap<>();
		rawMaterial = new ArrayList<>(bolts+machines);
		int index = bolts > machines ? bolts : machines;
		for(int i=0; i<index; i++) {
			if(bolts > i) {
				rawMaterial.add(RawMaterial.BOLT);
			}
			if(machines > i) {
				rawMaterial.add(RawMaterial.MACHINE);
			}
		}
	}
	
	public RawMaterial getRawMaterial(){
		return currentMaterialOnBelt;
	}
	
	public void setProduct(String workerName) {
		int productCount = workerToProductMap.get(workerName);
		workerToProductMap.put(workerName, productCount++);
	}
	
	public int getTotalProducts() {
		int product = 0;
		for(Entry<String, Integer> worker : workerToProductMap.entrySet()) {
			product = product + worker.getValue();
		}
		return product;
	}
	
	public void setCurrentRawMaterial(RawMaterial material) {
		currentMaterialOnBelt = material;
	}
	
	public void startProcessing() {
		//start rotating belt
	}
	
	private class RotatingBelt implements Runnable{
		
		public void run() {
			
		}
	}

}
