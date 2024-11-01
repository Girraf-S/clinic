package bsuir.clinic.clinic.entity;

import bsuir.clinic.clinic.entity.enums.Specialization;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String numberOfJobOffer;

    @Column(nullable = false)
    private Specialization specialization;

    @OneToMany(mappedBy = "doctor")
    private Set<MedicalExamination> medicalExaminations;

    @OneToMany(mappedBy = "doctor")
    private Set<MedicalHistory> medicalHistories;

    public Doctor(Long id, String firstName, String lastName, String numberOfJobOffer, Specialization specialization, Set<MedicalExamination> medicalExaminations, Set<MedicalHistory> medicalHistories) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfJobOffer = numberOfJobOffer;
        this.specialization = specialization;
        this.medicalExaminations = medicalExaminations;
        this.medicalHistories = medicalHistories;
    }

    public Doctor() {
    }

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
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

    public String getNumberOfJobOffer() {
        return this.numberOfJobOffer;
    }

    public Specialization getSpecialization() {
        return this.specialization;
    }

    public Set<MedicalExamination> getMedicalExaminations() {
        return this.medicalExaminations;
    }

    public Set<MedicalHistory> getMedicalHistories() {
        return this.medicalHistories;
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

    public void setNumberOfJobOffer(String numberOfJobOffer) {
        this.numberOfJobOffer = numberOfJobOffer;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setMedicalExaminations(Set<MedicalExamination> medicalExaminations) {
        this.medicalExaminations = medicalExaminations;
    }

    public void setMedicalHistories(Set<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Doctor)) return false;
        final Doctor other = (Doctor) o;
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
        final Object this$numberOfJobOffer = this.getNumberOfJobOffer();
        final Object other$numberOfJobOffer = other.getNumberOfJobOffer();
        if (this$numberOfJobOffer == null ? other$numberOfJobOffer != null : !this$numberOfJobOffer.equals(other$numberOfJobOffer))
            return false;
        final Object this$specialization = this.getSpecialization();
        final Object other$specialization = other.getSpecialization();
        if (this$specialization == null ? other$specialization != null : !this$specialization.equals(other$specialization))
            return false;
        final Object this$medicalExaminations = this.getMedicalExaminations();
        final Object other$medicalExaminations = other.getMedicalExaminations();
        if (this$medicalExaminations == null ? other$medicalExaminations != null : !this$medicalExaminations.equals(other$medicalExaminations))
            return false;
        final Object this$medicalHistories = this.getMedicalHistories();
        final Object other$medicalHistories = other.getMedicalHistories();
        if (this$medicalHistories == null ? other$medicalHistories != null : !this$medicalHistories.equals(other$medicalHistories))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Doctor;
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
        final Object $numberOfJobOffer = this.getNumberOfJobOffer();
        result = result * PRIME + ($numberOfJobOffer == null ? 43 : $numberOfJobOffer.hashCode());
        final Object $specialization = this.getSpecialization();
        result = result * PRIME + ($specialization == null ? 43 : $specialization.hashCode());
        final Object $medicalExaminations = this.getMedicalExaminations();
        result = result * PRIME + ($medicalExaminations == null ? 43 : $medicalExaminations.hashCode());
        final Object $medicalHistories = this.getMedicalHistories();
        result = result * PRIME + ($medicalHistories == null ? 43 : $medicalHistories.hashCode());
        return result;
    }

    public String toString() {
        return "Doctor(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", numberOfJobOffer=" + this.getNumberOfJobOffer() + ", specialization=" + this.getSpecialization() + ", medicalExaminations=" + this.getMedicalExaminations() + ", medicalHistories=" + this.getMedicalHistories() + ")";
    }

    public static class DoctorBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String numberOfJobOffer;
        private Specialization specialization;
        private Set<MedicalExamination> medicalExaminations;
        private Set<MedicalHistory> medicalHistories;

        DoctorBuilder() {
        }

        public DoctorBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DoctorBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DoctorBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DoctorBuilder numberOfJobOffer(String numberOfJobOffer) {
            this.numberOfJobOffer = numberOfJobOffer;
            return this;
        }

        public DoctorBuilder specialization(Specialization specialization) {
            this.specialization = specialization;
            return this;
        }

        public DoctorBuilder medicalExaminations(Set<MedicalExamination> medicalExaminations) {
            this.medicalExaminations = medicalExaminations;
            return this;
        }

        public DoctorBuilder medicalHistories(Set<MedicalHistory> medicalHistories) {
            this.medicalHistories = medicalHistories;
            return this;
        }

        public Doctor build() {
            return new Doctor(this.id, this.firstName, this.lastName, this.numberOfJobOffer, this.specialization, this.medicalExaminations, this.medicalHistories);
        }

        public String toString() {
            return "Doctor.DoctorBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", numberOfJobOffer=" + this.numberOfJobOffer + ", specialization=" + this.specialization + ", medicalExaminations=" + this.medicalExaminations + ", medicalHistories=" + this.medicalHistories + ")";
        }
    }
}
