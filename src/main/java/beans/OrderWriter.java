package beans;

import form.request.CalculateForm;
import form.response.CalculateReq;

public class OrderWriter {
	private Long recipientId;
	private CalculateForm form;
	private CalculateReq calculateReq;
	
	
	
	public Long getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}
	public CalculateForm getForm() {
		return form;
	}
	public void setForm(CalculateForm form) {
		this.form = form;
	}
	public CalculateReq getCalculateReq() {
		return calculateReq;
	}
	public void setCalculateReq(CalculateReq calculateReq) {
		this.calculateReq = calculateReq;
	}
	
	
	
}
