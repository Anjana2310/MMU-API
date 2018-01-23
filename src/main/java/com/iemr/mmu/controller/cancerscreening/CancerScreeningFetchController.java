package com.iemr.mmu.controller.cancerscreening;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.cancerScreening.CSServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 * @Objective Updating Cancer screening data for Nurse.
 * @Date 18-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping({ "/CS-cancerScreening" })
public class CancerScreeningFetchController {

	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(CancerScreeningFetchController.class);

	private CSServiceImpl cSServiceImpl;

	@Autowired
	public void setCancerScreeningServiceImpl(CSServiceImpl cSServiceImpl) {
		this.cSServiceImpl = cSServiceImpl;
	}

	/**
	 * Fething beneficiary data filled by Nurse for Doctor screen...
	 */

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Visit details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVisitDetailsScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnVisitDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = cSServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnVisitDetails:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer History details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocHistoryScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseScrnToDocScrnHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = cSServiceImpl.getBenDataFrmNurseToDocHistoryScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseScrnToDocScrnHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnHistory:" + e);
		}
		// System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Vital details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVitalScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnVital(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseToDocVitalScreen request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = cSServiceImpl.getBenDataFrmNurseToDocVitalScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseToDocVitalScreen response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseToDocVitalScreen:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary data for case sheet", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBeneficiaryDataEnteredByNurseAndDoctor" }, method = { RequestMethod.POST })
	public String getBenDataForCaseSheet(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\", \"visitDateTime\":\"Date\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataForCaseSheet request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			String caseSheetData = cSServiceImpl.getCancerCasesheetData(obj);
			if (caseSheetData != null) {
				response.setResponse(caseSheetData);
			} else {
				response.setError(5000, "Data not found !!!");
			}

			logger.info("getBenDataForCaseSheet response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataForCaseSheet:" + e);
		}
		return response.toString();
	}

}
