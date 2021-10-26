package mo.zain.e_commerce.network;

import mo.zain.e_commerce.pojo.HomeModel;
import mo.zain.e_commerce.pojo.category.CategoriesModel;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailesData;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailesModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("home")
    Call<HomeModel> getHome();

    @GET("categories")
    Call<CategoriesModel> getCategory();

    @GET("categories/{id}")
    Call<CategoryDetailesModel> getCategoryDetailes(@Path("id") int i);

}