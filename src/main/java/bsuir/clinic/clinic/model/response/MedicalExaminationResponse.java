package bsuir.clinic.clinic.model.response;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.entity.Patient;

import java.time.LocalDateTime;

public class MedicalExaminationResponse {
    private Long id;
    private boolean isPlanned;
    private LocalDateTime dateTime;
    private Doctor doctor;
    private Patient patient;

    public MedicalExaminationResponse(Long id, boolean isPlanned, LocalDateTime dateTime, Doctor doctor, Patient patient) {
        this.id = id;
        this.isPlanned = isPlanned;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    public MedicalExaminationResponse() {
    }

    public static MedicalExaminationResponseBuilder builder() {
        return new MedicalExaminationResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public boolean isPlanned() {
        return this.isPlanned;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlanned(boolean isPlanned) {
        this.isPlanned = isPlanned;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MedicalExaminationResponse)) return false;
        final MedicalExaminationResponse other = (MedicalExaminationResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        if (this.isPlanned() != other.isPlanned()) return false;
        final Object this$dateTime = this.getDateTime();
        final Object other$dateTime = other.getDateTime();
        if (this$dateTime == null ? other$dateTime != null : !this$dateTime.equals(other$dateTime)) return false;
        final Object this$doctor = this.getDoctor();
        final Object other$doctor = other.getDoctor();
        if (this$doctor == null ? other$doctor != null : !this$doctor.equals(other$doctor)) return false;
        final Object this$patient = this.getPatient();
        final Object other$patient = other.getPatient();
        if (this$patient == null ? other$patient != null : !this$patient.equals(other$patient)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedicalExaminationResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        result = result * PRIME + (this.isPlanned() ? 79 : 97);
        final Object $dateTime = this.getDateTime();
        result = result * PRIME + ($dateTime == null ? 43 : $dateTime.hashCode());
        final Object $doctor = this.getDoctor();
        result = result * PRIME + ($doctor == null ? 43 : $doctor.hashCode());
        final Object $patient = this.getPatient();
        result = result * PRIME + ($patient == null ? 43 : $patient.hashCode());
        return result;
    }

    public String toString() {
        return "MedicalExaminationResponse(id=" + this.getId() + ", isPlanned=" + this.isPlanned() + ", dateTime=" + this.getDateTime() + ", doctor=" + this.getDoctor() + ", patient=" + this.getPatient() + ")";
    }

    public static class MedicalExaminationResponseBuilder {
        private Long id;
        private boolean isPlanned;
        private LocalDateTime dateTime;
        private Doctor doctor;
        private Patient patient;

        MedicalExaminationResponseBuilder() {
        }

        public MedicalExaminationResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MedicalExaminationResponseBuilder isPlanned(boolean isPlanned) {
            this.isPlanned = isPlanned;
            return this;
        }

        public MedicalExaminationResponseBuilder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public MedicalExaminationResponseBuilder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public MedicalExaminationResponseBuilder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public MedicalExaminationResponse build() {
            return new MedicalExaminationResponse(this.id, this.isPlanned, this.dateTime, this.doctor, this.patient);
        }

        public String toString() {
            return "MedicalExaminationResponse.MedicalExaminationResponseBuilder(id=" + this.id + ", isPlanned=" + this.isPlanned + ", dateTime=" + this.dateTime + ", doctor=" + this.doctor + ", patient=" + this.patient + ")";
        }
    }
}
