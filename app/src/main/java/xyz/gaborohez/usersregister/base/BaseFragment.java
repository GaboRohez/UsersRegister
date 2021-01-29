package xyz.gaborohez.usersregister.base;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * Helper class for Viewer based on MVP pattern and View Binding
 *
 * @param <T> - Presenter Class </T>
 * @param <B> - ViewBinding Class </B>
 */

public abstract class BaseFragment<T, B> extends Fragment implements BaseView{

    protected T presenter;
    protected B binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroy() {

        if (binding != null) {
            binding = null;
        }

        if (presenter != null) {
            ((BasePresenter) presenter).detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoader(boolean visible) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showLoader(visible);
        }
    }

    @Override
    public void showAlertDialog(String message) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showAlertDialog(message);
        }
    }

    @Override
    public void showAlertDialog(int resId) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showAlertDialog(resId);
        }
    }

    protected void addFragmentInParentActivity(Fragment fragment, String tag, int id) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).addFragment(fragment, tag, id);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
    }

}