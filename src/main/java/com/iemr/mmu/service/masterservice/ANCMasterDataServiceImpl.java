package com.iemr.mmu.service.masterservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.ChiefComplaintMaster;
import com.iemr.mmu.data.masterdata.anc.AllergicReactionTypes;
import com.iemr.mmu.data.masterdata.anc.BirthComplication;
import com.iemr.mmu.data.masterdata.anc.BloodGroups;
import com.iemr.mmu.data.masterdata.anc.ChildVaccinations;
import com.iemr.mmu.data.masterdata.anc.DeliveryComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.DeliveryPlace;
import com.iemr.mmu.data.masterdata.anc.DeliveryType;
import com.iemr.mmu.data.masterdata.anc.DevelopmentProblems;
import com.iemr.mmu.data.masterdata.anc.Gestation;
import com.iemr.mmu.data.masterdata.anc.IllnessTypes;
import com.iemr.mmu.data.masterdata.anc.JointTypes;
import com.iemr.mmu.data.masterdata.anc.MenstrualCycleRange;
import com.iemr.mmu.data.masterdata.anc.MenstrualCycleStatus;
import com.iemr.mmu.data.masterdata.anc.MenstrualProblem;
import com.iemr.mmu.data.masterdata.anc.Musculoskeletal;
import com.iemr.mmu.data.masterdata.anc.PostpartumComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.PregComplicationTypes;
import com.iemr.mmu.data.masterdata.anc.PregDuration;
import com.iemr.mmu.data.masterdata.anc.SurgeryTypes;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;
import com.iemr.mmu.data.masterdata.nurse.CancerPersonalHabitType;
import com.iemr.mmu.data.masterdata.nurse.FamilyMemberType;
import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.masterrepo.anc.AllergicReactionTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.BirthComplicationRepo;
import com.iemr.mmu.repo.masterrepo.anc.BloodGroupsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ChildVaccinationsRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryPlaceRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.DevelopmentProblemsRepo;
import com.iemr.mmu.repo.masterrepo.anc.GestationRepo;
import com.iemr.mmu.repo.masterrepo.anc.IllnessTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.JointTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleRangeRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleStatusRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualProblemRepo;
import com.iemr.mmu.repo.masterrepo.anc.MusculoskeletalRepo;
import com.iemr.mmu.repo.masterrepo.anc.PostpartumComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregDurationRepo;
import com.iemr.mmu.repo.masterrepo.anc.SurgeryTypesRepo;
import com.iemr.mmu.repo.masterrepo.doctor.PreMalignantLesionMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.CancerDiseaseMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.CancerPersonalHabitMasterRepo;
import com.iemr.mmu.repo.masterrepo.nurse.FamilyMemberMasterRepo;

@Service
public class ANCMasterDataServiceImpl {
	
	private AllergicReactionTypesRepo allergicReactionTypesRepo;
	private BirthComplicationRepo birthComplicationRepo;
	private BloodGroupsRepo bloodGroupsRepo;
	private ChildVaccinationsRepo childVaccinationsRepo;
	private DeliveryComplicationTypesRepo deliveryComplicationTypesRepo;
	private DeliveryPlaceRepo deliveryPlaceRepo;
	private DeliveryTypeRepo deliveryTypeRepo;
	private DevelopmentProblemsRepo developmentProblemsRepo;
	private GestationRepo gestationRepo;
	private IllnessTypesRepo illnessTypesRepo;
	private JointTypesRepo jointTypesRepo;
	private MenstrualCycleRangeRepo menstrualCycleRangeRepo;
	private MenstrualCycleStatusRepo menstrualCycleStatusRepo;
	private MenstrualProblemRepo menstrualProblemRepo;
	private MusculoskeletalRepo musculoskeletalRepo;
	private PostpartumComplicationTypesRepo postpartumComplicationTypesRepo;
	private PregComplicationTypesRepo pregComplicationTypesRepo;
	private PregDurationRepo pregDurationRepo;
	private SurgeryTypesRepo surgeryTypesRepo;

	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;
	private CancerDiseaseMasterRepo cancerDiseaseMasterRepo;
	private CancerPersonalHabitMasterRepo cancerPersonalHabitMasterRepo;
	private FamilyMemberMasterRepo familyMemberMasterRepo;
	
