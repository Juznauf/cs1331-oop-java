public class Coordinates {
    /**
     * @author naufal
     */
    
    private final double latitude;
    private final double longitude;
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }    
    public static void main(String[] args) {
        
    }

    public boolean equals(Object other) {
        /**
         * @param other 
         * @return boolean representing whether another object is logically equiavalent to this instance of coordinates
         * 
         */

        if (this == other) { return true; }
        if (!(other instanceof Coordinates)) { return false; }
        Coordinates that = (Coordinates) other;
        return that.latitude == this.latitude && that.longitude == this.longitude;
    }

    public String toString() {
        /**
         * returns the string rep of this coordinates object in the format
         */
        return String.format("latitude: %.2f, longitude: %.2f", latitude, longitude);
    }

    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
}

