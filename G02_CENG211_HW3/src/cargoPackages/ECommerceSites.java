package cargoPackages;

import exceptions.CargoCodeFormatException;

public enum ECommerceSites {
	AMAZON{ public boolean checkingForSite(String code,int counter){return check(code,7,counter,5);}  },
	HEPSİBURADA{ public boolean checkingForSite(String code,int counter){return check2(code,8,counter,7);}  },
	TRENDYOL{ public boolean checkingForSite(String code,int counter){return check(code,8,counter,9);}  },
	N11{ public boolean checkingForSite(String code,int counter){return check2(code,7,counter,6);}  };
	
	 
	
	public abstract boolean checkingForSite(String code,int counter);
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	public boolean check(String code,int lenght, int dailyCounter,int dailyLimit){
		try {
			if(!(isNumeric(code) || !(code.length() == lenght))) {
				throw new CargoCodeFormatException("Site kargo formatı uygun değil");
			}
			else if(!(dailyCounter <= dailyLimit)){
				return false;
			}
			else {
				return true;
			}
			
		} catch (CargoCodeFormatException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
		
		public boolean check2(String code,int lenght, int dailyCounter,int dailyLimit){
			try {
				if((isNumeric(code) || !(code.length() == lenght))) {
					throw new CargoCodeFormatException("Site kargo formatı uygun değil");
				}
				else if(!(dailyCounter <= dailyLimit)){
					return false;
				}
				else {
					return true;
				}
				
			} catch (CargoCodeFormatException e) {
				System.out.println(e.getMessage());
				return false;
			}
	}
}
