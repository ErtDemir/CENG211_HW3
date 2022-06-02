package cargoPackages;

public interface INormalCargoPackage extends ICargoPackage<Integer>{
	
	public long getSenderId();
	public String getSenderName();
	public String getRecipientName();
	public String getRecipientAddress();
	String getStatus() ;
	String setStatus(Long senderId);
	
	double calculatePrice();

}
