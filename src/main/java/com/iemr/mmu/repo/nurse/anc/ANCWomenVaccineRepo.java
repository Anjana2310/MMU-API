package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;

@Repository
public interface ANCWomenVaccineRepo extends CrudRepository<ANCWomenVaccineDetail, Long>{
	
	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, vaccineName, status, receivedDate, receivedFacilityName "
			+ "from ANCWomenVaccineDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getANCWomenVaccineDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query(" SELECT vaccineName, processed from ANCWomenVaccineDetail where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID AND vaccineName=:vaccineName")
	public ArrayList<Object[]> getBenANCWomenVaccineStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update ANCWomenVaccineDetail set status=:status, receivedDate=:receivedDate, receivedFacilityName=:receivedFacilityName, "
			+ "modifiedBy=:modifiedBy, processed=:processed "
			+ "where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID AND vaccineName=:vaccineName")
	public int updateANCImmunizationDetails(@Param("status") String status,
			@Param("receivedDate") Date receivedDate,
			@Param("receivedFacilityName") String receivedFacilityName,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID,
			@Param("vaccineName") String vaccineName);
	
}
