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
            if (checkValue == place) {
                return true;
            }
        }
        return false;
    }
}
