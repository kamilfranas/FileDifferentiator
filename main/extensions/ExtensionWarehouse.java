package main.extensions;

import java.util.LinkedList;
import java.util.List;

public class ExtensionWarehouse {
    private List<Extension> extensions;

    public ExtensionWarehouse(){
        extensions = new LinkedList<>();

        extensions.add(new Extension("gif","474946383961", null));
        extensions.add(new Extension("gif", "474946383761", null));
        extensions.add(new Extension("jpg", "FFD8", "FFD9"));
        extensions.add(new Extension("jpeg", "FFD8", "FFD9"));
        extensions.add(new Extension("jpe", "FFD8", "FFD9"));
        extensions.add(new Extension("jif", "FFD8", "FFD9"));
        extensions.add(new Extension("jfif", "FFD8", "FFD9"));
        extensions.add(new Extension("jfi", "FFD8", "FFD9"));
        extensions.add(new Extension("png", "89504E47", null));
        extensions.add(new Extension("pdf", "25504446", null));
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

}
