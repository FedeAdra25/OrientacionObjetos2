package ar.edu.info.unlp.media;

import ar.edu.info.unlp.File;
import ar.edu.info.unlp.media.type.FileType;

public abstract class Media {
    public abstract String play(File file);
    public abstract boolean applies(FileType fileType);
}
