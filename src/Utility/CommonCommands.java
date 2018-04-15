package Utility;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.io.File;

public class CommonCommands {
    public int SetNum(String StringofNum) {
        if (StringofNum.equalsIgnoreCase("")) {
            return 0;
        }
        return Integer.valueOf(StringofNum);
    }

    public String getFileType(File file) {
        return file.getName().substring(file.getName().lastIndexOf('.') + 1);
    }

    public static void copy(String string) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(string);
        systemClipboard.setContent(content);
    }
}
