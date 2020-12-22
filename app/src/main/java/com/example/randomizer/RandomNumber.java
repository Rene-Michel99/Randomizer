package com.example.randomizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;


public class RandomNumber extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText ini,fim,qntd;
    private Button btn;
    private TextView result;

    public RandomNumber() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomNumber.
     */
    // TODO: Rename and change types and number of parameters
    public static RandomNumber newInstance(String param1, String param2) {
        RandomNumber fragment = new RandomNumber();
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
        final View view = inflater.inflate(R.layout.fragment_random_number,container,false);

        result = (TextView) view.findViewById(R.id.result);

        ini = (EditText) view.findViewById(R.id.ini_inter);

        fim = (EditText) view.findViewById(R.id.fim_inter);

        qntd = (EditText) view.findViewById(R.id.qntd);

        btn = (Button) view.findViewById(R.id.generate_num);

        btn.setOnClickListener(this);

        return view;
    }
    private String rand_number(int min,int max,int qnt){
        Random rand = new Random();
        String numbers = "Number(s): ";

        for(int i=0; i<qnt; i++){
            int num = rand.nextInt((max - min) + 1) + min;

            if(i != qnt-1)
                numbers += String.valueOf(num) +", ";
            else
                numbers += String.valueOf(num);
        }

        return numbers;
    }

    @Override
    public void onClick(View v) {
        boolean make = true;
        if (v == btn){
            if(ini.getText().toString().length() > 0 && fim.getText().length()>0 && qntd.getText().length()>0) {
                int num1 = Integer.parseInt(ini.getText().toString());
                int num2 = Integer.parseInt(fim.getText().toString());
                int qnt = Integer.parseInt(qntd.getText().toString());

                if (num1 > num2) {
                    int aux = num1;
                    num1 = num2;
                    num2 = aux;
                } else if (num1 == num2) {
                    make = false;
                    String txt = "Number(s): " + String.valueOf(num1);
                    result.setText(txt);
                }

                if (make) {
                    String res = rand_number(num1, num2, qnt);
                    result.setText(String.valueOf(res));
                }
            }
            else{
                LinearLayout lay = (LinearLayout) getView().findViewById(R.id.id_random);
                Snackbar.make(lay, R.string.error_qnt,Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}