import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    JFrame window, findAndReplaceWindow;
    // Text area
    JTextPane textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // Top menu bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuFindReplace;
    // File menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    // Edit menu
    JMenuItem iUndo, iRedo;
    // Format menu
    JMenuItem iWrap, iFontArial, iFontSCMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSiz24, iFontSize28;
    JMenu menuFont, menuFontSize;
    //Color menu
    JMenuItem iColor1, iColor2, iColor3;
    // Find & Replace menu
    JMenuItem iFindAndReplace;



    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    Function_FR fr = new Function_FR(this);

    KeyHandler lHandler = new KeyHandler(this);

    UndoManager um = new UndoManager();


    public static void main(String[] args){
        new GUI();
    }
    public GUI(){

        createWindow();
        createTextPane();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        CreateColorMenu();
        createFindAndReplaceMenu();


        format.selected_font = "Arial";
        format.createFont(16);
        //textArea.setText("Print your text here!");
        //format.wordWrap();
        //color.changeColor("White");
        window.setVisible(true);

    }

    public void createWindow(){
        window = new JFrame(("Notepad"));
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

    }

    public void createTextPane(){

        textArea = new JTextPane();
        JPanel noWrapPanel = new JPanel( new BorderLayout() );
        noWrapPanel.add( textArea );
        textArea.setFont(format.arial);
        textArea.addKeyListener(lHandler);





        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        menuFindReplace = new JMenu("Find and Replace");
        menuBar.add(menuFindReplace);



    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save as");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);


    }





    public void createFormatMenu(){
//        iWrap = new JMenuItem("Word wrap: Off");
//        iWrap.addActionListener(this);
//        iWrap.setActionCommand("Word Wrap");
//        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontSCMS = new JMenuItem("CSMS");
        iFontSCMS.addActionListener(this);
        iFontSCMS.setActionCommand("CSMS");
        menuFont.add(iFontSCMS);

        iFontTNR = new JMenuItem("TNR");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFont.add(iFontTNR);


        menuFontSize = new JMenu("Font size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);

        iFontSiz24 = new JMenuItem("24");
        iFontSiz24.addActionListener(this);
        iFontSiz24.setActionCommand("24");
        menuFontSize.add(iFontSiz24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menuFontSize.add(iFontSize28);


    }

    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }


    public void CreateColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Burbel");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    public void createFindAndReplaceMenu(){
        iFindAndReplace = new JMenuItem("Find/Replace");
        iFindAndReplace.addActionListener(this);
        iFindAndReplace.setActionCommand("Find and Replace");
        menuFindReplace.add(iFindAndReplace);
    }

    public void createFindAndReplaceWindow() {
        findAndReplaceWindow = new JFrame("Find and Replace");
        findAndReplaceWindow.setLayout(null);
        findAndReplaceWindow.setResizable(false);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        findAndReplaceWindow.setBounds(
                dimension.width / 2 - 166,
                dimension.height / 2 - 112,
                333,
                225);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "Save as": file.saveAs(); break;
            case "Exit": file.exit(); break;
            //case "Word Wrap": format.wordWrap(); break;
            case "Arial": format.setFont(command); break;
            case "CSMS": format.setFont(command); break;
            case "TNR": format.setFont(command); break;
            case "8": format.createFont(8); break;
            case "16": format.createFont(16); break;
            case "12": format.createFont(12); break;
            case "24": format.createFont(24); break;
            case "28": format.createFont(28); break;
            case "White": color.changeColor(command); break;
            case "Black": color.changeColor(command); break;
            case "Blue": color.changeColor(command); break;
            case "Undo": edit.undo(); break;
            case "Redo": edit.redo(); break;
            case "Find and Replace": fr.findAndReplace(); break;
        }
    }
}
