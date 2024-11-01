package bsuir.clinic.clinic.model.request;

public class MedicalHistoryRequest {

    private String conclusion;
    private String diagnosis;
    private Long cardId;
    private Long doctorId;

    public MedicalHistoryRequest(String conclusion, String diagnosis, Long cardId, Long doctorId) {
        this.conclusion = conclusion;
        this.diagnosis = diagnosis;
        this.cardId = cardId;
        this.doctorId = doctorId;
    }

    public MedicalHistoryRequest() {
    }

    public static MedicalHistoryRequestBuilder builder() {
        return new MedicalHistoryRequestBuilder();
    }

    public String getConclusion() {
        return this.conclusion;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public Long getCardId() {
        return this.cardId;
    }

    public Long getDoctorId() {
        return this.doctorId;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MedicalHistoryRequest)) return false;
        final MedicalHistoryRequest other = (MedicalHistoryRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$conclusion = this.getConclusion();
        final Object other$conclusion = other.getConclusion();
        if (this$conclusion == null ? other$conclusion != null : !this$conclusion.equals(other$conclusion))
            return false;
        final Object this$diagnosis = this.getDiagnosis();
        final Object other$diagnosis = other.getDiagnosis();
        if (this$diagnosis == null ? other$diagnosis != null : !this$diagnosis.equals(other$diagnosis)) return false;
        final Object this$cardId = this.getCardId();
        final Object other$cardId = other.getCardId();
        if (this$cardId == null ? other$cardId != null : !this$cardId.equals(other$cardId)) return false;
        final Object this$doctorId = this.getDoctorId();
        final Object other$doctorId = other.getDoctorId();
        if (this$doctorId == null ? other$doctorId != null : !this$doctorId.equals(other$doctorId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedicalHistoryRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $conclusion = this.getConclusion();
        result = result * PRIME + ($conclusion == null ? 43 : $conclusion.hashCode());
        final Object $diagnosis = this.getDiagnosis();
        result = result * PRIME + ($diagnosis == null ? 43 : $diagnosis.hashCode());
        final Object $cardId = this.getCardId();
        result = result * PRIME + ($cardId == null ? 43 : $cardId.hashCode());
        final Object $doctorId = this.getDoctorId();
        result = result * PRIME + ($doctorId == null ? 43 : $doctorId.hashCode());
        return result;
    }

    public String toString() {
        return "MedicalHistoryRequest(conclusion=" + this.getConclusion() + ", diagnosis=" + this.getDiagnosis() + ", cardId=" + this.getCardId() + ", doctorId=" + this.getDoctorId() + ")";
    }

    public static class MedicalHistoryRequestBuilder {
        private String conclusion;
        private String diagnosis;
        private Long cardId;
        private Long doctorId;

        MedicalHistoryRequestBuilder() {
        }

        public MedicalHistoryRequestBuilder conclusion(String conclusion) {
            this.conclusion = conclusion;
            return this;
        }

        public MedicalHistoryRequestBuilder diagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        public MedicalHistoryRequestBuilder cardId(Long cardId) {
            this.cardId = cardId;
            return this;
        }

        public MedicalHistoryRequestBuilder doctorId(Long doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public MedicalHistoryRequest build() {
            return new MedicalHistoryRequest(this.conclusion, this.diagnosis, this.cardId, this.doctorId);
        }

        public String toString() {
            return "MedicalHistoryRequest.MedicalHistoryRequestBuilder(conclusion=" + this.conclusion + ", diagnosis=" + this.diagnosis + ", cardId=" + this.cardId + ", doctorId=" + this.doctorId + ")";
        }
    }
}
