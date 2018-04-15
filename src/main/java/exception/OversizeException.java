package exception;

public class OversizeException extends LogisticsException {
	public OversizeException(String msgKey) {
		super(msgKey);
	}
}
