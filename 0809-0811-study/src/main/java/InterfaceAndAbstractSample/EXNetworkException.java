package InterfaceAndAbstractSample;

public class EXNetworkException extends Exception {
	private static final long serialVersionUID = 1L;

	public EXNetworkException(String message)
	{
		super(message);
	}
	
	public EXNetworkException()
	{
		super("Network Exception :");
	}

}
