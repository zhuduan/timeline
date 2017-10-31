package com.timeline.Common;

public class DataConfig {

    public enum DataValidation{

        NOT_VALID(0),
        VALID(1);

        private int validationFlag;

        DataValidation(int flag){
            this.validationFlag = flag;
        }

        public int getValidationFlag() {
            return validationFlag;
        }

        public void setValidationFlag(int validationFlag) {
            this.validationFlag = validationFlag;
        }
    }
}
