package xyz.gaborohez.usersregister.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse extends BaseResponse {

    @Expose
    @SerializedName("users")
    private List<UsersEntity> users;

    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "users=" + users +
                '}';
    }
}
