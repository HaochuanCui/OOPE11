package com.example.oope11.fragments;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.oope11.R;
import com.example.oope11.adapters.PlayerAdapter;
import com.example.oope11.providers.DataProvider;
import com.example.oope11.repositories.PlayerRepository;

public class PlayersFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlayerAdapter adapter;
    private PlayerRepository playerRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        playerRepository = new PlayerRepository();
        DataProvider.createSamplePlayers().forEach(playerRepository::add);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        
        recyclerView = view.findViewById(R.id.playersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        adapter = new PlayerAdapter(playerRepository.getAll());
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.updatePlayers(playerRepository.filter(player ->
                    player.getName().toLowerCase().contains(newText.toLowerCase()) ||
                    player.getTeam().toLowerCase().contains(newText.toLowerCase())
                ));
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}