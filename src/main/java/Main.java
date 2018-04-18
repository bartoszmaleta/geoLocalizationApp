import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.LatLng;

import java.util.Scanner;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Podaj adres:");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.next();
        GeocoderRequestBuilder geocoderRequestBuilder = new GeocoderRequestBuilder();
        geocoderRequestBuilder.setAddress(address);
        geocoderRequestBuilder.setLanguage("pl");
        Geocoder geocoder = new Geocoder();
        LatLng result = geocoder.geocode(geocoderRequestBuilder.getGeocoderRequest()).getResults()
                .get(0).getGeometry().getLocation();
        System.out.println("Współrzędne geograficzne miejsca to " + address + " " + result.getLat() + " " + result.getLng());
    }
}