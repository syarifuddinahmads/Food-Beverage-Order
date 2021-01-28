package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fborder.R;

import java.util.List;

import models.Transaction;


public class TransactionListAdapter extends RecyclerView.Adapter<TransactionItemHolder> {
    private List<Transaction> transactionList;

    public TransactionListAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_transaction;
    }

    @NonNull
    @Override
    public TransactionItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new TransactionItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionItemHolder holder, int position) {
        holder.getIdView().setText(transactionList.get(position).getIdTransaction());
        holder.getDateView().setText(transactionList.get(position).getDateTransaction());
        holder.getTotalView().setText(String.valueOf(transactionList.get(position).getGrandtotal()));
    }

    @Override
    public int getItemCount() {
        return this.transactionList.size();
    }
}
