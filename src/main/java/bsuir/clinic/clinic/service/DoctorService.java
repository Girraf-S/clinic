package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.DoctorMapper;
import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import bsuir.clinic.clinic.repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final DoctorMapper doctorMapper;

    public Page<DoctorResponse> getAll(Pageable pageable) {
        return doctorRepo.findAll(pageable).map(doctorMapper::toResponse);
    }

    public DoctorResponse getById(Long id) {
        return doctorMapper.toResponse(doctorRepo.findById(id)
                .orElseThrow(() -> new AppException(
                                "No such doctor with id = " + id,
                                HttpStatus.BAD_REQUEST
                        )
                )
        );
    }

    public void create(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toDoctor(doctorRequest);
        System.out.println(doctorRequest);
        System.out.println(doctorRequest);
        System.out.println(doctor);
        System.out.println(doctor);
        doctorRepo.save(doctor);
    }

    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }
}
