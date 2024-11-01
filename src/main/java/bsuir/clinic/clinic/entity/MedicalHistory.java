package bsuir.clinic.clinic.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "medical_histories")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startTreatment;

    @Column
    private LocalDate finishTreatment;

    @Column(nullable = false)
    private String conclusion;
    @Column(nullable = false)
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @OneToMany
    @JoinColumn(name = "treatment")
    private Set<Treatment> treatments;

    public MedicalHistory(Long id, LocalDate startTreatment, LocalDate finishTreatment, String conclusion, String diagnosis, Card card, Doctor doctor, Set<Treatment> treatments) {
        this.id = id;
        this.startTreatment = startTreatment;
        this.finishTreatment = finishTreatment;
        this.conclusion = conclusion;
        this.diagnosis = diagnosis;
        this.card = card;
        this.doctor = doctor;
        this.treatments = treatments;
    }

    public MedicalHistory() {
    }

    public static MedicalHistoryBuilder builder() {
        return new MedicalHistoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getStartTreatment() {
        return this.startTreatment;
    }

    public LocalDate getFinishTreatment() {
        return this.finishTreatment;
    }

    public String getConclusion() {
        return this.conclusion;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public Card getCard() {
        return this.card;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Set<Treatment> getTreatments() {
        return this.treatments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartTreatment(LocalDate startTreatment) {
        this.startTreatment = startTreatment;
    }

    public void setFinishTreatment(LocalDate finishTreatment) {
        this.finishTreatment = finishTreatment;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MedicalHistory)) return false;
        final MedicalHistory other = (MedicalHistory) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$startTreatment = this.getStartTreatment();
        final Object other$startTreatment = other.getStartTreatment();
        if (this$startTreatment == null ? other$startTreatment != null : !this$startTreatment.equals(other$startTreatment))
            return false;
        final Object this$finishTreatment = this.getFinishTreatment();
        final Object other$finishTreatment = other.getFinishTreatment();
        if (this$finishTreatment == null ? other$finishTreatment != null : !this$finishTreatment.equals(other$finishTreatment))
            return false;
        final Object this$conclusion = this.getConclusion();
        final Object other$conclusion = other.getConclusion();
        if (this$conclusion == null ? other$conclusion != null : !this$conclusion.equals(other$conclusion))
            return false;
        final Object this$diagnosis = this.getDiagnosis();
        final Object other$diagnosis = other.getDiagnosis();
        if (this$diagnosis == null ? other$diagnosis != null : !this$diagnosis.equals(other$diagnosis)) return false;
        final Object this$card = this.getCard();
        final Object other$card = other.getCard();
        if (this$card == null ? other$card != null : !this$card.equals(other$card)) return false;
        final Object this$doctor = this.getDoctor();
        final Object other$doctor = other.getDoctor();
        if (this$doctor == null ? other$doctor != null : !this$doctor.equals(other$doctor)) return false;
        final Object this$treatments = this.getTreatments();
        final Object other$treatments = other.getTreatments();
        if (this$treatments == null ? other$treatments != null : !this$treatments.equals(other$treatments))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedicalHistory;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $startTreatment = this.getStartTreatment();
        result = result * PRIME + ($startTreatment == null ? 43 : $startTreatment.hashCode());
        final Object $finishTreatment = this.getFinishTreatment();
        result = result * PRIME + ($finishTreatment == null ? 43 : $finishTreatment.hashCode());
        final Object $conclusion = this.getConclusion();
        result = result * PRIME + ($conclusion == null ? 43 : $conclusion.hashCode());
        final Object $diagnosis = this.getDiagnosis();
        result = result * PRIME + ($diagnosis == null ? 43 : $diagnosis.hashCode());
        final Object $card = this.getCard();
        result = result * PRIME + ($card == null ? 43 : $card.hashCode());
        final Object $doctor = this.getDoctor();
        result = result * PRIME + ($doctor == null ? 43 : $doctor.hashCode());
        final Object $treatments = this.getTreatments();
        result = result * PRIME + ($treatments == null ? 43 : $treatments.hashCode());
        return result;
    }

    public String toString() {
        return "MedicalHistory(id=" + this.getId() + ", startTreatment=" + this.getStartTreatment() + ", finishTreatment=" + this.getFinishTreatment() + ", conclusion=" + this.getConclusion() + ", diagnosis=" + this.getDiagnosis() + ", card=" + this.getCard() + ", doctor=" + this.getDoctor() + ", treatments=" + this.getTreatments() + ")";
    }

    public static class MedicalHistoryBuilder {
        private Long id;
        private LocalDate startTreatment;
        private LocalDate finishTreatment;
        private String conclusion;
        private String diagnosis;
        private Card card;
        private Doctor doctor;
        private Set<Treatment> treatments;

        MedicalHistoryBuilder() {
        }

        public MedicalHistoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MedicalHistoryBuilder startTreatment(LocalDate startTreatment) {
            this.startTreatment = startTreatment;
            return this;
        }

        public MedicalHistoryBuilder finishTreatment(LocalDate finishTreatment) {
            this.finishTreatment = finishTreatment;
            return this;
        }

        public MedicalHistoryBuilder conclusion(String conclusion) {
            this.conclusion = conclusion;
            return this;
        }

        public MedicalHistoryBuilder diagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        public MedicalHistoryBuilder card(Card card) {
            this.card = card;
            return this;
        }

        public MedicalHistoryBuilder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public MedicalHistoryBuilder treatments(Set<Treatment> treatments) {
            this.treatments = treatments;
            return this;
        }

        public MedicalHistory build() {
            return new MedicalHistory(this.id, this.startTreatment, this.finishTreatment, this.conclusion, this.diagnosis, this.card, this.doctor, this.treatments);
        }

        public String toString() {
            return "MedicalHistory.MedicalHistoryBuilder(id=" + this.id + ", startTreatment=" + this.startTreatment + ", finishTreatment=" + this.finishTreatment + ", conclusion=" + this.conclusion + ", diagnosis=" + this.diagnosis + ", card=" + this.card + ", doctor=" + this.doctor + ", treatments=" + this.treatments + ")";
        }
    }
}
