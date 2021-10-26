package mo.zain.e_commerce.network;

import mo.zain.e_commerce.pojo.HomeModel;
import mo.zain.e_commerce.pojo.category.CategoriesModel;
import mo.zain.e_commerce.pojo.category.CategoryData;
import mo.zain.e_commerce.pojo.categoryDetailes.CategoryDetailesModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserClient {
    private static final String BASE_URL = "https://student.valuxapps.com/api/";
    private Api api;
    private static UserClient Instance;

    public UserClient(){
        // builder & converter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // interFace
        api = retrofit.create(Api.class);
    }
    // singleton pattern
    public static synchronized UserClient getInstance() {
        if (Instance == null) Instance = new UserClient();
        return Instance;
    }

    //getHome
    public Call<HomeModel> getHomeData(){return api.getHome();}

    //getCategory
    public Call<CategoriesModel> getCategoryData(){return api.getCategory();}

    //getCategoryDetailes
    public Call<CategoryDetailesModel>
    getCategoryDetailes(int i){return api.getCategoryDetailes(i);}
}
