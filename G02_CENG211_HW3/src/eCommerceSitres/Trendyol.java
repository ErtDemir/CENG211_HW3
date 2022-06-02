package eCommerceSitres;

public class Trendyol extends ECommerceSites implements IECommerceSites<Object>{

	public Trendyol() {
		dailyLimit = 9;
	}
	@Override
	public int getDailyLimit() {
		return this.dailyLimit;
	}

	@Override
	public boolean checkCodeFormat(Object cargoCode) {
		if((cargoCode.toString().length() == 8) && isNumeric(cargoCode)) {
			return true;
		}
		return false;
	}

}
