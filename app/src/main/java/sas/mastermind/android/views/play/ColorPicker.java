package sas.mastermind.android.views.play;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import sas.mastermind.android.databinding.ColorPickerBinding;
import sas.mastermind.android.views.CombinationColors;

public class ColorPicker {
    private final ImageButton up;
    private final ImageView pickedColor;
    private final ImageButton down;
    private int i = 0;

    public ColorPicker(ColorPickerBinding picker) {
        this.up = picker.up;
        this.pickedColor = picker.pickedColor;
        this.down = picker.down;
        this.setPicker();
    }

    public char getColorPicked(){
        return CombinationColors.values()[i].getColorChar();
    }

    private void setPicker() {
        this.pickedColor.setImageResource(CombinationColors.values()[i].getColorResource());
        this.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickUp();
            }
        });
        this.down.setOnClickListener(view -> pickDown());
    }

    private void pickUp() {
        this.pickedColor.setImageResource(this.getNextColor());
    }

    private void pickDown() {
        this.pickedColor.setImageResource(getPreviousColor());
    }

    private int getNextColor() {
        this.i++;
        if (this.i > 5) {
            this.i = 0;
        }
        return CombinationColors.values()[this.i].getColorResource();
    }

    private int getPreviousColor() {
        this.i--;
        if (i < 0) {
            i = 5;
        }
        return CombinationColors.values()[this.i].getColorResource();
    }
}