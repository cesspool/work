package exception;

public class RateAlreadyExistException extends LogisticsException {
	public RateAlreadyExistException (String msgKey) {
		super(msgKey);
	}
}
