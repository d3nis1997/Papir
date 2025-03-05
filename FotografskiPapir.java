/**
 * Podrazred razreda Papir, ki predstavlja fotografski papir.
 * Ima dodatno lastnost "sijaj" in metodo za tiskanje fotografije.
 * @author Denis Tojnko
 * @version Vaja 36
 */
public class FotografskiPapir extends Papir implements Merljiv {

    /**
     * Stopnja sijaja fotografskega papirja (npr. mat, sijaj).
     */
    private String sijaj;
	

    /**
     * Konstruktor za ustvarjanje novega objekta FotografskiPapir.
     *
     * @param vrsta     Vrsta papirja.
     * @param gramatura Gramatura papirja.
     * @param barva     Barva papirja.
     * @param sijaj     Stopnja sijaja papirja.
	 * @param dolzina    Dolžina papirja v milimetrih.
     * @param sirina     Širina papirja v milimetrih.
     */
    public FotografskiPapir(String vrsta, int gramatura, String barva, String sijaj, double dolzina, double sirina) {
        super(vrsta, gramatura, barva, dolzina, sirina);
        this.sijaj = sijaj;
    }

    /**
     * Vrne stopnjo sijaja papirja.
     * @return Stopnja sijaja papirja.
     */
    public String getSijaj() {
        return sijaj;
    }

    /**
     * Nastavi stopnjo sijaja papirja.
     * @param sijaj Nova stopnja sijaja papirja.
     */
    public void setSijaj(String sijaj) {
        this.sijaj = sijaj;
    }

    /**
     * Metoda za tiskanje fotografije na fotografski papir.
     * Izpiše ime datoteke, vrsto papirja, barvo, sijaj in gramaturo.
     * @param imeDatoteke Ime datoteke s fotografijo.
     */
    public void natisniFotografijo(String imeDatoteke) {
        System.out.println("Tiskam fotografijo " + imeDatoteke + " na " + getVrsta() + " papir (" + getBarva() + ", " + sijaj + ", " + getGramatura() + "g).");
    }
	
	/**
     * Implementacija metode iz vmesnika Merljiv.
     * Izračuna površino fotografskega papirja.
     *
     * @return Površina fotografskega papirja v kvadratnih milimetrih.
     */
    @Override
    public double izracunajPovrsino() {
        return super.izracunajPovrsino();
    }
}