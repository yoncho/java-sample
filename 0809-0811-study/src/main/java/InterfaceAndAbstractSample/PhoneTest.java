package InterfaceAndAbstractSample;

public class PhoneTest {

	public static void main(String[] args) {
		//boolean hasUSIM, String phoneNumber, String userName, EWireService  wireServiceName
		SmartPhone phone1 = new SmartPhone(true, "010-9980-9914", "yoncho", EWireService.LGUPLUS);
		
		//1. Check Usim
		phone1.powerOn();
		phone1.connectNetwork("127.0.0.1", "8888");
		phone1.disconnectNetwork();
		
		System.out.println("==================================");
		phone1.printSmartPhoneInfo();
		System.out.println("==================================");
		SmartPhone phone2 = new SmartPhone(true, "010-9980-9914", "yoncho", EWireService.LGUPLUS);
		
		//1. Check Usim
		phone2.powerOn();
		phone2.connectNetwork("127.0.0.2", "2222");
		phone2.disconnectNetwork();
		
		System.out.println("==================================");
		phone1.printSmartPhoneInfo();
		System.out.println("==================================");
		phone2.printSmartPhoneInfo();
		System.out.println("==================================");
	}

}
