package cargoPackages;

import java.util.Calendar;

public abstract  class CargoPackage<T> implements ICargoPackage<T>{

	private int weight;
	private int width;
	private int length;
	private int height;
	private T cargoCode;
	
	
	public CargoPackage() {
		this(null,0,0,0,0);
	}
	public CargoPackage( T cargoCode, int weight, int width, int lenght, int height) {
		this.cargoCode = cargoCode;
		this.weight = weight;
		this.width = width;
		this.length = lenght;
		this.height = height;
	}
	
	

	public int getWeight() {
		return weight;
	}

	public int getWidth() {
		return width;
	}

	public int getLenght() {
		return length;
	}

	public int getHeight() {
		return height;
	}
	
	public T getCargoCode() {
		return cargoCode;
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public DayOfWeek calculateDeliveryDay() {
        Calendar calendar = Calendar.getInstance();
        int shipmentDuration = 2 ;
        switch((calendar.getTime().getDay() + shipmentDuration - 1) % 6 ) {
        case 0:
            return DayOfWeek.MONDAY;
        case 1:
            return DayOfWeek.TUESDAY;
        case 2:
            return DayOfWeek.WEDNESDAY;
        case 3:
            return DayOfWeek.THURSDAY;
        case 4:
            return DayOfWeek.FRIDAY;
        case 5:
            return DayOfWeek.SATURDAY;
        default:
            return null; //Not necessary throws an exception because all possibilities has controlled
        }
    }
 
	


	@Override
	public int calculateSize() {
		double desi = (double)(this.width*this.length*this.height)/3000;
		return (int) Double.max(desi,Double.valueOf(weight));
	}
	

	
}
