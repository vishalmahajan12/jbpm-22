package com.cis.drool_rest.models;

public class Payload {

	private long rimNumber;
	private String entitlementUuid;
	private long transactionAmount;
	
	public Payload() {
		// TODO Auto-generated constructor stub
	}

	public Payload(long rimNumber, String entitlementUuid, int transactionAmount) {
		super();
		this.rimNumber = rimNumber;
		this.entitlementUuid = entitlementUuid;
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Payload [rimNumber=" + rimNumber + ", entitlementUuid=" + entitlementUuid + ", transactionAmount="
				+ transactionAmount + "]";
	}

	public long getRimNumber() {
		return rimNumber;
	}

	public void setRimNumber(long rimNumber) {
		this.rimNumber = rimNumber;
	}

	public String getEntitlementUuid() {
		return entitlementUuid;
	}

	public void setEntitlementUuid(String entitlementUuid) {
		this.entitlementUuid = entitlementUuid;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	

}
