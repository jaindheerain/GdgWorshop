package dheerain.jain.gdgworkshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dheerain on 30-01-2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    ArrayList<Student> students;
    Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        Student student=students.get(position);
        if(student.getName().equals("A"))
            return 0;
        return 1;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int view;
        if(viewType==0)
            view=R.layout.layout_tupple;
        else
            view=R.layout.layout_tupple1;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(view,parent,false);
        StudentViewHolder studentViewHolder=new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student=students.get(position);
        holder.tvName.setText(student.getName().toString());
        holder.tvCourse.setText(student.getCourse().toString());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvCourse;

        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvCourse=itemView.findViewById(R.id.tvCourse);
        }
    }
}
