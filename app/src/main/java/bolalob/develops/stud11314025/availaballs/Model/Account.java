package bolalob.develops.stud11314025.availaballs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Okta on 06/07/2017.
 */

public class Account {
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("totalField")
    @Expose
    private Integer totalField;
    @SerializedName("latestUpdate")
    @Expose
    private java.lang.Object latestUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTotalField() {
        return totalField;
    }

    public void setTotalField(Integer totalField) {
        this.totalField = totalField;
    }

    public java.lang.Object getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(java.lang.Object latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

}
