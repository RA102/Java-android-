package it.step.sixlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.step.sixlesson.api.Controller;
import it.step.sixlesson.model.Type;
import it.step.sixlesson.model.TypesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypesActivity extends AppCompatActivity implements Callback<TypesResponse> {
    private static final String TAG = "TypesActivity";
    @BindView(R.id.types)
    RecyclerView types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
        ButterKnife.bind(this);
        types.setLayoutManager(new LinearLayoutManager(this));

        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            Call<TypesResponse> call = Controller.getInstance().getApi().getTypes();
            call.enqueue(this);
        } else {
            // not connected to the internet
            Toast.makeText(TypesActivity.this,
                    R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
        //progressBar.
    }

    @Override
    public void onResponse(Call<TypesResponse> call, Response<TypesResponse> response) {
        if(response.isSuccessful()) {
            TypesResponse typesResponse = response.body();
            if (typesResponse != null && typesResponse.getData() != null) {
                TypeAdapter adapter = new TypeAdapter(typesResponse.getData());
                types.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        } else {
            Toast.makeText(TypesActivity.this,
                    response.code() + ":" + response.message(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<TypesResponse> call, Throwable t) {
        Log.e(TAG, t.getMessage());
    }
}
