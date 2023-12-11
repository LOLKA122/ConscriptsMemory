package xyz.memo;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.json.JSONException;
import org.json.JSONObject;

import xyz.memo.utils.HoverUtils;
import xyz.memo.utils.RankDataGenerator;

public class CheckYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_yourself);

        //Назад
        ImageView ivClose = findViewById(R.id.ivClose);
        ivClose.setOnClickListener(view-> super.finish());
        new HoverUtils().setHover(ivClose);

        loadLevel();
    }

    private void loadLevel(){
        TextView tvA1 = findViewById(R.id.tvA1);
        TextView tvA2 = findViewById(R.id.tvA2);
        TextView tvA3 = findViewById(R.id.tvA3);
        TextView tvA4 = findViewById(R.id.tvA4);
        RelativeLayout rlA1 = findViewById(R.id.rlA1);
        RelativeLayout rlA2 = findViewById(R.id.rlA2);
        RelativeLayout rlA3 = findViewById(R.id.rlA3);
        RelativeLayout rlA4 = findViewById(R.id.rlA4);

        new HoverUtils().setHover(rlA1);
        new HoverUtils().setHover(rlA2);
        new HoverUtils().setHover(rlA3);
        new HoverUtils().setHover(rlA4);

        try {
            JSONObject rankObject = new RankDataGenerator().generate();

            ImageView ivRank = findViewById(R.id.ivRank);
            ivRank.setImageResource(rankObject.getInt("res"));

            int correctAnswer = rankObject.getInt("correct");

            tvA1.setText(rankObject.getString("1"));
            if(correctAnswer == 1) rlA1.setOnClickListener(view -> setCorrect(tvA1)); else rlA1.setOnClickListener(view -> setIncorrect(tvA1));

            tvA2.setText(rankObject.getString("2"));
            if(correctAnswer == 2) rlA2.setOnClickListener(view -> setCorrect(tvA2)); else rlA2.setOnClickListener(view -> setIncorrect(tvA2));

            tvA3.setText(rankObject.getString("3"));
            if(correctAnswer == 3) rlA3.setOnClickListener(view -> setCorrect(tvA3)); else rlA3.setOnClickListener(view -> setIncorrect(tvA3));

            tvA4.setText(rankObject.getString("4"));
            if(correctAnswer == 4) rlA4.setOnClickListener(view -> setCorrect(tvA4)); else rlA4.setOnClickListener(view -> setIncorrect(tvA4));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    private void setIncorrect(TextView tv){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.shake);
        tv.startAnimation(anim);
        tv.setTextColor(ContextCompat.getColor(this, R.color.red));
        new Handler().postDelayed(() -> tv.setTextColor(ContextCompat.getColor(this, R.color.black)), 180);
    }

    private void setCorrect(TextView tv){
        tv.setTextColor(ContextCompat.getColor(this, R.color.green));
        new Handler().postDelayed(()->{
            loadLevel();
            tv.setTextColor(ContextCompat.getColor(this, R.color.black));
        }, 180);
    }

}