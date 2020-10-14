package cartes;

public class Cartes {

    protected int idCart,bois,tuile,savoir,pierre;
    protected String nom;
    public static String[][] carteOuv = {{"0","Maitre","5","0","0","2","3","FALSE","-1"},{"1","Maître","5","2","0","0","3","FALSE","-1"},{"2","Maître","5","3","0","0","2","FALSE","-1"},
            {"3","Maître","5","3","2","0","0","FALSE","-1"},{"4","Maître","5","0","3","2","0","FALSE","-1"},{"5","Maître","5","2","3","0","0","FALSE","-1"},{"6","Maître","5","0","2","3","0","FALSE","-1"},
            {"7","Maître","5","0","0","3","2","FALSE","-1"},{"8","Compagnon","4","3","1","0","0","FALSE","-1"},{"9","Compagnon","4","0","0","1","3","FALSE","-1"},
            {"10","Compagnon","4","1","0","3","0","FALSE","-1"},{"11","Compagnon","4","0","3","0","1","FALSE","-1"},{"12","Compagnon","4","2","0","0","2","FALSE","-1"},
            {"13","Compagnon","4","2","2","0","0","FALSE","-1"},{"14","Compagnon","4","2","0","2","0","FALSE","-1"},{"15","Compagnon","4","0","2","0","2","FALSE","-1"},
            {"16","Compagnon","4","0","2","2","0","FALSE","-1"},{"17","Compagnon","4","0","0","2","2","FALSE","-1"},{"18","Compagnon","4","0","1","1","2","FALSE","-1"},
            {"Compagnon","4","2","0","0","2","FALSE","-1"}};


    public Cartes(int id, String nom, int bois,int tuile,int savoir,int pierre){
        this.idCart = id;
        this.bois = bois;
        this.tuile = tuile;
        this.savoir = savoir;
        this.pierre = pierre;
        this.nom = nom;


    }




    public String getIdCarte(){
        return nom;
    }


    @Override
    public String toString() {      //méthode pour visualiser
        return "Cartes{ " +
                "id=" + idCart +"}";
    }
}
