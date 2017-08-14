package bolalob.develops.stud11314025.availaballs.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class  Account {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("totalField")
    @Expose
    private Integer totalField;

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
}
