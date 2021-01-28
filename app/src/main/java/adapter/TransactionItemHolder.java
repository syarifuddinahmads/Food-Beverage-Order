package adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fborder.R;

public class TransactionItemHolder extends RecyclerView.ViewHolder {

    private TextView idView;
    private TextView dateView;
    private TextView totalView;
    private Button btnDetail;

    public TransactionItemHolder(@NonNull View itemView) {
        super(itemView);
        idView = itemView.findViewById(R.id.id_transaction);
        dateView = itemView.findViewById(R.id.date_transaction);
        totalView = itemView.findViewById(R.id.total_transaction);
        btnDetail = itemView.findViewById(R.id.btn_detail);
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

    public Button getBtnDetail() {
        return btnDetail;
    }

    public void setBtnDetail(Button btnDetail) {
        this.btnDetail = btnDetail;
    }
}