package com.example.myart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    private List<CartItemModel> mCartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        mCartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (mCartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CartItemModel.CART_ITEM:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
                return new CartItemViewHolder(view);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout, parent, false);
                return new TotalAmountViewHolder(cartTotalView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (mCartItemModelList.get(position).getType()) {
            case CartItemModel.CART_ITEM:

                int resource = mCartItemModelList.get(position).getProductImage();
                String title = mCartItemModelList.get(position).getProductTitle();
                int freecoupons = mCartItemModelList.get(position).getFreeCoupons();
                String productprice = mCartItemModelList.get(position).getProductPrice();
                String cuttedPrice = mCartItemModelList.get(position).getCuttedPrice();
                int offersApplied = mCartItemModelList.get(position).getOffersApplied();
                ((CartItemViewHolder)holder).setItemDetails(resource,title,freecoupons,productprice,cuttedPrice,offersApplied);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItems = mCartItemModelList.get(position).getTotalItems();
                String totalItemPrice = mCartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = mCartItemModelList.get(position).getDeliveryPrice();
                String totalAmount = mCartItemModelList.get(position).getTotalAmount();
                String savedAmount = mCartItemModelList.get(position).getSavedAmount();

                ((TotalAmountViewHolder)holder).setTotalAmount(totalItems,totalItemPrice, deliveryPrice, totalAmount, savedAmount);
                break;
            default:
                return;
        }
        }

        @Override
        public int getItemCount () {
            return mCartItemModelList.size();
        }

        class CartItemViewHolder extends RecyclerView.ViewHolder {
            private ImageView productImage;
            private ImageView freeCouponsIcon;
            private TextView productTitle;
            private TextView freeCoupons;
            private TextView productPrice;
            private TextView cuttedPrice;
            private TextView offersApplied;
            private TextView productQuantity;

            public CartItemViewHolder(@NonNull View itemView) {
                super(itemView);
                productImage = itemView.findViewById(R.id.product_image);
                productTitle = itemView.findViewById(R.id.product_title);
                freeCoupons = itemView.findViewById(R.id.tv_free_coupan);
                freeCouponsIcon = itemView.findViewById(R.id.free_coupan_icon);
                productPrice = itemView.findViewById(R.id.product_price);
                cuttedPrice = itemView.findViewById(R.id.cutted_price);
                offersApplied = itemView.findViewById(R.id.offers_applied);
                productQuantity = itemView.findViewById(R.id.product_quantity);
            }

            private void setItemDetails(int resource, String title, int freeCouponsNo, String productPriceText, String cuttedPriceText, int offerAppliedNo) {
                productImage.setImageResource(resource);
                productTitle.setText(title);
                if (freeCouponsNo > 0) {
                    freeCouponsIcon.setVisibility(View.VISIBLE);
                    freeCoupons.setVisibility(View.VISIBLE);

                    if (freeCouponsNo == 1) {
                        freeCoupons.setText("бесплатный" + freeCouponsNo + "купон");

                    } else {
                        freeCoupons.setText("бесплатный" + freeCouponsNo + "купон");
                    }
                } else {
                    freeCouponsIcon.setVisibility(View.INVISIBLE);
                    freeCoupons.setVisibility(View.INVISIBLE);
                }
                productPrice.setText(productPriceText);
                cuttedPrice.setText(cuttedPriceText);

                if (offerAppliedNo > 0) {
                    offersApplied.setVisibility(View.VISIBLE);
                    offersApplied.setText(offerAppliedNo + "предложения применены");
                } else {
                    offersApplied.setVisibility(View.INVISIBLE);

                }
            }
        }

        class TotalAmountViewHolder extends RecyclerView.ViewHolder {
            private TextView totalItems, totalItemsPrice, deliveryPrice, totalAmount, savedAmount;

            public TotalAmountViewHolder(@NonNull View itemView) {
                super(itemView);
                totalItems = itemView.findViewById(R.id.total_items);
                totalItemsPrice = itemView.findViewById(R.id.total_items_price);
                deliveryPrice = itemView.findViewById(R.id.delivery_price);
                totalAmount = itemView.findViewById(R.id.total_price);
                savedAmount = itemView.findViewById(R.id.saved_amount);

            }

            private void setTotalAmount(String totalItemText, String totalItemPriceText, String deliveryPricetext, String totalAmounttext, String savedAmounttext) {
                totalItems.setText(totalItemText);
                totalItemsPrice.setText(totalItemPriceText);
                deliveryPrice.setText(deliveryPricetext);
                totalAmount.setText(totalAmounttext);
                savedAmount.setText(savedAmounttext);
            }
        }
    }
