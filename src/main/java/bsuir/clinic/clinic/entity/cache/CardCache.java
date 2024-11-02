package bsuir.clinic.clinic.entity.cache;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;
import java.util.Set;

@RedisHash("Card")
public class CardCache {
    @Id
    private Long id;
    private String passwordNumber;
    private LocalDate dateOfBirth;
    private PatientCache patient;
    private Set<MedicalHistoryCache> medicalHistory;

    CardCache(Long id, String passwordNumber, LocalDate dateOfBirth, PatientCache patient, Set<MedicalHistoryCache> medicalHistory) {
        this.id = id;
        this.passwordNumber = passwordNumber;
        this.dateOfBirth = dateOfBirth;
        this.patient = patient;
        this.medicalHistory = medicalHistory;
    }

    public static CardCacheBuilder builder() {
        return new CardCacheBuilder();
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

    public PatientCache getPatient() {
        return this.patient;
    }

    public Set<MedicalHistoryCache> getMedicalHistory() {
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

    public void setPatient(PatientCache patient) {
        this.patient = patient;
    }

    public void setMedicalHistory(Set<MedicalHistoryCache> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CardCache)) return false;
        final CardCache other = (CardCache) o;
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
        return other instanceof CardCache;
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
        return "CardCache(id=" + this.getId() + ", passwordNumber=" + this.getPasswordNumber() + ", dateOfBirth=" + this.getDateOfBirth() + ", patient=" + this.getPatient() + ", medicalHistory=" + this.getMedicalHistory() + ")";
    }

    public static class CardCacheBuilder {
        private Long id;
        private String passwordNumber;
        private LocalDate dateOfBirth;
        private PatientCache patient;
        private Set<MedicalHistoryCache> medicalHistory;

        CardCacheBuilder() {
        }

        public CardCacheBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CardCacheBuilder passwordNumber(String passwordNumber) {
            this.passwordNumber = passwordNumber;
            return this;
        }

        public CardCacheBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public CardCacheBuilder patient(PatientCache patient) {
            this.patient = patient;
            return this;
        }

        public CardCacheBuilder medicalHistory(Set<MedicalHistoryCache> medicalHistory) {
            this.medicalHistory = medicalHistory;
            return this;
        }

        public CardCache build() {
            return new CardCache(this.id, this.passwordNumber, this.dateOfBirth, this.patient, this.medicalHistory);
        }

        public String toString() {
            return "CardCache.CardCacheBuilder(id=" + this.id + ", passwordNumber=" + this.passwordNumber + ", dateOfBirth=" + this.dateOfBirth + ", patient=" + this.patient + ", medicalHistory=" + this.medicalHistory + ")";
        }
    }
}
