package ru.mirea.survillo.mireaproject.ui.brawlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.survillo.mireaproject.MainActivity;
import ru.mirea.survillo.mireaproject.R;
import ru.mirea.survillo.mireaproject.ui.App;
import ru.mirea.survillo.mireaproject.ui.story.AppDatebase;

public class BrawlersAdd extends AppCompatActivity {
    private EditText brawName;
    private EditText brawType;
    private EditText brawLevel;
    private Button button;

    private AppDatebase db;
    private BrawlersDao brawlerDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brawlers_view);

        db = App.getInstance().getDatabase();
        brawlerDao = db.brawlersDao();

        brawName = findViewById(R.id.editNameBrawl);
        brawType = findViewById(R.id.edittypeBrawl);
        brawLevel = findViewById(R.id.editLevelBrawl);

        button = findViewById(R.id.btnSaveBrawl);
        button.setOnClickListener(this::saveBtn);
    }

    public void saveBtn(View view) {

        Brawlers brawl = new Brawlers();
        brawl.name = brawName.getText().toString();
        brawl.type = brawType.getText().toString();
        brawl.level = brawLevel.getText().toString();

        brawlerDao.insert(brawl);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