	@Autowired
	public void setAllergicReactionTypesRepo(AllergicReactionTypesRepo allergicReactionTypesRepo) {
		this.allergicReactionTypesRepo = allergicReactionTypesRepo;
	}
	
	@Autowired
	public void setBirthComplicationRepo(BirthComplicationRepo birthComplicationRepo) {
		this.birthComplicationRepo = birthComplicationRepo;
	}
	
	@Autowired
	public void setBloodGroupsRepo(BloodGroupsRepo bloodGroupsRepo) {
		this.bloodGroupsRepo = bloodGroupsRepo;
	}
	
	@Autowired
	public void setChildVaccinationsRepo(ChildVaccinationsRepo childVaccinationsRepo) {
		this.childVaccinationsRepo = childVaccinationsRepo;
	}
	
	@Autowired
	public void setDeliveryComplicationTypesRepo(DeliveryComplicationTypesRepo deliveryComplicationTypesRepo) {
		this.deliveryComplicationTypesRepo = deliveryComplicationTypesRepo;
	}
	
	@Autowired
	public void setDeliveryPlaceRepo(DeliveryPlaceRepo deliveryPlaceRepo) {
		this.deliveryPlaceRepo = deliveryPlaceRepo;
	}
	
	@Autowired
	public void setDeliveryTypeRepo(DeliveryTypeRepo deliveryTypeRepo) {
		this.deliveryTypeRepo = deliveryTypeRepo;
	}
	
	@Autowired
	public void setDevelopmentProblemsRepo(DevelopmentProblemsRepo developmentProblemsRepo) {
		this.developmentProblemsRepo = developmentProblemsRepo;
	}
	
	@Autowired
	public void setGestationRepo(GestationRepo gestationRepo) {
		this.gestationRepo = gestationRepo;
	}
	
	@Autowired
	public void setIllnessTypesRepo(IllnessTypesRepo illnessTypesRepo) {
		this.illnessTypesRepo = illnessTypesRepo;
	}
	
	@Autowired
	public void setJointTypesRepo(JointTypesRepo jointTypesRepo) {
		this.jointTypesRepo = jointTypesRepo;
	}
	
	@Autowired
	public void setMenstrualCycleRangeRepo(MenstrualCycleRangeRepo menstrualCycleRangeRepo) {
		this.menstrualCycleRangeRepo = menstrualCycleRangeRepo;
	}
	
	@Autowired
	public void setMenstrualCycleStatusRepo(MenstrualCycleStatusRepo menstrualCycleStatusRepo) {
		this.menstrualCycleStatusRepo = menstrualCycleStatusRepo;
	}
	
	@Autowired
	public void setMenstrualProblemRepo(MenstrualProblemRepo menstrualProblemRepo) {
		this.menstrualProblemRepo = menstrualProblemRepo;
	}
	
	@Autowired
	public void setMusculoskeletalRepo(MusculoskeletalRepo musculoskeletalRepo) {
		this.musculoskeletalRepo = musculoskeletalRepo;
	}
	
	@Autowired
	public void setPostpartumComplicationTypesRepo(PostpartumComplicationTypesRepo postpartumComplicationTypesRepo) {
		this.postpartumComplicationTypesRepo = postpartumComplicationTypesRepo;
	}
	
	@Autowired
	public void setPregComplicationTypesRepo(PregComplicationTypesRepo pregComplicationTypesRepo) {
		this.pregComplicationTypesRepo = pregComplicationTypesRepo;
	}
	
	@Autowired
	public void setPregDurationRepo(PregDurationRepo pregDurationRepo) {
		this.pregDurationRepo = pregDurationRepo;
	}
	
	@Autowired
	public void setSurgeryTypesRepo(SurgeryTypesRepo surgeryTypesRepo) {
		this.surgeryTypesRepo = surgeryTypesRepo;
	}
	
