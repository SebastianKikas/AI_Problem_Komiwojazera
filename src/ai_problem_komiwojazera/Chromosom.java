/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_problem_komiwojazera;

import java.util.List;

/**
 *
 * @author Sebastian Kikas
 */
public class Chromosom {

    private List<Integer> places;

    public Chromosom(int firstPlace) {
        places.add(firstPlace);

    }

    public Chromosom(List<Integer> newPlaces) {
        places = newPlaces;
    }

    public List<Integer> getListPlaces() {
        return places;
    }

    public int getPlace(int i) {
        return places.get(i);
    }

    public void setListPlaces(List<Integer> newPlaces) {
        places = newPlaces;
    }

    public void setNewPlace(int newPlace) {
        places.add(newPlace);
    }

    public void changeOldPlace(int newValue, int whichPlace) {
        places.set(whichPlace, newValue);
    }

    public Boolean isThisValue(int checkValue) {
        for (int place : places) {
            if (place == checkValue) {
                return true;
            }
        }
        return false;
    }

    public void mutation(int whichPlace, int newPlace) {
        int temp = places.get(whichPlace);
        places.set(whichPlace, newPlace);
        for (int i = 0; i < places.size(); i++) {
            if ((places.get(i) == newPlace) && (i != whichPlace)) {
                places.set(i, temp);
                break;
            }
        }
    }

    public void cross(int beginChange, int endChange, List<Integer> newPlaces) {
        int j = 0;
        for (int i = beginChange; i <= endChange; i++) {
            places.set(i, newPlaces.get(j));
            j++;
        }
        for(int i=0;i<places.size();i++){
            if (i<beginChange || i>endChange){
            for(int k=0;k<newPlaces.size();k++){
                    if(places.get(i)==newPlaces.get(k)){
                        
                    }
        }
    }
}
