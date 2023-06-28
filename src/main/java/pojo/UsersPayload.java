package pojo;

import java.util.Map;

public class UsersPayload {

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;
    public Map<String, Boolean> getAllowedActions() {
        return allowedActions;
    }

    public void setAllowedActions(Map<String, Boolean> allowedActions) {
        this.allowedActions = allowedActions;
    }

    private Map<String,Boolean> allowedActions;
    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    private String hired;
    public int getTimeZoneGroupId() {
        return timeZoneGroupId;
    }

    public void setTimeZoneGroupId(int timeZoneGroupId) {
        this.timeZoneGroupId = timeZoneGroupId;
    }

    private int timeZoneGroupId;
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    private int departmentId;
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private String middleName;
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    public String getfirstName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;







}
