package cargoPackages;

import eCommerceSitres.Amazon;
import eCommerceSitres.HepsiBurada;
import eCommerceSitres.IECommerceSites;
import eCommerceSitres.N11;
import eCommerceSitres.Trendyol;

public  class ECommerceCargoPackage<T> extends CargoPackage<T> implements IECommerceCargoPackage<T>,ICargoPackage<T>  {
	private String siteName;
	private String status;
	
	
	public ECommerceCargoPackage() {
		this("",null,0,0,0,0,0);
	}
	public ECommerceCargoPackage(String siteName, T cargoCode, int weight, int width, int lenght, int height, int count) {
		super(cargoCode,weight,width,lenght,height);
		this.siteName = siteName;
		this.status = setStatus(cargoCode,count);
	}

	public String getSiteName() {
		return siteName;
	}

	public String getStatus() {
		return status;
	}
	
	public T getCargoCode() {
		return super.getCargoCode();
	}
	
	public int calculateSize() {
		return super.calculateSize();
	}


	@SuppressWarnings("unchecked")
	public String setStatus(T cargoCode, int count) {
		String status = "Not Accepted";
		switch (siteName) {
		case "Amazon":
			IECommerceSites<T> amazon = (IECommerceSites<T>) new Amazon();
			if(amazon.checkCodeFormat(cargoCode) && (count < amazon.getDailyLimit())){
				return "Accepted";
			}
			break;
		case "Hepsiburada":
			IECommerceSites<T> hepsiburada = (IECommerceSites<T>) new HepsiBurada();
			if(hepsiburada.checkCodeFormat(cargoCode) && (count < hepsiburada.getDailyLimit())){
				return "Accepted";
			}
			break;
		case "N11":
			IECommerceSites<T> n11 = (IECommerceSites<T>) new N11();
			if(n11.checkCodeFormat(cargoCode) && (count < n11.getDailyLimit())){
				return "Accepted";
			}
			break;
		case "Trendyol":
			IECommerceSites<T> trendyol = (IECommerceSites<T>) new Trendyol();
			if(trendyol.checkCodeFormat(cargoCode) && (count < trendyol.getDailyLimit())){
				return "Accepted";
			}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + siteName);
		}
		return status;
	}
	



	

}
