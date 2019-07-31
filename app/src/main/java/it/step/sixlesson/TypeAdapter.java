package it.step.sixlesson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.step.sixlesson.model.Type;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.TypeViewHolder> {
    private List<Type> types;

    public TypeAdapter(List<Type> types) {
        this.types = types;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, parent, false);
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.kaz.setText(getType(position).getNameKz());
        holder.rus.setText(getType(position).getNameRus());
    }

    @Override
    public int getItemCount() {
        if (types == null)return 0;
        else return types.size();
    }

    private Type getType(int position){
        return types.get(position);
    }

    class TypeViewHolder extends RecyclerView.ViewHolder{
        TextView kaz;
        TextView rus;

        TypeViewHolder(@NonNull View itemView) {
            super(itemView);
            kaz = itemView.findViewById(R.id.kaz);
            rus = itemView.findViewById(R.id.rus);
        }
    }
}
