package InterfaceAndAbstractSample;

public interface INetworkable {
	boolean checkUSIM();
	boolean connectNetwork(String ipAddress, String port);
	boolean disconnectNetwork();
}
