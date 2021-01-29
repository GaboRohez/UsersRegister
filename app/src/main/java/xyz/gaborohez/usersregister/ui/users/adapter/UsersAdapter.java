package xyz.gaborohez.usersregister.ui.users.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import xyz.gaborohez.usersregister.R;
import xyz.gaborohez.usersregister.constants.AppConstants;
import xyz.gaborohez.usersregister.data.network.model.UsersEntity;
import xyz.gaborohez.usersregister.databinding.ItemPersonBinding;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private static final String TAG = "UsersAdapter";

    private Context context;
    private List<UsersEntity> list;
    private UsersIn listener;

    public interface UsersIn{
        void onItemClick(UsersEntity user);
    }

    public UsersAdapter(Context context, List<UsersEntity> list, UsersIn listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemPersonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list.get(position).getImage() != null){
            Log.d(TAG, "onBindViewHolder: "+AppConstants.BASE_IMAGE_URL+list.get(position).getImage());

            Glide.with(context).load(AppConstants.BASE_IMAGE_URL+list.get(position).getImage()).placeholder(android.R.drawable.progress_indeterminate_horizontal).error(android.R.drawable.stat_notify_error).into(holder.binding.ivProfile);
        }

        holder.binding.tvNick.setText(String.format(context.getString(R.string.nickname), list.get(position).getNick()));
        holder.binding.tvEmail.setText(list.get(position).getEmail());
        holder.binding.tvName.setText(String.format(context.getString(R.string.user_name), list.get(position).getName(), list.get(position).getSurname()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemPersonBinding binding;

        public ViewHolder(ItemPersonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
