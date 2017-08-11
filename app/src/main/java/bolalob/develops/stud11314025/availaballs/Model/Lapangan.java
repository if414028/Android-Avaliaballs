package bolalob.develops.stud11314025.availaballs.Model;

import android.accounts.Account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lapangan {

    @SerializedName("idFutsalField")
    @Expose
    private Integer idFutsalField;
    @SerializedName("fieldName")
    @Expose
    private String fieldName;
    @SerializedName("location")
    @Expose
    private String location;



    public Integer getIdFutsalField() {
        return idFutsalField;
    }

    public void setIdFutsalField(Integer idFutsalField) {
        this.idFutsalField = idFutsalField;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
