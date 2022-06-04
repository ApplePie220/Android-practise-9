package ru.mirea.survillo.mireaproject.ui.brawlers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.survillo.mireaproject.ui.App;
import ru.mirea.survillo.mireaproject.ui.story.AppDatebase;

public class BrawlersViewModel extends ViewModel {
    private final LiveData<List<Brawlers>> brawlers;
    private final AppDatebase appDatabase = App.instance.getDatabase();
    private final BrawlersDao brawlersDao = appDatabase.brawlersDao();

    public BrawlersViewModel(){
        brawlers = brawlersDao.getAllBrawlers();
    }

    public void addBrawler(Brawlers brawl){
        brawlersDao.insert(brawl);
    }

    public LiveData<List<Brawlers>> getBrawlersLiveData(){
        return brawlers;
    }
    public List<Brawlers> getBrawlers(){
        return brawlers.getValue();
    }
}
