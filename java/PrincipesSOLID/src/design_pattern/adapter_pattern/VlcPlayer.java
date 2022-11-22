package design_pattern.adapter_pattern;

public class VlcPlayer implements AdvancedMediaPlayer{
    /**
     * @param fileName
     */
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    /**
     * @param fileName
     */
    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}
