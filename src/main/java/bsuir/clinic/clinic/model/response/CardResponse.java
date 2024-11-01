package bsuir.clinic.clinic.model.response;

import bsuir.clinic.clinic.entity.Patient;

import java.time.LocalDate;

public class CardResponse {
    private Long id;
    private String passwordNumber;
    private LocalDate dateOfBirth;
    private Patient patient;

    public CardResponse(Long id, String passwordNumber, LocalDate dateOfBirth, Patient patient) {
        this.id = id;
        this.passwordNumber = passwordNumber;
        this.dateOfBirth = dateOfBirth;
        this.patient = patient;
    }

    public CardResponse() {
    }

    public static CardResponseBuilder builder() {
        return new CardResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getPasswordNumber() {
        return this.passwordNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CardResponse)) return false;
        final CardResponse other = (CardResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$passwordNumber = this.getPasswordNumber();
        final Object other$passwordNumber = other.getPasswordNumber();
        if (this$passwordNumber == null ? other$passwordNumber != null : !this$passwordNumber.equals(other$passwordNumber))
            return false;
        final Object this$dateOfBirth = this.getDateOfBirth();
        final Object other$dateOfBirth = other.getDateOfBirth();
        if (this$dateOfBirth == null ? other$dateOfBirth != null : !this$dateOfBirth.equals(other$dateOfBirth))
            return false;
        final Object this$patient = this.getPatient();
        final Object other$patient = other.getPatient();
        if (this$patient == null ? other$patient != null : !this$patient.equals(other$patient)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $passwordNumber = this.getPasswordNumber();
        result = result * PRIME + ($passwordNumber == null ? 43 : $passwordNumber.hashCode());
        final Object $dateOfBirth = this.getDateOfBirth();
        result = result * PRIME + ($dateOfBirth == null ? 43 : $dateOfBirth.hashCode());
        final Object $patient = this.getPatient();
        result = result * PRIME + ($patient == null ? 43 : $patient.hashCode());
        return result;
    }

    public String toString() {
        return "CardResponse(id=" + this.getId() + ", passwordNumber=" + this.getPasswordNumber() + ", dateOfBirth=" + this.getDateOfBirth() + ", patient=" + this.getPatient() + ")";
    }

    public static class CardResponseBuilder {
        private Long id;
        private String passwordNumber;
        private LocalDate dateOfBirth;
        private Patient patient;

        CardResponseBuilder() {
        }

        public CardResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CardResponseBuilder passwordNumber(String passwordNumber) {
            this.passwordNumber = passwordNumber;
            return this;
        }

        public CardResponseBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public CardResponseBuilder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public CardResponse build() {
            return new CardResponse(this.id, this.passwordNumber, this.dateOfBirth, this.patient);
        }

        public String toString() {
            return "CardResponse.CardResponseBuilder(id=" + this.id + ", passwordNumber=" + this.passwordNumber + ", dateOfBirth=" + this.dateOfBirth + ", patient=" + this.patient + ")";
        }
    }
}
