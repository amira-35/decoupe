import java.util.ArrayList;
import java.util.List;

public class Tools {
    static List<Neud> genererLesPermiersFils(float LaTailleB, float TailleT, float minB){
        Neud FirstChild = new Neud();
        Neud SecondChild = new Neud();
        Neud ThirdChild = new Neud();
        Morco M1 = new Morco();
        M1.NbrMorco =(int)(LaTailleB / TailleT);
        M1.Taille = TailleT;
        FirstChild.listeDeDecoupage.add(M1);
        FirstChild.chut = LaTailleB - TailleT*M1.NbrMorco;
        FirstChild.EvaluerLeChut(minB);
        Morco M2 = new Morco();
        M2.NbrMorco = M1.NbrMorco - 1;
        M2.Taille = TailleT;
        SecondChild.listeDeDecoupage.add(M2);
        SecondChild.chut = LaTailleB - TailleT*M2.NbrMorco;
        SecondChild.EvaluerLeChut(minB);
        Morco M3 = new Morco();
        M3.NbrMorco = M1.NbrMorco - 2;
        M3.Taille = TailleT;
        ThirdChild.listeDeDecoupage.add(M3);
        ThirdChild.chut = LaTailleB - TailleT*M3.NbrMorco;
        ThirdChild.EvaluerLeChut(minB);
        List<Neud> list = new ArrayList<>();
        list.add(FirstChild);
        list.add(SecondChild);
        list.add(ThirdChild);
        return list;
    }
    static List<Neud> genenerLesFilsQuelconque(Neud neud, List<Float> TailleDisponible,float minB){
        List<Neud> listFils = new ArrayList<>();
        int j;
        Neud neudTemp;
        for (int i = 0; i < TailleDisponible.size(); i++) {
            if(! neud.verifierLargeur(TailleDisponible.get(i)) && (neud.chut+3) >= TailleDisponible.get(i)){
                neudTemp = new Neud(neud);
                j =(int) (neud.chut/TailleDisponible.get(i));
                if(j==0) {
                    neudTemp.listeDeDecoupage.add(new Morco(1,TailleDisponible.get(i)));
                    neudTemp.chut = 0;
                    neudTemp.EvaluerLeChut(minB);
                    listFils.add(neudTemp);
                }
                else{
                for(int x=1; x<=j; x++){
                    neudTemp.listeDeDecoupage.add(new Morco(x,TailleDisponible.get(i)));
                    neudTemp.chut = neud.chut - x*TailleDisponible.get(i);
                    neudTemp.EvaluerLeChut(minB);
                    listFils.add(neudTemp);
                }}
            }
        }
        return listFils;
    }
    static List<Neud> DFS(List<Float> listeDesTubesDisponible, float tubeDemander, float TailleBobine, float minTube)
    {
        List<Neud> openList;
        openList = genererLesPermiersFils(TailleBobine,tubeDemander,minTube);
        Neud OptimaleSolution = new Neud(openList.get(0));
        List<Neud> Fils = new ArrayList<>();
        List<Neud> Listretorner = new ArrayList<>();

        while(openList.size() != 0){
            if(openList.get(0).poids >=0 && openList.get(0).poids < OptimaleSolution.poids){
                OptimaleSolution = new Neud(openList.get(0));
            }
            Neud tempNeud = openList.remove(0);
            Fils.clear();
            Fils.addAll(genenerLesFilsQuelconque(tempNeud,listeDesTubesDisponible,minTube));
            if(Fils.size() == 0) Listretorner.add(tempNeud);
            openList.addAll(Fils);
        }
        return Listretorner;
    }
}
