package ar.edu.info.unlp.media;

import ar.edu.info.unlp.File;
import ar.edu.info.unlp.media.type.FileType;
import ar.edu.info.unlp.stream.VideoStream;

public class VideoStreamAdapter extends Media{
    private VideoStream videoStream;

    public VideoStreamAdapter(VideoStream videoStream) {
        this.videoStream = videoStream;
    }

    @Override
    public String play(File file) {
        return videoStream.reproduce(file.getName());
    }

    @Override
    public boolean applies(FileType fileType) {
        return FileType.VIDEO_STREAM.equals(fileType);
    }
}
