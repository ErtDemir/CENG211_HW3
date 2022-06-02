package eCommerceSitres;

public abstract class ECommerceSites {
	public int dailyLimit ;
	
	public boolean isNumeric(Object object) { 
		  try {  
			    Double.parseDouble(object.toString());  
			    return true;
			  } catch(NumberFormatException e){  
			    return false;  
			  }  
			}
}
