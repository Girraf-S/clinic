package bsuir.clinic.clinic.model.request;

public class MedicalExaminationRequest {
    private boolean isPlanned;
    private Long doctorId;
    private Long patientId;

    public MedicalExaminationRequest(boolean isPlanned, Long doctorId, Long patientId) {
        this.isPlanned = isPlanned;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public MedicalExaminationRequest() {
    }

    public static MedicalExaminationRequestBuilder builder() {
        return new MedicalExaminationRequestBuilder();
    }

    public boolean isPlanned() {
        return this.isPlanned;
    }

    public Long getDoctorId() {
        return this.doctorId;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPlanned(boolean isPlanned) {
        this.isPlanned = isPlanned;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MedicalExaminationRequest)) return false;
        final MedicalExaminationRequest other = (MedicalExaminationRequest) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.isPlanned() != other.isPlanned()) return false;
        final Object this$doctorId = this.getDoctorId();
        final Object other$doctorId = other.getDoctorId();
        if (this$doctorId == null ? other$doctorId != null : !this$doctorId.equals(other$doctorId)) return false;
        final Object this$patientId = this.getPatientId();
        final Object other$patientId = other.getPatientId();
        if (this$patientId == null ? other$patientId != null : !this$patientId.equals(other$patientId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedicalExaminationRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isPlanned() ? 79 : 97);
        final Object $doctorId = this.getDoctorId();
        result = result * PRIME + ($doctorId == null ? 43 : $doctorId.hashCode());
        final Object $patientId = this.getPatientId();
        result = result * PRIME + ($patientId == null ? 43 : $patientId.hashCode());
        return result;
    }

    public String toString() {
        return "MedicalExaminationRequest(isPlanned=" + this.isPlanned() + ", doctorId=" + this.getDoctorId() + ", patientId=" + this.getPatientId() + ")";
    }

    public static class MedicalExaminationRequestBuilder {
        private boolean isPlanned;
        private Long doctorId;
        private Long patientId;

        MedicalExaminationRequestBuilder() {
        }

        public MedicalExaminationRequestBuilder isPlanned(boolean isPlanned) {
            this.isPlanned = isPlanned;
            return this;
        }

        public MedicalExaminationRequestBuilder doctorId(Long doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public MedicalExaminationRequestBuilder patientId(Long patientId) {
            this.patientId = patientId;
            return this;
        }

        public MedicalExaminationRequest build() {
            return new MedicalExaminationRequest(this.isPlanned, this.doctorId, this.patientId);
        }

        public String toString() {
            return "MedicalExaminationRequest.MedicalExaminationRequestBuilder(isPlanned=" + this.isPlanned + ", doctorId=" + this.doctorId + ", patientId=" + this.patientId + ")";
        }
    }
}
