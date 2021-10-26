package mo.zain.e_commerce.adpter;

import android.content.Intent;
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
import mo.zain.e_commerce.network.UserClient;
import mo.zain.e_commerce.pojo.category.Category;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailesModel;
import mo.zain.e_commerce.ui.CategoryDetailsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    List<Category> categoryList;

    public CategoriesAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        Category category=categoryList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(category.getImage())
                .into(holder.categoryImage);
        holder.nameCategory.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView nameCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage=itemView.findViewById(R.id.categoryImage);
            nameCategory=itemView.findViewById(R.id.nameCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext()
                            .startActivity(
                                    new Intent(itemView.getContext()
                                    , CategoryDetailsActivity.class)
                                    .putExtra("ID",categoryList.
                                            get(getAdapterPosition()).getId()));
                }
            });
        }
    }
}
