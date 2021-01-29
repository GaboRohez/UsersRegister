package xyz.gaborohez.usersregister.base;

public interface BaseUIView {
    void showLoader(boolean visible);
    void showAlertDialog(String message);
    void showAlertDialog(int resId);
}
