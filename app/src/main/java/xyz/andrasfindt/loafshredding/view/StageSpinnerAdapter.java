package xyz.andrasfindt.loafshredding.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import xyz.andrasfindt.loafshredding.R;
import xyz.andrasfindt.loafshredding.StageEnum;

public class StageSpinnerAdapter extends BaseAdapter {
    private Context context;

    public StageSpinnerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return StageEnum.values().length - 1;
    }

    @Override
    public Object getItem(int position) {
        return StageEnum.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StageEnum stage = StageEnum.values()[position];
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.stage_spinner_item, parent, false);
        }
        TextView stageTextView = convertView.findViewById(R.id.stage_text_view);
        stageTextView.setText(String.format("Stage %s", stage.asInt()));
        return convertView;
    }
}
