package InterfaceAndAbstractSample;

public class SmartPhone extends SmartDevice {
	
	private boolean hasUSIM;
	private String phoneNumber;
	private String userName;
	private WireService wireServiceName;
	
	//network by usim
	private Network network;
	
	//app
	private String[] appStorage; //stack
	private int topOfAppsStorage;
	

	public SmartPhone(boolean hasUSIM, String phoneNumber, String userName, WireService  wireServiceName)
	{
		this.hasUSIM = hasUSIM;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.wireServiceName = wireServiceName;
		appStorage = new String[256];
		topOfAppsStorage = -1;
		network = Network.getInstance();
		super.settingPID(); //휴대폰 PID 생성
		super.writeLog("create SmartPhone");
	}
	
	@Override
	public boolean connectNetwork(String ipAddress, String port) {
		try {
			boolean isOpenSuccess = false;
			
			if(checkUSIM() && checkPower()) {
				//Network Connect (socket) ipAddress:port
				network.setUrl(ipAddress, port);
				
				if(network.openChannel(network.getUrl()))
				{
					//channel open success
					// TODO : 이후 작업.
					super.writeLog(new StringBuilder("openChannel Success\nCHANNEL INFO : ").append(network.getUrl()).toString());
					isOpenSuccess = true;
				}
			}
			return isOpenSuccess;
		}
		catch(Exception ex)
		{
			super.writeLog(ex.toString());
			return false;
		}
	}

	@Override
	public boolean disconnectNetwork() {
		// Check Network Object
		try {
			boolean isCloseSuccess = false;
			
			if(checkUSIM() && checkPower()) {
				//Network Connect (socket) ipAddress:port
				if(network.closeChannel())
				{
					//channel open success
					// TODO : 이후 작업.
					super.writeLog("closeChannel Success");
					isCloseSuccess = true;
				}
			}
			return isCloseSuccess;
		}
		catch(Exception ex)
		{
			super.writeLog(ex.toString());
			return false;
		}
	}

	@Override
	void installApp(String appName) {
		if(checkPower())
		{
			topOfAppsStorage++;
			appStorage[topOfAppsStorage] = appName;
			
			super.writeLog("install App");
		}
	}

	@Override
	void deleteApp(String appName) {
		if(checkPower()) {
			super.writeLog("delete App");
		}
	}

	@Override
	public boolean checkUSIM() {
		if(!hasUSIM)
		{
			super.writeLog("USIM이 없습니다.");
		}
		return hasUSIM;
	}
	
	public boolean checkPower()
	{
		if(!power)
		{
			super.writeLog("전원이 꺼져 있습니다.");
		}
		return power;
	}
	
	public void printSmartPhoneInfo()
	{
		System.out.println("사용자 이름 : " + this.userName +
							"\n휴대폰 번호 : " + this.phoneNumber +
							"\n휴대폰 고유 번호 : " +  this.PID +
							"\n휴대폰 USIM 여부 : "  + (this.hasUSIM ? "O":"X")+
							"\n휴대폰 NETWORK 정보 : " + network.getUrl());
	}
}
