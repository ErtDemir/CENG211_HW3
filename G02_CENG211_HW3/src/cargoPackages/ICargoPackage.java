package cargoPackages;

public interface ICargoPackage<T> {
	int getWeight();
	int getWidth();
	int getLenght();
	int getHeight(); 
	T getCargoCode();


	
	DayOfWeek calculateDeliveryDay();
	int calculateSize();
}
