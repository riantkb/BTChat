package jp.ac.titech.itpro.sdl.btchat.message;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatMessage implements Parcelable {
    final static String FIELD_SEQ = "seq";
    final static String FIELD_TIME = "time";
    final static String FIELD_CONTENT = "content";
    final static String FIELD_SENDER = "sender";
    final static String FIELD_IS_SOUND = "is_sound";

    public int seq;
    public long time;
    public String content;
    public String sender;
    public boolean isSound;

    public ChatMessage(int seq, long time, String content, String sender) {
        this.seq = seq;
        this.time = time;
        this.content = content;
        this.sender = sender;
        this.isSound = false;
    }

    // SoundMessage
    public ChatMessage(int seq, long time, String sender) {
        this.seq = seq;
        this.time = time;
        this.content = "";
        this.sender = sender;
        this.isSound = true;
    }

    private ChatMessage(Parcel in) {
        seq = in.readInt();
        time = in.readLong();
        content = in.readString();
        sender = in.readString();
        isSound = in.readInt() == 1;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(seq);
        dest.writeLong(time);
        dest.writeString(content);
        dest.writeString(sender);
        dest.writeInt(isSound ? 1 : 0);
    }

    public static final Parcelable.Creator<ChatMessage> CREATOR =
            new Parcelable.Creator<ChatMessage>() {
                @Override
                public ChatMessage createFromParcel(Parcel src) {
                    return new ChatMessage(src);
                }

                @Override
                public ChatMessage[] newArray(int size) {
                    return new ChatMessage[size];
                }
            };
}
