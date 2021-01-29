package xyz.gaborohez.usersregister.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import xyz.gaborohez.usersregister.data.network.model.UsersResponse;

public interface WSUserAPI {

    @GET("users")
    Single<UsersResponse> getUsers();
}
