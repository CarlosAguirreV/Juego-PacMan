package pacman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author Carlos Aguirre
 */
public class PantallaBienvenida extends JFrame {

    private Random rand;
    private JPanel panelGlobal, panelMenu;
    private JButton btnJugar, btnAcerca, btnSalir;
    private Icon imgIcono, imgPacman, imgFantasma1, imgFantasma2, imgCopa;
    private Icon[] coleccionPortadas = {
        new ImageIcon(getClass().getResource("/recursos/portada1.png")),
        new ImageIcon(getClass().getResource("/recursos/portada2.png")),
        new ImageIcon(getClass().getResource("/recursos/portada3.png")),
        new ImageIcon(getClass().getResource("/recursos/portada4.png"))
    };
    private final Font fuenteTexto = new Font("Default", 1, 20);
    private JLabel lblPuntuacionMaxima, lblPortada;

    public PantallaBienvenida() {
        this.crearElementos();
        this.crearDistribucion();
        this.colocarElementos();
        this.definirEstilos();
        this.eventos();

        // Propiedades de la ventana.
        this.setTitle("PacMan");
        this.setResizable(false);
        this.pack();
        this.setSize(526, 615);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void crearElementos() {
        this.rand = new Random();
        this.panelGlobal = new JPanel();
        this.panelMenu = new JPanel();
        this.btnJugar = new JButton("Jugar");
        this.btnAcerca = new JButton("Acerca");
        this.btnSalir = new JButton("Salir");
        this.imgIcono = new ImageIcon(getClass().getResource("/recursos/logo.png"));
        this.imgPacman = new ImageIcon(getClass().getResource("/recursos/pacman_dcha.png"));
        this.imgFantasma1 = new ImageIcon(getClass().getResource("/recursos/fantasma4.png"));
        this.imgFantasma2 = new ImageIcon(getClass().getResource("/recursos/fantasma7.png"));
        this.imgCopa = new ImageIcon(getClass().getResource("/recursos/copa.png"));
        this.lblPuntuacionMaxima = new JLabel("Récord: ");
        this.lblPortada = new JLabel(coleccionPortadas[this.rand.nextInt(coleccionPortadas.length)]);
    }

    private void crearDistribucion() {
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.panelGlobal.setLayout(new BorderLayout());
        this.panelMenu.setLayout(new GridLayout(1, 3, 15, 0));
    }

    private void colocarElementos() {
        this.getContentPane().add(this.panelGlobal);
        this.panelGlobal.add(this.panelMenu, BorderLayout.SOUTH);
        this.panelMenu.add(this.btnJugar);
        this.panelMenu.add(this.btnAcerca);
        this.panelMenu.add(this.btnSalir);
        this.panelGlobal.add(lblPuntuacionMaxima, BorderLayout.NORTH);
        this.panelGlobal.add(lblPortada, BorderLayout.CENTER);
    }

    private void definirEstilos() {
        this.panelGlobal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.panelGlobal.setBackground(Color.black);
        this.panelMenu.setOpaque(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Juego.class.getResource("/recursos/icono.png")));

        Border bordeBlanco = BorderFactory.createLineBorder(Color.white, 2);
        Color colorBoton = new Color(32, 38, 117);
        this.btnJugar.setFont(fuenteTexto);
        this.btnSalir.setFont(fuenteTexto);
        this.btnJugar.setForeground(Color.white);
        this.btnJugar.setBackground(colorBoton);
        this.btnJugar.setBorder(bordeBlanco);
        this.btnAcerca.setFont(fuenteTexto);
        this.btnAcerca.setFont(fuenteTexto);
        this.btnAcerca.setForeground(Color.white);
        this.btnAcerca.setBackground(colorBoton);
        this.btnAcerca.setBorder(bordeBlanco);
        this.btnSalir.setFont(fuenteTexto);
        this.btnSalir.setFont(fuenteTexto);
        this.btnSalir.setForeground(Color.white);
        this.btnSalir.setBackground(colorBoton);
        this.btnSalir.setBorder(bordeBlanco);

        // Iconos diferentes para cada botón.
        this.btnJugar.setIcon(imgPacman);
        this.btnAcerca.setIcon(imgFantasma1);
        this.btnSalir.setIcon(imgFantasma2);

        this.btnJugar.setFocusable(false);
        this.btnAcerca.setFocusable(false);
        this.btnSalir.setFocusable(false);

        this.btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnAcerca.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Otros
        this.lblPuntuacionMaxima.setFont(fuenteTexto);
        this.lblPuntuacionMaxima.setForeground(Color.white);
        this.lblPuntuacionMaxima.setIcon(imgCopa);
    }

    private void eventos() {
        this.btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Juego();
                PantallaBienvenida.this.dispose();
            }
        });
        this.btnAcerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(PantallaBienvenida.this, "Juego programado por: Carlos Aguirre (Codigo Base) en colaboracion con DaPelle y Millan.\nAutor original: Toru Iwatani (1980)\nVersion: 12/03/2019", "Acerca de", JOptionPane.INFORMATION_MESSAGE, imgIcono);
            }
        });
        this.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        this.lblPortada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                lblPortada.setIcon(coleccionPortadas[rand.nextInt(coleccionPortadas.length)]);
            }
        });

    }

    public static void main(String[] args) {
        new PantallaBienvenida();
    }
}
