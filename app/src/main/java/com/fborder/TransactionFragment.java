package com.fborder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.TransactionListAdapter;
import models.Transaction;
import models.TransactionDetails;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionFragment extends Fragment {

    private List<Transaction> transactionList;
    private RecyclerView recyclerViewTransaction;

    public TransactionFragment() {
        // Required empty public constructor
    }

    public static TransactionFragment newInstance(String param1, String param2) {
        TransactionFragment fragment = new TransactionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        transactionList = new ArrayList<Transaction>();
        this.insertListTransaction();

        recyclerViewTransaction = view.findViewById(R.id.recyclerview_transaction);
        recyclerViewTransaction.setHasFixedSize(true);
        recyclerViewTransaction.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewTransaction.setAdapter(new TransactionListAdapter(transactionList));

        System.out.println("LIST TRANSACtiON "+transactionList.size());

        return view;
    }

    public void insertListTransaction(){

        List<TransactionDetails> transactionDetailsList1 = new ArrayList<>();
        transactionDetailsList1.add(new TransactionDetails("Milk Boba",15000,1,15000));
        transactionDetailsList1.add(new TransactionDetails("Kentang Goreng",10000,1,10000));
        Transaction transaction1 = new Transaction("HT-001","25 January 2021",25000,transactionDetailsList1);
        List<TransactionDetails> transactionDetailsList2 = new ArrayList<>();
        transactionDetailsList2.add(new TransactionDetails("Milk Boba",15000,1,15000));
        transactionDetailsList2.add(new TransactionDetails("Kentang Goreng",10000,2,20000));
        Transaction transaction2 = new Transaction("HT-002","25 January 2021",35000,transactionDetailsList2);
        List<TransactionDetails> transactionDetailsList3 = new ArrayList<>();
        transactionDetailsList2.add(new TransactionDetails("Pop Ice",15000,2,30000));
        transactionDetailsList2.add(new TransactionDetails("Tahu Kriuk",15000,1,15000));
        Transaction transaction3 = new Transaction("HT-003","26 January 2021",45000,transactionDetailsList3);
        List<TransactionDetails> transactionDetailsList4 = new ArrayList<>();
        transactionDetailsList4.add(new TransactionDetails("Kentang Goreng",10000,1,10000));
        transactionDetailsList4.add(new TransactionDetails("Tahu Kriuk",15000,1,15000));
        Transaction transaction4 = new Transaction("HT-004","27 January 2021",25000,transactionDetailsList4);
        List<TransactionDetails> transactionDetailsList5 = new ArrayList<>();
        transactionDetailsList2.add(new TransactionDetails("Pop Ice",15000,1,15000));
        Transaction transaction5 = new Transaction("HT-005","27 January 2021",15000,transactionDetailsList5);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
    }
}
