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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RandomList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomList extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText pair_1, pair_2;
    private TextView result;
    private Button btn;

    public RandomList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RandomList.
     */
    // TODO: Rename and change types and number of parameters
    public static RandomList newInstance(String param1, String param2) {
        RandomList fragment = new RandomList();
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

        pair_1 = view.findViewById(R.id.pair_1);
        pair_2 = view.findViewById(R.id.pair_2);
        result = view.findViewById(R.id.result_list);
        btn = view.findViewById(R.id.generate_list);

        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==btn) {
            if(pair_1.getText().toString().length() > 0 && pair_2.getText().toString().length()>0){
                String[] input1 = pair_1.getText().toString().split(",");
                String[] input2 = pair_2.getText().toString().split(",");

                if(input1.length == input2.length){
                    String out = "";

                    for(int i=0; i<input1.length; i++)
                        out = out + input1[i] + ":" + input2[i] + "\n";
                    result.setText(out);
                }
                else{
                    LinearLayout lay = (LinearLayout) getView().findViewById(R.id.id_random);
                    Snackbar.make(lay, R.string.error_count_list,Snackbar.LENGTH_SHORT).show();
                }
            }
            else{
                LinearLayout lay = (LinearLayout) getView().findViewById(R.id.id_random);
                Snackbar.make(lay, R.string.error_qnt,Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}