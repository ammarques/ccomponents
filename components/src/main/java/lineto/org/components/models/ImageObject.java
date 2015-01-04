package lineto.org.components.models;

/**
 * Created by amarques on 1/1/15.
 */
public class ImageObject {
    private boolean local = false;
    private String url;
    private int placeHolder;

    public ImageObject(){}

    public ImageObject(boolean local, String url, int placeHolder) {
        this.local = local;
        this.url = url;
        this.placeHolder = placeHolder;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }
}
