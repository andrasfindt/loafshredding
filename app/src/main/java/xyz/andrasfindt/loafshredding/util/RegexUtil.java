package xyz.andrasfindt.loafshredding.util;

import java.util.regex.Pattern;

public class RegexUtil {
    private static final String SUBURB_LISTING_REGEX = "<li class=\"suburbListing\" value=\"(\\d*)-(\\d[A|B])\"><a>(.*)</a></li>";
    public static final Pattern SUBURB_LISTING_PATTERN = Pattern.compile(SUBURB_LISTING_REGEX);

    private static final String STAGE_REGEX = "<div class=\"Stage(\\d+)Div\"";
    public static final Pattern STAGE_PATTERN = Pattern.compile(STAGE_REGEX);
}
