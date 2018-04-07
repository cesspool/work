package exception;

public class PathNotFoundException extends LogisticsException {
	public PathNotFoundException(String msgKey) {
		super(msgKey);
	}
}
