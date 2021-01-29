package xyz.gaborohez.usersregister.ui.users.interactor;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.gaborohez.usersregister.data.network.RetrofitClient;
import xyz.gaborohez.usersregister.data.network.WSUserAPI;
import xyz.gaborohez.usersregister.data.network.model.UsersResponse;
import xyz.gaborohez.usersregister.ui.users.presenter.UsersContract;

public class UsersInteractor implements UsersContract.Interactor {

    @Override
    public Single<UsersResponse> getUsers() {
        return RetrofitClient.api()
                .create(WSUserAPI.class)
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
