package ru.mirea.survillo.mireaproject.ui.story;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.survillo.mireaproject.ui.brawlers.Brawlers;
import ru.mirea.survillo.mireaproject.ui.brawlers.BrawlersDao;

@Database(entities = {Story.class, Brawlers.class}, version = 3)
public abstract class AppDatebase extends RoomDatabase{
    public abstract StoryDao storyDao();
    public abstract BrawlersDao brawlersDao();
}
