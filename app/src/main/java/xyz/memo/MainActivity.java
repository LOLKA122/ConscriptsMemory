package xyz.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import xyz.memo.utils.HoverUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Нужно знать
        RelativeLayout ntkButton = findViewById(R.id.rlNtk);
        ntkButton.setOnClickListener(view->{
            Intent intent = new Intent(this, NtkActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(ntkButton);

        //Физ подготовка
        RelativeLayout physicalActivityButton = findViewById(R.id.rlPhysicalTraining);
        physicalActivityButton.setOnClickListener(view->{
            Intent intent = new Intent(this, PhysicalActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(physicalActivityButton);

        //Проверь себя
        RelativeLayout checkYourselfButton = findViewById(R.id.rlCheckYourself);
        checkYourselfButton.setOnClickListener(view->{
            Intent intent = new Intent(this, CheckYourselfActivity.class);
            startActivity(intent);
        });
        new HoverUtils().setHover(checkYourselfButton);

    }
}