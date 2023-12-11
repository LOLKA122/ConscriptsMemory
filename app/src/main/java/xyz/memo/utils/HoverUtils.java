package xyz.memo.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class HoverUtils {
    @SuppressLint("ClickableViewAccessibility")
    public void setHover(View view){
        view.setOnTouchListener((view1, motionEvent) -> {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                view.animate().scaleX(0.95f).scaleY(0.95f).setInterpolator(new DecelerateInterpolator()).setDuration(50).start();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                new Handler().postDelayed(() -> {
                    view.animate().scaleX(1f).scaleY(1f).setInterpolator(new DecelerateInterpolator()).start();
                }, 50);
        }
        return false;
        });
    }
}
