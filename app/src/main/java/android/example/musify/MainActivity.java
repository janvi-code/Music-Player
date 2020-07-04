package android.example.musify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    wordAdapter adapter;
    ArrayList<word> words;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        words = new ArrayList<word>();
        words.add(new word("Laare", "Maninder Buttar", R.drawable.laare,R.raw.laaresong));
        words.add(new word("Ehna Chauni aa", "Jassi Gill", R.drawable.chauni,R.raw.chaunisong));
        words.add(new word("Regret", "Tanishq", R.drawable.regret,R.raw.regretsong));
        words.add(new word("Chor", "Ninja", R.drawable.chor,R.raw.chorsong));
        words.add(new word("Hath Chumme", "Ammy Virk", R.drawable.haath,R.raw.hathsong));
        words.add(new word("Rooh", "Sharry Maan", R.drawable.rroh,R.raw.roohsong));
        words.add(new word("Love you Oye", "Prabh Gill", R.drawable.love,R.raw.lovesong));
        words.add(new word("Zindagi", "Akhil", R.drawable.zindagi,R.raw.zindagisong));
        words.add(new word("Badnaam", "Mankirat Aulak", R.drawable.badnaam,R.raw.badnaamsong));
        words.add(new word("Pagal", "Daljit Dosanjh", R.drawable.pagal,R.raw.pagalsong));
        words.add(new word("Toronto", "Jass Manak", R.drawable.toronto,R.raw.torontosong));
        words.add(new word("Sarvann", "Amrinder Gill", R.drawable.sarvaan,R.raw.sarvaansong));
        words.add(new word("Gora rang", "Gurnaam Buttar", R.drawable.rang,R.raw.rangsong));

        words.add(new word("Shopping", "Jass Manak", R.drawable.shop,R.raw.shoppingsong));
        words.add(new word("Kala Suit", "Ammy virk", R.drawable.kala,R.raw.kalasong));


        adapter = new wordAdapter(this, words);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        SearchView sView = (SearchView) findViewById(R.id.serach_view);
        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Intent intent = new Intent(MainActivity.this, PlayingFromPlayList.class);
                intent.putExtra("Item", words.get(position));
                startActivity(intent);
            }
        });


    }
}
