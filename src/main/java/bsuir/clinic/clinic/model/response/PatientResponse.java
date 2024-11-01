package bsuir.clinic.clinic.model.response;

public class PatientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String citizenship;
    private String condition;

    public PatientResponse(Long id, String firstName, String lastName, String citizenship, String condition) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.condition = condition;
    }

    public PatientResponse() {
    }

    public static PatientResponseBuilder builder() {
        return new PatientResponseBuilder();
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

    public String getCitizenship() {
        return this.citizenship;
    }

    public String getCondition() {
        return this.condition;
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

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PatientResponse)) return false;
        final PatientResponse other = (PatientResponse) o;
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
        final Object this$citizenship = this.getCitizenship();
        final Object other$citizenship = other.getCitizenship();
        if (this$citizenship == null ? other$citizenship != null : !this$citizenship.equals(other$citizenship))
            return false;
        final Object this$condition = this.getCondition();
        final Object other$condition = other.getCondition();
        if (this$condition == null ? other$condition != null : !this$condition.equals(other$condition)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PatientResponse;
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
        final Object $citizenship = this.getCitizenship();
        result = result * PRIME + ($citizenship == null ? 43 : $citizenship.hashCode());
        final Object $condition = this.getCondition();
        result = result * PRIME + ($condition == null ? 43 : $condition.hashCode());
        return result;
    }

    public String toString() {
        return "PatientResponse(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", citizenship=" + this.getCitizenship() + ", condition=" + this.getCondition() + ")";
    }

    public static class PatientResponseBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String citizenship;
        private String condition;

        PatientResponseBuilder() {
        }

        public PatientResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PatientResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientResponseBuilder citizenship(String citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public PatientResponseBuilder condition(String condition) {
            this.condition = condition;
            return this;
        }

        public PatientResponse build() {
            return new PatientResponse(this.id, this.firstName, this.lastName, this.citizenship, this.condition);
        }

        public String toString() {
            return "PatientResponse.PatientResponseBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", citizenship=" + this.citizenship + ", condition=" + this.condition + ")";
        }
    }
}
