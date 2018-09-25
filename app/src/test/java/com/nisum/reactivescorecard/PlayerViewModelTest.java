package com.nisum.reactivescorecard;

import com.nisum.reactivescorecard.persistance.PlayerDataSource;
import com.nisum.reactivescorecard.persistance.dto.Player;
import com.nisum.reactivescorecard.viewmodels.PlayerViewModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class PlayerViewModelTest {

    @Mock
    private PlayerDataSource mDataSource;

    @Captor
    private ArgumentCaptor<Player> mPlayerArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> mPlayerDeleteArgumentCaptor;

    private PlayerViewModel mViewModel;

    private final String PLAYER_NAME = "Playername";
    Player player;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mViewModel = new PlayerViewModel(mDataSource);

        player = new Player(PLAYER_NAME, 100);
    }

    @Test
    public void insertPlayer(){
        mViewModel.insertPlayer(player).test().assertComplete();

        verify(mDataSource).insertPlayer(mPlayerArgumentCaptor.capture());
        assertThat(mPlayerArgumentCaptor.getValue().getName(), Matchers.is(PLAYER_NAME));
    }

    @Test
    public void getPlayers(){
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        when(mDataSource.getPlayers()).thenReturn(Flowable.just(playerList));
        mViewModel.getPlayers().test().assertValueCount(1);
    }


    @Test
    public void updateScore(){
        player.setScore(101);
        mViewModel.updateScore(player).test().assertComplete();

        verify(mDataSource).updateScore(mPlayerArgumentCaptor.capture());
        assertThat(mPlayerArgumentCaptor.getValue().getScore(), Matchers.is(101));
    }

    @Test
    public void deletePlayer(){
        mViewModel.deletePlayer(1).test().assertComplete();

        verify(mDataSource).deletePlayer(mPlayerDeleteArgumentCaptor.capture());
        assertThat(mPlayerDeleteArgumentCaptor.getValue(), Matchers.is(1));
    }
}
