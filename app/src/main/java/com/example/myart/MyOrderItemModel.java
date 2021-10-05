package com.example.myart;


import java.util.Date;

public class MyOrderItemModel {


        private String productTitle,orderStatus;
        private int rating,productImage;
        public MyOrderItemModel(String productTitle, int rating, int productImage, String orderStatus) {
                this.productTitle = productTitle;
                this.productImage = productImage;
                this.rating = rating;
                this.orderStatus = orderStatus;
        }

        public int getRating() {
                return rating;
        }

        public void setRating(int rating) {
                this.rating = rating;
        }

        public String getProductTitle() {
                return productTitle;
        }

        public void setProductTitle(String productTitle) {
                this.productTitle = productTitle;
        }

        public int getProductImage() {
                return productImage;
        }

        public void setProductImage(int productImage) {
                this.productImage = productImage;
        }

        public String getOrderStatus() {
                return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
        }
}
