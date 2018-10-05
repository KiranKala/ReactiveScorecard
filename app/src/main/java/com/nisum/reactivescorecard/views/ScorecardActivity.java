package com.nisum.reactivescorecard.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.adapters.PlayersAdapter;
import com.nisum.reactivescorecard.databinding.ActivityScorecardBinding;
import com.nisum.reactivescorecard.persistance.dto.Player;
import com.nisum.reactivescorecard.viewmodels.PlayerViewModel;
import com.nisum.reactivescorecard.viewmodels.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class ScorecardActivity extends AppCompatActivity {

    @Inject
    public ViewModelFactory viewModelFactory;
    public PlayerViewModel viewModel;

    @BindView(R.id.et_playername)
    EditText etPlayerName;

    @BindView(R.id.img_save)
    ImageView imgSave;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private PlayersAdapter adapter;

    private ActivityScorecardBinding binding;
    private Unbinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_scorecard);
        binder = ButterKnife.bind(this);

        viewModel        = ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel.class);

        init();
    }

    private void init(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PlayersAdapter(viewModel);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        binding.unbind();
        binder.unbind();
    }

    @Override
    protected void onStart() {
        super.onStart();

        viewModel.subscribePlayersList();
        viewModel.playersResponse().observe(this, updatedPlayersList -> notifyAdapterWith(updatedPlayersList));
    }

    private void notifyAdapterWith(List<Player> updatedPlayersList){
        adapter.submitList(updatedPlayersList);
    }

    public void insertPlayer(View view) {
        if(etPlayerName.getText().toString().length() > 0){
            viewModel.insertPlayerWith(etPlayerName.getText().toString());
            etPlayerName.getText().clear();
        }
        else{
            etPlayerName.setError("Required");
        }
    }
}
