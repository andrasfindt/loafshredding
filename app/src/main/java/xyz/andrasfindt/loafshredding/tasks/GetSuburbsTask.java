package xyz.andrasfindt.loafshredding.tasks;

import android.os.AsyncTask;
import android.util.Log;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import xyz.andrasfindt.loafshredding.Block;
import xyz.andrasfindt.loafshredding.Cache;
import xyz.andrasfindt.loafshredding.StageEnum;
import xyz.andrasfindt.loafshredding.Suburb;
import xyz.andrasfindt.loafshredding.util.RegexUtil;

import java.io.IOException;
import java.util.regex.Matcher;

import static xyz.andrasfindt.loafshredding.Config.DEBUG;

public class GetSuburbsTask extends AsyncTask<Void, Void, String> {

    private OkHttpClient client;
    private SuburbsCallback callback;

    public GetSuburbsTask(OkHttpClient client, SuburbsCallback callback) {
        this.client = client;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        StageEnum currentStage = Cache.getInstance().getCurrentStage();
        if (currentStage == null /*|| currentStage == StageEnum.UNKNOWN*/) {
            Log.i("GetSuburbsTask", "suburb info not in cache, retrieving");

            HttpUrl url = new HttpUrl.Builder()
                    .scheme("https")
                    .host("www.citypower.co.za")
                    .addPathSegment("customers")
                    .addPathSegment("Pages")
                    .addPathSegment("Load_Shedding.aspx")
                    .build();
            Request build = new Request.Builder().get().url(url).build();
            try {
                return client.newCall(build).execute().body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("GetSuburbsTask", "suburb info retrieved from cache");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String string) {
        if (string != null) {
            Cache instance = Cache.getInstance();
            instance.setCurrentStage(extractStage(string));
            int index = string.indexOf("<ul id=\"allSuburbs\">");
            int index1 = string.indexOf("</ul>", index) + 5;
            String allSuburbs = string.substring(index, index1);
            if (DEBUG) {
                Log.i("GetSuburbsTask", allSuburbs);
            }

            Block block1A = extractBlock(allSuburbs, "1A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block1A.toString());
            }
            Block block2A = extractBlock(allSuburbs, "2A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block2A.toString());
            }
            Block block3A = extractBlock(allSuburbs, "3A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block3A.toString());
            }
            Block block4A = extractBlock(allSuburbs, "4A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block4A.toString());
            }
            Block block5A = extractBlock(allSuburbs, "5A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block5A.toString());
            }
            Block block6A = extractBlock(allSuburbs, "6A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block6A.toString());
            }
            Block block7A = extractBlock(allSuburbs, "7A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block7A.toString());
            }
            Block block8A = extractBlock(allSuburbs, "8A");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block8A.toString());
            }
            Block block1B = extractBlock(allSuburbs, "1B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block1B.toString());
            }
            Block block2B = extractBlock(allSuburbs, "2B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block2B.toString());
            }
            Block block3B = extractBlock(allSuburbs, "3B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block3B.toString());
            }
            Block block4B = extractBlock(allSuburbs, "4B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block4B.toString());
            }
            Block block5B = extractBlock(allSuburbs, "5B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block5B.toString());
            }
            Block block6B = extractBlock(allSuburbs, "6B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block6B.toString());
            }
            Block block7B = extractBlock(allSuburbs, "7B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block7B.toString());
            }
            Block block8B = extractBlock(allSuburbs, "8B");
            if (DEBUG) {
                Log.i("GetSuburbsTask", block8B.toString());
            }
        }
        callback.onSuccess();
    }

    private Block extractBlock(String allSuburbs, String key) {
        String searchString = "<div class=\"suburbList\"><b>" + key + "</b>";
        int offset = searchString.length();
        int listStart = allSuburbs.indexOf(searchString) + offset;
        int listEnd = allSuburbs.indexOf("</div>", listStart);
        String list = allSuburbs.substring(listStart, listEnd).trim();
        if (DEBUG) {
            Log.i("GetSuburbsTask", list);
        }
        String[] split = list.split("</li>");
        Block block = new Block();
        Cache.getInstance().putBlock(key, block);
        for (String lineItem : split) {
            block.getSuburbs().add(new Suburb(lineItem + "</li>"));
        }
        return block;
    }

    private int extractStage(String string) {
        Matcher matcher = RegexUtil.STAGE_PATTERN.matcher(string);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
