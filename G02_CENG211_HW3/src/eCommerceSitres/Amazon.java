package eCommerceSitres;

public class Amazon extends ECommerceSites implements IECommerceSites<Object>{
	
	public Amazon () {
		dailyLimit = 5;
	}
	
	public int getDailyLimit() {
		return this.dailyLimit;
	}
	@Override
	public boolean checkCodeFormat(Object cargoCode) {
		if((cargoCode.toString().length() == 7) && isNumeric(cargoCode)) {
			return true;
		}
		return false;
	}
	

}
