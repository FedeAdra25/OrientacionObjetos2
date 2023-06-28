package ar.edu.info.unlp.media;

import ar.edu.info.unlp.File;
import ar.edu.info.unlp.media.type.FileType;

public class Audio extends Media {
    @Override
    public String play(File file) {
        return "Playing audio jeje";
    }

    @Override
    public boolean applies(FileType fileType) {
        return FileType.AUDIO.equals(fileType);
    }
}
