package mo.zain.e_commerce.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mo.zain.e_commerce.R;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailes;

public class DetailesAdapter extends RecyclerView.Adapter<DetailesAdapter.ViewHolder> {
    List<CategoryDetailes> categoryDetailesList;

    public DetailesAdapter(List<CategoryDetailes> categoryDetailesList) {
        this.categoryDetailesList = categoryDetailesList;
    }

    @NonNull
    @Override
    public DetailesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detaile_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull DetailesAdapter.ViewHolder holder, int position) {
        CategoryDetailes categoryDetailes=categoryDetailesList.get(position);
        holder.textView.setText(""+categoryDetailes.getName());
        Glide
                .with(holder.itemView.getContext())
                .load(categoryDetailes.getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return categoryDetailesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageDetailes);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
