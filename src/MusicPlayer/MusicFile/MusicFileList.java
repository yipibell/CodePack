package MusicPlayer.MusicFile;

import Utility.Encryption;
import Utility.FileEditing;

import java.util.ArrayList;
import java.util.List;

public class MusicFileList {
    private List<MusicFile> MFList=new ArrayList<>();

    private String SecretKey="MP3";
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation="/JAVA/new window/src/MusicPlayer/MusicFile/SaveMPList.smp";

    public void AddMusicFile(MusicFile mf){
        MFList.add(mf);
        SaveMFList();
    }

    public void SaveMFList() {
        String saveMF = "";
        for (MusicFile file : MFList) {
            saveMF += MFToString(file);
        }
        saveMF.replace(" ", "_");
        byte[] saveMFList = Encryption.Encryption(saveMF, SecretKey);
        fe.SavebitFile(saveMFList, SaveFilelocation);
    }

    private String MFToString(MusicFile file) {
        String AsString =
                file.getMusicFileName() + "|" +
                        file.getMusicFileLocation() + "\n";
        return AsString;
    }

    public void LoadMFList() {
        byte[] Decrypt = fe.LoadbitFile(SaveFilelocation);
        Decrypt = Encryption.Decryption(Decrypt, SecretKey);
        String sDecrypt = new String(Decrypt);
        String[] Decrypted = sDecrypt.replace("!@", "\\n").split("\\n");
        for (String decrypted : Decrypted) {
            if (decrypted.equals("")) break;
            String[] arg = decrypted.split("\\|");
            AddMusicFile(new MusicFile((arg[0]),(arg[1])));
        }
    }

    public List<MusicFile> getMFList() {
        return MFList;
    }

}
