package ru.mirea.survillo.mireaproject.ui.brawlers;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BrawlersDao {
    @Query("SELECT * FROM Brawlers")
    LiveData<List<Brawlers>> getAllBrawlers();
    @Insert
    void insert(Brawlers brawlers);
    @Update
    void update(Brawlers brawlers);
    @Delete
    void delete(Brawlers brawlers);
}
