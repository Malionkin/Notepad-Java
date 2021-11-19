import java.awt.Font;
public class Function_Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selected_font;



    public Function_Format(GUI gui){
        this.gui = gui;
    }
    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selected_font);
    }
    public void setFont(String font){
        selected_font = font;

        switch(selected_font){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "CSMS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "TNR":
                gui.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
