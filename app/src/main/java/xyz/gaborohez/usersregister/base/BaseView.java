package xyz.gaborohez.usersregister.base;


public interface BaseView {
    void showLoader(boolean visible);
    void showAlertDialog(String message);
    void showAlertDialog(int resId);
}
