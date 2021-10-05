package com.example.myart;


import java.util.Date;

public class RewardModel {
        private String title, ExpiryDate,coupanBody;
        private Date timestamp;


        public RewardModel(String title, String ExpiryDate, String coupanBody) {

            this.title = title;
            this.ExpiryDate = ExpiryDate;

            this.coupanBody = coupanBody;
            this.timestamp = timestamp;

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
  public String getExpiryDate() {
            return ExpiryDate;
        }

        public void setExpiryDate(String ExpiryDate) {
            this.ExpiryDate = ExpiryDate;
        }


        public String getCoupanBody() {
            return coupanBody;
        }

        public void setCoupanBody(String coupanBody) {
            this.coupanBody = coupanBody;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
    }
