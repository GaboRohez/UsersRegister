package xyz.gaborohez.usersregister.ui.users.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.gaborohez.usersregister.R;
import xyz.gaborohez.usersregister.base.BaseFragment;
import xyz.gaborohez.usersregister.base.BasePresenter;
import xyz.gaborohez.usersregister.data.network.model.UsersEntity;
import xyz.gaborohez.usersregister.databinding.FragmentUsersBinding;
import xyz.gaborohez.usersregister.ui.users.adapter.UsersAdapter;
import xyz.gaborohez.usersregister.ui.users.presenter.UsersContract;
import xyz.gaborohez.usersregister.ui.users.presenter.UsersPresenter;

public class UsersFragment extends BaseFragment<UsersContract.Presenter, FragmentUsersBinding> implements UsersContract.View, UsersAdapter.UsersIn {

    private static final String TAG = "UsersFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new UsersPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getUsers();
    }

    @Override
    public void emptyUserList() {
        binding.recycler.setVisibility(View.GONE);
        binding.tvEmptyInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUsers(List<UsersEntity> users) {
        UsersAdapter adapter = new UsersAdapter(getActivity(), users, this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setNestedScrollingEnabled(false);
        binding.recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(UsersEntity user) {
        Log.d(TAG, "showUsers: "+user.toString());
    }
}