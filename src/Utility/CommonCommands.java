package Utility;

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
}
