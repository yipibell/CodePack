package MusicPlayer.MusicFile;

import Utility.CommonCommands;
import Utility.Encryption;
import Utility.FileEditing;

import java.util.ArrayList;
import java.util.List;

public class MusicFileList {
    private List<MusicFile> MFList=new ArrayList<>();

    private String SecretKey="MP3";
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation="/JAVA/new window/src/MusicPlayer/MusicFile/SaveMPList.smp";
    private String SelectedSaveFilelocation="/JAVA/new window/src/MusicPlayer/MusicFile/OperetedMPList.smp";

    /*Music File List actions*/

    public void SaveMFList() {
        String saveMF = "";
        for (MusicFile file : MFList) {
            saveMF += MFToString(file);
        }
        saveMF.replace(" ", "_");
        byte[] saveMFList = Encryption.Encryption(saveMF, SecretKey);
        fe.SavebitFile(saveMFList, SaveFilelocation);
    }

    public void LoadMFList() {
        MFList.clear();
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

    public void AddMusicFile(MusicFile mf){
        MFList.add(mf);
        SaveMFList();
    }


    /*Selected music file actions*/
    private int Index;
    private CommonCommands CC=new CommonCommands();
    public void SaveMF(MusicFile file, int index) {
        String saveMF = "";
        saveMF += index + "|";
        saveMF += MFToString(file);
        saveMF.replace(" ", "_");
        byte[] saveMFbyte = Encryption.Encryption(saveMF, SecretKey);
        fe.SavebitFile(saveMFbyte, SelectedSaveFilelocation);
    }

    public MusicFile LoadMF() {
        MusicFile musicFile = (new MusicFile( "error", "error"));
        byte[] Decrypt = fe.LoadbitFile(SelectedSaveFilelocation);
        Decrypt = Encryption.Decryption(Decrypt, SecretKey);
        String sDecrypt = new String(Decrypt);
        String[] Decrypted = sDecrypt.replace("!@", "\\n").split("\\n");
        for (String decrypted : Decrypted) {
            if (decrypted.equals("")) break;
            String[] arg = decrypted.split("\\|");
            musicFile = (new MusicFile(arg[1], arg[2]));
            Index=CC.SetNum(arg[0]);
        }
        return musicFile;
    }

    public int getIndex() {
        return Index;
    }

    /*Maintance actions*/
    private String MFToString(MusicFile file) {
        String AsString =
                file.getMusicFileName() + "|" +
                        file.getMusicFileLocation() + "\n";
        return AsString;
    }

}
