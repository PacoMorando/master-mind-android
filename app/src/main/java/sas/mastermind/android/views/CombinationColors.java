package sas.mastermind.android.views;

import sas.mastermind.android.R;

public enum CombinationColors {
    r(R.drawable.token_red, 'r'),
    g(R.drawable.token_green, 'g'),
    b(R.drawable.token_blue, 'b'),
    c(R.drawable.token_cian, 'c'),
    y(R.drawable.token_yellow, 'y'),
    m(R.drawable.token_magenta, 'm');

    public static final int COMBINATION_SIZE = 4;
    private final int colorResource;
    private final char colorChar;

    CombinationColors(int colorResource, char colorChar) {
        this.colorResource = colorResource;
        this.colorChar = colorChar;
    }

    public int getColorResource() {
        return this.colorResource;
    }

    public char getColorChar(){
        return this.colorChar;
    }
}