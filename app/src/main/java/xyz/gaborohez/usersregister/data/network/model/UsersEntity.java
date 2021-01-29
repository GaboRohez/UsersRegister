package xyz.gaborohez.usersregister.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersEntity {

    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("nick")
    private String nick;
    @Expose
    @SerializedName("surname")
    private String surname;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("_id")
    private String _id;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "created_at='" + created_at + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", nick='" + nick + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
