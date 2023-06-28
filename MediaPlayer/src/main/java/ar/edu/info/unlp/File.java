package ar.edu.info.unlp;

import ar.edu.info.unlp.media.type.FileType;

public class File {
    private String name;
    private FileType type;

    public File(String name, FileType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public FileType getType() {
        return type;
    }
}
