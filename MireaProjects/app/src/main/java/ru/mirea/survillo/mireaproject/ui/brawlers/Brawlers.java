package ru.mirea.survillo.mireaproject.ui.brawlers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Brawlers {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String type;
    public String level;
}
