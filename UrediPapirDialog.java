import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Razred za dialog urejanja lastnosti objekta Papir.
 * Razširja JDialog in implementira ActionListener za obravnavo dogodkov gumbov.
 * @author Denis Tojnko
 * @version Vaja 36
 */
public class UrediPapirDialog extends JDialog implements ActionListener {

    // Deklaracija zasebnih lastnosti za vnosna polja in gumbe.
    private JTextField gramaturaTextField, barvaTextField, dolzinaTextField, sirinaTextField, dodatnoTextField;
    private JButton shraniButton, prekliciButton;
    private Papir papir;

    /**
     * Konstruktor za ustvarjanje dialoga za urejanje objekta Papir.
     *
     * @param parent Okno, ki je nadrejeno temu dialogu.
     * @param papir  Objekt Papir, ki ga želimo urediti.
     */
    public UrediPapirDialog(JFrame parent, Papir papir) {
        // Klic konstruktorja nadrejenega razreda JDialog.
        super(parent, "Uredi Papir", true);
        this.papir = papir;

        // Ustvarimo JPanel za postavitev elementov.
        JPanel povrsina = new JPanel();
        povrsina.setLayout(new GridLayout(0, 2));

        // Inicializacija vnosnih polj z vrednostmi objekta Papir.
        gramaturaTextField = new JTextField(String.valueOf(papir.getGramatura()));
        barvaTextField = new JTextField(papir.getBarva());
        dolzinaTextField = new JTextField(String.valueOf(papir.getDolzina()));
        sirinaTextField = new JTextField(String.valueOf(papir.getSirina()));
		
        // Inicializacija dodatnega vnosnega polja glede na tip objekta Papir.
        dodatnoTextField = new JTextField(papir instanceof FotografskiPapir ? ((FotografskiPapir) papir).getSijaj() : papir instanceof RisalniPapir ? ((RisalniPapir) papir).getFormat() : "");

        // Inicializacija gumbov in dodajanje ActionListener-jev.
        shraniButton = new JButton("Shrani");
        shraniButton.addActionListener(this);
        prekliciButton = new JButton("Prekliči");
        prekliciButton.addActionListener(this);

        // Dodajanje label in vnosnih polj na JPanel.
        povrsina.add(new JLabel("Gramatura:"));
        povrsina.add(gramaturaTextField);
        povrsina.add(new JLabel("Barva:"));
        povrsina.add(barvaTextField);
        povrsina.add(new JLabel("Dolžina:"));
        povrsina.add(dolzinaTextField);
        povrsina.add(new JLabel("Širina:"));
        povrsina.add(sirinaTextField);
        povrsina.add(new JLabel("Dodatno:"));
        povrsina.add(dodatnoTextField);
        povrsina.add(shraniButton);
        povrsina.add(prekliciButton);

        // Dodajanje JPanel na dialog in nastavitev velikosti in lokacije.
        add(povrsina);
        pack(); // Prilagodi velikost dialoga glede na vsebino.
        setLocationRelativeTo(parent); // Postavi dialog na sredino nadrejenega okna.
    }

    /**
     * Implementacija metode actionPerformed iz vmesnika ActionListener.
     * Obravnava dogodke gumbov "Shrani" in "Prekliči".
     *
     * @param e Dogodek, ki je sprožil klic metode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shraniButton) {
            // Spremeni lastnosti objekta Papir z vrednostmi iz vnosnih polj.
            papir.setGramatura(Integer.parseInt(gramaturaTextField.getText()));
            papir.setBarva(barvaTextField.getText());
            papir.setDolzina(Double.parseDouble(dolzinaTextField.getText()));
            papir.setSirina(Double.parseDouble(sirinaTextField.getText()));
			
            // Spremeni dodatno lastnost glede na tip objekta Papir.
            if (papir instanceof FotografskiPapir) {
                ((FotografskiPapir) papir).setSijaj(dodatnoTextField.getText());
            } else if (papir instanceof RisalniPapir) {
                ((RisalniPapir) papir).setFormat(dodatnoTextField.getText());
            }
            dispose(); // Zapre dialog.
        } else if (e.getSource() == prekliciButton) {
            dispose(); // Zapre dialog brez sprememb.
        }
    }
}