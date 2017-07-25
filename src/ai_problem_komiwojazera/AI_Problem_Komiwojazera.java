/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_problem_komiwojazera;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Kikas
 */
public class AI_Problem_Komiwojazera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int[][] data = new int[10][10];
            for (int i = 0; i < 10; i++) {
                data[0][i] = 10 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[1][i] = 9 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[2][i] = 8 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[3][i] = 7 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[4][i] = 6 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[5][i] = 5 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[6][i] = 4 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[7][i] = 3 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[8][i] = 2 * i;
            }
            for (int i = 0; i < 10; i++) {
                data[9][i] = i;
            }
            Trial trial = new Trial();
            List<Integer> bestResults = new ArrayList();
            List<Double> everageListBest = new ArrayList();
            for (int i = 0; i < 100; i++) {
                trial.findBeterList(data);
                bestResults.add(trial.getBestIndividualsList().get(0).getDistanceAll());
                double temp = 0;
                for (int j = 0; j < trial.getBestIndividualsList().size(); j++) {
                    temp += trial.getBestIndividualsList().get(j).getDistanceAll();
                }
                temp = temp / trial.getBestIndividualsList().size();
                everageListBest.add(temp);
            }
            System.out.println("Najlepsze wyniki   Średnia z listy");
            for (int i = 0; i < 100; i++) {
                System.out.print("   " + bestResults.get(i) + "      ");
                if (i > 0 && bestResults.get(i) > bestResults.get(i - 1)) {
                    System.out.println("UWAGA!!!");
                }
                System.out.println(everageListBest);
                if (i > 0 && everageListBest.get(i) > everageListBest.get(i - 1)) {
                    System.out.println("UWAGA!!!");
                }

            }
        } catch (ParametersInvalidOrTooLittleException e) {
            System.err.println(e);
        }
    }

}
