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

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    private static final String TAG = "MainFragment";
    RecyclerViewAdapter adapter;

    public ArrayList<String> eventMessages = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_history, container,false);

        eventMessages.add("Horse");
        eventMessages.add("Cow");
        eventMessages.add("Camel");
        eventMessages.add("Sheep");
        eventMessages.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rvHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(), eventMessages);
        recyclerView.setAdapter(adapter);





        return view;
    }


    public void insertSingleItem(String eventMSG) {
         int insertIndex = 2;
        eventMessages.add(insertIndex, eventMSG);
        adapter.notifyItemInserted(insertIndex);

        if(eventMessages.size() > 100)
            removeHalf();
    }


    private void removeHalf() {
        int startIndex = eventMessages.size()/2; // inclusive
        int endIndex = eventMessages.size()-1;   // exclusive
        int count = endIndex - startIndex; // 2 items will be removed
        eventMessages.subList(startIndex, endIndex).clear();
        adapter.notifyItemRangeRemoved(startIndex, count);
    }


}
