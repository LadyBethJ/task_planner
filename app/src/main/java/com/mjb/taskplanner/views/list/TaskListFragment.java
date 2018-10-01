package com.mjb.taskplanner.views.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjb.taskplanner.R;
import com.mjb.taskplanner.model.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TaskListFragment extends Fragment implements TaskListView {

    private static final String TAG = TaskListFragment.class.getSimpleName();
    private TaskListAdapter adapter;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    private TaskListPresenter presenter;

    public TaskListFragment() {
    }

    public static TaskListFragment newInstance() {
        TaskListFragment fragment = new TaskListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new TaskListPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        ButterKnife.bind(this,view);

        init();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    public void init() {
        adapter = new TaskListAdapter(this.getContext(), getTasksData());
        recyclerView.setAdapter(adapter);
    }

    public List<Task> getTasksData() {
        //TODO recuperar las tareas de la BBDD
        List<Task> sampleTask = new ArrayList<>();
        sampleTask.add(new Task("Comprar detergente","Limpieza", "2018-09-23", "18:35"));
        sampleTask.add(new Task("Comprar patatas","Comida", "2018-09-23", "18:35"));
        sampleTask.add(new Task("Comprar chocolate","Comida", "2018-09-23", "18:35"));
        return sampleTask;
    }

}
