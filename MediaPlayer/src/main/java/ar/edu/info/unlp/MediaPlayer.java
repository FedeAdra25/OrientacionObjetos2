package ar.edu.info.unlp;

import ar.edu.info.unlp.media.Media;

import java.util.Arrays;

public class MediaPlayer {
    private Media[] medias;

    public MediaPlayer(Media[] medias) {
        this.medias = medias;
    }
    public String play(File file){
        return  Arrays.stream(medias)
                .filter(media -> media.applies(file.getType()))
                .map(media -> media.play(file))
                .findFirst().orElse("ERROR");
    }
}
