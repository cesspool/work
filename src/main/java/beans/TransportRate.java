package beans;

import java.util.List;

public class TransportRate {
	private final List<Rate> rate;
	private final Transport transport;
	
	public TransportRate (List<Rate> rate, Transport transport) {
		this.rate = rate;
		this.transport = transport;
	}
	
	public List<Rate> getRate() {
		return rate;
	}
	public Transport getTransport() {
		return transport;
	}
	
}
