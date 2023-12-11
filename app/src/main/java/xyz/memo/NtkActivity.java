package xyz.memo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import xyz.memo.utils.HoverUtils;

public class NtkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntk);

        //Знать наизусть
        RelativeLayout kbhButton = findViewById(R.id.rlKnowByHeart);
        kbhButton.setOnClickListener(view->{
            Intent intent = new Intent(this, KnowByHeartActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(kbhButton);

        //Общая информация
        RelativeLayout aboutButton = findViewById(R.id.rlAbout);
        aboutButton.setOnClickListener(view->{
            Intent intent = new Intent(this, GloryDaysActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(aboutButton);

        //Оружие и нормативы
        RelativeLayout weaponsRegulationsButton = findViewById(R.id.rlWeaponsRegulations);
        weaponsRegulationsButton.setOnClickListener(view->{
            Intent intent = new Intent(this, WeaponsRegulationsActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(weaponsRegulationsButton);

        //Назад
        ImageView ivClose = findViewById(R.id.ivClose);
        ivClose.setOnClickListener(view->{
            super.finish();
        });
        new HoverUtils().setHover(ivClose);

    }
}