package main.plaintext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlainTextChecker {

    private Path p;

    public PlainTextChecker(File file) {
        this.p = file.toPath();
    }

    public boolean checkIsPlaneTextFile() {
        try {
            if(Files.probeContentType(p).startsWith("text/plain")) return true;
        } catch (NullPointerException e) {
            System.out.println("Content type is not text/plain with current extension");
            return false;
        } catch (IOException f) {
            System.out.println("IO exception while checking is the file txt");
            return false;
        }
    return false;
    }
}
