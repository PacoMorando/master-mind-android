package sas.mastermind.android.views;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import sas.mastermind.android.databinding.ColorPickerBinding;

public class ColorPicker {
    private final ImageButton up;
    private final ImageView pickedColor;
    private final ImageButton down;
    private final String name;
    private int i = 0;

    public ColorPicker(String name, ColorPickerBinding picker) {
        this.name = name;
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
        //System.out.println("UP " + this.name);
        this.pickedColor.setImageResource(this.getNextColor());
        System.out.println(CombinationColors.values()[this.i]);
    }

    private void pickDown() {
        //System.out.println("DOWN " + name);
        this.pickedColor.setImageResource(getPreviousColor());
        System.out.println(CombinationColors.values()[this.i]);
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