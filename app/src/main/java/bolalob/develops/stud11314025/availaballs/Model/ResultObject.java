package bolalob.develops.stud11314025.availaballs.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultObject {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("totalPage")
    @Expose
    private Integer totalPage;
//    @SerializedName("object")
//    @Expose
//    private Lapangan object;

//    public Lapangan getObject() {
//        return object;
//    }
//
//    public void setObject(Lapangan object) {
//        this.object = object;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
