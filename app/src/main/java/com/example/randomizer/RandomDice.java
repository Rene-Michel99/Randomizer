package com.example.randomizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RandomDice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomDice extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView img_dice = null;
    private Button btn = null;

    public RandomDice() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomDice.
     */
    // TODO: Rename and change types and number of parameters
    public static RandomDice newInstance(String param1, String param2) {
        RandomDice fragment = new RandomDice();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random_dice, container, false);

        btn = (Button) view.findViewById(R.id.roll_dice);
        img_dice = (ImageView) view.findViewById(R.id.dice);

        btn.setOnClickListener(this);

        return view;
    }

    private void change_dice(int num){
        switch (num){
            case 1:
                img_dice.setImageResource(R.drawable.face1);
                break;
            case 2:
                img_dice.setImageResource(R.drawable.face2);
                break;
            case 3:
                img_dice.setImageResource(R.drawable.face3);
                break;
            case 4:
                img_dice.setImageResource(R.drawable.face4);
                break;
            case 5:
                img_dice.setImageResource(R.drawable.face5);
                break;
            case 6:
                img_dice.setImageResource(R.drawable.face6);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn){
            Random rand = new Random();

            int min = 1, max = 6;

            int num = rand.nextInt((max - min) + 1) + min;
            change_dice(num);

        }
    }
}