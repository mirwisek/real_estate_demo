package com.estate.real.ui.home;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.estate.real.R;
import com.estate.real.ui.Item;
import com.estate.real.ui.ParentItem;
import com.estate.real.ui.ParentRecyclerAdapter;
import com.estate.real.ui.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


public class NearbyFragment extends Fragment  {


    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.fragment_nearby, container, false);

        List<Item> dummyList = new ArrayList<>();
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));

        String categories[] = new String[]{
                "Experienced Services",
                "Hot Deals",
                "Recommended Real Estates",
                "High Review Machineary"
        };

        List<ParentItem> parentList = new ArrayList<>();
        parentList.add(new ParentItem(categories[0], dummyList));
        parentList.add(new ParentItem(categories[1], dummyList));
        parentList.add(new ParentItem(categories[2], dummyList));
        parentList.add(new ParentItem(categories[3], dummyList));

        ParentRecyclerAdapter adapter =
                new ParentRecyclerAdapter(parentList, new RecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, Item item) {
                        Toast.makeText(getContext(), "Item Clicked :" + item.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

        adapter.setOnItemClickListener(new ParentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onViewAllClick(View v, int listPosition) {
                Toast.makeText(getContext(), "VIEW ALL", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = parent.findViewById(R.id.parentRecyclerView);
        recyclerView.setAdapter(adapter);
        return parent;
    }

}
