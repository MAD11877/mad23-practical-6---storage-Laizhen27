package sg.edu.np.mad.practical6;

import java.io.Serializable;

public class User implements Serializable {

    public String Name;
    public String Description;
    public int UserID;
    public static boolean Followed;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public boolean isFollowed() {
        return Followed;
    }

    public void setFollowed(boolean followed) {
        Followed = followed;
    }

    public User(String name, String description, int userID, boolean followed) {
        Name = name;
        Description = description;
        UserID = userID;
        Followed = followed;
    }
}
