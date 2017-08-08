package bolalob.develops.stud11314025.availaballs.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Okta on 06/07/2017.
 */

public class Service {

    private static final String BASE_URL = "https://api.myjson.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }
}

//    private static API REST_CLIENT;
//    static {
//        setupRestClient();
//    }
//    private Service(){}
//
//    public static API get(){
//        return REST_CLIENT;
//    }
//
//    private static void setupRestClient(){
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        // set your desired log level
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        // add logging as last interceptor
//        httpClient.addInterceptor(logging);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.myjson.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        REST_CLIENT = retrofit.create(API.class);
//    }

//    String API_BASE_URL = "https://api.myjson.com/";
//
//
//
//
//
//
//    // Create a very simple REST adapter which points the GitHub API endpoint.
//    RestClient client = retrofit.create(RestClient.class);
//
//    // Fetch a list of the Github repositories.
//    Observable<List<Lapangan>> call = client.
//}2