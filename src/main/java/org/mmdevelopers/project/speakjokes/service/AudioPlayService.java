package org.mmdevelopers.project.speakjokes.service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class AudioPlayService {
    private static final int BUFFER_SIZE = 4096;

    public void play(String soundFilePath) {
        try {
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream(soundFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            System.out.println("Playback Started.");

            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();

            System.out.println("Playback has been finished.");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println("Error occured during playback process:" + ex.getMessage());
        }
    }

}
