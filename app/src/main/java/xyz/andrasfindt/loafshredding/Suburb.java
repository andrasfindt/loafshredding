package xyz.andrasfindt.loafshredding;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import xyz.andrasfindt.loafshredding.util.RegexUtil;

import java.util.regex.Matcher;

public class Suburb implements Parcelable {
    public static final Creator<Suburb> CREATOR = new Creator<Suburb>() {
        @Override
        public Suburb createFromParcel(Parcel in) {
            return new Suburb(in);
        }

        @Override
        public Suburb[] newArray(int size) {
            return new Suburb[size];
        }
    };
    private String cityPowerId;
    private String blockCode;
    private String name;

    public Suburb(String lineItem) {
        Matcher matcher = RegexUtil.SUBURB_LISTING_PATTERN.matcher(lineItem);
        if (matcher.matches()) {
            this.cityPowerId = matcher.group(1) + "-" + matcher.group(2);
            this.blockCode = matcher.group(2);
            this.name = cleanName(matcher.group(3));
        }
    }

    protected Suburb(Parcel in) {
        cityPowerId = in.readString();
        blockCode = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityPowerId);
        dest.writeString(blockCode);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private String cleanName(String group) {
        if (group == null)
            return null;
        String trim = group.trim();
        if (trim.endsWith(",")) {
            return trim.substring(0, trim.length() - 1).trim();
        } else
            return trim;
    }

    public String getCityPowerId() {
        return cityPowerId;
    }

    public void setCityPowerId(String cityPowerId) {
        this.cityPowerId = cityPowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public String getBlockCode() {
        return blockCode;
    }
}
