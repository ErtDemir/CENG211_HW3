package eCommerceSitres;

public class HepsiBurada extends ECommerceSites implements IECommerceSites<Object>{
	
	public HepsiBurada() {
		dailyLimit = 7;
	}
	
	@Override
	public boolean checkCodeFormat(Object cargoCode) {
		if((cargoCode.toString().length() == 8) && !isNumeric(cargoCode)) {
			return true;
		}
		return false;
	}

	@Override
	public int getDailyLimit() {
		return this.dailyLimit;
	}


}
