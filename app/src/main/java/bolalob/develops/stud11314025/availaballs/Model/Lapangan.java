package bolalob.develops.stud11314025.availaballs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lapangan {

    @SerializedName("idFutsalField")
    @Expose
    private int idFutsalField;
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
    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    public Lapangan(){

    }

    public Lapangan(int idFutsalField, String fieldName, String location, String detailLocation, String numberOfField, String openingHours, String closingHours, String phone, String price, String account, String days, String latitude, String longitude) {
        this.idFutsalField = idFutsalField;
        this.fieldName = fieldName;
        this.location = location;
        this.detailLocation = detailLocation;
        this.numberOfField = numberOfField;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.phone = phone;
        this.price = price;
        this.account = account;
        this.days = days;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdFutsalField() {
        return idFutsalField;
    }

    public void setIdFutsalField(int idFutsalField) {
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
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

    @Override
    public String toString() {
        return "Lapangan{" +
                "idFutsalField=" + idFutsalField +
                ", fieldName='" + fieldName + '\'' +
                ", location='" + location + '\'' +
                ", detailLocation='" + detailLocation + '\'' +
                ", numberOfField='" + numberOfField + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", closingHours='" + closingHours + '\'' +
                ", phone='" + phone + '\'' +
                ", price='" + price + '\'' +
                ", account='" + account + '\'' +
                ", days='" + days + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
