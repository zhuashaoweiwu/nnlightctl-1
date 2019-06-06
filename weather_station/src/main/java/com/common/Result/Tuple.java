package com.common.Result;

public class Tuple {
    public static class TwoTuple<K, T> {
        public K getFirst() {
            return first;
        }

        public void setFirst(K first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }

        private K first;
        private T second;
    }
}
