package com.petzila.api.model.response;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public final class XSignUpResponse extends XResponse {
    public static final class XData {
        private String id;
        private boolean temporal;
        private String email;
        private String firstName;
        private String lastName;
        private String description;
        private String profilePicture;
        private String username;
        private String status;
        private String createdAt;
        private String updatedAt;
        private long followingCount;
        private List<Long> following;
        private List<Long> petsCount;
        private List<Long> pets;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isTemporal() {
            return temporal;
        }

        public void setTemporal(boolean temporal) {
            this.temporal = temporal;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public long getFollowingCount() {
            return followingCount;
        }

        public void setFollowingCount(long followingCount) {
            this.followingCount = followingCount;
        }

        public List<Long> getFollowing() {
            return following;
        }

        public void setFollowing(List<Long> following) {
            this.following = following;
        }

        public List<Long> getPetsCount() {
            return petsCount;
        }

        public void setPetsCount(List<Long> petsCount) {
            this.petsCount = petsCount;
        }

        public List<Long> getPets() {
            return pets;
        }

        public void setPets(List<Long> pets) {
            this.pets = pets;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("temporal", temporal)
                    .add("email", email)
                    .add("firstName", firstName)
                    .add("lastName", lastName)
                    .add("description", description)
                    .add("profilePicture", profilePicture)
                    .add("username", username)
                    .add("status", status)
                    .add("createdAt", createdAt)
                    .add("updatedAt", updatedAt)
                    .add("followingCount", followingCount)
                    .add("petsCount", petsCount)
                    .add("pets", pets)
                    .toString();
        }
    }

    private XData data = new XData();

    public XData getData() {
        return data;
    }

    public void setData(XData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("data", data)
                .toString();
    }
}
