package xyz.andrasfindt.loafshredding.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import xyz.andrasfindt.loafshredding.R;
import xyz.andrasfindt.loafshredding.Suburb;

import java.util.List;

public class SuburbAdapter extends RecyclerView.Adapter<SuburbAdapter.ViewHolder> {
    private final List<Suburb> suburbs;
    private final View.OnClickListener onClickListener;
    private final Context context;

    public SuburbAdapter(Context context, List<Suburb> suburbs, View.OnClickListener onClickListener) {
        this.context = context;
        this.suburbs = suburbs;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.suburb_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.updateView(suburbs.get(position));
    }

    @Override
    public int getItemCount() {
        return suburbs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView blockCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(onClickListener);
            name = itemView.findViewById(R.id.suburb_name);
            blockCode = itemView.findViewById(R.id.suburb_block_code);
        }

        public void updateView(Suburb suburb) {
            name.setText(suburb.getName());
            blockCode.setText(suburb.getBlockCode());
            itemView.setTag(suburb);
        }
    }
}
