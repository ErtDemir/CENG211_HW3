package cargoAcceptanceApp;

import cargoPackages.IECommerceCargoPackage;
import cargoPackages.INormalCargoPackage;



public class CargoAcceptanceAppView {
	CargoAcceptance cargoPackages = new CargoAcceptance();
	
	
	public void viewBuilder() {
		int numberOfAcceptedCargo = getNumberOfAcceptedCargo();
		System.out.println("Welcome!!");
		System.out.println("Number of Accepted Cargo: " + numberOfAcceptedCargo);
		System.out.println("Number of Not Accepted Cargo: " + (cargoPackages.cargoAccept().size() - numberOfAcceptedCargo));
		System.out.println("Here are the details : \n");
		System.out.println("NORMAL CARGO PACKAGES : ");
		System.out.println("No - Cargo Code - Sender ID - Sender Name - Recipient Name - Recipient Address - Size - Price - Delivery Day");
		System.out.println(normalStringBuilder());
		System.out.println("\nE-COMMERCE CARGO PARCKAGES:");
		System.out.println("No - E-commerce Site - Cargo Code - Status - Size - Delivery Day");
		System.out.println(eCommerceStringBuilder());
		
		
	}
	
	@SuppressWarnings("unused")
	private String eCommerceStringBuilder() {
		String eCommerceCargoString = "";
		int counter = 1;
		
		for(Object cargoPackage : cargoPackages.cargoAccept()) {
			try {
				@SuppressWarnings("unchecked")
				IECommerceCargoPackage<Object> eComerce = ((IECommerceCargoPackage<Object>)cargoPackage);
				eCommerceCargoString += String.format("%d %s %s %s %d %s \n", counter,eComerce.getSiteName(),eComerce.getCargoCode().toString(),eComerce.getStatus(),eComerce.calculateSize(),eComerce.calculateDeliveryDay());
				counter += 1;
				
			} catch (ClassCastException e) {
				//
			}	
		}
		return eCommerceCargoString;
	}
	
	private String normalStringBuilder() {
		String normalCargoString = "";
		int counter = 1;
		
		for(Object cargoPackage : cargoPackages.cargoAccept()) {
			try {
				INormalCargoPackage normal = (INormalCargoPackage)cargoPackage;
				normalCargoString += String.format("%d %d %d %s %s %s %d %.2f %s \n",counter,normal.getCargoCode().intValue(),normal.getSenderId(),normal.getSenderName(),normal.getRecipientName(),normal.getRecipientAddress(),normal.calculateSize(),normal.calculatePrice(),normal.calculateDeliveryDay());
				counter += 1;
				
			} catch (ClassCastException e) {
				//
			}	
		}
		return normalCargoString;
	}
	
	@SuppressWarnings("unchecked")
	private int getNumberOfAcceptedCargo () {
		int numberOfAcceptedCargo = 0;
		
		for(Object cargoPackage : cargoPackages.cargoAccept()) {
			try {
				INormalCargoPackage normal = (INormalCargoPackage)cargoPackage;
				if(normal.getStatus().equals("Accepted")) {
					numberOfAcceptedCargo += 1;
				}
				
			} catch (ClassCastException e) {
				IECommerceCargoPackage<Object> eComerce = ((IECommerceCargoPackage<Object>)cargoPackage);
				if(eComerce.getStatus().equals("Accepted")) {
					numberOfAcceptedCargo += 1;
				}
			}	
		}
		return numberOfAcceptedCargo;
	}
}
