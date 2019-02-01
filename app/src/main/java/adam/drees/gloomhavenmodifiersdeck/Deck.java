package adam.drees.gloomhavenmodifiersdeck;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static final int CARDTYPES = 15;

    int deckPosition;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private String[] contentsList;
    private int[] quantityList;
    private int[] backgroundList;

    Random rand = new Random();

    //Create initial deck
    public Deck(){
    contentsList = new String[CARDTYPES];
    quantityList = new int[CARDTYPES];
    backgroundList = new int[CARDTYPES];

    defaultArrays();
    rebuildDeck();
    }

    //Draw the card on the top of the deck
    public Card draw(){
        deckPosition = deckPosition % cards.size();
        return cards.get(deckPosition++);
    }

    //Shuffle the array of cards;
    public void shuffle(){
        rand.nextInt();
        for(int i = 0; i < cards.size(); i++){
            int j = rand.nextInt(cards.size());
            Card holder = cards.get(i);
            cards.set(i,cards.get(j));
            cards.set(j, holder);
        }
        deckPosition = 0;
    }

    //take the defined deck arrays and use them to build a deck
    public void rebuildDeck(){
        cards.clear();
        int count = 1;
        for(int i = 0; i<CARDTYPES; i++){
            for(int j = 0; j<quantityList[i]; j++){
                Card writer = new Card();
                writer.contents = contentsList[i];
                writer.background = RandomColor(backgroundList[i]);
                writer.edition = count++;
                writer.xMove = rand.nextInt(16);
                writer.yMove = rand.nextInt(16);
                cards.add(writer);
            }
        }
       shuffle();
    }

    private int RandomColor(int baseTone){
        int redMod = rand.nextInt(20);
        int greenMod = rand.nextInt(20);
        int blueMod = rand.nextInt(20);
        int colorMod = Color.rgb(redMod-10, greenMod-10, blueMod-10);
        return baseTone+colorMod;
    }



    //Populates arrays with known defaults. this should be moved to a values file...
    private void defaultArrays(){
        contentsList[0] = "+0";
        contentsList[1] = "+1";
        contentsList[2] = "-1";
        contentsList[3] = "+2";
        contentsList[4] = "-2";
        contentsList[5] = "x2 & SHUFFLE";
        contentsList[6] = "NULL & SHUFFLE";
        contentsList[7] = "Card 1";
        contentsList[8] = "Card 2";
        contentsList[9] = "Card 3";
        contentsList[10] = "Card 4";
        contentsList[11] = "Card 5";
        contentsList[12] = "Card 6";
        contentsList[13] = "Card 7";
        contentsList[14] = "Card 8";

        quantityList[0] = 6;
        quantityList[1] = 5;
        quantityList[2] = 5;
        quantityList[3] = 1;
        quantityList[4] = 1;
        quantityList[5] = 1;
        quantityList[6] = 1;
        quantityList[7] = 0;
        quantityList[8] = 0;
        quantityList[9] = 0;
        quantityList[10] = 0;
        quantityList[11] = 0;
        quantityList[12] = 0;
        quantityList[13] = 0;
        quantityList[14] = 0;

        backgroundList[0] = Color.parseColor( "#CFB9A1" );
        backgroundList[1] = Color.parseColor( "#B5DE93" );
        backgroundList[2] = Color.parseColor( "#C66B58" );
        backgroundList[3] = Color.parseColor( "#B5DE93" );
        backgroundList[4] = Color.parseColor( "#C66B58" );
        backgroundList[5] = Color.parseColor( "#C198DC" );
        backgroundList[6] = Color.parseColor( "#EAC96F" );
        backgroundList[7] = Color.parseColor( "#8B62C4" );
        backgroundList[8] = Color.parseColor( "#8B62C4" );
        backgroundList[9] = Color.parseColor( "#8B62C4" );
        backgroundList[10] = Color.parseColor( "#8B62C4" );
        backgroundList[11] = Color.parseColor( "#8B62C4" );
        backgroundList[12] = Color.parseColor( "#8B62C4" );
        backgroundList[13] = Color.parseColor( "#8B62C4" );
        backgroundList[14] = Color.parseColor( "#8B62C4" );
    }

    void defaultQuantity(int value, int cardNo){
        quantityList[cardNo] = value;
    }

    void defaultContents(String value, int cardNo){
        contentsList[cardNo] = value;
    }


}
