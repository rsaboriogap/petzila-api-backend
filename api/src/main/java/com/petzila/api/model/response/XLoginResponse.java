package com.petzila.api.model.response;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class XLoginResponse extends XResponse {
    public static final class XData {
        private String id;
        private String temporalPassword;
        private String email;
        private String firstName;
        private String lastName;
        private String description;
        private String username;
        private String petsCount;
        private String token;
        private String renewToken;
        private String notificationCount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTemporalPassword() {
            return temporalPassword;
        }

        public void setTemporalPassword(String temporalPassword) {
            this.temporalPassword = temporalPassword;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPetsCount() {
            return petsCount;
        }

        public void setPetsCount(String petsCount) {
            this.petsCount = petsCount;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRenewToken() {
            return renewToken;
        }

        public void setRenewToken(String renewToken) {
            this.renewToken = renewToken;
        }

        public String getNotificationCount() {
            return notificationCount;
        }

        public void setNotificationCount(String notificationCount) {
            this.notificationCount = notificationCount;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("temporalPassword", temporalPassword)
                    .add("email", email)
                    .add("firstName", firstName)
                    .add("lastName", lastName)
                    .add("description", description)
                    .add("username", username)
                    .add("petsCount", petsCount)
                    .add("token", token)
                    .add("renewToken", renewToken)
                    .add("notificationCount", notificationCount)
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
