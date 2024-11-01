package bsuir.clinic.clinic.model.request;

import java.time.LocalDate;

public class CardRequest {
    private String passwordNumber;
    private LocalDate dateOfBirth;
    private Long patientId;

    public CardRequest(String passwordNumber, LocalDate dateOfBirth, Long patientId) {
        this.passwordNumber = passwordNumber;
        this.dateOfBirth = dateOfBirth;
        this.patientId = patientId;
    }

    public CardRequest() {
    }

    public static CardRequestBuilder builder() {
        return new CardRequestBuilder();
    }

    public String getPasswordNumber() {
        return this.passwordNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CardRequest)) return false;
        final CardRequest other = (CardRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$passwordNumber = this.getPasswordNumber();
        final Object other$passwordNumber = other.getPasswordNumber();
        if (this$passwordNumber == null ? other$passwordNumber != null : !this$passwordNumber.equals(other$passwordNumber))
            return false;
        final Object this$dateOfBirth = this.getDateOfBirth();
        final Object other$dateOfBirth = other.getDateOfBirth();
        if (this$dateOfBirth == null ? other$dateOfBirth != null : !this$dateOfBirth.equals(other$dateOfBirth))
            return false;
        final Object this$patientId = this.getPatientId();
        final Object other$patientId = other.getPatientId();
        if (this$patientId == null ? other$patientId != null : !this$patientId.equals(other$patientId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $passwordNumber = this.getPasswordNumber();
        result = result * PRIME + ($passwordNumber == null ? 43 : $passwordNumber.hashCode());
        final Object $dateOfBirth = this.getDateOfBirth();
        result = result * PRIME + ($dateOfBirth == null ? 43 : $dateOfBirth.hashCode());
        final Object $patientId = this.getPatientId();
        result = result * PRIME + ($patientId == null ? 43 : $patientId.hashCode());
        return result;
    }

    public String toString() {
        return "CardRequest(passwordNumber=" + this.getPasswordNumber() + ", dateOfBirth=" + this.getDateOfBirth() + ", patientId=" + this.getPatientId() + ")";
    }

    public static class CardRequestBuilder {
        private String passwordNumber;
        private LocalDate dateOfBirth;
        private Long patientId;

        CardRequestBuilder() {
        }

        public CardRequestBuilder passwordNumber(String passwordNumber) {
            this.passwordNumber = passwordNumber;
            return this;
        }

        public CardRequestBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public CardRequestBuilder patientId(Long patientId) {
            this.patientId = patientId;
            return this;
        }

        public CardRequest build() {
            return new CardRequest(this.passwordNumber, this.dateOfBirth, this.patientId);
        }

        public String toString() {
            return "CardRequest.CardRequestBuilder(passwordNumber=" + this.passwordNumber + ", dateOfBirth=" + this.dateOfBirth + ", patientId=" + this.patientId + ")";
        }
    }
}
