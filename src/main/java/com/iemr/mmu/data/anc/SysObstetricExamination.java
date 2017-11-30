package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Obstetric")
public class SysObstetricExamination {

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
	@Column(name = "FundalHeight")
	private String fundalHeight;

	@Expose
	@Column(name = "FHAndPOA_Status")
	private String fHAndPOA_Status;

	@Expose
	@Column(name = "FHAndPOA_Interpretation")
	private String fHAndPOA_Interpretation;

	@Expose
	@Column(name = "FetalMovements")
	private String fetalMovements;

	@Expose
	@Column(name = "FetalHeartSounds")
	private String fetalHeartSounds;

	@Expose
	@Column(name = "FetalHeartRate_BeatsPerMinute")
	private String fetalHeartRate_BeatsPerMinute;

	@Expose
	@Column(name = "FetalPositionOrLie")
	private String fetalPositionOrLie;

	@Expose
	@Column(name = "FetalPresentation")
	private String fetalPresentation;

	@Expose
	@Column(name = "AbdominalScars")
	private String abdominalScars;
	
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

	public String getFundalHeight() {
		return fundalHeight;
	}

	public void setFundalHeight(String fundalHeight) {
		this.fundalHeight = fundalHeight;
	}

	public String getfHAndPOA_Status() {
		return fHAndPOA_Status;
	}

	public void setfHAndPOA_Status(String fHAndPOA_Status) {
		this.fHAndPOA_Status = fHAndPOA_Status;
	}

	public String getfHAndPOA_Interpretation() {
		return fHAndPOA_Interpretation;
	}

	public void setfHAndPOA_Interpretation(String fHAndPOA_Interpretation) {
		this.fHAndPOA_Interpretation = fHAndPOA_Interpretation;
	}

	public String getFetalMovements() {
		return fetalMovements;
	}

	public void setFetalMovements(String fetalMovements) {
		this.fetalMovements = fetalMovements;
	}

	public String getFetalHeartSounds() {
		return fetalHeartSounds;
	}

	public void setFetalHeartSounds(String fetalHeartSounds) {
		this.fetalHeartSounds = fetalHeartSounds;
	}

	public String getFetalHeartRate_BeatsPerMinute() {
		return fetalHeartRate_BeatsPerMinute;
	}

	public void setFetalHeartRate_BeatsPerMinute(String fetalHeartRate_BeatsPerMinute) {
		this.fetalHeartRate_BeatsPerMinute = fetalHeartRate_BeatsPerMinute;
	}

	public String getFetalPositionOrLie() {
		return fetalPositionOrLie;
	}

	public void setFetalPositionOrLie(String fetalPositionOrLie) {
		this.fetalPositionOrLie = fetalPositionOrLie;
	}

	public String getFetalPresentation() {
		return fetalPresentation;
	}

	public void setFetalPresentation(String fetalPresentation) {
		this.fetalPresentation = fetalPresentation;
	}

	public String getAbdominalScars() {
		return abdominalScars;
	}

	public void setAbdominalScars(String abdominalScars) {
		this.abdominalScars = abdominalScars;
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
	
}