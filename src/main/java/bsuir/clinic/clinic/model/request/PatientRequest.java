package bsuir.clinic.clinic.model.request;

public class PatientRequest {
    private String firstName;
    private String lastName;
    private String citizenship;
    private String condition;
    private Long cardId;

    public PatientRequest(String firstName, String lastName, String citizenship, String condition, Long cardId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.condition = condition;
        this.cardId = cardId;
    }

    public PatientRequest() {
    }

    public static PatientRequestBuilder builder() {
        return new PatientRequestBuilder();
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

    public Long getCardId() {
        return this.cardId;
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

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PatientRequest)) return false;
        final PatientRequest other = (PatientRequest) o;
        if (!other.canEqual((Object) this)) return false;
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
        final Object this$cardId = this.getCardId();
        final Object other$cardId = other.getCardId();
        if (this$cardId == null ? other$cardId != null : !this$cardId.equals(other$cardId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PatientRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $citizenship = this.getCitizenship();
        result = result * PRIME + ($citizenship == null ? 43 : $citizenship.hashCode());
        final Object $condition = this.getCondition();
        result = result * PRIME + ($condition == null ? 43 : $condition.hashCode());
        final Object $cardId = this.getCardId();
        result = result * PRIME + ($cardId == null ? 43 : $cardId.hashCode());
        return result;
    }

    public String toString() {
        return "PatientRequest(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", citizenship=" + this.getCitizenship() + ", condition=" + this.getCondition() + ", cardId=" + this.getCardId() + ")";
    }

    public static class PatientRequestBuilder {
        private String firstName;
        private String lastName;
        private String citizenship;
        private String condition;
        private Long cardId;

        PatientRequestBuilder() {
        }

        public PatientRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientRequestBuilder citizenship(String citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public PatientRequestBuilder condition(String condition) {
            this.condition = condition;
            return this;
        }

        public PatientRequestBuilder cardId(Long cardId) {
            this.cardId = cardId;
            return this;
        }

        public PatientRequest build() {
            return new PatientRequest(this.firstName, this.lastName, this.citizenship, this.condition, this.cardId);
        }

        public String toString() {
            return "PatientRequest.PatientRequestBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", citizenship=" + this.citizenship + ", condition=" + this.condition + ", cardId=" + this.cardId + ")";
        }
    }
}
