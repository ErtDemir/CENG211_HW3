package eCommerceSitres;

public interface IECommerceSites<T> {
	boolean checkCodeFormat(T cargoCode);
	public int getDailyLimit();
}
