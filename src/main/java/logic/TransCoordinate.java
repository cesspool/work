package logic;

//evaluate distance btw 2 nodes by their coordinate

public class TransCoordinate {

    private double llat1;
    private double llat2;
    private double llong1;
    private double llong2;
    private int rad;


    public double setGeoCoordinate(double llat1, double llong1, double llat2, double llong2){
        this.llat1 = llat1;
        this.llat2 = llat2;
        this.llong1 = llong1;
        this.llong2 = llong2;
        this.rad = 6372795;

        return transform();

    }

    public double transform(){
        //rad
        double lat1 = llat1 * Math.PI/180;
        double lat2 = llat2 * Math.PI/180;
        double long1 = llong1 * Math.PI/180;
        double long2 = llong2 * Math.PI/180;

        //cos and sin of latitudes and longitudes's subtraction
        double cl1 = Math.cos(lat1);
        double cl2 = Math.cos(lat2);
        double sl1 = Math.sin(lat1);
        double sl2 = Math.sin(lat2);
        double delta = long2 - long1;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        //evaluate length of great circle
        double y = Math.sqrt(Math.pow((cl2*sdelta),2)+Math.pow((cl1*sl2-sl1*cl2*cdelta),2));
        double x = sl1*sl2+cl1*cl2*cdelta;
        double ad = Math.atan2(y,x);
        double dist = ad*rad/1000;
        return dist; //kilometers
    }
}
