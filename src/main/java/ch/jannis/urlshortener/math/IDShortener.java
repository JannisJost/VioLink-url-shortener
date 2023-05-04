package ch.jannis.urlshortener.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IDShortener {
    private static final char[] availableChars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public String getValue(int value) {
        List<String> vigecimalList = new ArrayList<>();
        String vigecimalValue = "";
        int nextValue;
        do {
            nextValue = value / availableChars.length;
            int remainder = value % availableChars.length;
            vigecimalList.add(Character.toString(availableChars[remainder]));
            value = nextValue;
        } while (value > 0);
        Collections.reverse(vigecimalList);
        for (String symbol : vigecimalList) {
            vigecimalValue = vigecimalValue.concat(symbol);
        }
        return vigecimalValue;
    }

    public int getInt(String value) {
        int intValue = 0;
        boolean isFirst = true;
        List<String> symbols = new ArrayList<>();
        while (value.length() > 0) {
            symbols.add(value.substring(0, 1));
            value = value.substring(1);
        }
        for (int i = 0; i <= symbols.size() - 1; i++) {
            int remainder = 0;
            for (int j = 0; j <= availableChars.length - 1; j++) {
                if (symbols.get(i).equals(Character.toString(availableChars[j]))) {
                    remainder = j;
                    break;
                }
            }
            if (i == 0) {
                intValue = remainder * availableChars.length;
            } else if (i == symbols.size() - 1) {
                intValue += remainder;
            } else {
                intValue += remainder;
                intValue *= availableChars.length;
            }
        }
        System.out.println(intValue);
        return intValue;
    }
}
