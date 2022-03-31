package graph;

import java.util.*;

public class Graph {

    // am folosit Set pentru a elimina duplicatele
    Set<Point> pointList;

    public Graph() {
        pointList = new HashSet();
    }

    public Set<Point> getPointList() {
        return pointList;
    }

    public void setPointList(Set<Point> pointList) {
        this.pointList = pointList;
    }

    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------


    // elimin duplicatele din array si pun numerele unice intr-o lista
    public List<Integer> removeDuplicatesFromInitialArray(int[] arr){
        List<Integer> listAux = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] != arr[i+1]){
                listAux.add(arr[i]);
            }
        }
        listAux.add(arr[arr.length-1]);
        return listAux;
    }

    /*
       verific daca avem exact 2 valori diferite de Y
       daca sunt 3 valori diferite de Y => romb
    */
    public boolean checkIfOnlyTwoDifferentValuesOnOYAxis(Point pointA, Point pointB, Point pointC, Point pointD){
        final int TWOVALUES = 2;

        /*
            pentru a forma un dreptunghi, avem nevoie de minim 4 puncte
            pun valorile de pe axa Y ale celor 4 puncte candidate intr-un array
        */
        int[] pointsY = {pointA.getY(), pointB.getY(), pointC.getY(), pointD.getY()};

        // elimin duplicatele si stochez numerele unice intr-o lista
        List<Integer> list = removeDuplicatesFromInitialArray(pointsY);

        int numberOfNonZeros = list.size();
        /*
            daca avem exact 2 valori diferite => e dreptunghi
            daca ar fi exact 3 valori diferite => romb
        */
        return numberOfNonZeros == TWOVALUES;
    }

    // verific daca toate conditiile, pentru a forma un dreptunghi, sunt indeplinite
    public boolean checkIfLinesAreOk(Point pointA, Point pointB, Point pointC, Point pointD){
        // pun conditia sa accepte doar posibile dreptunghiuri
        if(!checkIfOnlyTwoDifferentValuesOnOYAxis(pointA, pointB, pointC, pointD))
            return false;

        // calculez centrul de greutate al presupusului dreptunghi
        double centerX = (pointA.getX() + pointB.getX() + pointC.getX() + pointD.getX()) / 4.0;
        double centerY = (pointA.getY() + pointB.getY() + pointC.getY() + pointD.getY()) / 4.0;

        /*
            folosesc distanta euclidiana pentru a calcula distanta dintre
            centrul de greutate si punctele A, B, C, D
        */
        double ACenter = Math.sqrt(Math.pow(pointA.getX() - centerX, 2) + Math.pow(pointA.getY() - centerY, 2) );
        double BCenter = Math.sqrt(Math.pow(pointB.getX() - centerX, 2) + Math.pow(pointB.getY() - centerY, 2) );
        double CCenter = Math.sqrt(Math.pow(pointC.getX() - centerX, 2) + Math.pow(pointC.getY() - centerY, 2) );
        double DCenter = Math.sqrt(Math.pow(pointD.getX() - centerX, 2) + Math.pow(pointD.getY() - centerY, 2) );

        /*
            daca toate distantele de la centru la punctele A, B, C, D
            sunt egale atunci e dreptunghi
        */
        return (ACenter == BCenter && ACenter == CCenter && ACenter == DCenter);
    }

    /*
        numar dreptunghiurile din toate combinatiile posibile (fara repetarea punctelor)
        returnez numarul de dreptunghiuri gasite
    */
    public int countRectangles(Set<Point> pointList){
        // daca avem mai putin de 4 puncte => nu putem forma dreptunghi
        if(pointList.size() <= 3){
            return 0;
        }

        // convertesc Set in List ca sa pot folosi metoda get(index)
        List<Point> points = new ArrayList<>(pointList);

        int count = 0;
        // trec prin toate punctele si verific daca pot forma un dreptunghi
        for(int i = 0; i<points.size()-3; i++)
            for(int j = i+1; j< points.size()-2; j++)
                for(int k = j+1; k< points.size()-1; k++)
                    for(int l = k+1; l< points.size(); l++){
                        if(checkIfLinesAreOk(points.get(i), points.get(j), points.get(k), points.get(l)))
                        {
                            count++;
//                            System.out.print("\nGasit la punctele: (" +
//                                    points.get(i).getX() + ", " + points.get(i).getY() + "), (" +
//                                    points.get(j).getX() + ", " + points.get(j).getY() + "), (" +
//                                    points.get(k).getX() + ", " + points.get(k).getY() + "), (" +
//                                    points.get(l).getX() + ", " + points.get(l).getY() + ")" );
                        }
                    }

        return count;
    }

    // afisez punctele de intrare
    public void displayPoints(Set<Point> pointList){
        int j = 0;
        System.out.println("\nAfisare puncte de intrare:");
        // V1 afisarea arata o virgula la sfarsit :((
//        for (Point point: pointList) {
//            System.out.print("(" + point.getX() + ", " + point.getY() +")" + ",  ");
//        ++j;
//        if((j % 15) == 0)
//            System.out.println();
//        }

        // V2 afisarea e putin mai costisitoare, dar nu mai pune virgula la sfarsit
        // convertesc Set in List pentru a folosi metoda get(index)
        List<Point> points = new ArrayList<>(pointList);
        for(int i = 0; i< pointList.size()-1; i++){
            System.out.print("(" + points.get(i).getX() + ", " + points.get(i).getY() +")" + ",  ");
            ++j;
            if((j % 15) == 0)
                System.out.println();
        }
        System.out.println("(" + points.get(points.size()-1).getX() + ", " + points.get(points.size()-1).getY() +")");
    }

}
