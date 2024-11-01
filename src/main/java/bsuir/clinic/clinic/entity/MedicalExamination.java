package bsuir.clinic.clinic.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_examinations")
public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean isPlanned;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "treatment")
    private Treatment treatment;

    public MedicalExamination(Long id, boolean isPlanned, LocalDateTime dateTime, Doctor doctor, Patient patient, Treatment treatment) {
        this.id = id;
        this.isPlanned = isPlanned;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.treatment = treatment;
    }

    public MedicalExamination() {
    }

    public static MedicalExaminationBuilder builder() {
        return new MedicalExaminationBuilder();
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

    public Treatment getTreatment() {
        return this.treatment;
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

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MedicalExamination)) return false;
        final MedicalExamination other = (MedicalExamination) o;
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
        final Object this$treatment = this.getTreatment();
        final Object other$treatment = other.getTreatment();
        if (this$treatment == null ? other$treatment != null : !this$treatment.equals(other$treatment)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedicalExamination;
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
        final Object $treatment = this.getTreatment();
        result = result * PRIME + ($treatment == null ? 43 : $treatment.hashCode());
        return result;
    }

    public String toString() {
        return "MedicalExamination(id=" + this.getId() + ", isPlanned=" + this.isPlanned() + ", dateTime=" + this.getDateTime() + ", doctor=" + this.getDoctor() + ", patient=" + this.getPatient() + ", treatment=" + this.getTreatment() + ")";
    }

    public static class MedicalExaminationBuilder {
        private Long id;
        private boolean isPlanned;
        private LocalDateTime dateTime;
        private Doctor doctor;
        private Patient patient;
        private Treatment treatment;

        MedicalExaminationBuilder() {
        }

        public MedicalExaminationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MedicalExaminationBuilder isPlanned(boolean isPlanned) {
            this.isPlanned = isPlanned;
            return this;
        }

        public MedicalExaminationBuilder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public MedicalExaminationBuilder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public MedicalExaminationBuilder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public MedicalExaminationBuilder treatment(Treatment treatment) {
            this.treatment = treatment;
            return this;
        }

        public MedicalExamination build() {
            return new MedicalExamination(this.id, this.isPlanned, this.dateTime, this.doctor, this.patient, this.treatment);
        }

        public String toString() {
            return "MedicalExamination.MedicalExaminationBuilder(id=" + this.id + ", isPlanned=" + this.isPlanned + ", dateTime=" + this.dateTime + ", doctor=" + this.doctor + ", patient=" + this.patient + ", treatment=" + this.treatment + ")";
        }
    }
}
