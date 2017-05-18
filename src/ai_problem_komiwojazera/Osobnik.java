/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_problem_komiwojazera;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Sebastian Kikas
 */
public class Osobnik {

    private List<Chromosom> listChromosoms;
    private int[][] distances;
    private int distanceAll;

    public Osobnik() {
    }

    public Osobnik(int[][] distance) {
        this.distances = distance;
    }

    public List<Chromosom> getChromosom() {
        return listChromosoms;
    }

    public void setChromosom(List<Chromosom> chromosom) {
        this.listChromosoms = chromosom;
    }

    public int[][] getDistance() {
        return distances;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    public int getDistanceAll() {
        return distanceAll;
    }

    public void setDistanceAll(int distanceAll) {
        this.distanceAll = distanceAll;
    }

    public void creatFirstChromosom(int[][] distances) {

        Chromosom chromosom = new Chromosom();
        for (int i = 0; i < distances.length; i++) {
            chromosom.setNewPlace(i);
            if ((i + 1) != distances.length) {
                distanceAll += distances[i][i + 1];
            } else {
                distanceAll += distances[i][0];
            }
        }
        listChromosoms.add(chromosom);
    }
    
    public void creatNextChromosom(int[][] distances) {

        Chromosom chromosom = new Chromosom();
        Random generator = new Random();
        Set<Integer> checkList= new HashSet();
        for (int i = 0; i < distances.length; i++) {
            
            while(!checkList.contains(generator.nextInt(distances.length))) {
                
            }
            chromosom.setNewPlace(i);
            if ((i + 1) != distances.length) {
                distanceAll += distances[i][i + 1];
            } else {
                distanceAll += distances[i][0];
            }
        }
        listChromosoms.add(chromosom);

    }
}
