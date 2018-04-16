package com.galleryusingviewanimation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;

    private Integer[] miImgArr = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08, R.drawable.img09,
            R.drawable.img10, R.drawable.img11, R.drawable.img12};

    private Integer[] miThumbImgArr = {
            R.drawable.img01th, R.drawable.img02th, R.drawable.img03th,
            R.drawable.img04th, R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th, R.drawable.img09th,
            R.drawable.img10th, R.drawable.img11th, R.drawable.img12th};

    private Animation[] animationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);

        mImgSwitcher.setFactory(this);	// 主程式類別必須implements ViewSwitcher.ViewFactory
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        ImageAdapter imgAdap = new ImageAdapter(this, miThumbImgArr);

        initAnimation();

        mGridView = (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);
        mGridView.setOnItemClickListener(gridViewOnItemClick);
    }

    private void initAnimation() {
        ScaleAnimation scale;
        TranslateAnimation trans;
        RotateAnimation rotate;

        // alphaIn
        AlphaAnimation alphaIn = new AlphaAnimation(0f, 1f);
        alphaIn.setInterpolator(new LinearInterpolator());
        alphaIn.setDuration(1000);

        // alphaOut
        AlphaAnimation alphaOut = new AlphaAnimation(1f, 0f);
        alphaOut.setInterpolator(new LinearInterpolator());
        alphaOut.setDuration(1000);

        // scale_rotate_in
        AnimationSet scaleRotateIn = new AnimationSet(false);
        scale = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(1000);
        scale.setDuration(1000);
        rotate = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setStartOffset(1000);
        rotate.setDuration(1000);
        scaleRotateIn.addAnimation(scale);
        scaleRotateIn.addAnimation(rotate);

        // scale_rotate_out
        AnimationSet scaleRotateOut = new AnimationSet(false);
        scale = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setDuration(1000);
        rotate = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setDuration(1000);
        scaleRotateOut.addAnimation(scale);
        scaleRotateOut.addAnimation(rotate);

        // scale_rotate_trans_in
        AnimationSet scaleRotateTransIn = new AnimationSet(false);
        scale = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(1000);
        scale.setDuration(1000);
        rotate = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setStartOffset(1000);
        rotate.setDuration(1000);
        trans = new TranslateAnimation(0, 0, -500, 0);
        trans.setInterpolator(new LinearInterpolator());
        trans.setStartOffset(1000);
        trans.setDuration(1000);
        scaleRotateTransIn.addAnimation(scale);
        scaleRotateTransIn.addAnimation(rotate);
        scaleRotateTransIn.addAnimation(trans);

        // scale_rotate_trans_out
        AnimationSet scaleRotateTransOut = new AnimationSet(false);
        scale = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setDuration(1000);
        rotate = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setDuration(1000);
        trans = new TranslateAnimation(0, 0, 0, 500);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(1000);
        scaleRotateTransOut.addAnimation(scale);
        scaleRotateTransOut.addAnimation(rotate);
        scaleRotateTransOut.addAnimation(trans);

        // trans_in
        AnimationSet transIn = new AnimationSet(false);
        trans = new TranslateAnimation(0, 0, -1000, 0);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(1000);
        transIn.addAnimation(trans);

        // trans_out
        AnimationSet transOut = new AnimationSet(false);
        trans = new TranslateAnimation(0, 0, 0, 300);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(1000);
        transOut.addAnimation(trans);

        animationList = new Animation[]{
                alphaIn,
                alphaOut,
                scaleRotateIn,
                scaleRotateOut,
                scaleRotateTransIn,
                scaleRotateTransOut,
                transIn,
                transOut
        };
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }


    private AdapterView.OnItemClickListener gridViewOnItemClick = new
            AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent,
                                        View v,
                                        int position,
                                        long id) {

                    int rand = (int)(Math.random() * 4 + 1);

                    mImgSwitcher.setInAnimation(animationList[rand * 2]);
                    mImgSwitcher.setOutAnimation(animationList[rand * 2 + 1]);

                    mImgSwitcher.setImageResource(miImgArr[position]);
                }
            };
}
