//Write a program that determines the distance in miles between points (Latitude : 41.507483, longitude : -99.436554) and (Latitude : 38.504048, Longitude : -98.315949).
// Show the result with two digits after the decimal point. Call the program. (Hint: Use the Haversine formula.) 
public class KnutsonDistance {

public static void main(String[] args){

double lat1 = 41.507483;
double lon1 = -99.436554;
double lat2 = 38.504048;
double lon2 = -98.315949;

// distance between latitudes and longitudes
double dLat = Math.toRadians(lat2 - lat1);
double dLon = Math.toRadians(lon2 - lon1);

// convert to radians
lat1 = Math.toRadians(lat1);
lat2 = Math.toRadians(lat2);

// apply formulae
double a = Math.pow(Math.sin(dLat / 2), 2) +
Math.pow(Math.sin(dLon / 2), 2) *
Math.cos(lat1) *
Math.cos(lat2);
double rad = 6371;
double c = 2 * Math.asin(Math.sqrt(a));
double fin = rad * c;

System.out.println(fin);
    }
}




