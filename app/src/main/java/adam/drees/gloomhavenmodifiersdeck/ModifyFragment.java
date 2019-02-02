package adam.drees.gloomhavenmodifiersdeck;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ModifyFragment extends Fragment {
    private static final String TAG = "MainFragment";

    private Button buttonApply;
    private ImageView buttonL;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modify, container,false);
        buttonApply = (Button) view.findViewById(R.id.buttonApply);
        buttonL = (ImageView) view.findViewById(R.id.modifyl);

        final EditText count[] = new EditText[15];
        final EditText face[] = new EditText[8];

        count[0] = (EditText) view.findViewById(R.id.countc1);
        count[1] = (EditText) view.findViewById(R.id.countc2);
        count[2] = (EditText) view.findViewById(R.id.countc3);
        count[3] = (EditText) view.findViewById(R.id.countc4);
        count[4] = (EditText) view.findViewById(R.id.countc5);
        count[5] = (EditText) view.findViewById(R.id.countc6);
        count[6] = (EditText) view.findViewById(R.id.countc7);
        count[7] = (EditText) view.findViewById(R.id.countc8);
        count[8] = (EditText) view.findViewById(R.id.countc9);
        count[9] = (EditText) view.findViewById(R.id.countc10);
        count[10] = (EditText) view.findViewById(R.id.countc11);
        count[11] = (EditText) view.findViewById(R.id.countc12);
        count[12] = (EditText) view.findViewById(R.id.countc13);
        count[13] = (EditText) view.findViewById(R.id.countc14);
        count[14] = (EditText) view.findViewById(R.id.countc15);


        face[0] = (EditText) view.findViewById(R.id.facec8);
        face[1] = (EditText) view.findViewById(R.id.facec9);
        face[2] = (EditText) view.findViewById(R.id.facec10);
        face[3] = (EditText) view.findViewById(R.id.facec11);
        face[4] = (EditText) view.findViewById(R.id.facec12);
        face[5] = (EditText) view.findViewById(R.id.facec13);
        face[6] = (EditText) view.findViewById(R.id.facec14);
        face[7] = (EditText) view.findViewById(R.id.facec15);



        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for(int i = 0; i<count.length; i++){
                    ((MainActivity)getActivity()).playerDeck.defaultQuantity(Integer.valueOf("0"+count[i].getText().toString()),i);
                }

                for(int i = 0; i<face.length; i++){
                    ((MainActivity)getActivity()).playerDeck.defaultContents(face[i].getText().toString(),i+7);
                }

                ((MainActivity)getActivity()).sendEvent("DECK MODIFIED");

                ((MainActivity)getActivity()).playerDeck.rebuildDeck();
                //((MainActivity)getActivity()).setViewPager(0);
            }
        });

        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });



        return view;
    }
}
