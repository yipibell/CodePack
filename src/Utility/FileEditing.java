package Utility;

import javafx.fxml.LoadException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileEditing {
    private String ErrorFilelocation = "src/Utility/Error/Error.fxml";

    /*String*/
    public void export(String filename, String save) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             PrintWriter writer = new PrintWriter(fos)) {
            writer.println("" + save);
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + filename);
            ioe.printStackTrace();
        }
    }

    public void ErrorExport(String save) {
        try (FileOutputStream fos = new FileOutputStream(ErrorFilelocation);
             PrintWriter writer = new PrintWriter(fos)) {
            writer.println("" + save);
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + ErrorFilelocation);
            ioe.printStackTrace();
        }
    }

    public String Import(String filename) {
        String Load = "";
        try {
            FileInputStream fis = new FileInputStream(filename);
            Load += new String(fis.readAllBytes());
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + filename);
            ioe.printStackTrace();
        }
        return Load;
    }

    /*bytes*/
    public void SavebitFile(byte[] byts, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(byts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] LoadbitFile(String path) {
        byte[] byts;
        try (FileInputStream fis = new FileInputStream(path)) {
            return byts = fis.readAllBytes();
        } catch (LoadException a) {
            a.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byts = null;
    }
}
