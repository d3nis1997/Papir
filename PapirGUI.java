// Uvozimo razred za delo z vhodno-izhodnimi operacijami ter pripomočke
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Razred za prikaz delovanja grafičnega uporabniškega vmesnika
 * za delo s papirji
 *
 * razširja razred z delo z okni in implementira vmesnik za dogodke
 * @author Denis Tojnko
 * @version Vaja 36 - GUI
 */
public class PapirGUI extends JFrame implements ActionListener {

    // Deklariramo zasebne lastnosti GUI
    private JPanel povrsina;
    private JTextField vrstaTextField, gramaturaTextField, barvaTextField, dolzinaTextField, sirinaTextField, dodatnoTextField;
    private JButton dodajButton;
    private JComboBox<String> vrstaComboBox;
    private PapirTableModel modelTabele;
	private JButton urediButton, izbrisiButton;
    private JTable tabela;

    /**
     * Javna statična metoda programa, Zažene se vedno ob zagonu
     * @param args Seznam argumentov iz ukazne vrstice
     */
    public static void main(String[] args) {
        PapirGUI gui = new PapirGUI();
    }

    //Konstruktor, ki postavi osnovne lastnosti okna
    public PapirGUI() {
        super("Papir GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        povrsina = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Dodajanje prostora okoli elementov
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Gumba Uredi in Izbriši
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        urediButton = new JButton("Uredi");
        urediButton.addActionListener(this);
        povrsina.add(urediButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        izbrisiButton = new JButton("Izbriši");
        izbrisiButton.addActionListener(this);
        povrsina.add(izbrisiButton, gbc);

        // Tabela
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0; // Razširitev tabele na celotno širino
        gbc.weighty = 1.0; // Razširitev tabele na celotno višino
        gbc.fill = GridBagConstraints.BOTH; // Razširitev v obe smeri
        modelTabele = new PapirTableModel();
        tabela = new JTable(modelTabele);
        povrsina.add(new JScrollPane(tabela), gbc);

        // Vnosna polja
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        povrsina.add(new JLabel("Vrsta:"), gbc);
        gbc.gridy++;
        vrstaComboBox = new JComboBox<>(new String[]{"Papir", "FotografskiPapir", "RisalniPapir"});
        povrsina.add(vrstaComboBox, gbc);
        gbc.gridy++;
        povrsina.add(new JLabel("Gramatura:"), gbc);
        gbc.gridy++;
        gramaturaTextField = new JTextField(20);
        povrsina.add(gramaturaTextField, gbc);
        gbc.gridy++;
        povrsina.add(new JLabel("Barva:"), gbc);
        gbc.gridy++;
        barvaTextField = new JTextField(20);
        povrsina.add(barvaTextField, gbc);
        gbc.gridy++;
        povrsina.add(new JLabel("Dolžina:"), gbc);
        gbc.gridy++;
        dolzinaTextField = new JTextField(20);
        povrsina.add(dolzinaTextField, gbc);
        gbc.gridy++;
        povrsina.add(new JLabel("Širina:"), gbc);
        gbc.gridy++;
        sirinaTextField = new JTextField(20);
        povrsina.add(sirinaTextField, gbc);
        gbc.gridy++;
        povrsina.add(new JLabel("Dodatno (Sijaj/Format):"), gbc);
        gbc.gridy++;
        dodatnoTextField = new JTextField(20);
        povrsina.add(dodatnoTextField, gbc);

        // Gumb Dodaj
        gbc.gridy++;
        dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(this);
        povrsina.add(dodajButton, gbc);

        add(povrsina);
        setVisible(true);
    }

    /**
     * Metoda, ki jo predpisuje vmestnik ActionListener
     * se kliče vedno, ko je pritisnjen gumb
     * @param e Dogodek ob kliku
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dodajButton) {
            dodajPapir();
        } else if (e.getSource() == urediButton) {
            urediPapir();
        } else if (e.getSource() == izbrisiButton) {
            izbrisiPapir();
        }
    }
	
	/**
	 * Metoda za dodajanje novega objekta Papir v tabelo.
	 * Pridobi vrednosti iz vnosnih polj in ustvari ustrezen objekt Papir.
	 */
	private void dodajPapir() {
        String vrsta = (String) vrstaComboBox.getSelectedItem();
        int gramatura = Integer.parseInt(gramaturaTextField.getText());
        String barva = barvaTextField.getText();
        double dolzina = Double.parseDouble(dolzinaTextField.getText());
        double sirina = Double.parseDouble(sirinaTextField.getText());
        String dodatno = dodatnoTextField.getText();
		
		// Ustvarimo objekt Papir glede na vrsto papirja.
        Papir papir;
        switch (vrsta) {
            case "FotografskiPapir":
                papir = new FotografskiPapir("Fotografski", gramatura, barva, dodatno, dolzina, sirina);
                break;
            case "RisalniPapir":
                papir = new RisalniPapir("Risalni", gramatura, barva, dodatno, dolzina, sirina);
                break;
            default:
                papir = new Papir("Navaden", gramatura, barva, dolzina, sirina);
                break;
        }
        modelTabele.addPapir(papir);
    }

	/**
	 * Metoda za urejanje izbranega objekta Papir v tabeli.
	 * Odpre dialog za urejanje in posodobi tabelo po urejanju.
	 */
    private void urediPapir() {
        int vrstica = tabela.getSelectedRow();
        if (vrstica >= 0) {
            Papir papir = modelTabele.getPapir(vrstica);
            if (papir != null) {
                UrediPapirDialog dialog = new UrediPapirDialog(PapirGUI.this, papir);
                dialog.setVisible(true);
                modelTabele.fireTableDataChanged();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izberite vrstico za urejanje.");
        }
    }
	
	/**
	 * Metoda za brisanje izbranega objekta Papir iz tabele.
	 */
    private void izbrisiPapir() {
        int vrstica = tabela.getSelectedRow();
        if (vrstica >= 0) {
            modelTabele.removeRow(vrstica);
        } else {
            JOptionPane.showMessageDialog(this, "Izberite vrstico za brisanje.");
        }
    }
}