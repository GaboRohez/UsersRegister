package xyz.gaborohez.usersregister.ui.users.presenter;


import java.net.SocketTimeoutException;

import retrofit2.HttpException;
import xyz.gaborohez.usersregister.app.UsersApp;
import xyz.gaborohez.usersregister.base.BasePresenter;
import xyz.gaborohez.usersregister.constants.AppConstants;
import xyz.gaborohez.usersregister.ui.users.interactor.UsersInteractor;

public class UsersPresenter extends BasePresenter<UsersContract.View> implements UsersContract.Presenter {

    private UsersContract.Interactor interactor;

    public UsersPresenter(UsersContract.View view) {
        super(view);
        interactor = new UsersInteractor();
    }

    @Override
    public void getUsers() {
        addSubscription(interactor.getUsers()
                .doOnSubscribe(disposable -> view.showLoader(true))
                .doAfterTerminate(() -> view.showLoader(false))
                .subscribe(response -> {
                    if (response.getCode().equals(AppConstants.SUCCESS)){
                        if (!response.getUsers().isEmpty())
                            view.showUsers(response.getUsers());
                        else
                            view.emptyUserList();
                    }else {
                        view.showAlertDialog(response.getMessage());
                    }
                }, throwable -> {
                    if (throwable instanceof HttpException) {
                        view.showAlertDialog(handlerError(throwable));
                    } else if (throwable instanceof SocketTimeoutException) {
                        // handle timeout from Retrofit
                        view.showAlertDialog(processError(throwable));
                    }else {
                        view.showAlertDialog(UsersApp.resourcesManager.getErrorServer());
                    }
                }));
    }
}
