package lineto.org.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ActionMenuView;
import android.widget.LinearLayout;

import lineto.org.components.Image;
import lineto.org.components.models.ImageObject;


public class ImageSingle extends Activity {

    public Image custom_image;
    public LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_xml);

        container = (LinearLayout) findViewById(R.id.container);

        initializeComponent();
        programmaticallyCreated();
    }

    public void initializeComponent(){
        String url = "http://www.deadzebra.com/dyzplastic/images/android-s1-7b.jpg";
        custom_image = (Image) findViewById(R.id.custom_image);
        custom_image.update(new ImageObject(false, url, R.drawable.no_image));
    }

    public void programmaticallyCreated(){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(182,182);
        params.setMargins(0,20,0, 0);

        String url = "http://www.deadzebra.com/dyzplastic/images/android-s1-sc.jpg";
        Image image = new Image(this,new ImageObject(false, url, R.drawable.no_image));
        image.setBackgroundColor(Color.BLACK);
        image.setLayoutParams(params);
        container.addView(image);
    }


}
