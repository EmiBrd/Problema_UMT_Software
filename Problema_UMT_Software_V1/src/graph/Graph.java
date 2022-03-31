
package graph;

import java.util.*;

public class Graph {

    // folosesc Set pentru a nu avea puncte duplicate
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


    // verific pe axa X sa fie doar 2 puncte egale
    // verific pe axa Y sa fie doar 2 puncte egale
    // daca si pe axa X si pe axa Y sunt cate 2 puncte egale => e dreptunghi
    public boolean checkIfLinesAreOk(Point pointA, Point pointB, Point pointC, Point pointD){
        int countSameLineX = 0, countSameLineY = 0;;
        // verific toate combinatiile in care coordonata X a unui punct este egala cu coordonata X a altui punct
        if(pointA.getX() == pointB.getX())
            countSameLineX++;
        if(pointA.getX() == pointC.getX())
            countSameLineX++;
        if(pointA.getX() == pointD.getX())
            countSameLineX++;
        if(pointB.getX() == pointC.getX())
            countSameLineX++;
        if(pointB.getX() == pointD.getX())
            countSameLineX++;
        if(pointC.getX() == pointD.getX())
            countSameLineX++;

        // verific toate combinatiile in care coordonata Y a unui punct este egala cu coordonata Y a altui punct
        if(pointA.getY() == pointB.getY())
            countSameLineY++;
        if(pointA.getY() == pointC.getY())
            countSameLineY++;
        if(pointA.getY() == pointD.getY())
            countSameLineY++;
        if(pointB.getY() == pointC.getY())
            countSameLineY++;
        if(pointB.getY() == pointD.getY())
            countSameLineY++;
        if(pointC.getY() == pointD.getY())
            countSameLineY++;

        return (countSameLineX == 2 && countSameLineY == 2);
    }

    // numar dreptunghiurile din toate combinatiile posibile (fara repetarea punctelor)
    // returnez numarul de dreptunghiuri gasite
    public int countRectangles(Set<Point> pointList){
        // daca avem mai putin de 4 puncte => nu putem forma dreptunghi
        if(pointList.size() <= 3){
            return 0;
        }

        // convertesc Set in List ca sa pot folosi metoda get(index)
        List<Point> points = new ArrayList<>(pointList);

        int count = 0;
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
