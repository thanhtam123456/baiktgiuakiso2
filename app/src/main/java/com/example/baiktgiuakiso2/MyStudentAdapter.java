package com.example.baiktgiuakiso2;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MyStudentAdapter  extends RecyclerView.Adapter<MyStudentAdapter.ViewHolder>  {
    List<Sanpham> models;
    int mResource;
    Context mContext;
    public MyStudentAdapter(Context context,int resource, List<Sanpham> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyStudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyStudentAdapter.ViewHolder viewHolder, int i) {
        final Sanpham model = models.get(i);
        viewHolder.edtId.setText(model.getId()+"");
        viewHolder.edtProductName.setText(model.getProductName()+"");
        viewHolder.edtPrice.setText(model.getPrice()+"");
        viewHolder.edtdescription.setText(model.getSdescription());
        viewHolder.edtproducter.setText(model.getProducer());
        viewHolder.btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   models.remove(model);
                    notifyDataSetChanged();

            }
        });
        viewHolder.Btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ThemsanphamActivity.class);
                intent.putExtra("POST",mResource);
               intent.putExtra("updat",mResource);
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText edtId;
        private EditText edtProductName;
        private  EditText edtPrice;
        private EditText edtproducter;
        private EditText edtdescription;
        private Button bnthem;
        private Button Btnup;
        private Button  btnxoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.Btnup=itemView.findViewById(R.id.BTNup);
            this.bnthem=itemView.findViewById(R.id.them);
            this.btnxoa=itemView.findViewById(R.id.xoa);
            this.edtId = itemView.findViewById(R.id.edt_id);
            this.edtProductName = itemView.findViewById(R.id.edt_ProductName);
            this.edtPrice = itemView.findViewById(R.id.edt_price);
            this.edtproducter = itemView.findViewById(R.id.edt_producer);
            this.edtdescription = itemView.findViewById(R.id.edt_sdescription);
        }

    }
}
