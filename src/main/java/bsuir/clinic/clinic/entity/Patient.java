package bsuir.clinic.clinic.entity;

import bsuir.clinic.clinic.entity.enums.Condition;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Column(nullable = false)
    private String citizenship;


    @OneToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @OneToMany(mappedBy = "patient")
    private Set<MedicalExamination> medicalExaminations;

    public Patient(Long id, String firstName, String lastName, Condition condition, String citizenship, Card card, Set<MedicalExamination> medicalExaminations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.condition = condition;
        this.citizenship = citizenship;
        this.card = card;
        this.medicalExaminations = medicalExaminations;
    }

    public Patient() {
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getCitizenship() {
        return this.citizenship;
    }

    public Card getCard() {
        return this.card;
    }

    public Set<MedicalExamination> getMedicalExaminations() {
        return this.medicalExaminations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setMedicalExaminations(Set<MedicalExamination> medicalExaminations) {
        this.medicalExaminations = medicalExaminations;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Patient)) return false;
        final Patient other = (Patient) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$condition = this.getCondition();
        final Object other$condition = other.getCondition();
        if (this$condition == null ? other$condition != null : !this$condition.equals(other$condition)) return false;
        final Object this$citizenship = this.getCitizenship();
        final Object other$citizenship = other.getCitizenship();
        if (this$citizenship == null ? other$citizenship != null : !this$citizenship.equals(other$citizenship))
            return false;
        final Object this$card = this.getCard();
        final Object other$card = other.getCard();
        if (this$card == null ? other$card != null : !this$card.equals(other$card)) return false;
        final Object this$medicalExaminations = this.getMedicalExaminations();
        final Object other$medicalExaminations = other.getMedicalExaminations();
        if (this$medicalExaminations == null ? other$medicalExaminations != null : !this$medicalExaminations.equals(other$medicalExaminations))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Patient;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $condition = this.getCondition();
        result = result * PRIME + ($condition == null ? 43 : $condition.hashCode());
        final Object $citizenship = this.getCitizenship();
        result = result * PRIME + ($citizenship == null ? 43 : $citizenship.hashCode());
        final Object $card = this.getCard();
        result = result * PRIME + ($card == null ? 43 : $card.hashCode());
        final Object $medicalExaminations = this.getMedicalExaminations();
        result = result * PRIME + ($medicalExaminations == null ? 43 : $medicalExaminations.hashCode());
        return result;
    }

    public String toString() {
        return "Patient(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", condition=" + this.getCondition() + ", citizenship=" + this.getCitizenship() + ", card=" + this.getCard() + ", medicalExaminations=" + this.getMedicalExaminations() + ")";
    }

    public static class PatientBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Condition condition;
        private String citizenship;
        private Card card;
        private Set<MedicalExamination> medicalExaminations;

        PatientBuilder() {
        }

        public PatientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PatientBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientBuilder condition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public PatientBuilder citizenship(String citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public PatientBuilder card(Card card) {
            this.card = card;
            return this;
        }

        public PatientBuilder medicalExaminations(Set<MedicalExamination> medicalExaminations) {
            this.medicalExaminations = medicalExaminations;
            return this;
        }

        public Patient build() {
            return new Patient(this.id, this.firstName, this.lastName, this.condition, this.citizenship, this.card, this.medicalExaminations);
        }

        public String toString() {
            return "Patient.PatientBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", condition=" + this.condition + ", citizenship=" + this.citizenship + ", card=" + this.card + ", medicalExaminations=" + this.medicalExaminations + ")";
        }
    }
}
