package ru.mirea.survillo.mireaproject.ui.brawlers;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.survillo.mireaproject.R;

public class BrawlersFragment extends Fragment {

    private List<Brawlers> brawlers = new ArrayList<>();
    private BrawlersViewModel brawlersViewModel;
    private BrawlersAdapter brawlersAdapter = new BrawlersAdapter(brawlers);
    private RecyclerView recyclerView;
    private ActivityResultLauncher<Intent> launcher;
    public static final int ADD_CAT_RESULT_CODE=1;
    public static final String NAME_LABEL="name";
    public static final String TYPE_LABEL="type";
    public static final String AGE_LABEL="level";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_brawlers, container, false);

        if (getActivity() != null){
            brawlersViewModel = new ViewModelProvider(getActivity()).
                    get(BrawlersViewModel.class);
            brawlersViewModel.getBrawlersLiveData().observe(getActivity(), this::onChanged);
        }
        view.findViewById(R.id.btnAddBrawl).setOnClickListener(this::onNewBrawlClicked);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.brawlersRecyclerView);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(brawlersAdapter);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result) -> {
                    if (result.getResultCode() == ADD_CAT_RESULT_CODE
                            && result.getData() != null){
                        Brawlers brawler = new Brawlers();
                        brawler.name = result.getData().getStringExtra(NAME_LABEL);
                        brawler.type = result.getData().getStringExtra(TYPE_LABEL);
                        brawler.level = result.getData().getStringExtra(AGE_LABEL);
                        brawlersViewModel.addBrawler(brawler);
                        brawlersAdapter.notifyDataSetChanged();
                    }
                });
        return view;
    }

    public void onChanged(List<Brawlers> brawlerfromDB) {
        if (!brawlers.isEmpty()){
            brawlers.clear();
        }
        brawlers.addAll(brawlerfromDB);
        brawlersAdapter.notifyDataSetChanged();
    }

    private void onNewBrawlClicked(View view){
        Intent intent = new Intent(getActivity(), BrawlersAdd.class);
        launcher.launch(intent);
    }
}