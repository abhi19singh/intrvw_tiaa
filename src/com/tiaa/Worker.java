package com.tiaa;

public class Worker implements Runnable {
	
	private String[] rawMaterial = new String[3];
	private SharedRawMaterial sharedMarterial;
	private int timeToAssemble;
	private boolean productCreated = false;
	private String name;
	
	public Worker(SharedRawMaterial sharedResource, int timeToAssemble, String workerName) {
		sharedMarterial = sharedResource;
		this.timeToAssemble = timeToAssemble;
		this.name = workerName;
	}
	
	
	public boolean pickRawMaterial() {
		boolean accepted = true;
		synchronized (sharedMarterial) {
			if(rawMaterial.length == 0) {
				rawMaterial[0] = sharedMarterial.getRawMaterial().getName();
			} else if(rawMaterial.length == 1) {
				rawMaterial[1] = sharedMarterial.getRawMaterial().getName();
			} else {
				String bolt = RawMaterial.BOLT.getName();
				if(rawMaterial[0].equals(bolt) && rawMaterial[1].equals(bolt)) {
					accepted = !sharedMarterial.getRawMaterial().getName().equals(bolt);
				}else if(rawMaterial[0].equals(bolt) && rawMaterial[1].equals(RawMaterial.MACHINE.getName())){
					accepted = !sharedMarterial.getRawMaterial().getName().equals(RawMaterial.MACHINE.getName());
				}
			}
			return accepted;
		}
	}
	
	public void createProduct() {
		productCreated = true;
		rawMaterial = new String[3];
	}
	
	public void setProductIfCreated() {
		synchronized (sharedMarterial) {
			sharedMarterial.setProduct(this.name);
			productCreated = false;
		}
		
	}
	
	public void run() {
		try {
			if(rawMaterial.length == 3) {
				createProduct();
				Thread.sleep(timeToAssemble);
			}
			}catch(Exception ex) {
				//TODO : 
			}
	}

}
