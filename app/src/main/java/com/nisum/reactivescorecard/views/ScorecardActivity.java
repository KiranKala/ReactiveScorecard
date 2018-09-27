package com.nisum.reactivescorecard.views;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.databinding.ActivityScorecardBinding;
import com.nisum.reactivescorecard.di.ContextModule;
import com.nisum.reactivescorecard.di.DaggerScorecardComponent;
import com.nisum.reactivescorecard.di.ScorecardComponent;
import com.nisum.reactivescorecard.persistance.dto.Player;
import com.nisum.reactivescorecard.adapters.PlayersAdapter;
import com.nisum.reactivescorecard.viewmodels.PlayerViewModel;
import com.nisum.reactivescorecard.viewmodels.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ScorecardActivity extends AppCompatActivity {

    private ViewModelFactory viewModelFactory;
    private PlayerViewModel viewModel;

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
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_scorecard);
        binder = ButterKnife.bind(this);

        ScorecardComponent component = DaggerScorecardComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        viewModelFactory = component.getViewModelFactory();
        viewModel        = ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel.class);

        init();
    }

    private void init(){
        recyclerView.setHasFixedSize(true);
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
