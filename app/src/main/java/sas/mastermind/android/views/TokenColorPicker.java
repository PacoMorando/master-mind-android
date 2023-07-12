package sas.mastermind.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;

import java.util.Arrays;

import sas.mastermind.android.R;

public class TokenColorPicker extends NumberPicker {
    private final int[] imageResources;

    public TokenColorPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Inicializa el array de recursos de imágenes
        imageResources = new int[]{R.drawable.token_red, R.drawable.token_green, R.drawable.token_blue};
        // Establece el número de elementos en el NumberPicker
        setDisplayedValues(getImageDisplayValues());
        setMaxValue(imageResources.length - 1);
        setMinValue(0);
    }

    private String[] getImageDisplayValues() {
        // Crea un array de strings vacío con la misma longitud que el array de recursos de imágenes
        String[] displayValues = new String[imageResources.length];
        // Asigna una cadena vacía a cada elemento del array
        Arrays.fill(displayValues, "");
        return displayValues;
    }

}
