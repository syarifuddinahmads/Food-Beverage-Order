package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fborder.OrderDetailActivity;
import com.fborder.R;
import com.fborder.TransactionFragment;

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
    public void onBindViewHolder(@NonNull TransactionItemHolder holder, final int position) {
        holder.getIdView().setText(transactionList.get(position).getIdTransaction());
        holder.getDateView().setText(transactionList.get(position).getDateTransaction());
        holder.getTotalView().setText(String.valueOf(transactionList.get(position).getGrandtotal()));
        holder.getBtnDetail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("transaction",transactionList.get(position).toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.transactionList.size();
    }
}
