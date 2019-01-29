package adam.drees.gloomhavenmodifiersdeck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    private Button mbuttonHistory;
    private Button mbuttonModify;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container,false);
        mbuttonHistory = (Button) view.findViewById(R.id.buttonHistory);
        mbuttonModify = (Button) view.findViewById(R.id.buttonModify);

        mbuttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        mbuttonModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });



        return view;
    }
}
