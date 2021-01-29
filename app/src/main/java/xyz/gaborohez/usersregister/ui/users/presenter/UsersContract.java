package xyz.gaborohez.usersregister.ui.users.presenter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import xyz.gaborohez.usersregister.base.BaseView;
import xyz.gaborohez.usersregister.data.network.model.UsersEntity;
import xyz.gaborohez.usersregister.data.network.model.UsersResponse;

public interface UsersContract {
    interface View extends BaseView {

        void showUsers(List<UsersEntity> users);

        void emptyUserList();
    }

    interface Presenter {

        void getUsers();
    }

    interface Interactor {

        Single<UsersResponse> getUsers();
    }
}
