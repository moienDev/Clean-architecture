package adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import creativeuiux.moviebooking2.MovieInfoActivity;
import creativeuiux.moviebooking2.R;
import modalclass.TheaterModalClass;


public class Theater_RecycleviewAdapter extends RecyclerView.Adapter<Theater_RecycleviewAdapter.MyViewHolder> {

    Context context;
    private List<TheaterModalClass> theaterModalClasses;


    public Theater_RecycleviewAdapter(Context mainActivityContacts, List<TheaterModalClass> listModalClassList) {
        this.theaterModalClasses = listModalClassList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_thaters, parent, false);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,MovieInfoActivity.class);
                context.startActivity(i);

            }
        });

        return new MyViewHolder(itemView);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        TheaterModalClass modalClass = theaterModalClasses.get(position);
        holder.poster_image.setImageResource(modalClass.getPoster_image());
        holder.poster_name.setText(modalClass.getPoster_name());
        holder.language.setText(modalClass.getLanguage());
        holder.poster_like.setText(modalClass.getLike());



    }

    @Override
    public int getItemCount() {
        return theaterModalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView poster_name, poster_like, language;
        ImageView poster_image;


        public MyViewHolder(View view) {
            super(view);


            poster_name = (TextView) view.findViewById(R.id.poster_name);
            poster_like = (TextView) view.findViewById(R.id.poster_like);
            language = (TextView) view.findViewById(R.id.language);
            poster_image = (ImageView) view.findViewById(R.id.poster1);


        }

    }
}
