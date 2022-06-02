package cargoPackages;



public class NormalCargoPackage extends CargoPackage<Integer> implements INormalCargoPackage,ICargoPackage<Integer>{
	
	private long senderId;
	private String senderName;
	private String recipientName;
	private String recipientAddress;
	private String status;
	
	
	public NormalCargoPackage() {
		this(0,"","","",0,0,0,0);		
	}
	
	public NormalCargoPackage(long senderId,String senderName, String recipientName, String recipientAddress, int weight, int width, int lenght, int height) {
		super(Code.generateCargoCode(7),weight, width, lenght, height);
		this.senderId = senderId;
		this.senderName = senderName;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.status = setStatus(senderId);
		
	}
	
	

	public long getSenderId() {
		return senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}
	

	
	public double calculatePrice() {
		int size = super.calculateSize();
		return  (18.5)+3*size;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	@Override
	public String setStatus(Long senderId) {
		status = "Not Accepted";
		if(senderId.toString().length() == 11) {
			status = "Accepted";
		}
		return status;
	}
	
	
	
	// We created inner class to use a method in super 
	// constructor otherwise we cannot use a method which is defined in outer class
	static class Code {
		// generate max 9-digit random number
		private static int generateCargoCode(double lenght) {
			double min = Math.pow(10, lenght);
			double max = min*10 - 1;
			return (int)(Math.random() * (max - min + 1) + min);
		}
	}






	
	

}
