/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_problem_komiwojazera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sebastian Kikas
 */
public class Trial {

    private List<Individual> bestIndividualsList;
    private List<Individual> currentIndividualsList;
    private List<Individual> usedIndividuals;

    public List<Individual> getBestIndividualsList() {
        return bestIndividualsList;
    }

    public void setBestIndividualsList(List<Individual> bestIndividualsList) {
        this.bestIndividualsList = bestIndividualsList;
    }

    public List<Individual> getCurrentIndividualsList() {
        return currentIndividualsList;
    }

    public void setCurrentIndividualsList(List<Individual> currentIndividualsList) {
        this.currentIndividualsList = currentIndividualsList;
    }

    public void makeFirstList(int[][] data) {
        Individual indiv = null;
        for (int[] data1 : data) {
            if (indiv == null) {
                indiv.creatFirstChromosom(data);
            } else {
                indiv.creatNextChromosom(data);
            }
            currentIndividualsList.add(indiv);
        }
    }

    public int checkIfWas(List<Integer> tempTable, int tested) {

        if (!tempTable.isEmpty()) {
            while (tempTable.contains(tested)) {
                if (tested != 10) {
                    tested++;
                } else {
                    tested = 2;
                }
            }
        }
        return tested;
    }

    public void makeCross(Individual newIndividual, int secondPath, int howManyPlaces) {

        Random generator = new Random();
        int beginCross = generator.nextInt(howManyPlaces);
        int howLongCross = 0;
        if (generator.nextBoolean() || beginCross == (howManyPlaces - 1)) {
            howLongCross = 1;
        } else if (generator.nextBoolean() || beginCross == (howManyPlaces - 2)) {
            howLongCross = 2;
        } else if (generator.nextBoolean() || beginCross == (howManyPlaces - 3)) {
            howLongCross = 3;
        } else {
            howLongCross = 4;
        }
        List<Integer> tempListGenes = null;
        tempListGenes.addAll(bestIndividualsList.get(secondPath)
                .getChromosome().getListPlaces());
        List<Integer> tempListGenesChange = null;
        for (int j = beginCross; j < (beginCross + howLongCross); j++) {
            tempListGenesChange.add(tempListGenes.get(j));
        }
        newIndividual.cross(beginCross, (beginCross + howLongCross), tempListGenesChange);
        currentIndividualsList.add(newIndividual);
    }

    public void makeMutation(Individual newIndividual, List<Integer> tempTable, int howManyPlaces, int which) {
        Random generator = new Random();
        newIndividual = bestIndividualsList.get(which);
        tempTable.add(which);
        int howManyMutation = generator.nextInt(howManyPlaces) / 2;    //ile mutacji w pojedyńczym osobniku, 
        for (int j = 0; j < howManyMutation; j++) {
            newIndividual.mutation(generator.nextInt(howManyPlaces), generator.nextInt(howManyPlaces));
        }
        currentIndividualsList.add(newIndividual);
    }

    public void findBeterList(int[][] data) {

        if (bestIndividualsList.isEmpty()) {
            makeFirstList(data);
            usedIndividuals.addAll(bestIndividualsList);
        } else {
            /*
            Lista najlepszych z 20 elementów, 2 najlepszych zostaje, 10 najgorszych odpada
            3-10 mutacje i krzyrzówki, dodajemy 5 całkiem nowych, 4 krzyżówki i mutacje najlepszych 5,
            4 mutacje i krzyrzówki najlepszej 5 z losowymi
             */

            currentIndividualsList.add(bestIndividualsList.get(0));
            currentIndividualsList.add(bestIndividualsList.get(1));
            Random generator = new Random();
            List<Integer> tempTable = new ArrayList<Integer>();                 //które już wykorzystane
            Individual newIndividual = null;
            int howManyPlaces = data.length;                        // Ile miejsc sprawdzamy
            for (int i = 0; i < 8; i++) {
                if (generator.nextBoolean()) {  //mutacja
                    int temp = generator.nextInt(8) + 2;      //losowa pozycja z listy z przedziału 3-10
                    temp = checkIfWas(tempTable, temp);        //sprawdzamy czy już była lokalizacja wykorzystywana i zwracamy taką która jeszcze nie była
                    makeMutation(newIndividual, tempTable, howManyPlaces, temp);
                } else {                              //krzyżówka
                    int firstPath = generator.nextInt(8) + 2;      //losowa pozycja z listy z przedziału 3-10
                    firstPath = checkIfWas(tempTable, firstPath);
                    tempTable.add(firstPath);
                    int secondPath = generator.nextInt(8) + 2;
                    secondPath = checkIfWas(tempTable, secondPath);
                    tempTable.add(secondPath);
                    newIndividual = bestIndividualsList.get(firstPath);
                    makeCross(newIndividual, secondPath, howManyPlaces);
                }

            }
            for (int i = 0; i < 4; i++) {        //mutacje i krzyrzówki najlepszych 2
                if (generator.nextBoolean()) {      //mutacja
                    if (generator.nextBoolean()) {
                        makeMutation(newIndividual, tempTable, howManyPlaces, 0);
                    } else {
                        makeMutation(newIndividual, tempTable, howManyPlaces, 1);
                    }
                } else {                              //krzyżówka
                    if (generator.nextBoolean()) {
                        makeCross(bestIndividualsList.get(0), 1, howManyPlaces);
                    } else {
                        makeCross(bestIndividualsList.get(1), 0, howManyPlaces);
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                int temp = generator.nextInt(23) + 2;
                if (generator.nextBoolean()) {
                    newIndividual = bestIndividualsList.get(0);
                    makeCross(newIndividual, temp, howManyPlaces);
                    if (generator.nextBoolean()) {
                        makeMutation(newIndividual, tempTable, howManyPlaces, 0);
                    }
                } else {
                    newIndividual = bestIndividualsList.get(1);
                    makeCross(newIndividual, temp, howManyPlaces);
                    if (generator.nextBoolean()) {
                        makeMutation(newIndividual, tempTable, howManyPlaces, 1);
                    }
                }
                currentIndividualsList.add(newIndividual);
            }
            
        }
        Collections.sort(bestIndividualsList);
    }
}
