import java.util.ArrayList;
import java.util.List;

public class Neud {
    List<Morco> listeDeDecoupage;
    float chut;
    float poids;

    public Neud() {
        this.listeDeDecoupage = new ArrayList<>();
    }

    public Neud(Neud n){
        this.listeDeDecoupage = new ArrayList<>();
        for (int i = 0; i < n.listeDeDecoupage.size(); i++) {
            this.listeDeDecoupage.add(new Morco(n.listeDeDecoupage.get(i)));
        }
        this.chut = n.chut;
        this.poids = n.poids;
    }

    void EvaluerLeChut(float minB){
        this.poids = this.chut;
    }
    boolean verifierLargeur(float Largeur){
        for (int i = 0; i < this.listeDeDecoupage.size(); i++) {
            if(this.listeDeDecoupage.get(i).Taille == Largeur) return true;
        }
        return false;
    }
}
