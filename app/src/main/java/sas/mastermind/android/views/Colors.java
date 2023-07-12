package sas.mastermind.android.views;

import sas.mastermind.android.R;

public enum Colors {
    r(R.drawable.token_red, 'r'),
    g(R.drawable.token_green, 'g'),
    b(R.drawable.token_blue, 'b'),
    c(R.drawable.token_cian, 'c'),
    y(R.drawable.token_yellow, 'y'),
    m(R.drawable.token_magenta, 'm');

    private final int colorResource;
    private final char colorChar;

    Colors(int colorResource, char colorChar) {
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