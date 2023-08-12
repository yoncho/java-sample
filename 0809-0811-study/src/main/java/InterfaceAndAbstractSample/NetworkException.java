package InterfaceAndAbstractSample;

public class NetworkException extends Exception {
	private static final long serialVersionUID = 1L;

	public NetworkException(String message)
	{
		super(message);
	}
	
	public NetworkException()
	{
		super("Network Exception :");
	}

}
