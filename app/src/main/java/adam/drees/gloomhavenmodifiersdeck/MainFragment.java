package adam.drees.gloomhavenmodifiersdeck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    private ImageView buttonDraw;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container,false);

        buttonDraw = (ImageView) view.findViewById(R.id.buttonDraw);

        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card drawnCard;
                drawnCard = ((MainActivity)getActivity()).playerDeck.draw();
                v.findViewById(R.id.displayBackground).setBackgroundColor(drawnCard.background);
            }
        });



        return view;
    }




}
