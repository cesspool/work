package exception;

import web.Message;
import web.Message.Type;

public class LogisticsException extends Exception {
	private Message msg;
	
	public LogisticsException() {
	}
	
	public LogisticsException(String msgKey) {
		msg = new Message(Type.ERROR, msgKey);
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}  
	
	
}
