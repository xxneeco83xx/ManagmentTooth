package cote.listador;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas Buzzi on 3/6/2016.
 */

public class Query implements Queryable
{
    private Context _Context;
    private ContentResolver contentResolver;
    private Cursor cursor;

    public Query(Context applicationContext)
    {
        _Context = applicationContext;
        contentResolver = _Context.getContentResolver();
    }

    /*  polymorphism for execute query's type audio    */
    public List<FileName> runQuery(MediaStore.Audio.Media mediaStore)
    {
        List<FileName> filesMedia = new ArrayList<FileName>();

        //Some audio may be explicitly marked as not being music
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] columns = new String[] {
                mediaStore._ID,
                mediaStore.TITLE,
                mediaStore.DATA,
                mediaStore.MIME_TYPE,
                mediaStore.SIZE };

        cursor = contentResolver.query(mediaStore.EXTERNAL_CONTENT_URI, columns, selection, null, null );

        while(cursor.moveToNext())
        {
            FileName fileName = new FileName();

            fileName.setFullPath(cursor.getString(3));
            fileName.setExtensionType(cursor.getString(4).split("\\.")[1]);
            fileName.setFileName(cursor.getString(4).split("\\.")[0]);
            fileName.setContentType("MUSIC");

            filesMedia.add(fileName);
        }

        return filesMedia;
    }

    /*  polymorphism for execute query's type images    */
    public List<FileName> runQuery(MediaStore.Images.Media mediaStore)
    {
        List<FileName> filesMedia = new ArrayList<FileName>();

        String[] columns = new String[] {
                mediaStore._ID,
                mediaStore.TITLE,
                mediaStore.DATA,
                mediaStore.MIME_TYPE,
                mediaStore.SIZE };

        cursor = contentResolver.query(mediaStore.EXTERNAL_CONTENT_URI, columns, null, null, null );

        while(cursor.moveToNext())
        {
            FileName fileName = new FileName();

            fileName.setFullPath(cursor.getString(3));
            fileName.setExtensionType(cursor.getString(4).split("\\.")[1]);
            fileName.setFileName(cursor.getString(4).split("\\.")[0]);
            fileName.setContentType("IMAGES");

            filesMedia.add(fileName);
        }

        return filesMedia;
    }

    /*  polymorphism for execute query's type video    */
    public List<FileName> runQuery(MediaStore.Video.Media mediaStore)
    {
        List<FileName> filesMedia = new ArrayList<FileName>();

        String[] columns = new String[] {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.MIME_TYPE,
                MediaStore.Audio.Media.SIZE };

        cursor = contentResolver.query(mediaStore.EXTERNAL_CONTENT_URI, columns, null, null, null );

        while(cursor.moveToNext())
        {
            FileName fileName = new FileName();

            fileName.setFullPath(cursor.getString(3));
            fileName.setExtensionType(cursor.getString(4).split("\\.")[1]);
            fileName.setFileName(cursor.getString(4).split("\\.")[0]);
            fileName.setContentType("VIDEO");

            filesMedia.add(fileName);
        }

        return filesMedia;
    }
}
