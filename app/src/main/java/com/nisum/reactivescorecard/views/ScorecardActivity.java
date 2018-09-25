package com.nisum.reactivescorecard.views;

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

import com.nisum.reactivescorecard.Injection;
import com.nisum.reactivescorecard.R;
import com.nisum.reactivescorecard.databinding.ActivityScorecardBinding;
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


    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @BindView(R.id.et_playername)
    EditText etPlayerName;

    @BindView(R.id.img_save)
    ImageView imgSave;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private List<Player> players = new ArrayList<>();
    private PlayersAdapter adapter;

    private ActivityScorecardBinding binding;
    private Unbinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_scorecard);
        binder = ButterKnife.bind(this);
        viewModelFactory = Injection.provideViewModelFactory(this);
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

        mDisposable.clear();
        binding.unbind();
        binder.unbind();
    }

    @Override
    protected void onStart() {
        super.onStart();
        subscribePlayersList();
    }

    private void subscribePlayersList(){
        mDisposable.add(viewModel.getPlayers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(playersList -> {
                    List<Player> list = new ArrayList<>();
                    list.addAll(playersList);
                    adapter.submitList(list);
                }, throwable -> Log.e("Get Players", "Unable to retrieve players", throwable)));
    }

    public void insertPlayer(View view){
        imgSave.setEnabled(false);
        mDisposable.add(viewModel.insertPlayer(new Player(etPlayerName.getText().toString(), 0))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    imgSave.setEnabled(true);
                    etPlayerName.getText().clear();
                }, throwable -> Log.e("Insert Player", "Unable to insert Player", throwable))
        );
    }
}
