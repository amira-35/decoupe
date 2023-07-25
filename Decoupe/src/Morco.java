public class Morco {
    int NbrMorco;
    float Taille;

    public Morco(Morco morco) {
        this.Taille = morco.Taille;
        this.NbrMorco = morco.NbrMorco;
    }
    public Morco(){}
    public Morco(int n,float t){
        this.NbrMorco = n;
        this.Taille =t;
    }
}
