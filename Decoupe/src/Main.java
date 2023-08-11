import java.util.ArrayList;
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

        Neud OptimaleSolution = Tools.DFS(tailleDisponible,TailleBobineDemander,TailleBobine,minTube);
        System.out.println("Le Chutte Finale= " + OptimaleSolution.chut);
        for (int i = 0; i < OptimaleSolution.listeDeDecoupage.size(); i++) {
            System.out.println("La " + (i+1) + " ime Decoupage de Taille:" + OptimaleSolution.listeDeDecoupage.get(i).Taille +" Nombre:" + OptimaleSolution.listeDeDecoupage.get(i).NbrMorco);
        }
    }
}