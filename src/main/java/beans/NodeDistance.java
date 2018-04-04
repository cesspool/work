package beans;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NodeDistance {
	private Node node;
	//private List<String> cities;
	//Map<Long, String> allCities;
	private Collection<Distance> distances;
	private String[] cities;
	List<Integer> transport;
	
	
	public List<Integer> getTransport() {
		return transport;
	}

	public void setTransport(List<Integer> transport) {
		this.transport = transport;
	}

	public NodeDistance () {
		node = new Node();
	}
	
	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}



//	public Collection<Transport> getTransports() {
//		return transports;
//	}
//	public void setTransports(Collection<Transport> transports) {
//		this.transports = transports;
//	}
	public Collection<Distance> getDistances() {
		return distances;
	}
	public void setDistances(Collection<Distance> distances) {
		this.distances = distances;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
//	public Map<Long, String> getAllCities() {
//		return allCities;
//	}
//	public void setAllCities(Map<Long, String> allCities) {
//		this.allCities = allCities;
//	}
	
//	public List<String> getCities() {
//		return cities;
//	}
//	public void setCities(List<String> cities) {
//		this.cities = cities;
//	}
}
