package android.example.musify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class wordAdapter extends ArrayAdapter<word> {
    private List<word> searchList;

    public wordAdapter(Context context, ArrayList<word> pWords) {
        super(context,0,pWords);
        searchList = new ArrayList<>(pWords);

    }

    public Filter getFilter() {
        return wordfilter;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        word local_word = getItem(position);


        TextView songTextView = (TextView) listItemView.findViewById(R.id.text1);
        songTextView.setText(local_word.getSongName());
        TextView singerTextView = (TextView) listItemView.findViewById(R.id.text2);
        singerTextView.setText(local_word.getSingerName());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);


        image.setImageResource(local_word.getSongId());
        return listItemView;
    }

    private Filter wordfilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<word> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(searchList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (word item : searchList) {
                    if (item.getSongName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                    if (item.getSingerName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        public CharSequence convertResultToString(Object resultValue) {
            return ((word) resultValue).getSongName();
        }

    };
}
