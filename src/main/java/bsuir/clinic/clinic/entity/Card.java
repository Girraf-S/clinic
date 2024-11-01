package bsuir.clinic.clinic.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String passwordNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "card")
    private Set<MedicalHistory> medicalHistory;

    public Card(Long id, String passwordNumber, LocalDate dateOfBirth, Patient patient, Set<MedicalHistory> medicalHistory) {
        this.id = id;
        this.passwordNumber = passwordNumber;
        this.dateOfBirth = dateOfBirth;
        this.patient = patient;
        this.medicalHistory = medicalHistory;
    }

    public Card() {
    }

    public static CardBuilder builder() {
        return new CardBuilder();
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

    public Set<MedicalHistory> getMedicalHistory() {
        return this.medicalHistory;
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

    public void setMedicalHistory(Set<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Card)) return false;
        final Card other = (Card) o;
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
        final Object this$medicalHistory = this.getMedicalHistory();
        final Object other$medicalHistory = other.getMedicalHistory();
        if (this$medicalHistory == null ? other$medicalHistory != null : !this$medicalHistory.equals(other$medicalHistory))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Card;
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
        final Object $medicalHistory = this.getMedicalHistory();
        result = result * PRIME + ($medicalHistory == null ? 43 : $medicalHistory.hashCode());
        return result;
    }

    public String toString() {
        return "Card(id=" + this.getId() + ", passwordNumber=" + this.getPasswordNumber() + ", dateOfBirth=" + this.getDateOfBirth() + ", patient=" + this.getPatient() + ", medicalHistory=" + this.getMedicalHistory() + ")";
    }

    public static class CardBuilder {
        private Long id;
        private String passwordNumber;
        private LocalDate dateOfBirth;
        private Patient patient;
        private Set<MedicalHistory> medicalHistory;

        CardBuilder() {
        }

        public CardBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CardBuilder passwordNumber(String passwordNumber) {
            this.passwordNumber = passwordNumber;
            return this;
        }

        public CardBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public CardBuilder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public CardBuilder medicalHistory(Set<MedicalHistory> medicalHistory) {
            this.medicalHistory = medicalHistory;
            return this;
        }

        public Card build() {
            return new Card(this.id, this.passwordNumber, this.dateOfBirth, this.patient, this.medicalHistory);
        }

        public String toString() {
            return "Card.CardBuilder(id=" + this.id + ", passwordNumber=" + this.passwordNumber + ", dateOfBirth=" + this.dateOfBirth + ", patient=" + this.patient + ", medicalHistory=" + this.medicalHistory + ")";
        }
    }
}