	@Autowired
	public void setChiefComplaintMasterRepo(ChiefComplaintMasterRepo chiefComplaintMasterRepo) {
		this.chiefComplaintMasterRepo = chiefComplaintMasterRepo;
	}
	
	@Autowired
	public void setCancerDiseaseMasterRepo(CancerDiseaseMasterRepo cancerDiseaseMasterRepo) {
		this.cancerDiseaseMasterRepo = cancerDiseaseMasterRepo;
	}
	
	@Autowired
	public void setCancerPersonalHabitMasterRepo(CancerPersonalHabitMasterRepo cancerPersonalHabitMasterRepo) {
		this.cancerPersonalHabitMasterRepo = cancerPersonalHabitMasterRepo;
	}
	
	@Autowired
	public void setFamilyMemberMasterRepo(FamilyMemberMasterRepo familyMemberMasterRepo) {
		this.familyMemberMasterRepo = familyMemberMasterRepo;
	}
	
	public String getANCMasterData() {
		Map<String, Object> resMap = new HashMap<String, Object>();
			
		ArrayList<Object[]> allergicReactionTypes = allergicReactionTypesRepo.getAllergicReactionTypes();
		ArrayList<Object[]> birthComplications = birthComplicationRepo.getBirthComplicationTypes();
		ArrayList<Object[]> bloodGroups = bloodGroupsRepo.getBloodGroups();
		ArrayList<Object[]> childVaccinations = childVaccinationsRepo.getChildVaccinations();
		ArrayList<Object[]> deliveryComplicationTypes = deliveryComplicationTypesRepo.getDeliveryComplicationTypes();
		ArrayList<Object[]> deliveryPlace = deliveryPlaceRepo.getDeliveryPlaces();
		ArrayList<Object[]> deliveryType = deliveryTypeRepo.getDeliveryTypes();
		ArrayList<Object[]> developmentProblems = developmentProblemsRepo.getDevelopmentProblems();
		ArrayList<Object[]> gestation = gestationRepo.getGestationTypes();
		ArrayList<Object[]> illnessTypes = illnessTypesRepo.getIllnessTypes();
		ArrayList<Object[]> jointTypes = jointTypesRepo.getJointTypes();
		ArrayList<Object[]> menstrualCycleLengths = menstrualCycleRangeRepo.getMenstrualCycleRanges("Cycle Length");
		ArrayList<Object[]> menstrualCycleBloodFlowDuration = menstrualCycleRangeRepo.getMenstrualCycleRanges(" Blood Flow Duration");
		ArrayList<Object[]> menstrualCycleStatus = menstrualCycleStatusRepo.getMenstrualCycleStatuses();
		ArrayList<Object[]> menstrualProblem = menstrualProblemRepo.getMenstrualProblems();
		ArrayList<Object[]> musculoskeletalLateralityTypes = musculoskeletalRepo.getMusculoskeletalvalues("Laterality");
		ArrayList<Object[]> musculoskeletalAbnormalityTypes = musculoskeletalRepo.getMusculoskeletalvalues("Abnormality");
		ArrayList<Object[]> postpartumComplicationTypes = postpartumComplicationTypesRepo.getPostpartumComplicationTypes();
		ArrayList<Object[]> pregComplicationTypes = pregComplicationTypesRepo.getPregComplicationTypes();
		ArrayList<Object[]> pregDuration = pregDurationRepo.getPregDurationTypes();
		ArrayList<Object[]> surgeryTypes = surgeryTypesRepo.getSurgeryTypes();
		
		//existing
		ArrayList<ChiefComplaintMaster> ccList = chiefComplaintMasterRepo.getChiefComplaintMaster();
		ArrayList<Object[]> DiseaseTypes = cancerDiseaseMasterRepo.getCancerDiseaseMaster();
		ArrayList<Object[]> tobaccoUseStatus = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Tobacco Use Status");
		ArrayList<Object[]> typeOfTobaccoProducts = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Type of Tobacco Product");
		ArrayList<Object[]> alcoholUseStatus = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Alcohol Usage");
		ArrayList<Object[]> typeOfAlcoholProducts = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Type of Alcohol");
		
		ArrayList<Object[]> frequencyOfAlcoholIntake = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Frequency of Alcohol Intake");
		ArrayList<Object[]> quantityOfAlcoholIntake = cancerPersonalHabitMasterRepo
				.getCancerPersonalHabitTypeMaster("Average Quantity of Alcohol consumption");
		
		ArrayList<Object[]> familyMemberTypes = familyMemberMasterRepo.getFamilyMemberTypeMaster();
	
		
		resMap.put("AllergicReactionTypes", AllergicReactionTypes.getAllergicReactionTypes(allergicReactionTypes));
		resMap.put("birthComplications", BirthComplication.getBirthComplicationTypes(birthComplications));
		resMap.put("bloodGroups", BloodGroups.getBloodGroups(bloodGroups));
		resMap.put("childVaccinations", ChildVaccinations.getChildVaccinations(childVaccinations));
		resMap.put("deliveryComplicationTypes", DeliveryComplicationTypes.getDeliveryComplicationTypes(deliveryComplicationTypes));
		resMap.put("deliveryPlaces", DeliveryPlace.getDeliveryPlace(deliveryPlace));
		resMap.put("deliveryTypes", DeliveryType.getDeliveryType(deliveryType));
		resMap.put("developmentProblems", DevelopmentProblems.getDevelopmentProblems(developmentProblems));
		resMap.put("gestation", Gestation.getGestations(gestation));
		resMap.put("illnessTypes", IllnessTypes.getIllnessTypes(illnessTypes));
		resMap.put("jointTypes", JointTypes.getJointTypes(jointTypes));
		resMap.put("menstrualCycleLengths", MenstrualCycleRange.getMenstrualCycleRanges(menstrualCycleLengths));
		resMap.put("menstrualCycleBloodFlowDuration", MenstrualCycleRange.getMenstrualCycleRanges(menstrualCycleBloodFlowDuration));
		resMap.put("menstrualCycleStatus", MenstrualCycleStatus.getMenstrualCycleStatuses(menstrualCycleStatus));
		resMap.put("menstrualProblem", MenstrualProblem.getMenstrualProblems(menstrualProblem));
		resMap.put("musculoskeletalLateralityTypes", Musculoskeletal.getMusculoskeletals(musculoskeletalLateralityTypes));
		resMap.put("musculoskeletalAbnormalityTypes", Musculoskeletal.getMusculoskeletals(musculoskeletalAbnormalityTypes));
		resMap.put("postpartumComplicationTypes", PostpartumComplicationTypes.getPostpartumComplicationTypes(postpartumComplicationTypes));
		resMap.put("pregComplicationTypes", PregComplicationTypes.getPregComplicationTypes(pregComplicationTypes));
		resMap.put("pregDuration", PregDuration.getPregDurationValues(pregDuration));
		resMap.put("surgeryTypes", SurgeryTypes.getSurgeryTypes(surgeryTypes));
		
		//existing
		resMap.put("chiefComplaintMaster", ccList);
		resMap.put("CancerDiseaseType", CancerDiseaseType.getCancerDiseaseTypeMasterData(DiseaseTypes));
		resMap.put("tobaccoUseStatus",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(tobaccoUseStatus));
		resMap.put("typeOfTobaccoProducts",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(typeOfTobaccoProducts));
		resMap.put("alcoholUseStatus",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(alcoholUseStatus));
		resMap.put("typeOfAlcoholProducts",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(typeOfAlcoholProducts));
		resMap.put("frequencyOfAlcoholIntake",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(frequencyOfAlcoholIntake));
		resMap.put("quantityOfAlcoholIntake",
				CancerPersonalHabitType.getCancerPersonalHabitTypeMasterData(quantityOfAlcoholIntake));
		resMap.put("familyMemberTypes", FamilyMemberType.getFamilyMemberTypeMasterData(familyMemberTypes));
		
		return new Gson().toJson(resMap);
	}
}