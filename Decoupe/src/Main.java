import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Float> tailleDisponible = new ArrayList<>();
        tailleDisponible.add(277F);
        //tailleDisponible.add(98F);
        //tailleDisponible.add(105F);
        tailleDisponible.add(111F);
        tailleDisponible.add(157F);
        tailleDisponible.add(90F);
        tailleDisponible.add(131F);
        tailleDisponible.add(176F);
        tailleDisponible.add(215F);


        //tailleDisponible.add(100F);
        //tailleDisponible.add(100F);
        float minTube = 90;
        float TailleBobine = 1209;
        float TailleBobineDemander = 157F;
        
        List<Neud> OptimaleSolution = Tools.DFS(tailleDisponible,TailleBobineDemander,TailleBobine,minTube);
        Collections.sort(OptimaleSolution);
        for (int i = 0; i < OptimaleSolution.size(); i++) {
            System.out.println("Le Chut = " + OptimaleSolution.get(i).chut);
            System.out.println("La Liste de Découpage:");
            for (int j = 0; j < OptimaleSolution.get(i).listeDeDecoupage.size(); j++) {
                System.out.println("Morco: " + OptimaleSolution.get(i).listeDeDecoupage.get(j).Taille + " Nombre: " + OptimaleSolution.get(i).listeDeDecoupage.get(j).NbrMorco);
            }
            System.out.println("***************************************************");

        }
    }
}