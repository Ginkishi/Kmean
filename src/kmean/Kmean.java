/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmean;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author victo
 */
public class Kmean {

    static Random r = new Random();

    /**
     * @param args the command line arguments
     */
    public void calculerDistance(ArrayList<Point> individus, ArrayList<Cluster> clusters) throws Exception {
        for (Point p : individus) {
            double max = Double.MAX_VALUE;
            Cluster referent = null;
            for (Cluster c : clusters) {
                double dist = Math.sqrt(Math.pow(c.centre.x - p.x, 2) + Math.pow(c.centre.y - p.y, 2));
                if (dist < max) {
                    max = dist;
                    referent = c;
                }
            }
            if (referent == null) {
                throw new Exception("Erreur lors de l'initialisation du Cluster référent dans la fonction calculerDistance");
            } else {
                referent.tabPoint.add(p);
            }
        }
    }

    public void calculerBarycentre(ArrayList<Cluster> clusters) {
        for (Cluster C : clusters) {
            Double xTotal = 0.0;
            Double yTotal = 0.0;
            for (Point p : C.tabPoint) {
                xTotal += p.x;
                yTotal += p.y;
            }
            xTotal /= Cluster.tabPoint.size();
            yTotal /= Cluster.tabPoint.size();
            Point barycentre = new Point(xTotal, yTotal);
            C = new Cluster(barycentre, new ArrayList<Point>());
        }

    }

    public void lanceAlgorithme(ArrayList<Point> points, int nombreCluster) {
        ArrayList<Cluster> cluster = new ArrayList<Cluster>();
        double xMax = Double.MIN_VALUE;
        double xMin = Double.MAX_VALUE;
        double yMax = Double.MIN_VALUE;
        double yMin = Double.MAX_VALUE;
        for (Point p : points) {
            if (p.x > xMax) {
                xMax = p.x;
            }
            if (p.x < xMin) {
                xMin = p.x;
            }
            if (p.y > yMax) {
                yMax = p.y;
            }
            if (p.y < yMin) {
                yMin = p.y;
            }
        }
        for (int i = 0; i < nombreCluster; i++) {
                double valX = r.nextDouble()*(xMax-xMin)+xMin;
                double valY = r.nextDouble()*(yMax-yMin)+yMin;
               cluster.add(new Cluster(new Point(valX,valY),new ArrayList<Point>()));
        }
    }

    public static void main(String[] args) {
            
    }

}
