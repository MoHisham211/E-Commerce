package mo.zain.e_commerce.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import mo.zain.e_commerce.R;
import mo.zain.e_commerce.adpter.DetailesAdapter;
import mo.zain.e_commerce.network.UserClient;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailes;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailesModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    DetailesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_category);

        recyclerView=findViewById(R.id.RV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Intent intent=getIntent();
        int id=intent.getIntExtra("ID",0);

        getDetails(id);

    }
    private void getDetails(int id)
    {
        UserClient.getInstance().getCategoryDetailes(id)
                .enqueue(new Callback<CategoryDetailesModel>() {
                    @Override
                    public void onResponse(Call<CategoryDetailesModel> call, Response<CategoryDetailesModel> response) {
                        if (response.body().getStatus())
                        {
                            List<CategoryDetailes> categoryDetailes=response.body().getData().getData();
                            adapter=new DetailesAdapter(categoryDetailes);
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoryDetailesModel> call, Throwable t) {

                    }
                });

    }
}