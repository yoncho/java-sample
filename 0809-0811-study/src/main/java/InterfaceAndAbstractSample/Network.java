package InterfaceAndAbstractSample;

public class Network {
	//singleton pattern (Network 객체를 단 1개밖에 생성 못 함)
	private static Network channel;
	private String url;
	private String channelInfo; // if channel open success, channelInfo is not null
	
	private Network() {
		// TODO : Init Network Setting.
	}
	// singleton
	public  static Network getInstance() {
		if (channel == null)
		{
			channel = new Network();
		}
		return channel;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String ipAddress, String port)
	{
		// ipAddress = 127.0.0.1 , port = 8888
		// url = 127.0.0.l:8888
		this.url = new StringBuilder(ipAddress).append(":").append(port).toString();
	}
	
	public boolean openChannel(String url) throws NetworkException
	{
		// TODO : channel open by url
		//if channel open success => return true
		//if channel open failed  => return false
		if (url == null)
		{
			throw new NetworkException("Channel Open Failed");
		}
		channelInfo = "#CHANNEL INFO";
		return true;
	}
	
	public boolean closeChannel() throws NetworkException
	{
		// TODO : channel close by channel
		//if channel close success => return true
		//if channel close failed  => return false
		if (channelInfo == null)
		{
			throw new NetworkException("Channel Not Open");
		}
		return true;
	}
}
