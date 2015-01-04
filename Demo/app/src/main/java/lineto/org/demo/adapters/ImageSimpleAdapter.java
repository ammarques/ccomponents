package lineto.org.demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import lineto.org.components.Image;
import lineto.org.components.models.ImageObject;
import lineto.org.demo.R;

/**
 * Created by amarques on 1/4/15.
 */
public class ImageSimpleAdapter extends BaseAdapter {

    private List<ImageObject> imos;
    private Context context;

    public ImageSimpleAdapter(Context context, List<ImageObject> imos) {
        this.imos = imos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.imos.size();
    }

    @Override
    public ImageObject getItem(int position) {
        return this.imos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_image_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image = (Image) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageObject imo = getItem(position);
        viewHolder.image.update(imo);

        return convertView;
    }

    public static class ViewHolder {
        Image image;
    }
}
