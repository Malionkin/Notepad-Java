package xml;

import java.awt.*;

public class Pattern_ {

    private String Pattern;
    private Color color;

    public Pattern_(String Pattern, Color color){
        this.color = color;
        this.Pattern = Pattern;
    }

    public String getPattern(){
        return Pattern;
    }

    public Color getColor(){
        return color;
    }

}
