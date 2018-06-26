package com.nnlight.common;

import java.math.BigDecimal;

public class GisPointUtil {
    public static boolean checkGisPoint(Point point, Rectangular rectangular) {
        BigDecimal startLongitude = new BigDecimal(rectangular.getStartLongitude());
        BigDecimal endLongitude = new BigDecimal(rectangular.getEndLongitude());

        BigDecimal startLatitude = new BigDecimal(rectangular.getStartLatitude());
        BigDecimal endLatitude = new BigDecimal(rectangular.getEndLatitude());

        BigDecimal longitude = new BigDecimal(point.getLongitude());
        BigDecimal latitude = new BigDecimal(point.getLatitude());

        return longitude.compareTo(startLongitude) >= 0 && longitude.compareTo(endLongitude) <= 0
                && latitude.compareTo(startLatitude) <= 0 && latitude.compareTo(endLatitude) >= 0;
    }

    public static class Rectangular {
        public String getStartLongitude() {
            return startLongitude;
        }

        public void setStartLongitude(String startLongitude) {
            this.startLongitude = startLongitude;
        }

        public String getStartLatitude() {
            return startLatitude;
        }

        public void setStartLatitude(String startLatitude) {
            this.startLatitude = startLatitude;
        }

        public String getEndLongitude() {
            return endLongitude;
        }

        public void setEndLongitude(String endLongitude) {
            this.endLongitude = endLongitude;
        }

        public String getEndLatitude() {
            return endLatitude;
        }

        public void setEndLatitude(String endLatitude) {
            this.endLatitude = endLatitude;
        }

        public Rectangular(String startLongitude, String startLatitude, String endLongitude, String endLatitude) {
            this.startLongitude = startLongitude;
            this.startLatitude = startLatitude;
            this.endLongitude = endLongitude;
            this.endLatitude = endLatitude;
        }

        private String startLongitude;
        private String startLatitude;
        private String endLongitude;
        private String endLatitude;
    }

    public static class Point {
        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        private String longitude;
        private String latitude;

        public Point(String longitude, String latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }
}
