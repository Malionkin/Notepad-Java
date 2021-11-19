import javax.naming.event.EventContext;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName;
    String fileAddress;
    public Function_File(GUI gui){

        this.gui = gui;

    }

    public void newFile(){

        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open(){

        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!= null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("File address and file mane " + fileAddress + fileName);


        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            gui.textArea.setText("");

            String line = null;
            String result  = "";

            while((line = br.readLine())!= null ){
                result += (line+"\n");
            }
            gui.textArea.setText(result);
            br.close();
        } catch(Exception e){
            System.out.println("FILE NOT OPENED!");
        }
    }

    public void save(){
        if (fileName == null){
            saveAs();
        }
        else{
            try{
                FileWriter fr = new FileWriter(fileAddress + fileName);
                fr.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fr.close();
            } catch (Exception e){
                System.out.println("SOMETHING WRONG!");
            }
        }
    }
    public void saveAs(){
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }


        try {
            FileWriter fr = new FileWriter(fileAddress + fileName);
            fr.write(gui.textArea.getText());
            fr.close();


        } catch (Exception e){
            System.out.println("SOMETHING WRONG!");
        }



    }

    public void exit(){
        System.exit(0);
    }


}
