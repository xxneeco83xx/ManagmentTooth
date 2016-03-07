package cote.listador;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas Buzzi on 3/6/2016.
 */

public class MainActivity extends AppCompatActivity {

    private Context _context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _context = getApplicationContext();

        LoadItems();
    }


    public void LoadItems()
    {
        Query query = new Query(_context);
        List<FileName> files = new ArrayList<FileName>();

        MediaStore.Audio.Media objMedia = new MediaStore.Audio.Media();

        files = query.runQuery(objMedia);

        List<String> listFiles = new ArrayList<String>();

        for ( FileName file : files )
        {
            listFiles.add(file.getFileName());
        }

        if ( listFiles.isEmpty() )
        {
            listFiles.add("No se han detectado elementos de tipo audio");
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(_context, android.R.layout.simple_list_item_1, android.R.id.text1, listFiles);
        listView.setAdapter(adapter);

        return;
    }
}
