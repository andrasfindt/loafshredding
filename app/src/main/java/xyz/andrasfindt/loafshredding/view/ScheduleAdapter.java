package xyz.andrasfindt.loafshredding.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import xyz.andrasfindt.loafshredding.ScheduleEvent;
import xyz.andrasfindt.loafshredding.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    public static final SimpleDateFormat DAY_DATE_FORMAT = new SimpleDateFormat("EEE d MMM", Locale.getDefault());
    public static final SimpleDateFormat TIME_DATE_FORMAT = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private final Context context;
    private final List<ScheduleEvent> scheduleEvents;

    public ScheduleAdapter(Context context, List<ScheduleEvent> scheduleEvents) {
        this.context = context;
        this.scheduleEvents = scheduleEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedule_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.updateView(scheduleEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return scheduleEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView day;
        private TextView start;
        private TextView end;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.schedule_day);
            start = itemView.findViewById(R.id.schedule_start_date);
            end = itemView.findViewById(R.id.schedule_end_date);
        }

        public void updateView(ScheduleEvent event) {
            day.setText(DAY_DATE_FORMAT.format(event.getStartDate()));
            start.setText(TIME_DATE_FORMAT.format(event.getStartDate()));
            end.setText(TIME_DATE_FORMAT.format(event.getEndDate()));
        }
    }
}
