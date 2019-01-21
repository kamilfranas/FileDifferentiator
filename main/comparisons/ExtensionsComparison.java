package main.comparisons;

import main.extensions.Extension;

import java.util.List;

public class ExtensionsComparison {
    private List<Extension> extensionsList;

    public ExtensionsComparison(List<Extension> extensionsList) {
        this.extensionsList = extensionsList;
    }

    public String compareExtensions(String firstBytes, String lastBytes){
       StringBuilder sb = new StringBuilder();

        for(Extension e : extensionsList){

            if(firstBytes.startsWith(e.getFirstBytes())){
                if(e.getLastBytes() == null){ sb.append(".");
                   sb.append(e.getExtensionName());
                } else if(lastBytes.endsWith(e.getLastBytes())) {
                    sb.append(".");
                    sb.append(e.getExtensionName());
                }
            }
        }
        if(sb.length() > 0) return sb.toString();
        return null;
    }

}
