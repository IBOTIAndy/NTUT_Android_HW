package com.gameusingdynamicfragment;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment {

    public enum GameResultType {
        TYPE_1, HIDE
    }

    // 所屬的 Activity 必須實作以下介面中的callback方法
    public interface CallbackInterface {
        public void updateGameResult(int iCountSet,
                                     int iCountPlayerWin,
                                     int iCountComWin,
                                     int iCountDraw);
        public void enableGameResult(GameResultType type);
    };

    private CallbackInterface mCallback;

    private ImageButton mImgBtnDice;
    private TextView mTxtResult;
/*
    public EditText mEdtCountSet,
                    mEdtCountPlayerWin,
                    mEdtCountComWin,
                    mEdtCountDraw;
*/

    private Integer[] diceStatus = {
            R.drawable.dice01, R.drawable.dice02,
            R.drawable.dice03, R.drawable.dice04,
            R.drawable.dice05, R.drawable.dice06
    };

    // 新增統計遊戲局數和輸贏的變數
    private int miCountSet = 0,
                miCountPlayerWin = 0,
                miCountComWin = 0,
                miCountDraw = 0;

    private Button mBtnShowResult1,
                    mBtnHiddenResult;

    private boolean mbShowResult = false;

//    private final static String TAG = "Result";
//    private int mTagCount = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (CallbackInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    "must implement GameFragment.CallbackInterface.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 利用inflater物件的inflate()方法取得介面佈局檔，並將最後的結果傳回給系統
       return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 必須先呼叫getView()取得程式畫面物件，然後才能呼叫它的
        // findViewById()取得介面物件
        mTxtResult = (TextView) getView().findViewById(R.id.txtResult);
        mImgBtnDice = (ImageButton) getView().findViewById(R.id.imgBtnDice);

        // 以下介面元件是在另一個Fragment中，因此必須呼叫所屬的Activity
        // 才能取得這些介面元件
/*
        mEdtCountSet = (EditText) getActivity().findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText) getActivity().findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText) getActivity().findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText) getActivity().findViewById(R.id.edtCountDraw);
*/

        mImgBtnDice = (ImageButton) getView().findViewById(R.id.imgBtnDice);
        mBtnShowResult1 = (Button) getView().findViewById(R.id.btnShowResult1);
        mBtnHiddenResult = (Button) getView().findViewById(R.id.btnHiddenResult);

        mImgBtnDice.setOnClickListener(imgBtnDiceOnClick);
        mBtnShowResult1.setOnClickListener(btnShowResult1OnClick);
        mBtnHiddenResult.setOnClickListener(btnHiddenResultOnClick);
    }

    private void throwDice() {
        // 全部局數 +1
        miCountSet++;

        // 骰子擲出來的點數
        int score = (int)(Math.random() * 6 + 1);

        // 顯示擲出來的圖
        mImgBtnDice.setImageDrawable(getResources().getDrawable(diceStatus[score - 1]));

        // 5、6 是電腦贏
        if (score >= 5) {
            // 電腦贏 +1
            miCountComWin++;
            mTxtResult.setText(getString(R.string.player_lose));
        }
        // 3、4 是平手
        else if (score >= 3) {
            // 平手 +1
            miCountDraw++;
            mTxtResult.setText(getString(R.string.player_draw));
        }
        // 1、2 是玩家贏
        else {
            // 玩家贏 +1
            miCountPlayerWin++;
            mTxtResult.setText(getString(R.string.player_win));
        }

        // 要把結果傳回去
        mCallback.updateGameResult(miCountSet, miCountPlayerWin, miCountComWin, miCountDraw);
    }

    private View.OnClickListener imgBtnDiceOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // 取得動畫
            final AnimationDrawable animation = (AnimationDrawable) getResources().getDrawable(R.drawable.anim_roll_dice);
            // 設定顯示動畫
            mImgBtnDice.setImageDrawable(animation);
            // 動畫開始
            animation.start();
            // 宣告 Handler
            Handler handler = new Handler();
            // 一秒鐘後停止動畫且擲出點數
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animation.stop();
                    throwDice();
                }
            }, 1000);
        }
    };

    private View.OnClickListener btnShowResult1OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.TYPE_1);
        }
    };

    private View.OnClickListener btnHiddenResultOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.HIDE);
        }
    };

}
