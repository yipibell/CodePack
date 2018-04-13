package Utility;

import java.io.*;

public class FileEditing {
    private String ErrorFilelocation = "src/Utility/Error/Error.txt";

    public void ErrorExport(String save) {
        try (FileOutputStream fos = new FileOutputStream(ErrorFilelocation);
             PrintWriter writer = new PrintWriter(fos)) {
            writer.println("" + save);
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + ErrorFilelocation);
            ioe.printStackTrace();
        }
    }

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

    public String ImportLine(String filename) {
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

    public String Import(String filename) {
        String Load;
        try {
            FileInputStream fis = new FileInputStream(filename);
            Load = new String(fis.readAllBytes());
            return Load;
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
        try (FileInputStream fis = new FileInputStream(path)) {
            return fis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
