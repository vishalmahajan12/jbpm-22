package com.cis.drool_rest.models;

public class QIBGroupInfo {
	private long groupId;
	private String name;
	private long rimNumber;
	private boolean verifierGroup;
	private boolean isActive;
	private String entitlementUuid;
	private int affrimationCount;
	private int sequence;
	private long minLimit;
	private long maxLimit;

	public QIBGroupInfo(long groupId, String name, long rimNumber, boolean verifierGroup, boolean isActive,
			String entitlementUuid, int affrimationCount, int sequence, long minLimit, long maxLimit) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.rimNumber = rimNumber;
		this.verifierGroup = verifierGroup;
		this.isActive = isActive;
		this.entitlementUuid = entitlementUuid;
		this.affrimationCount = affrimationCount;
		this.sequence = sequence;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
	}

	@Override
	public String toString() {
		return "QIBGroupInfo [groupId=" + groupId + ", name=" + name + ", rimNumber=" + rimNumber + ", verifierGroup="
				+ verifierGroup + ", isActive=" + isActive + ", entitlementUuid=" + entitlementUuid
				+ ", affrimationCount=" + affrimationCount + ", sequence=" + sequence + ", minLimit=" + minLimit
				+ ", maxLimit=" + maxLimit + "]";
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRimNumber() {
		return rimNumber;
	}

	public void setRimNumber(long rimNumber) {
		this.rimNumber = rimNumber;
	}

	public boolean isVerifierGroup() {
		return verifierGroup;
	}

	public void setVerifierGroup(boolean verifierGroup) {
		this.verifierGroup = verifierGroup;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEntitlementUuid() {
		return entitlementUuid;
	}

	public void setEntitlementUuid(String entitlementUuid) {
		this.entitlementUuid = entitlementUuid;
	}

	public int getAffrimationCount() {
		return affrimationCount;
	}

	public void setAffrimationCount(int affrimationCount) {
		this.affrimationCount = affrimationCount;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public long getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(long minLimit) {
		this.minLimit = minLimit;
	}

	public long getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(long maxLimit) {
		this.maxLimit = maxLimit;
	}
	
	

}
