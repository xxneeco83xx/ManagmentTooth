package cote.listador;

import android.provider.MediaStore;

import java.util.List;

/**
 * Created by Nicoals Buzzi on 3/6/2016.
 */
public interface Queryable
{

    public List<FileName> runQuery(MediaStore.Audio.Media mediaStore);
    public List<FileName> runQuery(MediaStore.Images.Media mediaStore);
    public List<FileName> runQuery(MediaStore.Video.Media mediaStore);

}
