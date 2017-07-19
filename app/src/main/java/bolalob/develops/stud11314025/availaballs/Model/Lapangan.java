package bolalob.develops.stud11314025.availaballs.Model;


/**
 * Created by Okta on 19/06/2017.
 */

public class Lapangan {
    private Integer idFutsalField;
    private String fieldName;
    private String location;
    private String photo;
    private String phoneNumber;
    private Integer numberOfField;
    private String openingHours;
    private String closingHours;
    private String price;
    private Account account;

    public Lapangan(Integer idFutsalField, String fieldName, String location, String photo, String phoneNumber, Integer numberOfField, String openingHours, String closingHours, String price, Account account) {
        this.idFutsalField = idFutsalField;
        this.fieldName = fieldName;
        this.location = location;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.numberOfField = numberOfField;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.price = price;
        this.account = account;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNumberOfField() {
        return numberOfField;
    }

    public void setNumberOfField(Integer numberOfField) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
