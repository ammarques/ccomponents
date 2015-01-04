package lineto.org.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.io.File;

import lineto.org.components.models.ImageObject;

/**
 * Created by amarques on 1/1/15.
 */
public class Image extends RelativeLayout {

    private ImageObject imo;
    private RelativeLayout container;
    private ImageView img;
    private ProgressBar load;

    public Image(Context context) {
        super(context);
    }

    public void update(final ImageObject imo) {
        this.imo = imo;
        inflate();
    }

    public Image(Context context, final ImageObject imo) {
        super(context);
        this.imo = imo;
        inflate();
    }

    public Image(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.Image);

        if(this.imo == null){
            this.imo = new ImageObject();
        }

        this.imo.setUrl(styledAttrs.getString(R.styleable.Image_img_url));
        this.imo.setLocal(styledAttrs.getBoolean(R.styleable.Image_img_local,false));
        this.imo.setPlaceHolder(styledAttrs.getResourceId(R.styleable.Image_img_placeholder,0));

        styledAttrs.recycle();
        inflate();
    }

    public void inflate() {
        if (container == null)
            container = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.custom_image, this);

        this.img = (ImageView) container.findViewById(R.id.img);
        this.load = (ProgressBar) container.findViewById(R.id.load);
        load();
    }

    public void setPlaceHolder(){
        if(this.imo.getPlaceHolder() > 0){
            this.img.setBackgroundResource(imo.getPlaceHolder());
            this.load.setVisibility(View.GONE);
        }

    }

    public void load() {
        this.load.setVisibility(View.VISIBLE);

        if (this.imo.getUrl() != null) {

            Uri uri = Uri.parse(this.imo.getUrl());

            if (this.imo.isLocal())
                uri = Uri.fromFile(new File(this.imo.getUrl()));

//            Picasso.with(getContext()).setIndicatorsEnabled(true);
//            Picasso.with(getContext()).setLoggingEnabled(true);

            Picasso.with(getContext())
                    .load(uri)
                    .skipMemoryCache()
                    .into(this.img, new Callback() {
                        @Override
                        public void onSuccess() {
                            img.setBackgroundResource(android.R.color.transparent);
                            load.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            setPlaceHolder();
                            load.setVisibility(View.GONE);
                        }
                    });
        }else{
            setPlaceHolder();
        }
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public ProgressBar getLoad() {
        return load;
    }

    public void setLoad(ProgressBar load) {
        this.load = load;
    }
}