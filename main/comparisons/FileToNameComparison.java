package main.comparisons;

import main.extensions.Extension;
import main.extensions.ExtensionReader;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class FileToNameComparison {
    private String fromName;
    private String fromFile;

    public FileToNameComparison(String filePath, List<Extension> extensionsList) {
        File file = new File(filePath);
        ExtensionReader extensionReader = new ExtensionReader(file, extensionsList);
        this.fromName = extensionReader.readExtensionFromFileName(file.getName());
        this.fromFile = extensionReader.readExtensionFromFile();
    }

    public boolean compareNameToFileExtension()  {
            if(fromFile == null) {
                System.out.println("Extension (" + fromName+ ") is not handled or it is a text file");
                return false;
            } else {
                String[] strings = fromFile.split(Pattern.quote("."));
                for(String ex : strings){
                    if(ex.equalsIgnoreCase(fromName)) {
                        fromFile = ex;
                        return true;
                    }
                }
            }
            return false;
    }

    public String getFromName() {
        return fromName;
    }

    public String getFromFile() {
        return fromFile;
    }
}
