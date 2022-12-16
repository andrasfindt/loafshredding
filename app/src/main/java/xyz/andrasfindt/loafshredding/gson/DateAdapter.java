package xyz.andrasfindt.loafshredding.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateAdapter extends TypeAdapter<Date> {

    public static final String REGEX = "/Date\\((\\d+)\\)/";

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
//        out.value(String.format(Locale.getDefault(), "/Date(%d)/", value.getTime()));
        out.value(String.format(Locale.getDefault(), "%s", value));
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        String s = in.nextString();
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher = p.matcher(s);
        if (matcher.matches()) {
            return new Date(Long.valueOf(matcher.group(1)));
        }
        return null;
    }
}
