package Utility;

import java.io.File;

public class CommonCommands {
    public int SetNum(String StringofNum) {
        if (StringofNum.equalsIgnoreCase("")) {
            return 0;
        }
        Integer num = Integer.valueOf(StringofNum);
        return num;
    }

    public String getFileType(File file){
        String type="";
        type = file.getName().substring(file.getName().lastIndexOf('.')+1);
        return type;
    }

}