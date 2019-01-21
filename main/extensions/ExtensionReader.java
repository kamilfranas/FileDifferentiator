package main.extensions;

import main.comparisons.ExtensionsComparison;
import main.files.FileReader;
import main.plaintext.PlainTextChecker;

import java.io.File;
import java.util.List;

public class ExtensionReader {
    private long fileSize;
    private ExtensionsComparison extensionsComparison;
    private PlainTextChecker plainTextChecker;
    private FileReader fileReader;

    public ExtensionReader(File file, List<Extension> extensionsList) {
        this.fileSize = file.length();
        this.extensionsComparison = new ExtensionsComparison(extensionsList);
        this.plainTextChecker = new PlainTextChecker(file);
        this.fileReader = new FileReader(file,  6);
    }

    public String readExtensionFromFileName(String fileName) {
        if(fileName.length() == 0) return "unknown";
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else return "unknown";
    }

    public String readExtensionFromFile() {
        if(fileSize > 12) {
            String ex;
            ex = extensionsComparison.compareExtensions(fileReader.readFirstBytes(), fileReader.readLastBytes());
            if (ex != null) return ex;
        }

        if (plainTextChecker.checkIsPlaneTextFile()) return "txt";
        return null;
    }

}
