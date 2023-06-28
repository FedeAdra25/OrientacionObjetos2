package ar.edu.info.unlp.media;

import ar.edu.info.unlp.File;
import ar.edu.info.unlp.media.type.FileType;

public class VideoFile extends Media {
    @Override
    public String play(File file) {
        return "Reproducing video";
    }

    @Override
    public boolean applies(FileType fileType) {
        return FileType.VIDEO_FILE.equals(fileType);
    }
}
