package pojo;

import java.util.Map;

public class verify {
    private String username;
    private boolean active;
    private String firstName;

    private String middleName;

    private int departmentId;
    private int timeZoneGroupId;
    private String hired;
    private String email;
    private Map<String,Boolean> allowedActions;

    private String fullName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getTimeZoneGroupId() {
        return timeZoneGroupId;
    }

    public void setTimeZoneGroupId(int timeZoneGroupId) {
        this.timeZoneGroupId = timeZoneGroupId;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Boolean> getAllowedActions() {
        return allowedActions;
    }

    public void setAllowedActions(Map<String, Boolean> allowedActions) {
        this.allowedActions = allowedActions;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
