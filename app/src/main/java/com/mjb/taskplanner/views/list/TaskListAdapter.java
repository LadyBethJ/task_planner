package com.mjb.taskplanner.views.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mjb.taskplanner.R;
import com.mjb.taskplanner.model.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Task} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private final List<Task> taskItems;
    private Context context;
    //private static LayoutInflater inflater = null;

    public TaskListAdapter(Context context, List<Task> items) {
        taskItems = items;
        this.context = context;
        this.context = context;
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Populate the Listview
        final int pos = position;
        Task task = taskItems.get(position);

        holder.itemName.setText(task.getName());
        holder.itemList.setText(task.getList());
        holder.itemDate.setText(task.getDate());
        holder.itemHour.setText(task.getHour());

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_name) TextView itemName;
        @BindView(R.id.item_list) TextView itemList;
        @BindView(R.id.item_date) TextView itemDate;
        @BindView(R.id.item_hour) TextView itemHour;
        public Task mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
