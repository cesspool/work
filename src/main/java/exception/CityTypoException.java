package exception;

public class CityTypoException extends LogisticsException {
	public CityTypoException(String msgKey) {
		super(msgKey);
	}
}
