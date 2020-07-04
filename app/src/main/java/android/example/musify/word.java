package android.example.musify;

import android.os.Parcel;
import android.os.Parcelable;

public class word implements Parcelable {
    private String song_name;
    private String singer_name;
    private int song_id;
    private int sing_id;

    public word(String name, String singer, int image,int sing) {
        song_name = name;
        singer_name = singer;
        song_id = image;
        sing_id = sing;
    }

    protected word(Parcel in) {
        song_name = in.readString();
        singer_name = in.readString();
        song_id = in.readInt();
        sing_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<word> CREATOR = new Creator<word>() {
        @Override
        public word createFromParcel(Parcel in) {
            return new word(in);
        }

        @Override
        public word[] newArray(int size) {
            return new word[size];
        }
    };

    public String getSongName() {
        return song_name;
    }

    public String getSingerName() {
        return singer_name;
    }

    public int getSongId() {
        return song_id;
    }

    public int getSingId()
    {
        return sing_id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(song_name);
        dest.writeString(singer_name);
        dest.writeInt(song_id);
        dest.writeInt(sing_id);
    }
}
