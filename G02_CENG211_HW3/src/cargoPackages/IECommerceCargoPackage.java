package cargoPackages;

public interface IECommerceCargoPackage<T> extends ICargoPackage<T> {
	String getSiteName();
	String setStatus(T cargoCode, int count);
	String getStatus();
}
