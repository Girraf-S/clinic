package bsuir.clinic.clinic.entity.cache;

import bsuir.clinic.clinic.entity.enums.Specialization;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Doctor")
public class DoctorCache implements Serializable {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String numberOfJobOffer;
    private Specialization specialization;

    DoctorCache(Long id, String firstName, String lastName, String numberOfJobOffer, Specialization specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfJobOffer = numberOfJobOffer;
        this.specialization = specialization;
    }

    public static DoctorCacheBuilder builder() {
        return new DoctorCacheBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DoctorCache)) return false;
        final DoctorCache other = (DoctorCache) o;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DoctorCache;
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
        return result;
    }

    public String toString() {
        return "DoctorCache(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", numberOfJobOffer=" + this.getNumberOfJobOffer() + ", specialization=" + this.getSpecialization() + ")";
    }

    public static class DoctorCacheBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String numberOfJobOffer;
        private Specialization specialization;

        DoctorCacheBuilder() {
        }

        public DoctorCacheBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DoctorCacheBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DoctorCacheBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DoctorCacheBuilder numberOfJobOffer(String numberOfJobOffer) {
            this.numberOfJobOffer = numberOfJobOffer;
            return this;
        }

        public DoctorCacheBuilder specialization(Specialization specialization) {
            this.specialization = specialization;
            return this;
        }

        public DoctorCache build() {
            return new DoctorCache(this.id, this.firstName, this.lastName, this.numberOfJobOffer, this.specialization);
        }

        public String toString() {
            return "DoctorCache.DoctorCacheBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", numberOfJobOffer=" + this.numberOfJobOffer + ", specialization=" + this.specialization + ")";
        }
    }
}
