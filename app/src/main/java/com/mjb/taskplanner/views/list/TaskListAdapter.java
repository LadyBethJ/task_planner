package com.mjb.taskplanner.views.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mjb.taskplanner.R;
import com.mjb.taskplanner.model.Task;
import com.mjb.taskplanner.views.taskdetail.TaskDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Task} and makes a call to the
 * intent which will open the selected task's detail in a new activity.
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private final List<Task> taskItems;
    private Context context;

    public TaskListAdapter(Context context, List<Task> items) {
        taskItems = items;
        this.context = context;
        this.context = context;
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
        final Task task = taskItems.get(position);

        holder.itemName.setText(task.getName());
        holder.itemList.setText(task.getList());
        holder.itemDate.setText(task.getDate());
        holder.itemHour.setText(task.getHour());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO cuando BBDD ready pasar el id de la tarea, ahora pasamos todo
                Intent intent = new Intent(context, TaskDetailActivity.class);
                intent.putExtra("NAME", task.getName());
                intent.putExtra("LIST", task.getList());
                intent.putExtra("DATE", task.getDate());
                intent.putExtra("HOUR", task.getHour());
                context.startActivity(intent);
            }
        });
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
        @BindView(R.id.card_view) CardView cardView;
        public Task mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
