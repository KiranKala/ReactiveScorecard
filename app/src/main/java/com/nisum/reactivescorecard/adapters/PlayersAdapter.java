package com.nisum.reactivescorecard.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.databinding.RowBinding;
import com.nisum.reactivescorecard.persistance.dto.Player;
import com.nisum.reactivescorecard.viewmodels.PlayerViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PlayersAdapter extends ListAdapter<Player, PlayersAdapter.ViewHolder> {

    PlayerViewModel viewModel;
    public PlayersAdapter(PlayerViewModel viewModel) {
        super(Player.DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowBinding binding = DataBindingUtil.inflate(inflater, R.layout.row, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Player player = getItem(position);

        viewHolder.binding.setPlayer(player);
        viewHolder.binding.imgDown.setOnClickListener(view -> updateScore(player, false));
        viewHolder.binding.imgUp.setOnClickListener(view -> updateScore(player, true));
        viewHolder.binding.imgDelete.setOnClickListener(view -> deletePlayer(player.getId()));
    }


    private void updateScore(Player player, boolean isAdd){
        player.setScore(isAdd ? (player.getScore()+1) : (player.getScore()-1));

        viewModel.updateScore(player)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.e("Update Player", "Player updation completed"));
    }

    public void deletePlayer(int playerId){
        viewModel.deletePlayer(playerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.e("Delete Player", "Player deletion completed"));
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final RowBinding binding;

        public ViewHolder(final RowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
