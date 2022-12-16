package xyz.andrasfindt.loafshredding.tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import xyz.andrasfindt.loafshredding.Cache;
import xyz.andrasfindt.loafshredding.Config;
import xyz.andrasfindt.loafshredding.ScheduleCacheKey;
import xyz.andrasfindt.loafshredding.ScheduleEvent;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetScheduleForSuburbTask extends AsyncTask<ScheduleRequest, Void, List<ScheduleEvent>> {
    private OkHttpClient client;
    private ScheduleCallback scheduleCallback;
    private ScheduleRequest request;
    private long timeMillis;

    public GetScheduleForSuburbTask(OkHttpClient client, ScheduleCallback scheduleCallback) {
        this.client = client;
        this.scheduleCallback = scheduleCallback;
    }

    @Override
    protected List<ScheduleEvent> doInBackground(ScheduleRequest... args) {
        request = args[0];
        List<ScheduleEvent> schedule = Cache.getInstance().getSchedule(new ScheduleCacheKey(request));
        if (schedule == null) {
            Log.i("GetScheduleForSuburbTask", "schedule " + request.getSuburb().getBlockCode() + "-Stage" + request.getStageEnum().asInt() + " not in cache, retrieving");
            timeMillis = System.currentTimeMillis();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("https")
                    .host("www.citypower.co.za")
                    .addPathSegment("LoadSheddingSchedule.axd")
                    .addQueryParameter("Suburb", request.getSuburb().getCityPowerId())
                    .addQueryParameter("Stage", "Stage" + request.getStageEnum().asInt())
                    .addQueryParameter("_", String.valueOf(timeMillis))
                    .build();
            Request build = new Request.Builder().get().url(url).build();
            try {
                String string = client.newCall(build).execute().body().string();
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<ScheduleEvent>>() {
                }.getType();
                schedule = gson.fromJson(string, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("GetScheduleForSuburbTask", "schedule " + request.getSuburb().getBlockCode() + "-Stage" + request.getStageEnum().asInt() + " retrieved from cache");
        }
        return schedule;
    }

    @Override
    protected void onPostExecute(List<ScheduleEvent> list) {
        List<ScheduleEvent> scheduleEvents = list.stream().filter(s -> s.getStartDate().getTime() > timeMillis).collect(Collectors.toList());
        if (Config.DEBUG) {
            scheduleEvents.forEach(s -> Log.i("GetScheduleForSuburbTask", s.toString()));
        }
        Cache.getInstance().putSchedule(new ScheduleCacheKey(request), scheduleEvents);
        scheduleCallback.onSuccess();
    }
}
