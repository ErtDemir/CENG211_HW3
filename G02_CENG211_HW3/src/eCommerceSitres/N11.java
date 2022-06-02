package eCommerceSitres;

public class N11 extends ECommerceSites implements IECommerceSites<Object>{
	
	public N11() {
		dailyLimit = 6;
	}
	@Override
	public int getDailyLimit() {
		return this.dailyLimit;
	}

	@Override
	public boolean checkCodeFormat(Object cargoCode) {
		if((cargoCode.toString().length() == 7) && !isNumeric(cargoCode)) {
			return true;
		}
		return false;
	}

}
