package lineto.org.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lineto.org.components.models.ImageObject;
import lineto.org.demo.adapters.ImageSimpleAdapter;


public class ImageListView extends ActionBarActivity {

    private ListView listvw;
    private ImageSimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list_view);

        setListView();
    }

    private List<ImageObject> getLists(){
        List<ImageObject> images = new ArrayList<ImageObject>();
        images.add(new ImageObject(false,"http://blogs-images.forbes.com/thomasbrewster/files/2014/09/Android1.png",R.drawable.no_image));
        images.add(new ImageObject(false,"http://cdn.bgr.com/2012/11/android-icon.jpg",R.drawable.no_image));
        images.add(new ImageObject(false,"http://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS",R.drawable.no_image));
        images.add(new ImageObject(false,"http://movilarena.com/wp-content/uploads/2012/04/musica-android.jpg",R.drawable.no_image));
        images.add(new ImageObject(false,"http://www.definemg.com/wp-content/uploads/2013/01/android.jpg",R.drawable.no_image));
        images.add(new ImageObject(false,"http://www.rbowman.co.uk/files/2012/03/tux_in_android_robot_costume_2_by_whidden-d3aq9k0.png",R.drawable.no_image));
        images.add(new ImageObject(false,"https://lh4.ggpht.com/C_B6YXyEaPxC1KYRARAU7xqrMDFf38DC4AKpazbrP4hgfNft1afvdET2Bffk8ZVayXrG=w170",R.drawable.no_image));
        images.add(new ImageObject(false,"http://media2.giga.de/2013/05/Opera_Android-robog.png",R.drawable.no_image));
        return images;
    }

    private void setListView(){
        listvw = (ListView) findViewById(R.id.listvw);
        List<ImageObject> imos = new ArrayList<ImageObject>();

        adapter = new ImageSimpleAdapter(this, getLists());
        listvw.setAdapter(adapter);
    }
}
