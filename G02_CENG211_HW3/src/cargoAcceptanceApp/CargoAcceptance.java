package cargoAcceptanceApp;

import java.util.ArrayList;
import java.util.HashMap;
import cargoPackages.CargoPackage;
import cargoPackages.ECommerceCargoPackage;
import cargoPackages.ICargoPackage;
import cargoPackages.IECommerceCargoPackage;
import cargoPackages.IPriceCalculator;
import cargoPackages.NormalCargoPackage;
import exceptions.CargoTypeNotSupportedException;
import fileAccess.CSVReader;
import fileAccess.IFileIO;

public class CargoAcceptance {
	
	public ArrayList<Object>  cargoAccept() {
		ArrayList<Object> allCargoPackages = new ArrayList<Object>();
		IFileIO lines = new CSVReader("HW3_PackagesToAccept");
		
		HashMap<String, Integer> dailyLimintCounterForSites = new HashMap<String, Integer>();
		
		
		
			for( String line : lines.getLines()) {
				try {
				String[] sp = line.split(";");
				if(sp[0].equals("Normal")) {
					allCargoPackages.add(new NormalCargoPackage(Long.parseLong(sp[1]),sp[2],sp[3],sp[4],Integer.parseInt(sp[5]),Integer.parseInt(sp[6]),Integer.parseInt(sp[7]),Integer.parseInt(sp[8])));
				}
				else if(sp[0].equals("Ecommerce")) {
					Object cargoCode = sp[2];
					
					int counter = 1;
					if(dailyLimintCounterForSites.containsKey(sp[1])) {
						counter += dailyLimintCounterForSites.get(sp[1]).intValue();
						dailyLimintCounterForSites.put(sp[1], counter );
					}
					else {
						dailyLimintCounterForSites.put(sp[1], counter );
					}
					
					allCargoPackages.add(new ECommerceCargoPackage<Object>(sp[1],cargoCode,Integer.parseInt(sp[3]),Integer.parseInt(sp[4]),Integer.parseInt(sp[5]),Integer.parseInt(sp[6]),counter));
				}
				else {
					throw new CargoTypeNotSupportedException("Cargo type not supported!!");
				}
				}
				catch (CargoTypeNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			}
		
		return allCargoPackages;
		
	}
	
	public double objectToDouble(Object obj) { 
		  try {  
		    Double d = Double.parseDouble(obj.toString());  
		    return d;
		  } catch(NumberFormatException e){  
		    return 0;  
		  }  
		}
		

}
