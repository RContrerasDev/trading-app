package com.roboto.response;

public class Currency {
	

	private Rates rates;
    private String base;
    private String date;
    private Boolean success;
    private Integer timestamp;
    

    public void setRates(Rates rates){
        this.rates = rates;
    }
    public Rates getRates(){
        return this.rates;
    }
    public void setBase(String base){
        this.base = base;
    }
    public String getBase(){
        return this.base;
    }
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	
    
    

}
