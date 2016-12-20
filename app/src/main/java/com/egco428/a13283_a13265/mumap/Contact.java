package com.egco428.a13283_a13265.mumap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.egco428.a13283_a13265.mumap.Building.BuildingDataSource;
import com.egco428.a13283_a13265.mumap.Building.BuildingPlace;

import java.util.List;

public class Contact extends AppCompatActivity implements View.OnTouchListener {
    BuildingDataSource buildingDataSource;
    private ArrayAdapter<BuildingPlace> courseArrayAdapter;
    private ImageView img;
    private TextView edit1;
    private TextView edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edit1 = (TextView)findViewById(R.id.glomeview);
        edit2 = (TextView)findViewById(R.id.towview);
        Toast.makeText(this,"Two Finger For Description",Toast.LENGTH_LONG);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int count = event.getPointerCount();
        // get pointer index from the event object
        int pointerIndex = event.getActionIndex();

        // get pointer ID
        int pointerId = event.getPointerId(pointerIndex);

        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                if (count == 2) {
                    edit1.setVisibility(View.VISIBLE);
                    edit2.setVisibility(View.VISIBLE);

                }
                break;
            }
            case MotionEvent.ACTION_MOVE: { // a pointer was moved
                // TODO use data
                break;
            }
            case MotionEvent.ACTION_UP:

            case MotionEvent.ACTION_POINTER_UP:{
                edit1.setVisibility(View.INVISIBLE);
                edit2.setVisibility(View.INVISIBLE);

            }
            case MotionEvent.ACTION_CANCEL: {
                // TODO use data
                break;
            }
        }

        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
