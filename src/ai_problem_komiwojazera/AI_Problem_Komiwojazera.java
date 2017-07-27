/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_problem_komiwojazera;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author Sebastian Kikas
 */
public class AI_Problem_Komiwojazera {

    private static final String API_KEY = "AIzaSyBQj4A92hIJZ2AJpp-Bc62oWEhgRQ0KUOM";
//    private static final GeoApiContext context = new GeoApiContext();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        try {
//            int[][] data = new int[10][10];
//            for (int i = 0; i < 10; i++) {
//                data[0][i] = 10 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[1][i] = 9 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[2][i] = 8 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[3][i] = 7 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[4][i] = 6 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[5][i] = 5 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[6][i] = 4 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[7][i] = 3 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[8][i] = 2 * i;
//            }
//            for (int i = 0; i < 10; i++) {
//                data[9][i] = i;
//            }
//            Trial trial = new Trial();
//            List<Integer> bestResults = new ArrayList();
//            List<Double> everageListBest = new ArrayList();
//            for (int i = 0; i < 1000; i++) {
//                trial.findBeterList(data);
//                bestResults.add(trial.getBestIndividualsList().get(0).getDistanceAll());
//                double temp = 0;
//                for (int j = 0; j < trial.getBestIndividualsList().size(); j++) {
//                    temp += trial.getBestIndividualsList().get(j).getDistanceAll();
//                }
//                temp = temp / trial.getBestIndividualsList().size();
//                everageListBest.add(temp);
//            }
//            System.out.println("Najlepsze wyniki   Średnia z listy");
//            for (int i = 0; i < 1000; i++) {
//                System.out.print("   " + bestResults.get(i) + "            ");
//                if (i > 0 && bestResults.get(i) > bestResults.get(i - 1)) {
//                    System.out.println("UWAGA!!!");
//                }
//                System.out.println(everageListBest.get(i));
//                if (i > 0 && everageListBest.get(i) > everageListBest.get(i - 1)) {
//                    System.out.println("UWAGA!!!");
//                }
//
//            }
        

        String[] origins = new String[]{"Perth, Australia", "Sydney, Australia", "Melbourne, Australia", "Adelaide, Australia", "Brisbane, Australia", "Darwin, Australia", "Hobart, Australia", "Canberra, Australia"};
        String[] destinations = new String[]{"Uluru, Australia", "Kakadu, Australia", "Blue Mountains, Australia", "Bungle Bungles, Australia", "The Pinnacles, Australia"};

        DistanceMatrix matrix;
        try {
//               matrix = DistanceMatrixApi.newRequest(context).origins(origins).destinations(destinations).mode(TravelMode.DRIVING).language("en-AU").avoid(RouteRestriction.TOLLS).units(Unit.IMPERIAL).departureTime(new DateTime().plusMinutes(2)).await();
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(API_KEY)
                    .build();
            matrix = DistanceMatrixApi.newRequest(context).origins(origins).destinations(destinations)
                    .mode(TravelMode.DRIVING).language("en-AU").avoid(RouteRestriction.TOLLS)
                    .units(Unit.METRIC).departureTime(new DateTime().plusMinutes(2)).await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(matrix.originAddresses[0]+" do "+matrix.destinationAddresses[0]+ " "+matrix.rows[0].elements[0].distance));
            
//            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
//            DistanceMatrix trix = req.origins("Vancouver BC", "Seattle")
//                    .destinations("San Francisco", "Victoria BC")
//                    .mode(TravelMode.DRIVING)
//                    .avoid(RouteRestriction.HIGHWAYS)
//                    .language("fr-FR")
//                    .await();
//            for (int i = 0; i < trix.rows.length; i++) {
//                System.out.println(trix.originAddresses[i] + " " + trix.destinationAddresses[i] + " " + trix.rows[i].elements[0]);
//            }
        } catch (ApiException | InterruptedException | IOException ex) {
            Logger.getLogger(AI_Problem_Komiwojazera.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (ParametersInvalidOrTooLittleException e) {
//            System.err.println(e);
//        }
    }

}
