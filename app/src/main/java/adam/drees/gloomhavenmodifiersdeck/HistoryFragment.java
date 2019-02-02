package adam.drees.gloomhavenmodifiersdeck;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    private static final String TAG = "MainFragment";

    //Recycle View for History
    RecyclerViewAdapter rclAdapter;
    public ArrayList<String> eventMessages = new ArrayList<>();
    private ImageView buttonR;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_history, container,false);


        eventMessages.add("GAME STARTED");


        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rvHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rclAdapter = new RecyclerViewAdapter(getContext(), eventMessages);
        recyclerView.setAdapter(rclAdapter);

        buttonR = (ImageView) view.findViewById(R.id.historyr);


        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });

        return view;
    }




    public void insertSingleItem(String eventMSG) {
        int insertIndex = 0;
        eventMessages.add(insertIndex, eventMSG);
        rclAdapter.notifyItemInserted(insertIndex);

        if(eventMessages.size() > 100)
            removeHalf();
    }


    private void removeHalf() {
        int startIndex = eventMessages.size()/2; // inclusive
        int endIndex = eventMessages.size();   // exclusive
        int count = endIndex - startIndex; // 2 items will be removed
        eventMessages.subList(startIndex, endIndex).clear();
        rclAdapter.notifyItemRangeRemoved(startIndex, count);
    }





}
