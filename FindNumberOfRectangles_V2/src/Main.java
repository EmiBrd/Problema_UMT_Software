
import graph.Graph;
import graph.Point;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Graph graph = new Graph();
        Set<Point> pointList = new HashSet<>();

        //Input 1 => ne asteptam sa rezulte 3
        pointList.add(new Point(1, 1));
        pointList.add(new Point(1, 3));
        pointList.add(new Point(2, 1));
        pointList.add(new Point(2, 3));
        pointList.add(new Point(3, 1));
        pointList.add(new Point(3, 3));

        // Input 2 => ne asteptam sa rezulte 1
//        pointList.add(new Point(1, 1));
//        pointList.add(new Point(1, 3));
//        pointList.add(new Point(2, 1));
//        pointList.add(new Point(3, 1));
//        pointList.add(new Point(3, 3));


        // Formula calculare dreptunghiuri imbricate:
        // Nr total dreptunghiuri = (1 + 2 + 3 + ... + n) * (1 + 2 + 3 + ... + m)
        // n = numar dreptunghiuri de pe axa X
        // m = numar dreptunghiuri de pe axa Y


        // Input 3 => ne asteptam sa rezulte 9
//        for(int i = 0; i<3; i++){
//            for(int j = 0; j<3; j++){
//                pointList.add(new Point(i, j));
//            }
//        }

        // Input 4 => ne asteptam sa rezulte 36
//        for(int i = 0; i<4; i++){
//            for(int j = 0; j<4; j++){
//                pointList.add(new Point(i, j));
//            }
//        }

        // Input 5 => ne asteptam sa rezulte 60
//        for(int i = 0; i<4; i++){
//            for(int j = 0; j<5; j++){
//                pointList.add(new Point(i, j));
//            }
//        }

        // Input 6 => ne asteptam sa rezulte 11025 (dureaza aproximativ 6.5 secunde)
//        for(int i = 0; i<15; i++){
//            for(int j = 0; j<15; j++){
//                pointList.add(new Point(i, j));
//            }
//        }

        // Input 7 => ne asteptam sa rezulte 36100 (dureaza aproximativ 48.5 secunde)
//        for(int i = 0; i<20; i++){
//            for(int j = 0; j<20; j++){
//                pointList.add(new Point(i, j));
//            }
//        }


        // adaug punctele intr-un Set pentru a nu permite duplicate
        graph.setPointList(pointList);
        // afisez punctele de intrare
        graph.displayPoints(pointList);

        System.out.println("\n\nNumar dreptunghiuri = " + graph.countRectangles(pointList));
        System.out.println("Done");

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds\n");

    }


}
