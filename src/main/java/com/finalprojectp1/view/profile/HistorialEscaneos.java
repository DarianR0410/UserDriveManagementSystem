package com.finalprojectp1.view.profile;

import com.finalprojectp1.view.signin.swing.PanelRound;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

/**
 * @author Isaac M
 */
public class HistorialEscaneos extends JFrame {

    // Componentes de la interfaz gráfica
    private JPanel contenedor;
    private PanelRound trabajo;
    private PanelRound encabezado;
    private PanelRound cuerpo;
    private PanelRound footer;
    private JLabel title;
    private JLabel count;
    private int index;
    private DefaultListModel<String> modelo;
    private JList<String> lista;
    private JScrollPane scroll;
    private String fechaHora;
    private String textoFinal;
    private SimpleDateFormat formato;

    // Constructor
    public HistorialEscaneos() {
        initComponents(); // Inicializa y construye la ventana
        setTitle("Historial"); // Título de la ventana
        setExtendedState(MAXIMIZED_BOTH); // La ventana se abre maximizada
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cierra solo esta ventana al salir
    }

    private void initComponents() {
        // Paneles
        // Trabajando con el panel "contenedor"
        contenedor = new JPanel();
        contenedor.setLayout(new MigLayout("fill")); // llena todo el espacio
        contenedor.setBackground(new Color(230, 233, 236));
        this.getContentPane().add(contenedor); // Se agrega el contenedor al JFrame

        // Trabajando con el panel "trabajo"
        trabajo = new PanelRound();
        trabajo.setLayout(new MigLayout("fillx, filly")); // Llena horizontal y vertical
        trabajo.setBackground(Color.WHITE);
        // Configura el redondeo de los bordes
        trabajo.setRoundBottomLeft(30);
        trabajo.setRoundBottomRight(30);
        trabajo.setRoundTopLeft(30);
        trabajo.setRoundTopRight(30);
        // Añadir al contenedor con tamaño fijo y centrado
        contenedor.add(trabajo, "align 50% 50%, w 700!, h 500!");

        // Trabajando con el panel "encabezado"
        encabezado = new PanelRound();
        encabezado.setBackground(new Color(106, 90, 205, 80));
        encabezado.setRoundTopLeft(30);
        encabezado.setRoundTopRight(30);
        encabezado.setLayout(new MigLayout("fillx, filly"));
        trabajo.add(encabezado, "dock north, w 700!, h 100!");

        // Trabajando con el panel "cuerpo"
        cuerpo = new PanelRound();
        cuerpo.setLayout(new MigLayout("insets 5, fill")); // Márgenes de 5 y llenar espacio
        cuerpo.setBackground(new Color(255, 51, 102, 0));
        cuerpo.setRoundBottomLeft(30);
        cuerpo.setRoundBottomRight(30);
        trabajo.add(cuerpo, "grow"); // Que crezca y llene espacio disponible

        // Trabajando con el panel "footer"
        footer = new PanelRound();
        footer.setBackground(new Color(106, 90, 205, 80));
        footer.setRoundBottomLeft(30);
        footer.setRoundBottomRight(30);
        footer.setLayout(new MigLayout("insets 0, fill", "[center]", "[center]")); // Centrado
        trabajo.add(footer, "dock south, w 700!, h 50!");

        // Trabajando con el label "title"
        title = new JLabel();
        title.setText("Historial de Escaneos");
        title.setFont(new Font("Roboto", 1, 24));
        title.setForeground(new Color(75, 0, 130));
        encabezado.add(title, "gapleft 20");

        // Trabajando con el label "count"
        count = new JLabel();
        count.setText("Total escaneos: " + 0);
        count.setFont(new Font("Roboto Medium", 0, 14));
        count.setForeground(new Color(63, 63, 63));
        footer.add(count);

        // Trabajando con la lista de escaneos       
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo); // Se conecta la lista con el modelo
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo uno a la vez

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Cambiar color del fondo y del texto al seleccionar
                if (isSelected) {
                    label.setBackground(new Color(102, 102, 255, 240)); // Fondo de selección
                    label.setForeground(Color.WHITE); // Texto de selección
                }

                // Fuente
                label.setFont(new Font("Roboto", 0, 14));

                // Margen interno + línea separadora abajo
                Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10); // top, left, bottom, right
                Border separator = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(240, 240, 240)); // solo abajo
                label.setBorder(BorderFactory.createCompoundBorder(separator, margin));

                return label;
            }
        });

        scroll = new JScrollPane(lista);
        scroll.setBorder(null); // Sin borde externo

        insertDataList(); // Método que llena la lista
        index = modelo.getSize(); // Total de elementos actuales
        count.setText("Total escaneos: " + index); // Actualiza el contador
        cuerpo.add(scroll, "grow, push"); // Agrega el scroll al cuerpo

    }

    private String descripcionFecha(String entrada) {
        formato = new SimpleDateFormat("dd/MM/yyyy, HH:mm"); // Formato de fecha
        fechaHora = formato.format(new Date()); // Fecha actual
        textoFinal = "<html><b>" + entrada + "</b><br><span style='color:gray'>" + fechaHora + "</span></html>";
        return textoFinal;
    }

    private void insertDataList() {
        //Agregando datos a la lista en modo de prueba
        modelo.addElement(descripcionFecha("<b>Número de teléfono:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Nombre completo:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Numero de licencia:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Placa:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Marca:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Modelo:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Año:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Color:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Placa:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa<br>"
                + "<b>Marca:</b> aaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        modelo.addElement(descripcionFecha("Elemento 1"));
        modelo.addElement(descripcionFecha("Elemento 2"));
        modelo.addElement(descripcionFecha("Elemento 3"));
        modelo.addElement(descripcionFecha("Elemento 4"));
        modelo.addElement(descripcionFecha("Elemento 5"));
        modelo.addElement(descripcionFecha("Elemento 6"));
        modelo.addElement(descripcionFecha("Elemento 7"));
        modelo.addElement(descripcionFecha("Elemento 8"));
        modelo.addElement(descripcionFecha("Elemento 9"));
    }

}
