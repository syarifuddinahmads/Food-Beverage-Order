package adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fborder.R;

public class TransactionItemHolder extends RecyclerView.ViewHolder {

    private TextView idView;
    private TextView dateView;
    private TextView totalView;
    public TransactionItemHolder(@NonNull View itemView) {
        super(itemView);
        idView = itemView.findViewById(R.id.id_transaction);
        dateView = itemView.findViewById(R.id.date_transaction);
        totalView = itemView.findViewById(R.id.total_transaction);
    }

    public TextView getIdView() {
        return idView;
    }

    public void setIdView(TextView idView) {
        this.idView = idView;
    }

    public TextView getDateView() {
        return dateView;
    }

    public void setDateView(TextView dateView) {
        this.dateView = dateView;
    }

    public TextView getTotalView() {
        return totalView;
    }

    public void setTotalView(TextView totalView) {
        this.totalView = totalView;
    }
}