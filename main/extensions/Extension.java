package main.extensions;

public class Extension {
    private String extensionName;
    private String firstBytes;
    private String lastBytes;

    public Extension(String extensionName, String firstBytes, String lastBytes) {
        this.extensionName = extensionName;
        this.firstBytes = firstBytes;
        this.lastBytes = lastBytes;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public String getFirstBytes() {
        return firstBytes;
    }

    public String getLastBytes() {
        return lastBytes;
    }

}
