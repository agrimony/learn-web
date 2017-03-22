package novel.logic.model;

import java.util.Map;

/**
 * Created by hou on 3/12/17.
 */
public class CrawelListCondition {
    private String url;
    private String tagXPath;
    private String[] rules;
private Map<String,String> tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTagXPath() {
        return tagXPath;
    }

    public void setTagXPath(String tagXPath) {
        this.tagXPath = tagXPath;
    }


}
