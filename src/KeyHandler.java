import org.xml.sax.SAXException;
import xml.Pattern_;
import xml.XMLParser;

import javax.swing.*;
import javax.swing.text.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {



    ArrayList<Pattern_> pattern_s = new ArrayList<>();
    final StyleContext cont = StyleContext.getDefaultStyleContext();
    GUI gui;
    Function_FR fr = new Function_FR(gui);

    public KeyHandler(GUI gui){

        this.gui = gui;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.save();
        }
        if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.saveAs();
        }
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F){
            gui.menuFile.doClick();
        }
        if (e.isControlDown() && e.isShiftDown() &&  e.getKeyCode() == KeyEvent.VK_Z){
            gui.um.redo();
        }

        else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z){
            gui.um.undo();
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

//        StyledDocument doc = gui.textArea.getStyledDocument();
//        SimpleAttributeSet sas = new SimpleAttributeSet();
//        XMLParser xmlParser = new XMLParser();
//        try{
//            pattern_s = xmlParser.Read();
//        } catch (Exception r){}
//        for (int i = 0; i < pattern_s.size(); i++){
//            AttributeSet color_attribute = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, pattern_s.get(i).getColor());
//            doc.setCharacterAttributes(0,3/* pattern_s.get(i).getPattern().length()*/, color_attribute, false);
//
//        }
//        gui.textArea.setCharacterAttributes(doc.getDefaultRootElement().getAttributes(), true);
    }
}
