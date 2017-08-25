package bolalob.develops.stud11314025.availaballs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Voldarex on 8/24/2017.
 */

public class LocationByMap {
    @SerializedName("idFutsalField")
    @Expose
    private Integer idFutsalField;
    @SerializedName("fieldName")
    @Expose
    private String fieldName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("detailLocation")
    @Expose
    private String detailLocation;
    @SerializedName("numberOfField")
    @Expose
    private String numberOfField;
    @SerializedName("openingHours")
    @Expose
    private String openingHours;
    @SerializedName("closingHours")
    @Expose
    private String closingHours;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("latestUpdate")
    @Expose
    private String latestUpdate;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

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

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getNumberOfField() {
        return numberOfField;
    }

    public void setNumberOfField(String numberOfField) {
        this.numberOfField = numberOfField;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
