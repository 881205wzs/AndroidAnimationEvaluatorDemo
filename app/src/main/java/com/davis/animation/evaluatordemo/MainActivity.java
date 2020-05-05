package com.davis.animation.evaluatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.davis.animation.evalutor.BaseEvaluatorMethod;
import com.davis.animation.evalutor.AnimEvaluator;
import com.davis.animation.evalutor.EvaluatorType;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EvaluatorAdapter adapter;
    private View target;

    private DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        listView = (ListView) findViewById(R.id.listview);
        adapter = new EvaluatorAdapter(this);
        listView.setAdapter(adapter);
        target = findViewById(R.id.target);
        drawView = (DrawView) findViewById(R.id.drawview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                drawView.clear();
                EvaluatorType s = (EvaluatorType) view.getTag();
                AnimatorSet set = new AnimatorSet();
                target.setTranslationX(0);
                target.setTranslationY(0);
                set.playTogether(
                        AnimEvaluator.build(s, 1200, ObjectAnimator.ofFloat(target, "translationY", 0, dipToPixels(MainActivity.this, -(160 - 3))), new BaseEvaluatorMethod.OnEvaluatorListener() {
                            @Override
                            public void on(float time, float value, float start, float end, float duration) {
                                drawView.drawPoint(time, duration, value - dipToPixels(MainActivity.this, 60));
                            }
                        })
                );
                set.setDuration(1200);
                set.start();
            }
        });
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }
}
