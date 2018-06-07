package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_bencomorbiditycondition")
public class BencomrbidityCondDetails {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;
	
	@Expose
	@Column(name = "ComorbidConditionID")
	private Short comorbidConditionID;
	
	@Expose
	@Column(name = "ComorbidCondition")
	private String comorbidCondition;
	
	@Expose
	@Column(name = "Year")
	private Timestamp year;
	
	@Expose
	@Column(name = "OtherComorbidCondition")
	private String otherComorbidCondition;
	
	@Expose
	@Column(name = "IsForHistory")
	private Boolean isForHistory;
	
	@Transient
	@Expose 
	private Integer timePeriodAgo;
	
	@Transient
	@Expose
	private String timePeriodUnit;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;
	
	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	
	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;
	
	@Transient
	private Date captureDate;
	
	@Transient
	private Date date;
	
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}


	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}


	public Long getBenVisitID() {
		return benVisitID;
	}


	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}


	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}


	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}


	public Short getComorbidConditionID() {
		return comorbidConditionID;
	}


	public void setComorbidConditionID(Short comorbidConditionID) {
		this.comorbidConditionID = comorbidConditionID;
	}


	public String getComorbidCondition() {
		return comorbidCondition;
	}


	public void setComorbidCondition(String comorbidCondition) {
		this.comorbidCondition = comorbidCondition;
	}


	public Timestamp getYear() {
		return year;
	}


	public void setYear(Timestamp year) {
		this.year = year;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public String getProcessed() {
		return processed;
	}


	public void setProcessed(String processed) {
		this.processed = processed;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Timestamp getLastModDate() {
		return lastModDate;
	}


	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getID() {
		return ID;
	}
	
	public Integer getTimePeriodAgo() {
		return timePeriodAgo;
	}


	public void setTimePeriodAgo(Integer timePeriodAgo) {
		this.timePeriodAgo = timePeriodAgo;
	}


	public String getTimePeriodUnit() {
		return timePeriodUnit;
	}


	public void setTimePeriodUnit(String timePeriodUnit) {
		this.timePeriodUnit = timePeriodUnit;
	}


	public String getOtherComorbidCondition() {
		return otherComorbidCondition;
	}


	public void setOtherComorbidCondition(String otherComorbidCondition) {
		this.otherComorbidCondition = otherComorbidCondition;
	}

	public Boolean getIsForHistory() {
		return isForHistory;
	}

	public void setIsForHistory(Boolean isForHistory) {
		this.isForHistory = isForHistory;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}


	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}


	public String getVehicalNo() {
		return vehicalNo;
	}


	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}


	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}


	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}


	public String getSyncedBy() {
		return syncedBy;
	}


	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}


	public Timestamp getSyncedDate() {
		return syncedDate;
	}


	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}


	public String getReservedForChange() {
		return reservedForChange;
	}


	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
	}


	public BencomrbidityCondDetails(Date createdDate, String comorbidCondition,String otherComorbidCondition, Date year) {
		super();
		this.captureDate = createdDate;
		this.comorbidCondition = comorbidCondition;
		this.otherComorbidCondition = otherComorbidCondition;
		this.date = year;
		
	}
	
	public BencomrbidityCondDetails(Short comorbidConditionID, String comorbidCondition, Timestamp year,
			String otherComorbidCondition) {
		super();
		this.comorbidConditionID = comorbidConditionID;
		this.comorbidCondition = comorbidCondition;
		this.year = year;
		this.otherComorbidCondition = otherComorbidCondition;
	}
	
	public BencomrbidityCondDetails(Short comorbidConditionID, String comorbidCondition, String otherComorbidCondition,
			Boolean isForHistory, Integer timePeriodAgo, String timePeriodUnit) {
		super();
		this.comorbidConditionID = comorbidConditionID;
		this.comorbidCondition = comorbidCondition;
		this.otherComorbidCondition = otherComorbidCondition;
		this.isForHistory = isForHistory;
		this.timePeriodAgo = timePeriodAgo;
		this.timePeriodUnit = timePeriodUnit;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public BencomrbidityCondDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getVisitCode() {
		return visitCode;
	}


	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}
	
}
