package com.example.taskmanagerhw13.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.taskmanagerhw13.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SinInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinInFragment extends Fragment {
    private Button mButtonSignUp;
    private Button mButtonBack;
    private Callbacks mCallBacks;

    public SinInFragment() {
        // Required empty public constructor
    }

    public static SinInFragment newInstance() {
        SinInFragment fragment = new SinInFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sin_in, container, false);

        findAllView(view);
        setListeners();
        return view;
    }

    private void findAllView(View view) {
        mButtonSignUp = view.findViewById(R.id.button_Sign_up);
        mButtonBack = view.findViewById(R.id.button_back);
    }

    private void setListeners() {
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBacks.onBackClicked();
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Callbacks)
            mCallBacks = (Callbacks) context;
        else {
            throw new ClassCastException(context.toString()
                    + "you must implement onBackClicked");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBacks = null;
    }

    public interface Callbacks {
        void onBackClicked();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}