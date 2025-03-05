/**
 * Podrazred razreda Papir, ki predstavlja risalni papir.
 * Ima dodatno lastnost "format" in metodo za risanje skice.
 * @author Denis Tojnko
 * @version Vaja 36
 */
public class RisalniPapir extends Papir implements Merljiv {

    /**
     * Format risalnega papirja (npr. A3, A2).
     */
    private String format;
	

    /**
     * Konstruktor za ustvarjanje novega objekta RisalniPapir.
     *
     * @param vrsta     Vrsta papirja.
     * @param gramatura Gramatura papirja.
     * @param barva     Barva papirja.
     * @param format    Format risalnega papirja.
	 * @param dolzina    Dolžina papirja v milimetrih.
     * @param sirina     Širina papirja v milimetrih.
     */
    public RisalniPapir(String vrsta, int gramatura, String barva, String format, double dolzina, double sirina) {
        super(vrsta, gramatura, barva, dolzina, sirina);
        this.format = format;
    }

    /**
     * Vrne format risalnega papirja.
     * @return Format risalnega papirja.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Nastavi format risalnega papirja.
     * @param format Nov format risalnega papirja.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Metoda za risanje skice na risalni papir.
     * Izpiše temo, vrsto papirja, barvo, format in gramaturo.
     * @param tema Slikarska tema skice.
     */
    public void narisiSkico(String tema) {
        System.out.println("Rišem skico z naslovom '" + tema + "' na " + getVrsta() + " papir (" + getBarva() + ", " + format + ", " + getGramatura() + "g).");
    }
	
	/**
     * Implementacija metode iz vmesnika Merljiv.
     * Izračuna površino risalnega papirja.
     *
     * @return Površina risalnega papirja v kvadratnih milimetrih.
     */
    @Override
    public double izracunajPovrsino() {
        return super.izracunajPovrsino();
    }
}