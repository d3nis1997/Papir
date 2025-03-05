/**
 * Razred za predstavitev modela papirja.
 * Ima lastnosti, kot so vrsta, gramatura in barva, ter metode za tiskanje, prepogibanje in izračun površine.
 *
 * @author Denis Tojnko
 * @version Vaja 36
 */
public class Papir implements Merljiv {

    /**
     * Vrsta papirja (A4, umetniški, recikliran).
     */
    public String vrsta;

    /**
     * Gramatura papirja (teža papirja na kvadratni meter).
     */
    public int gramatura;

    /**
     * Barva papirja.
     */
    public String barva;

    public double dolzina;

    public double sirina;

    /**
     * Konstruktor za ustvarjanje novega objekta Papir.
     * Inicializira lastnosti
     * @param vrsta     Vrsta papirja.
     * @param gramatura Gramatura papirja.
     * @param barva     Barva papirja.
     * @param dolzina    Dolžina papirja v milimetrih.
     * @param sirina     Širina papirja v milimetrih.
     */
    public Papir(String vrsta, int gramatura, String barva, double dolzina, double sirina) {
        this.vrsta = vrsta;
        this.gramatura = gramatura;
        this.barva = barva;
        this.dolzina = dolzina;
        this.sirina = sirina;
    }

    /**
     * Vrne vrsto papirja.
     * @return Vrsta papirja.
     */
    public String getVrsta() {
        return vrsta;
    }

    /**
     * Nastavi vrsto papirja.
     * @param vrsta Nova vrsta papirja.
     */
    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    /**
     * Vrne gramaturo papirja.
     * @return Gramatura papirja.
     */
    public int getGramatura() {
        return gramatura;
    }

    /**
     * Nastavi gramaturo papirja.
     * @param gramatura Nova gramatura papirja.
     */
    public void setGramatura(int gramatura) {
        this.gramatura = gramatura;
    }

    /**
     * Vrne barvo papirja.
     * @return Barva papirja.
     */
    public String getBarva() {
        return barva;
    }

    /**
     * Nastavi barvo, dolzino in sirino papirja.
     * @param barva Nova barva papirja.
     * @param dolzina Nova dolzina papirja.
     * @param sirina Nova sirina papirja.
     */
    public void setBarva(String barva) {
        this.barva = barva;
    }
	public void setDolzina(double dolzina) {
        this.dolzina = dolzina;
    }

    public void setSirina(double sirina) {
        this.sirina = sirina;
    }


    /**
     * Metoda za tiskanje besedila na papir.
     * Izpiše na kakšnem listu je napisano besedilo.
     * @param besedilo Besedilo, ki ga želimo natisniti.
     */
    public void natisniBesedilo(String besedilo) {
        System.out.println("Natisnjeno besedilo na " + vrsta + " papirju (" + barva + ", " + gramatura + "g): " + besedilo);
    }

    /**
     * Metoda za prepogibanje papirja.
     */
    public void prepogniPapir() {
        System.out.println(vrsta + " papir (" + gramatura + "g) je bil prepognjen.");
    }

    /**
     * Metoda za izračun površine papirja.
     * @param dolzina Dolžina papirja.
     * @param sirina  Širina papirja.
     */
    public void izmeriPovrsino(int dolzina, int sirina) {
        int povrsina = (dolzina * sirina) / 100;
        System.out.println("Površina " + vrsta + " papirja (" + gramatura + "g) je " + povrsina + " kvadratnih centimetrov.");
    }

    /**
     * Implementacija metode iz vmesnika Merljiv.
     * Izračuna površino papirja.
     *
     * @return Površina papirja v kvadratnih milimetrih.
     */
    public double izracunajPovrsino() {
        return (dolzina * sirina) / 100;
    }

    public double getDolzina() {
        return dolzina;
    }

    public double getSirina() {
        return sirina;
    }
}
