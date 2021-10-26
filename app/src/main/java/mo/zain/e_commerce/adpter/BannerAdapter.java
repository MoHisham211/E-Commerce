package mo.zain.e_commerce.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mo.zain.e_commerce.R;
import mo.zain.e_commerce.pojo.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    List<Banner> bannerList;

    public BannerAdapter(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item,parent,false);
        //view.setLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.ViewHolder holder, int position) {
        Banner banner=bannerList.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(banner.getImage())
                .into(holder.BannerImage);
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView BannerImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            BannerImage=itemView.findViewById(R.id.bannerImage);
        }
    }
}
