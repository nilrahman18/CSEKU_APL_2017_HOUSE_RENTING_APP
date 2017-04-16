package com.example.niloy.my_house_renting_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niloy on 4/3/2017.
 */

public class CustomAdapter extends ArrayAdapter<Ads> implements Filterable {
    ArrayList<Ads> adList;
    LayoutInflater vi;
    ArrayList<Ads> origAdsList;
    int Resource;
    ViewHolder holder;
    private CountryFilter filter;

    public CustomAdapter(Context context, int resource, ArrayList<Ads> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        adList = objects;
        this.origAdsList = adList;
    }

    public void resetData() {
        adList = (ArrayList<Ads>) origAdsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.imageview = (ImageView) v.findViewById(R.id.movieImage);
            holder.name = (TextView) v.findViewById(R.id.nameTxt);
            holder.owner = (TextView) v.findViewById(R.id.name2Txt);
            holder.division = (TextView) v.findViewById(R.id.divisionTxt);
            holder.address = (TextView) v.findViewById(R.id.addressTxt);
            holder.description = (TextView) v.findViewById(R.id.descriptionTxt);
            holder.price = (TextView) v.findViewById(R.id.priceTxt);
            holder.contact = (TextView) v.findViewById(R.id.contactTxt);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        try {
            holder.imageview.setImageResource(R.drawable.homeicon);
            new DownloadImageTask(holder.imageview).execute(adList.get(position).getURL());
            holder.imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.name.setText("Home Name : " + adList.get(position).getName());
            holder.owner.setText("Owner Name : " + adList.get(position).getOwner());
            holder.division.setText("Division : " + adList.get(position).getDivision());
            holder.address.setText("Address : " + adList.get(position).getAddress());
            holder.description.setText("Description : " + adList.get(position).getDescription());
            holder.price.setText("Price : " + Integer.toString(adList.get(position).getPrice()));
            holder.contact.setText("Contact : " + Integer.toString(adList.get(position).getContact()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return v;
    }

    static class ViewHolder {
        public ImageView imageview;
        public TextView name;
        public TextView owner;
        public TextView division;
        public TextView address;
        public TextView description;
        public TextView price;
        public TextView contact;

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CountryFilter();
        }
        return filter;
    }

    private class CountryFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<Ads> filteredItems = new ArrayList<Ads>();

                for (int i = 0, l = adList.size(); i < l; i++) {
                    Ads country = adList.get(i);
                    if (country.toString().toLowerCase().contains(constraint))
                        filteredItems.add(country);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            } else {
                synchronized (this) {
                    result.values = adList;
                    result.count = adList.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            origAdsList = (ArrayList<Ads>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = origAdsList.size(); i < l; i++)
                add(origAdsList.get(i));
            notifyDataSetInvalidated();
        }
    }

}
