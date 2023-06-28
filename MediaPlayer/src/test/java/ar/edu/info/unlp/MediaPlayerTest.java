package ar.edu.info.unlp;

import ar.edu.info.unlp.media.Audio;
import ar.edu.info.unlp.media.Media;
import ar.edu.info.unlp.media.VideoFile;
import ar.edu.info.unlp.media.VideoStreamAdapter;
import ar.edu.info.unlp.media.type.FileType;
import ar.edu.info.unlp.stream.VideoStream;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MediaPlayerTest {

    private final String AUDIO_TEXT="Playing audio jeje";
    private final String VIDEO_TEXT= "Reproducing video";
    private final String VIDEO_STREAM_TEXT="Streeeeeeeam";
    @Test
    void playAudioTest() {
        File audioFile = new File("BOING", FileType.AUDIO);
        Media[] medias = {new Audio(), new VideoFile(), new VideoStreamAdapter(new VideoStream())};
        MediaPlayer mediaPlayer = new MediaPlayer(medias);
        assertEquals(AUDIO_TEXT,mediaPlayer.play(audioFile));
    }
    @Test
    void playVideoTest() {
        File videoFile = new File("FFIUUMBA", FileType.VIDEO_FILE);
        Media[] medias = {new Audio(), new VideoFile(), new VideoStreamAdapter(new VideoStream())};
        MediaPlayer mediaPlayer = new MediaPlayer(medias);
        assertEquals(VIDEO_TEXT,mediaPlayer.play(videoFile));
    }
    @Test
    void playVideoStreamTest() {
        File videoFile = new File("WAWIAWWIA", FileType.VIDEO_STREAM);
        Media[] medias = {new Audio(), new VideoFile(), new VideoStreamAdapter(new VideoStream())};
        MediaPlayer mediaPlayer = new MediaPlayer(medias);
        assertEquals(VIDEO_STREAM_TEXT,mediaPlayer.play(videoFile));
    }
}