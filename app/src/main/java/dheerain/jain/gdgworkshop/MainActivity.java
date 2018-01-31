package dheerain.jain.gdgworkshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students;
    EditText etName,etCourse;
    Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students=new ArrayList<>();
        students.add(new Student("A","CSE"));
        students.add(new Student("A","ECE"));
        students.add(new Student("A","IT"));
        students.add(new Student("B","CSE"));
        students.add(new Student("B","Ece"));
        students.add(new Student("B","IT"));
        students.add(new Student("A","CSE"));
        students.add(new Student("A","ECE"));
        students.add(new Student("A","IT"));
        students.add(new Student("B","CSE"));
        students.add(new Student("B","Ece"));
        students.add(new Student("B","IT"));
        Log.d("MA", "onCreate: "+students.size());
        btAdd=findViewById(R.id.btAdd);
        etCourse=findViewById(R.id.etCourse);
        etName=findViewById(R.id.etName);
        final StudentAdapter studentAdapter=new StudentAdapter(students,this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student(etName.getText().toString(),etCourse.getText().toString()));
                Log.d("MA", "onClick: "+students.size());
                studentAdapter.notifyDataSetChanged();

            }
        });
        RecyclerView rvList=findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(studentAdapter);
    }
}
