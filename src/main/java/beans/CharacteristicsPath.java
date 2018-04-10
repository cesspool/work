package beans;

import java.util.List;

public class CharacteristicsPath {

	private double cost;
	private double time;
	private List<Integer> transport;
	private List<String> path;
	private List<Long> pathId;
	
	
	public List<Long> getPathId() {
		return pathId;
	}
	public void setPathId(List<Long> pathId) {
		this.pathId = pathId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public List<Integer> getTransport() {
		return transport;
	}
	public void setTransport(List<Integer> transport) {
		this.transport = transport;
	}
	public List<String>  getPath() {
		return path;
	}
	public void setPath(List<String>  path) {
		this.path = path;
	}
	
	
}
