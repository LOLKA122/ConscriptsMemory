package xyz.memo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import xyz.memo.utils.HoverUtils;

public class PhysicalActivity extends AppCompatActivity {

    int pullUpsScore = 0;
    int liftingScore = 0;
    int pushUpsScore = 0;
    int run1000Score = 0;
    int run100Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_activity);

        //Информация
        RelativeLayout rlInfo = findViewById(R.id.rlInfo);
        rlInfo.setOnClickListener(view->showAlertDialog());
        new HoverUtils().setHover(rlInfo);

        //Назад
        ImageView ivClose = findViewById(R.id.ivClose);
        ivClose.setOnClickListener(view->{
            super.finish();
        });
        new HoverUtils().setHover(ivClose);

        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = scrollView.getScrollY();

                if (scrollY == 0) {
                    ivClose.setVisibility(View.VISIBLE);
                    rlInfo.setVisibility(View.VISIBLE);
                } else {
                    ivClose.setVisibility(View.GONE);
                    rlInfo.setVisibility(View.GONE);
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("SAVE", MODE_PRIVATE);

        //Подтягивания
        EditText etPullUps = findViewById(R.id.etPullUps);
        etPullUps.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String newText = editable.toString();
                if(newText.equals("")) pullUpsScore = 0;
                try {
                    int x = Integer.parseInt(newText);
                    if(x >= 30) pullUpsScore = 100;
                    if(x <= 29 && x >= 20) pullUpsScore = 80;
                    if(x <= 19 && x >= 12) pullUpsScore = 60;
                    if(x <= 11 && x >= 7) pullUpsScore = 40;
                    if(x <= 6 && x >= 2) pullUpsScore = 20;
                    if(x < 2) pullUpsScore = 0;
                }catch (Exception ignored){}
                sharedPreferences.edit().putString("pullUps", newText).apply();
                countScore();
            }
        });

        //Подъемы с переворотом
        EditText etLifting = findViewById(R.id.etLifting);
        etLifting.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String newText = editable.toString();
                if(newText.equals("")) liftingScore = 0;
                try {
                    int x = Integer.parseInt(newText);
                    if(x >= 32) liftingScore = 100;
                    if(x <= 31 && x >= 14) liftingScore = 80;
                    if(x <= 13 && x >= 8) liftingScore = 60;
                    if(x <= 7 && x >= 4) liftingScore = 40;
                    if(x <= 3 && x >= 1) liftingScore = 20;
                    if(x < 1) liftingScore = 0;
                }catch (Exception ignored){}
                sharedPreferences.edit().putString("lifting", newText).apply();
                countScore();
            }
        });

        //Отжимания
        EditText etPushUps = findViewById(R.id.etPushUps);
        etPushUps.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String newText = editable.toString();
                if(newText.equals("")) pushUpsScore = 0;
                try {
                    int x = Integer.parseInt(newText);
                    if(x >= 75) pushUpsScore = 100;
                    if(x <= 74 && x >= 55) pushUpsScore = 80;
                    if(x <= 54 && x >= 40) pushUpsScore = 60;
                    if(x <= 39 && x >= 30) pushUpsScore = 40;
                    if(x <= 29 && x >= 20) pushUpsScore = 20;
                    if(x < 20) pushUpsScore = 0;
                }catch (Exception ignored){}
                sharedPreferences.edit().putString("pushUps", newText).apply();
                countScore();
            }
        });

        //Отжимания
        EditText etRun1000 = findViewById(R.id.etRun1000);
        etRun1000.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String newText = editable.toString().replace(",", ".");
                if(newText.equals("")) run1000Score = 0;
                try {
                    float x = Float.parseFloat(newText);
                    if(x > 5.10f) run1000Score = 0;
                    if(x >= 3.48f && x <= 5.10f) run1000Score = 20;
                    if(x >= 3.31f && x <= 3.47f) run1000Score = 40;
                    if(x >= 3.16f && x <= 3.30f) run1000Score = 60;
                    if(x >= 2.56f && x <= 3.15f) run1000Score = 80;
                    if(x <= 2.55f) run1000Score = 100;
                }catch (Exception ignored){}
                sharedPreferences.edit().putString("run1000", newText).apply();
                countScore();
            }
        });

        //Отжимания
        EditText etRun100 = findViewById(R.id.etRun100);
        etRun100.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String newText = editable.toString().replace(",", ".");
                if(newText.equals("")) run100Score = 0;
                try {
                    float x = Float.parseFloat(newText);
                    if(x > 16.7f) run100Score = 0;
                    if(x >= 14.5f && x <= 16.7f) run100Score = 20;
                    if(x >= 13.7f && x <= 14.4f) run100Score = 40;
                    if(x >= 12.9f && x <= 13.6f) run100Score = 60;
                    if(x >= 11.9f && x <= 12.8f) run100Score = 80;
                    if(x <= 11.8f) run100Score = 100;
                }catch (Exception ignored){}
                sharedPreferences.edit().putString("run100", newText).apply();
                countScore();
            }
        });

        String pullUps = sharedPreferences.getString("pullUps", "");
        String lifting = sharedPreferences.getString("lifting", "");
        String pushUps = sharedPreferences.getString("pushUps", "");
        String run1000 = sharedPreferences.getString("run1000", "");
        String run100 = sharedPreferences.getString("run100", "");

        etPullUps.setText(pullUps);
        etLifting.setText(lifting);
        etPushUps.setText(pushUps);
        etRun1000.setText(run1000);
        etRun100.setText(run100);

    }

    private void countScore(){
        TextView tvScore = findViewById(R.id.tvResult);
        tvScore.setText(String.valueOf(pullUpsScore+liftingScore+pushUpsScore+run100Score+run1000Score));
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Информация")
                .setMessage("В первых пяти таблицах верхняя строка это баллы, нижняя это кол-во раз (норматив).");
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}