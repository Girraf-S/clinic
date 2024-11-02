package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.*;
import bsuir.clinic.clinic.mapper.*;
import bsuir.clinic.clinic.repo.*;
import bsuir.clinic.clinic.repo.cache.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final DoctorRepo doctorRepo;
    private final DoctorCacheRepo doctorCacheRepo;
    private final DoctorMapper doctorMapper;

    private final CardRepo cardRepo;
    private final CardCacheRepo cardCacheRepo;
    private final CardMapper cardMapper;

    private final PatientRepo patientRepo;
    private final PatientCacheRepo patientCacheRepo;
    private final PatientMapper patientMapper;

    private final MedicalHistoryRepo medicalHistoryRepo;
    private final MedicalHistoryCacheRepo medicalHistoryCacheRepo;
    private final MedicalHistoryMapper medicalHistoryMapper;

    private final MedicalExaminationRepo medicalExaminationRepo;
    private final MedicalExaminationCacheRepo medicalExaminationCacheRepo;
    private final MedicalExaminationMapper medicalExaminationMapper;

    private final TreatmentRepo treatmentRepo;
    private final TreatmentCacheRepo treatmentCacheRepo;
    private final TreatmentMapper treatmentMapper;


    public void init() {

        initDoctors();
        initCards();
        initPatients();
        initTreatments();
        initMedicalExaminations();
        initMedicalHistories();

    }


    private List<Treatment> initTreatments(){
        List<Treatment> objects = treatmentRepo.findAll();

        for(Treatment object: objects)
            treatmentCacheRepo.save(treatmentMapper.toCache(object));
        return objects;
    }

    private List<Doctor> initDoctors(){
        List<Doctor> doctors = doctorRepo.findAll();

        for(Doctor doctor: doctors)
            doctorCacheRepo.save(doctorMapper.toCache(doctor));
        return doctors;
    }

    private List<Patient> initPatients(){
        List<Patient> patients = patientRepo.findAll();

        for(Patient patient: patients)
            patientCacheRepo.save(patientMapper.toCache(patient));
        return patients;
    }

    private List<MedicalHistory> initMedicalHistories(){
        List<MedicalHistory> objects = medicalHistoryRepo.findAll();

        for(MedicalHistory object: objects)
            medicalHistoryCacheRepo.save(medicalHistoryMapper.toCache(object));
        return objects;
    }

    private List<MedicalExamination> initMedicalExaminations(){
        List<MedicalExamination> objects = medicalExaminationRepo.findAll();

        for(MedicalExamination object: objects)
            medicalExaminationCacheRepo.save(medicalExaminationMapper.toCache(object));
        return objects;
    }

    private List<Card> initCards(){
        List<Card> objects = cardRepo.findAll();

        for(Card object: objects)
            cardCacheRepo.save(cardMapper.toCache(object));
        return objects;
    }

}
