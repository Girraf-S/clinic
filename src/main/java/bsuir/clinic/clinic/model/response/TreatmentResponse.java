package bsuir.clinic.clinic.model.response;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.entity.MedicalHistory;

public class TreatmentResponse {
    private Long id;
    private String medications;
    private String exercise;
    private MedicalExamination medicalExamination;
    private MedicalHistory medicalHistory;
    private Doctor doctor;

    public TreatmentResponse(Long id, String medications, String exercise, MedicalExamination medicalExamination, MedicalHistory medicalHistory, Doctor doctor) {
        this.id = id;
        this.medications = medications;
        this.exercise = exercise;
        this.medicalExamination = medicalExamination;
        this.medicalHistory = medicalHistory;
        this.doctor = doctor;
    }

    public TreatmentResponse() {
    }

    public static TreatmentResponseBuilder builder() {
        return new TreatmentResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getMedications() {
        return this.medications;
    }

    public String getExercise() {
        return this.exercise;
    }

    public MedicalExamination getMedicalExamination() {
        return this.medicalExamination;
    }

    public MedicalHistory getMedicalHistory() {
        return this.medicalHistory;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExamination = medicalExamination;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TreatmentResponse)) return false;
        final TreatmentResponse other = (TreatmentResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$medications = this.getMedications();
        final Object other$medications = other.getMedications();
        if (this$medications == null ? other$medications != null : !this$medications.equals(other$medications))
            return false;
        final Object this$exercise = this.getExercise();
        final Object other$exercise = other.getExercise();
        if (this$exercise == null ? other$exercise != null : !this$exercise.equals(other$exercise)) return false;
        final Object this$medicalExamination = this.getMedicalExamination();
        final Object other$medicalExamination = other.getMedicalExamination();
        if (this$medicalExamination == null ? other$medicalExamination != null : !this$medicalExamination.equals(other$medicalExamination))
            return false;
        final Object this$medicalHistory = this.getMedicalHistory();
        final Object other$medicalHistory = other.getMedicalHistory();
        if (this$medicalHistory == null ? other$medicalHistory != null : !this$medicalHistory.equals(other$medicalHistory))
            return false;
        final Object this$doctor = this.getDoctor();
        final Object other$doctor = other.getDoctor();
        if (this$doctor == null ? other$doctor != null : !this$doctor.equals(other$doctor)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TreatmentResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $medications = this.getMedications();
        result = result * PRIME + ($medications == null ? 43 : $medications.hashCode());
        final Object $exercise = this.getExercise();
        result = result * PRIME + ($exercise == null ? 43 : $exercise.hashCode());
        final Object $medicalExamination = this.getMedicalExamination();
        result = result * PRIME + ($medicalExamination == null ? 43 : $medicalExamination.hashCode());
        final Object $medicalHistory = this.getMedicalHistory();
        result = result * PRIME + ($medicalHistory == null ? 43 : $medicalHistory.hashCode());
        final Object $doctor = this.getDoctor();
        result = result * PRIME + ($doctor == null ? 43 : $doctor.hashCode());
        return result;
    }

    public String toString() {
        return "TreatmentResponse(id=" + this.getId() + ", medications=" + this.getMedications() + ", exercise=" + this.getExercise() + ", medicalExamination=" + this.getMedicalExamination() + ", medicalHistory=" + this.getMedicalHistory() + ", doctor=" + this.getDoctor() + ")";
    }

    public static class TreatmentResponseBuilder {
        private Long id;
        private String medications;
        private String exercise;
        private MedicalExamination medicalExamination;
        private MedicalHistory medicalHistory;
        private Doctor doctor;

        TreatmentResponseBuilder() {
        }

        public TreatmentResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TreatmentResponseBuilder medications(String medications) {
            this.medications = medications;
            return this;
        }

        public TreatmentResponseBuilder exercise(String exercise) {
            this.exercise = exercise;
            return this;
        }

        public TreatmentResponseBuilder medicalExamination(MedicalExamination medicalExamination) {
            this.medicalExamination = medicalExamination;
            return this;
        }

        public TreatmentResponseBuilder medicalHistory(MedicalHistory medicalHistory) {
            this.medicalHistory = medicalHistory;
            return this;
        }

        public TreatmentResponseBuilder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public TreatmentResponse build() {
            return new TreatmentResponse(this.id, this.medications, this.exercise, this.medicalExamination, this.medicalHistory, this.doctor);
        }

        public String toString() {
            return "TreatmentResponse.TreatmentResponseBuilder(id=" + this.id + ", medications=" + this.medications + ", exercise=" + this.exercise + ", medicalExamination=" + this.medicalExamination + ", medicalHistory=" + this.medicalHistory + ", doctor=" + this.doctor + ")";
        }
    }
}
