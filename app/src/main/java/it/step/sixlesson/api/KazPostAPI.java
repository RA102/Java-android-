package it.step.sixlesson.api;

import it.step.sixlesson.model.TypesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface KazPostAPI {
    @GET("types")
    Call<TypesResponse> getTypes();

    @GET("byAddress/")
    Call<TypesResponse> getByAddress();
}
