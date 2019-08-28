package creativeuiux.moviebooking2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.Cast_RecycleviewAdapter;
import modalclass.CastModalClass;

public class MovieInfoActivity extends AppCompatActivity {


    RecyclerView cast_recycleview;

    Cast_RecycleviewAdapter cast_recycleviewAdapter;

    private ArrayList<CastModalClass> castArrayList;

    TextView txtbooknow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        //Recycleview
        cast_recycleview = (RecyclerView) findViewById(R.id.cast_recycleview);


        txtbooknow = (TextView) findViewById(R.id.txtbooknow);

        txtbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MovieInfoActivity.this, ShowTimeActivity.class);
                startActivity(i);

            }
        });


        // Cast  - adding data in array list

        castArrayList = new ArrayList<>();
        castArrayList.add(new CastModalClass(R.drawable.cast1,"Michael B.\n" + "Jordan"));
        castArrayList.add(new CastModalClass(R.drawable.cast2,"Sylvester \nStallone"));
        castArrayList.add(new CastModalClass(R.drawable.cast3,"Tessa\n" + "Thompson"));
        castArrayList.add(new CastModalClass(R.drawable.cast4,"Dolph\n" + "Lundgren"));
        castArrayList.add(new CastModalClass(R.drawable.cast1,"Michael B.\n" + "Jordan"));
        castArrayList.add(new CastModalClass(R.drawable.cast2,"Sylvester \nStallone"));
        castArrayList.add(new CastModalClass(R.drawable.cast3,"Tessa\n" + "Thompson"));
        castArrayList.add(new CastModalClass(R.drawable.cast4,"Dolph\n" + "Lundgren"));

        //Use of Cast Adapter
        cast_recycleviewAdapter = new Cast_RecycleviewAdapter(MovieInfoActivity.this,castArrayList);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(MovieInfoActivity.this);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cast_recycleview.setLayoutManager(layoutManager2);
        cast_recycleview.setAdapter(cast_recycleviewAdapter);
    }
}
