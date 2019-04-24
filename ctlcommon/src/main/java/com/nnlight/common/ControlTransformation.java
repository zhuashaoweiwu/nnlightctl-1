package com.nnlight.common;

public class ControlTransformation {


    public ControlTransformation(Builder builder) {
        this.startIndex = builder.startIndex;
        this.runLength = builder.runLength;
        this.ilength = builder.ilength;
        this.point = builder.point;
    }


    protected Integer startIndex;     //起始位置
    protected Integer runLength = 0;  //协议data长度
    protected Integer ilength = 0;    //截至位置
    protected int point;      //向后位移位置


    public Integer getStartIndex(Integer startIndex) {

        return startIndex + point;
    }

    public static class Builder {
        protected Integer startIndex;
        protected Integer runLength;
        protected Integer ilength;
        protected int point;

        public Builder() {
        }

        public Builder(Integer startIndex) {
            this.startIndex = startIndex;
        }


        public Builder startIndex(Integer startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        public Builder ilength(Integer ilength) {
            this.ilength = ilength;
            return this;
        }

        public Builder point(int point) {
            this.point = point;
            return this;
        }

        public Builder runLength(Integer runLength) {
            this.runLength = runLength;
            return this;
        }


        public ControlTransformation build() {
            return new ControlTransformation(this);
        }
    }

}
