package bsuir.clinic.clinic.model.request;

public class TreatmentRequest {
    private String medications;
    private String exercise;
    private Long medicalHistoryId;
    private Long medicalExaminationId;
    private Long doctorId;

    public TreatmentRequest(String medications, String exercise, Long medicalHistoryId, Long medicalExaminationId, Long doctorId) {
        this.medications = medications;
        this.exercise = exercise;
        this.medicalHistoryId = medicalHistoryId;
        this.medicalExaminationId = medicalExaminationId;
        this.doctorId = doctorId;
    }

    public TreatmentRequest() {
    }

    public static TreatmentRequestBuilder builder() {
        return new TreatmentRequestBuilder();
    }

    public String getMedications() {
        return this.medications;
    }

    public String getExercise() {
        return this.exercise;
    }

    public Long getMedicalHistoryId() {
        return this.medicalHistoryId;
    }

    public Long getMedicalExaminationId() {
        return this.medicalExaminationId;
    }

    public Long getDoctorId() {
        return this.doctorId;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setMedicalHistoryId(Long medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public void setMedicalExaminationId(Long medicalExaminationId) {
        this.medicalExaminationId = medicalExaminationId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TreatmentRequest)) return false;
        final TreatmentRequest other = (TreatmentRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$medications = this.getMedications();
        final Object other$medications = other.getMedications();
        if (this$medications == null ? other$medications != null : !this$medications.equals(other$medications))
            return false;
        final Object this$exercise = this.getExercise();
        final Object other$exercise = other.getExercise();
        if (this$exercise == null ? other$exercise != null : !this$exercise.equals(other$exercise)) return false;
        final Object this$medicalHistoryId = this.getMedicalHistoryId();
        final Object other$medicalHistoryId = other.getMedicalHistoryId();
        if (this$medicalHistoryId == null ? other$medicalHistoryId != null : !this$medicalHistoryId.equals(other$medicalHistoryId))
            return false;
        final Object this$medicalExaminationId = this.getMedicalExaminationId();
        final Object other$medicalExaminationId = other.getMedicalExaminationId();
        if (this$medicalExaminationId == null ? other$medicalExaminationId != null : !this$medicalExaminationId.equals(other$medicalExaminationId))
            return false;
        final Object this$doctorId = this.getDoctorId();
        final Object other$doctorId = other.getDoctorId();
        if (this$doctorId == null ? other$doctorId != null : !this$doctorId.equals(other$doctorId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TreatmentRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $medications = this.getMedications();
        result = result * PRIME + ($medications == null ? 43 : $medications.hashCode());
        final Object $exercise = this.getExercise();
        result = result * PRIME + ($exercise == null ? 43 : $exercise.hashCode());
        final Object $medicalHistoryId = this.getMedicalHistoryId();
        result = result * PRIME + ($medicalHistoryId == null ? 43 : $medicalHistoryId.hashCode());
        final Object $medicalExaminationId = this.getMedicalExaminationId();
        result = result * PRIME + ($medicalExaminationId == null ? 43 : $medicalExaminationId.hashCode());
        final Object $doctorId = this.getDoctorId();
        result = result * PRIME + ($doctorId == null ? 43 : $doctorId.hashCode());
        return result;
    }

    public String toString() {
        return "TreatmentRequest(medications=" + this.getMedications() + ", exercise=" + this.getExercise() + ", medicalHistoryId=" + this.getMedicalHistoryId() + ", medicalExaminationId=" + this.getMedicalExaminationId() + ", doctorId=" + this.getDoctorId() + ")";
    }

    public static class TreatmentRequestBuilder {
        private String medications;
        private String exercise;
        private Long medicalHistoryId;
        private Long medicalExaminationId;
        private Long doctorId;

        TreatmentRequestBuilder() {
        }

        public TreatmentRequestBuilder medications(String medications) {
            this.medications = medications;
            return this;
        }

        public TreatmentRequestBuilder exercise(String exercise) {
            this.exercise = exercise;
            return this;
        }

        public TreatmentRequestBuilder medicalHistoryId(Long medicalHistoryId) {
            this.medicalHistoryId = medicalHistoryId;
            return this;
        }

        public TreatmentRequestBuilder medicalExaminationId(Long medicalExaminationId) {
            this.medicalExaminationId = medicalExaminationId;
            return this;
        }

        public TreatmentRequestBuilder doctorId(Long doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public TreatmentRequest build() {
            return new TreatmentRequest(this.medications, this.exercise, this.medicalHistoryId, this.medicalExaminationId, this.doctorId);
        }

        public String toString() {
            return "TreatmentRequest.TreatmentRequestBuilder(medications=" + this.medications + ", exercise=" + this.exercise + ", medicalHistoryId=" + this.medicalHistoryId + ", medicalExaminationId=" + this.medicalExaminationId + ", doctorId=" + this.doctorId + ")";
        }
    }
}
