package form.request;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatusForm {
	private String nameRecip;
	private List<String> orderDoneIDs;
	
	public void readOrdersDone(Map<String, String[]> params) {
		orderDoneIDs = params.keySet().stream().filter(key -> key.startsWith("id_"))
						.map(key -> params.get(key))
						.filter(pVal -> (pVal.length > 0) && (pVal[0] != null))
						.map(pVal -> pVal[0])
						.collect(Collectors.toList());
	}

	
	
	public List<String> getOrderDoneIDs() {
		return orderDoneIDs;
	}



	public String getNameRecip() {
		return nameRecip;
	}

	public void setNameRecip(String nameRecip) {
		this.nameRecip = nameRecip;
	}
		
}
