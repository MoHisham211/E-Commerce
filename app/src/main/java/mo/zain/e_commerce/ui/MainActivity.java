package mo.zain.e_commerce.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import mo.zain.e_commerce.R;
import mo.zain.e_commerce.adpter.BannerAdapter;
import mo.zain.e_commerce.adpter.CategoriesAdapter;
import mo.zain.e_commerce.network.UserClient;
import mo.zain.e_commerce.pojo.Banner;
import mo.zain.e_commerce.pojo.HomeModel;
import mo.zain.e_commerce.pojo.Product;
import mo.zain.e_commerce.pojo.category.CategoriesModel;
import mo.zain.e_commerce.pojo.category.Category;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BannerAdapter adapter;
    CategoriesAdapter categoriesAdapter;
    RecyclerView recyclerView,categoryRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        categoryRV=findViewById(R.id.categoryRV);
        categoryRV.setHasFixedSize(true);
        categoryRV.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        //
        recyclerView=findViewById(R.id.banner);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        //
        getHomeData();
        getCategory();

    }
    private void getHomeData(){
        UserClient.getInstance().getHomeData().enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
                if (response.body().getStatus()){
                    List<Product> product=response.body().getData().getProducts();
                    List<Banner> banners=response.body().getData().getBanners();
                    adapter=new BannerAdapter(banners);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {

            }
        });
    }
    private void getCategory(){
        UserClient.getInstance().getCategoryData().enqueue(new Callback<CategoriesModel>() {
            @Override
            public void onResponse(Call<CategoriesModel> call, Response<CategoriesModel> response) {
                if (response.body().getStatus())
                {
                    List<Category> categoryList=response.body().getData().getData();
                    categoriesAdapter=new CategoriesAdapter(categoryList);
                    categoriesAdapter.notifyDataSetChanged();
                    categoryRV.setAdapter(categoriesAdapter);
                }

            }

            @Override
            public void onFailure(Call<CategoriesModel> call, Throwable t) {

            }
        });
    }
}