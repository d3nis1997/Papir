import javax.swing.table.DefaultTableModel;

/**
 * Razred za delo s tabelo papirjev
 * Razširja privzeti razred za tabele
 *
 * @author Denis Tojnko
 * @version Vaja 36 - GUI
 */
public class PapirTableModel extends DefaultTableModel {

    //Konstruktor, ki ustvari tabelo papirjev
    public PapirTableModel() {
        super();
        addColumn("Vrsta");
        addColumn("Gramatura");
        addColumn("Barva");
        addColumn("Dolžina");
        addColumn("Širina");
        addColumn("Dodatno"); // Dodatni stolpec za specifične lastnosti (sijaj/format)
    }

    /**
     * Javna metoda, ki doda papir v tabelo
     * @param papir Objekt, ki ga dodamo v tabelo
     */
    public void addPapir(Papir papir) {
        Object[] vrstica;
        if (papir instanceof FotografskiPapir) {
            FotografskiPapir fp = (FotografskiPapir) papir;
            vrstica = new Object[]{fp.getVrsta(), fp.getGramatura(), fp.getBarva(), fp.dolzina, fp.sirina, fp.getSijaj()};
        } else if (papir instanceof RisalniPapir) {
            RisalniPapir rp = (RisalniPapir) papir;
            vrstica = new Object[]{rp.getVrsta(), rp.getGramatura(), rp.getBarva(), rp.dolzina, rp.sirina, rp.getFormat()};
        } else {
            vrstica = new Object[]{papir.getVrsta(), papir.getGramatura(), papir.getBarva(), papir.dolzina, papir.sirina, ""};
        }
        addRow(vrstica);
    }
	
	/**
	 * Metoda za pridobivanje objekta Papir iz tabele na podlagi indeksa vrstice.
	 *
	 * @param vrstica Indeks vrstice v tabeli, iz katere pridobimo objekt Papir.
	 * @return Objekt Papir, ki ustreza vrstici v tabeli, ali null, če vrstica ne obstaja.
	 */
	public Papir getPapir(int vrstica) {
        if (vrstica >= 0 && vrstica < getRowCount()) {
            String vrsta = (String) getValueAt(vrstica, 0);
            int gramatura = (int) getValueAt(vrstica, 1);
            String barva = (String) getValueAt(vrstica, 2);
            double dolzina = (double) getValueAt(vrstica, 3);
            double sirina = (double) getValueAt(vrstica, 4);
            String dodatno = (String) getValueAt(vrstica, 5);

            if (vrsta.equals("FotografskiPapir")) {
                return new FotografskiPapir(vrsta, gramatura, barva, dodatno, dolzina, sirina);
            } else if (vrsta.equals("RisalniPapir")) {
                return new RisalniPapir(vrsta, gramatura, barva, dodatno, dolzina, sirina);
            } else {
                return new Papir(vrsta, gramatura, barva, dolzina, sirina);
            }
        }
        return null;
    }
}