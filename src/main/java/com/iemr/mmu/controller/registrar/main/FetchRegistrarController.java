package com.iemr.mmu.controller.registrar.main;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.controller.registrar.master.RegistrarController;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperBeneficiaryRegistration;
import com.iemr.mmu.service.masterservice.RegistrarServiceMasterDataImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/registrar" })
/** Objective: Performs QuickSearch, AdvancedSearch and fetching Beneficiary Details*/
public class FetchRegistrarController {
	private Logger logger = LoggerFactory.getLogger(FetchRegistrarController.class);
	private InputMapper inputMapper = new InputMapper();
	private RegistrarServiceImpl registrarServiceImpl;
	private RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl;
	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setRegistrarServiceImpl(RegistrarServiceImpl registrarServiceImpl) {
		this.registrarServiceImpl = registrarServiceImpl;
	}

	@Autowired
	public void setRegistrarServiceMasterDataImpl(RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl) {
		this.registrarServiceMasterDataImpl = registrarServiceMasterDataImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	// Registrar Work List API .....
	@CrossOrigin()
	@ApiOperation(value = "Get Registrar workList Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/registrarWorkListData" }, method = { RequestMethod.POST })
	public String getRegistrarWorkList(@ApiParam(value = "{\"spID\": \"Integer\"}") @RequestBody String comingRequest)
			throws JSONException {
		OutputResponse response = new OutputResponse();
		logger.info("getRegistrarWorkList request:" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);

			// wrapperRegWorklistArray =
			// this.registrarServiceImpl.getRegWorkList(obj.getInt("spID"));
			response.setResponse(this.registrarServiceImpl.getRegWorkList(obj.getInt("spID")));
			logger.info("getRegistrarWorkList response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getRegistrarWorkList:" + e);
		}
		return response.toString();
	}

	// Registrar Quick search .....
	@CrossOrigin()
	@ApiOperation(value = "Search for the Beneficiary by BeneficiaryID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/quickSearch" }, method = { RequestMethod.POST })
	public String quickSearchBeneficiary(
			@ApiParam(value = "{\"benID\": \"String\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("quickSearchBeneficiary request:" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);

			// wrapperRegWorklistArray =
			// registrarServiceImpl.getQuickSearchBenData(obj.getString("benID"));
			response.setResponse(registrarServiceImpl.getQuickSearchBenData(obj.getString("benID")));
			logger.info("quickSearchBeneficiary response:" + response);
		} catch (Exception e) {
			logger.error("Error in quickSearchBeneficiary :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	// Registrar Advance search .....
	@CrossOrigin()
	@ApiOperation(value = "Search for the Beneficiary based on provided data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/advanceSearch" }, method = { RequestMethod.POST })
	public String advanceSearch(
			@ApiParam(value = "{\"firstName\": \"String\", \"lastName\": \"String\", \"phoneNo\": \"String\","
					+ "\"beneficiaryID\": \"String\", \"stateID\": \"Integer\", \"districtID\": \"Integer\", \"aadharNo\": \"String\"},"
					+ " \"govtIdentityNo\": \"String\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("advanceSearch request :" + comingRequest);
		try {
			// JSONObject obj = new JSONObject(comingRequest);
			V_BenAdvanceSearch v_BenAdvanceSearch = inputMapper.gson().fromJson(comingRequest,
					V_BenAdvanceSearch.class);
			response.setResponse(registrarServiceImpl.getAdvanceSearchBenData(v_BenAdvanceSearch));
			logger.info("advanceSearch response:" + response);
		} catch (Exception e) {
			logger.error("Error in advanceSearch :" + e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Details of given beneficiaryRegID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/benDetailsByRegID" }, method = { RequestMethod.POST })
	public String getBenDetailsByRegID(
			@ApiParam(value = "{\"beneficiaryRegID\": \"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDetailsByRegID request :" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {

					String beneficiaryData = registrarServiceMasterDataImpl
							.getBenDetailsByRegID(obj.getLong("beneficiaryRegID"));

					response.setResponse(beneficiaryData);
				} else {
					response.setError(500, "Please pass beneficiaryRegID");
				}
			} else {
				response.setError(500, "Bad Request... beneficiaryRegID is not there in request");
			}
			logger.info("getBenDetailsByRegID response :" + response);
		} catch (Exception e) {
			logger.error("Error in getBenDetailsByRegID :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/beneficiaryDetails" }, method = { RequestMethod.POST })
	public String getBeneficiaryDetails(
			@ApiParam(value = "{\"beneficiaryRegID\": \"Long\"}") @RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("getBeneficiaryDetails request :" + requestObj);
		try {

			JSONObject obj = new JSONObject(requestObj);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {

					String beneficiaryData = registrarServiceImpl
							.getBeneficiaryDetails(obj.getLong("beneficiaryRegID"));
					if (beneficiaryData != null) {
						response.setResponse(beneficiaryData);
					} else {
						Map<String, String> noDataMap = new HashMap<>();
						response.setResponse(new Gson().toJson(noDataMap));
					}

				} else {
					response.setError(500, "Please pass beneficiaryRegID");
				}
			} else {
				response.setError(500, "Bad Request... beneficiaryRegID is not there in request");
			}
			logger.info("getBeneficiaryDetails response :" + response);
		} catch (Exception e) {
			logger.error("Error in getBeneficiaryDetails :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Image", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/beneficiaryImage" }, method = { RequestMethod.POST })
	public String getBeneficiaryImage(
			@ApiParam(value = "{\"beneficiaryRegID\": \"Long\"}") @RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("getBeneficiaryImage request :" + requestObj);
		try {
			JSONObject obj = new JSONObject(requestObj);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {
					String beneficiaryData = registrarServiceImpl.getBenImage(obj.getLong("beneficiaryRegID"));

					response.setResponse(beneficiaryData);
				} else {
					response.setError(500, "Please pass beneficiaryRegID");
				}
			} else {
				response.setError(500, "Bad Request... beneficiaryRegID is not there in request");
			}
			logger.info("getBeneficiaryDetails response :" + response);
		} catch (Exception e) {

		}
		return response.toString();
	}
}