package adam.drees.gloomhavenmodifiersdeck;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    private ImageView buttonDraw;
    private Button buttonShuffle;
    private TextView cardText;
    private ConstraintLayout cardBack;
    private TextView cardEdition;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container,false);

        buttonDraw = (ImageView) view.findViewById(R.id.buttonDraw);
        buttonShuffle = (Button) view.findViewById(R.id.buttonShuffle);
        cardText = (TextView) view.findViewById(R.id.displayCard);
        cardBack = (ConstraintLayout) view.findViewById(R.id.displayBackground);
        cardEdition = (TextView) view.findViewById(R.id.displayEdition);



        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card drawnCard;
                drawnCard = ((MainActivity)getActivity()).playerDeck.draw();
                cardText.setText(drawnCard.contents);
                cardBack.setBackgroundColor(drawnCard.background);
                cardEdition.setText(Integer.toString(drawnCard.edition));
                cardText.setPadding(drawnCard.xMove,drawnCard.yMove,16-drawnCard.xMove, 16-drawnCard.yMove);
            }
        });



        buttonShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).playerDeck.shuffle();
                cardText.setText("");
                cardBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cardEdition.setText("");
            }
        });



        return view;
    }




}
