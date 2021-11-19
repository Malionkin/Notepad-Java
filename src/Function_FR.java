import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function_FR implements ActionListener{
    GUI gui;
    JLabel findLabel, replaceWithLabel;
    JTextField findTextField, replaceWithTextField;
    JButton findNextButton, replaceNextButton, replaceAllButton;
    int start_pos_4_next = 0;
    int counter = 0;
    int replace_r_counter = 0;
    public Function_FR(GUI gui){
        this.gui = gui;
    }

    public void findAndReplace(){
        gui.createFindAndReplaceWindow();
        gui.findAndReplaceWindow.setVisible(true);

        findLabel = new JLabel("Find");
        findLabel.setText("Find:");
        findLabel.setBounds(30, 30, 50, 15);
        gui.findAndReplaceWindow.add(findLabel);

        replaceWithLabel = new JLabel("Replace with");
        replaceWithLabel.setText("Replace with:");
        replaceWithLabel.setBounds(30, 60, 100, 15);
        gui.findAndReplaceWindow.add(replaceWithLabel);

        findTextField = new JTextField();
        findTextField.setBounds(140, 30, 150, 20);
        gui.findAndReplaceWindow.add(findTextField);

        replaceWithTextField = new JTextField();
        replaceWithTextField.setBounds(140, 60, 150, 20);
        gui.findAndReplaceWindow.add(replaceWithTextField);

        findNextButton = new JButton("Find Next");
        findNextButton.setBounds(30, 110, 125, 60);
        findNextButton.addActionListener(this);
        findNextButton.setActionCommand("Find next");
        gui.findAndReplaceWindow.add(findNextButton);


        replaceAllButton = new JButton("Replace All");
        replaceAllButton.setBounds(165, 110, 125, 60);
        replaceAllButton.addActionListener(this);
        replaceAllButton.setActionCommand("Replace all");
        gui.findAndReplaceWindow.add(replaceAllButton);
    }




    public int actuallyFind(String regex){

        ++counter ;
        ++replace_r_counter;
        String data = gui.textArea.getText();
        if (replace_r_counter == 1){
        this.replaceAll("\\r", "");}
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        int amountOfMatches = (int) matcher.results().count();

        if (counter == amountOfMatches + 1){
            JOptionPane.showMessageDialog(new JFrame(), "No any matches", "Error", JOptionPane.INFORMATION_MESSAGE);
            counter = 0;
            start_pos_4_next = 0;
            return start_pos_4_next;
        }


        matcher.find(start_pos_4_next );
        gui.textArea.setSelectionStart(matcher.start() );
        gui.textArea.setSelectionEnd(matcher.start() + regex.length() );
        start_pos_4_next = matcher.start() + regex.length();
        System.out.println(matcher.start());
        System.out.println(start_pos_4_next);
        System.out.println("Counts = " + amountOfMatches);




        return start_pos_4_next;
    }

    public void replaceAll(String regexFind, String regexReplace) {
        String data = gui.textArea.getText();

        Pattern pattern = Pattern.compile(regexFind, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        int amountOfMatches = (int) matcher.results().count();
        if (amountOfMatches != 0) {
            for (int i = 0; i < amountOfMatches; i++) {
                matcher = pattern.matcher(data);
                matcher.find();
                StringBuilder editedData = new StringBuilder(data);
                editedData.delete(matcher.start(), matcher.end());
                editedData.insert(matcher.start(), regexReplace);
                data = editedData.toString();
            }
            //String data_1 = matcher.replaceAll(regexReplace);
            gui.textArea.setText(data);
            gui.textArea.setSelectionColor(Color.YELLOW);
            gui.textArea.setSelectionStart(matcher.start());
            gui.textArea.setSelectionEnd(matcher.start() + regexReplace.length());
        }
        else JOptionPane.showMessageDialog(new JFrame(), "No any matches", "Error", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Find next" -> actuallyFind(findTextField.getText());
            case "Replace all" -> replaceAll(findTextField.getText(), replaceWithTextField.getText());
        }
    }

}
