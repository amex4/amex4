package com.accessControlService.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Entry {
	
	@Id
	private int entryId;
	private String name;
	private String purpose;
	private long phoneNumber;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String entryTime;
	private String exitTime;
	private List<String> houseNumbers;
	private boolean accessAllowed;
	

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public List<String> getHouseNumbers() {
		return houseNumbers;
	}

	public void setHouseNumbers(List<String> houseNumbers) {
		this.houseNumbers = houseNumbers;
	}

	public boolean isAccessAllowed() {
		return accessAllowed;
	}

	public void setAccessAllowed(boolean accessAllowed) {
		this.accessAllowed = accessAllowed;
	}
}
