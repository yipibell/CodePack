package MusicPlayer.MusicFile;

public class MusicFile {
    private String MusicFileName;
    private String MusicFileLocation;


    public MusicFile(String musicFileLocation, String musicFileName) {
        MusicFileName = musicFileName;
        MusicFileLocation = musicFileLocation;
    }

    public String getMusicFileName() {
        return MusicFileName;
    }

    public void setMusicFileName(String musicFileName) {
        MusicFileName = musicFileName;
    }

    public String getMusicFileLocation() {
        return MusicFileLocation;
    }

    public void setMusicFileLocation(String musicFileLocation) {
        MusicFileLocation = musicFileLocation;
    }
}
