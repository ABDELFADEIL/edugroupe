package design_pattern.adapter_pattern;

public class Mp4Player implements AdvancedMediaPlayer{
    /**
     * @param fileName
     */
    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    /**
     * @param fileName
     */
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
