package bsuir.clinic.clinic.model.request;

public class DoctorRequest {
    private String firstName;
    private String lastName;
    private String numberOfJobOffer;
    private String specialization;

    public DoctorRequest(String firstName, String lastName, String numberOfJobOffer, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfJobOffer = numberOfJobOffer;
        this.specialization = specialization;
    }

    public DoctorRequest() {
    }

    public static DoctorRequestBuilder builder() {
        return new DoctorRequestBuilder();
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

    public String getSpecialization() {
        return this.specialization;
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DoctorRequest)) return false;
        final DoctorRequest other = (DoctorRequest) o;
        if (!other.canEqual((Object) this)) return false;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DoctorRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $numberOfJobOffer = this.getNumberOfJobOffer();
        result = result * PRIME + ($numberOfJobOffer == null ? 43 : $numberOfJobOffer.hashCode());
        final Object $specialization = this.getSpecialization();
        result = result * PRIME + ($specialization == null ? 43 : $specialization.hashCode());
        return result;
    }

    public String toString() {
        return "DoctorRequest(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", numberOfJobOffer=" + this.getNumberOfJobOffer() + ", specialization=" + this.getSpecialization() + ")";
    }

    public static class DoctorRequestBuilder {
        private String firstName;
        private String lastName;
        private String numberOfJobOffer;
        private String specialization;

        DoctorRequestBuilder() {
        }

        public DoctorRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DoctorRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DoctorRequestBuilder numberOfJobOffer(String numberOfJobOffer) {
            this.numberOfJobOffer = numberOfJobOffer;
            return this;
        }

        public DoctorRequestBuilder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public DoctorRequest build() {
            return new DoctorRequest(this.firstName, this.lastName, this.numberOfJobOffer, this.specialization);
        }

        public String toString() {
            return "DoctorRequest.DoctorRequestBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", numberOfJobOffer=" + this.numberOfJobOffer + ", specialization=" + this.specialization + ")";
        }
    }
}
