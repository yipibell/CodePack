package Utility;

import javafx.fxml.LoadException;

import java.io.*;

public class FileEditing {
    private String ErrorFilelocation = "Java/src/Utility/Error/Error.txt";
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
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String Load;
            if ((Load = reader.readLine()) != null) {
                return Load;
            }
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + filename);
            ioe.printStackTrace();
        }
        return null;
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
