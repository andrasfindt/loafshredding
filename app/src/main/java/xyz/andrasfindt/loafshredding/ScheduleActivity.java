package xyz.andrasfindt.loafshredding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import xyz.andrasfindt.loafshredding.tasks.GetScheduleForSuburbTask;
import xyz.andrasfindt.loafshredding.tasks.ScheduleCallback;
import xyz.andrasfindt.loafshredding.tasks.ScheduleRequest;
import xyz.andrasfindt.loafshredding.view.ScheduleAdapter;
import xyz.andrasfindt.loafshredding.view.StageSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    private final List<ScheduleEvent> scheduleEvents = new ArrayList<>();
    private int selected;
    private Suburb suburb;
    private ScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Spinner spinner = findViewById(R.id.stage_spinner);
        spinner.setAdapter(new StageSpinnerAdapter(this));
        RecyclerView recyclerView = findViewById(R.id.schedule_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ScheduleAdapter(this, scheduleEvents);
        recyclerView.setAdapter(adapter);
        TextView textView = findViewById(R.id.suburb_name);
        Intent intent = getIntent();
        if (intent != null) {
            suburb = intent.getParcelableExtra(Config.SUBURB);
            textView.setText(String.format("%s (%s)", suburb.getName(), suburb.getBlockCode()));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    loadData(StageEnum.values()[position], suburb);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            selected = StageEnum.valueOf(intent.getIntExtra(Config.STAGE, StageEnum.ONE.asInt())).ordinal();
            spinner.setSelection(selected);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void loadData(StageEnum stage, Suburb suburb) {
        OkHttpClient client = new OkHttpClient();
        new GetScheduleForSuburbTask(client, new ScheduleCallback() {
            @Override
            public void onSuccess() {
                Log.i("ScheduleActivity", "success");
                scheduleEvents.clear();
                scheduleEvents.addAll(Cache.getInstance().getSchedule(new ScheduleCacheKey(suburb.getBlockCode(), stage)));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure() {

            }
        }).execute(new ScheduleRequest(stage, suburb));
    }
}
