package InterfaceAndAbstractSample;

import java.nio.charset.Charset;
import java.util.Random;

public abstract class ACSmartDevice extends ACDevice implements ILogging{
	protected String PID;
	
	@Override
	void powerOn() {
		this.power = true;
	}

	@Override
	void powerOff() {
		// TODO Auto-generated method stub
		this.power = false;
	}

	abstract void installApp(String appName);
	abstract void deleteApp(String appName);
	public void writeLog(String logData)
	{
		System.out.println(logData);
	}
	public void settingPID()
	{
	    PID = generateRandomHexString(16);
	}
	
	 public String generateRandomHexString(int length) {
	    Random random = new Random();
	    StringBuilder hexString = new StringBuilder();

	    for (int i = 0; i < length; i++) {
	        int randomInt = random.nextInt(16); // Generate a random number between 0 and 15
	        hexString.append(Integer.toHexString(randomInt)); // Convert to hexadecimal and append
	    }

	    return hexString.toString().toUpperCase(); // Convert to uppercase for consistency
	 }
}
