package com.android.smarttest.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.smarttest.R;
import com.android.smarttest.model.CandidateObj;

import java.util.List;

public class EmployeeDashboardListAdapter extends RecyclerView.Adapter<EmployeeDashboardListAdapter.Holder> {

    private Context mContext;
    private List<CandidateObj> mList;

    public EmployeeDashboardListAdapter(Context mContext, List<CandidateObj> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.candidate_info_row, parent, false);
        Holder viewHolder = new Holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        final CandidateObj candidateInfo = mList.get(position);
        holder.candidateName.setText(candidateInfo.getName());
        holder.candidateEmail.setText(candidateInfo.getEmail());
        holder.candidateNumber.setText(candidateInfo.getNumber());
        holder.candidateResult.setText(candidateInfo.getResult());

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShare(candidateInfo);
            }
        });
    }

    private void doShare(CandidateObj candidateInfo) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, candidateInfo.getEmail());
            intent.putExtra(Intent.EXTRA_SUBJECT, "Written Round Result");
            if("Disqualified".equalsIgnoreCase(candidateInfo.getResult())){
                intent.putExtra(Intent.EXTRA_TEXT, "You are Disqualified. All the best for next Time.");
            }else{
                intent.putExtra(Intent.EXTRA_TEXT, "You are Qualified. Our HR will communicate for next round.");
            }
        try {
            if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                mContext.startActivity(intent);
            }
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView share;
        private TextView candidateName;
        private TextView candidateEmail;
        private TextView candidateNumber;
        private TextView candidateResult;

        public Holder(View itemView) {
            super(itemView);
            share = (ImageView) itemView.findViewById(R.id.candidate_info_share);
            candidateName = (TextView) itemView.findViewById(R.id.candidate_info_name);
            candidateEmail = (TextView) itemView.findViewById(R.id.candidate_info_email);
            candidateNumber = (TextView) itemView.findViewById(R.id.candidate_info_number);
            candidateResult = (TextView) itemView.findViewById(R.id.candidate_result);
        }
    }
}
