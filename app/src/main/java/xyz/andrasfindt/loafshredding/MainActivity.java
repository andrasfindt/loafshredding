package xyz.andrasfindt.loafshredding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import okhttp3.OkHttpClient;
import xyz.andrasfindt.loafshredding.tasks.GetSuburbsTask;
import xyz.andrasfindt.loafshredding.tasks.SuburbsCallback;
import xyz.andrasfindt.loafshredding.view.SuburbAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private final List<Suburb> allSuburbs = new ArrayList<>();
    private final List<Suburb> visibleSuburbs = new ArrayList<>();

    private SuburbAdapter suburbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient client = new OkHttpClient();
        final RecyclerView recyclerView = findViewById(R.id.suburb_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        suburbAdapter = new SuburbAdapter(this, visibleSuburbs, v -> {
            Object tag = v.getTag();
            if (tag instanceof Suburb) {
                if (Config.DEBUG) {
                    Log.i("MainActivity", tag.toString());
                }

                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                StageEnum currentStage = Cache.getInstance().getCurrentStage();
                intent.putExtra(Config.STAGE, currentStage == StageEnum.UNKNOWN ? StageEnum.ONE.asInt() : currentStage.asInt());
                intent.putExtra(Config.SUBURB, (Suburb) tag);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(suburbAdapter);
        final SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return onQueryTextChange(s);
            }

            @Override
            public boolean onQueryTextChange(String s) {
                visibleSuburbs.clear();
                if (!s.isEmpty()) {
                    visibleSuburbs.addAll(allSuburbs.stream().filter(suburb -> suburb.getName().toLowerCase().contains(s.toLowerCase())).collect(Collectors.toList()));
                }
                suburbAdapter.notifyDataSetChanged();
                return true;
            }
        });
        new GetSuburbsTask(client, new SuburbsCallback() {
            @Override
            public void onSuccess() {
                Log.i("MainActivity", "success");
                allSuburbs.addAll(Cache.getInstance().getAllSuburbs());
                suburbAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure() {

            }
        }).execute();
    }


}
