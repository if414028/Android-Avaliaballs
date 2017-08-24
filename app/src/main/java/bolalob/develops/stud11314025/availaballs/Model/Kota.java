package bolalob.develops.stud11314025.availaballs.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Voldarex on 8/23/2017.
 */

public class Kota extends RealmObject {

    @PrimaryKey
    private int id;

    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
