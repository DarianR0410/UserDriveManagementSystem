package com.finalprojectp1.view.signin;

import com.formdev.flatlaf.FlatClientProperties;
import com.finalprojectp1.controller.signin.EventoConductorLogin;
import com.finalprojectp1.controller.signin.ManejadorEventos;
import com.finalprojectp1.controller.signin.ObtenerInfoSignConductor;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * @author Isaac M
 */
public class panelRegistroConductor extends javax.swing.JPanel {

    private VentanaRegistro ventana;
    private ManejadorEventos manejador;
    private Map<String, String[]> modelosPorMarca;
    private Color colorSeleccionado;

    /**
     * Creates new form panelLogin
     *
     * @param ventana
     */
    // Constructor
    public panelRegistroConductor(VentanaRegistro ventana) {
        this.ventana = ventana;
        initComponents();
        init();
        this.setSize(850, 510);
        ventana.getTglbRoll().setEnabled(true);
    }

    /**
     * Inicializa componentes y configura la interfaz gráfica.
     */
    private void init() {
        // llamada al metodo que personaliza los campos
        customizeCamps();

        panelSign2.add(btnRgConductor, "align center, wrap");
        panelSign2.add(jbIraLog, "align center, wrap");

        jbIraLog.addMouseListener(new EventoConductorLogin(ventana));

        btnRgCondTxt.addMouseListener(new ObtenerInfoSignConductor(this));
    }

    /**
     * Personaliza los campos de entrada agregando placeholders e iconos entre
     * otros.
     */
    private void customizeCamps() {
        fillCbbx();
        // Placeholders

        jtNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre");
        jtApellido.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido");
        jtNumero.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Numero");
        jtCorreo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Correo");
        jpContrasena.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        jtPlaca.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Placa");
        jtColor.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Color");

        //// Iconos
        jtNombre.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-1.png")));
        jtApellido.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-2.png")));
        jtNumero.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-3.png")));
        jtCorreo.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-4.png")));
        jpContrasena.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-5.png")));
        jpContrasena.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true;");
        jtPlaca.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-6.png")));
        jtColor.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/img/icon-10.png")));
        // 
    }

    private void fillCbbx() {

        // Detectamos cuando el usuario cambia la selección
        jcMarca.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!jcMarca.getSelectedItem().equals("Marca")) {
                    // Una vez que el usuario elige una marca válida,
                    // deshabilitamos la opción inicial
                    jcMarca.removeItem("Marca");
                }
            }
        });

        // Llamanda al metodo que agrega el icono
        customizeCbCall(jcMarca, "Marca", "/img/icon-7.png");

        // Detectamos cuando el usuario cambia la selección
        jcModelo.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!jcModelo.getSelectedItem().equals("Modelo")) {
                    // Una vez que el usuario elige una marca válida,
                    // deshabilitamos la opción inicial
                    jcModelo.removeItem("Modelo");
                }
            }
        });

        // Llamanda al metodo que agrega el icono
        customizeCbCall(jcModelo, "Modelo", "/img/icon-8.png");

        // Dandole valores a modelo segun la marca seleccionada
        modelosPorMarca = new HashMap<>();
        modelosPorMarca.put("Honda", new String[]{"Modelo", "Civic", "Accord", "CR-V", "Pilot", "Ridgeline", "Fit", "HR-V", "Odyssey", "Passport", "Insight", "S2000", "Element", "Clarity", "Prelude", "Crosstour"});
        modelosPorMarca.put("Toyota", new String[]{"Modelo", "Corolla", "Camry", "RAV4", "Hilux", "Land Cruiser", "Yaris", "Highlander", "Tacoma", "4Runner", "Avalon", "Sienna", "C-HR", "Sequoia", "Tundra", "Prius"});
        modelosPorMarca.put("Kia", new String[]{"Modelo", "Rio", "Forte", "Sportage", "Sorento", "Seltos", "Soul", "Telluride", "Stinger", "Carnival", "K5", "Niro", "Ceed", "Picanto", "Optima", "Mohave"});
        modelosPorMarca.put("Hyundai", new String[]{"Modelo", "Creta", "Elantra", "Tucson", "Sonata", "Palisade", "Santa Fe", "Kona", "Venue", "Accent", "Ioniq", "Veloster", "Nexo", "Azera", "Genesis", "Staria"});
        modelosPorMarca.put("Nissan", new String[]{"Modelo", "Sentra", "Altima", "Versa", "X-Trail", "Frontier", "Qashqai", "Murano", "Pathfinder", "Maxima", "Juke", "Kicks", "Rogue", "Armada", "370Z", "GT-R"});
        modelosPorMarca.put("Chevrolet", new String[]{"Modelo", "Spark", "Malibu", "Equinox", "Traverse", "Silverado", "Camaro", "Tahoe", "Suburban", "Colorado", "Blazer", "Trax", "Impala", "Sonic", "Bolt EV", "Corvette"});
        modelosPorMarca.put("Volkswagen", new String[]{"Modelo", "Golf", "Jetta", "Passat", "Tiguan", "Atlas", "Polo", "Arteon", "Beetle", "Touareg", "ID.4", "Taos", "T-Roc", "Caddy", "Sharan", "Amarok"});
        modelosPorMarca.put("Ford", new String[]{"Modelo", "Escape", "Bronco", "Explorer", "F-150", "Mustang", "Edge", "Ranger", "Expedition", "EcoSport", "Fusion", "Focus", "Maverick", "Transit", "Fiesta", "Taurus"});
        modelosPorMarca.put("Renault", new String[]{"Modelo", "Clio", "Megane", "Captur", "Koleos", "Duster", "Sandero", "Logan", "Talisman", "Scenic", "Kadjar", "Arkana", "Zoe", "Espace", "Twizy", "Fluence"});
        modelosPorMarca.put("Mazda", new String[]{"Modelo", "Mazda2", "Mazda3", "CX-5", "CX-9", "MX-5 Miata", "Mazda6", "CX-3", "CX-30", "CX-50", "RX-8", "BT-50", "MPV", "Tribute", "MX-30", "Mazda5"});

        // Detectamos cuando el usuario cambia la selección
        jcAno.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!jcAno.getSelectedItem().equals("Año")) {
                    // Una vez que el usuario elige una marca válida,
                    // deshabilitamos la opción inicial
                    jcAno.removeItem("Año");
                }
            }
        });

        // Llamanda al metodo que agrega el icono
        customizeCbCall(jcAno, "Año", "/img/icon-9.png");
    }

    public void customizeCbCall(JComboBox<String> combo, String textoIndicativo, String rutaIcono) {
        ImageIcon icono = new ImageIcon(getClass().getResource(rutaIcono));

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (textoIndicativo.equals(value)) {
                    label.setText("<html><font color='gray'>" + textoIndicativo + "</font></html>");  // Siempre gris
                    label.setIcon(icono);
                } else {
                    label.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
                    label.setIcon(icono); // label.setIcon(null);
                }

                return label;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDinamcLg = new com.finalprojectp1.view.signin.swing.PanelRound();
        titlelg = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        panelSign2 = new com.finalprojectp1.view.signin.swing.PanelRound();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNumero = new javax.swing.JTextField();
        jtCorreo = new javax.swing.JTextField();
        jpContrasena = new javax.swing.JPasswordField();
        jtPlaca = new javax.swing.JTextField();
        jcMarca = new javax.swing.JComboBox<>();
        jcModelo = new javax.swing.JComboBox<>();
        jcAno = new javax.swing.JComboBox<>();
        jtColor = new javax.swing.JTextField();
        btnRgConductor = new com.finalprojectp1.view.signin.swing.PanelRound();
        btnRgCondTxt = new javax.swing.JLabel();
        jbIraLog = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(850, 510));

        panelDinamcLg.setBackground(new java.awt.Color(162, 57, 202));
        panelDinamcLg.setPreferredSize(new java.awt.Dimension(470, 510));
        panelDinamcLg.setRoundBottomLeft(40);
        panelDinamcLg.setRoundTopLeft(40);

        titlelg.setFont(new java.awt.Font("Roboto Slab", 1, 36)); // NOI18N
        titlelg.setForeground(new java.awt.Color(255, 255, 255));
        titlelg.setText("Registrarme");

        image3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/02.gif"))); // NOI18N

        javax.swing.GroupLayout panelDinamcLgLayout = new javax.swing.GroupLayout(panelDinamcLg);
        panelDinamcLg.setLayout(panelDinamcLgLayout);
        panelDinamcLgLayout.setHorizontalGroup(
                panelDinamcLgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDinamcLgLayout.createSequentialGroup()
                                .addGroup(panelDinamcLgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelDinamcLgLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelDinamcLgLayout.createSequentialGroup()
                                                .addGap(124, 124, 124)
                                                .addComponent(titlelg)))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelDinamcLgLayout.setVerticalGroup(
                panelDinamcLgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDinamcLgLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(titlelg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        panelSign2.setBackground(new java.awt.Color(51, 51, 51, 110));
        panelSign2.setPreferredSize(new java.awt.Dimension(380, 510));
        panelSign2.setRoundBottomRight(40);
        panelSign2.setRoundTopRight(40);

        jtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jtNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNumeroKeyTyped(evt);
            }
        });

        jtCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jpContrasena.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jtPlaca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jcMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Marca", "Toyota", "Nissan", "Chevrolet", "Hyundai", "Kia", "Volkswagen", "Ford", "Honda", "Renault", "Mazda"}));
        jcMarca.setToolTipText("");
        jcMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMarcaActionPerformed(evt);
            }
        });

        jcModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Modelo"}));

        jcAno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Año", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));

        jtColor.setEditable(false);
        jtColor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtColorMouseClicked(evt);
            }
        });

        btnRgConductor.setBackground(new java.awt.Color(162, 57, 202));
        btnRgConductor.setForeground(new java.awt.Color(255, 255, 255));
        btnRgConductor.setPreferredSize(new java.awt.Dimension(185, 40));

        btnRgCondTxt.setFont(new java.awt.Font("Roboto SemiCondensed SemiBold", 0, 22)); // NOI18N
        btnRgCondTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnRgCondTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRgCondTxt.setText("Registrar");
        btnRgCondTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRgCondTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRgCondTxtMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRgCondTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRgConductorLayout = new javax.swing.GroupLayout(btnRgConductor);
        btnRgConductor.setLayout(btnRgConductorLayout);
        btnRgConductorLayout.setHorizontalGroup(
                btnRgConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRgCondTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        btnRgConductorLayout.setVerticalGroup(
                btnRgConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRgCondTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jbIraLog.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbIraLog.setForeground(new java.awt.Color(3, 96, 190));
        jbIraLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbIraLog.setText("¿Ya tienes una cuenta? Iniciar sesión!");
        jbIraLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbIraLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbIraLogMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbIraLogMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSign2Layout = new javax.swing.GroupLayout(panelSign2);
        panelSign2.setLayout(panelSign2Layout);
        panelSign2Layout.setHorizontalGroup(
                panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSign2Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnRgConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSign2Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSign2Layout.createSequentialGroup()
                                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jpContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(65, 65, 65))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSign2Layout.createSequentialGroup()
                                                .addComponent(jbIraLog)
                                                .addGap(84, 84, 84))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSign2Layout.createSequentialGroup()
                                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSign2Layout.createSequentialGroup()
                                                                .addComponent(jcAno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jtColor))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSign2Layout.createSequentialGroup()
                                                                .addComponent(jtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jcMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelSign2Layout.createSequentialGroup()
                                                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(28, 28, 28))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSign2Layout.createSequentialGroup()
                                                .addComponent(jcModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63))))
        );
        panelSign2Layout.setVerticalGroup(
                panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSign2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addComponent(jcMarca))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(panelSign2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(btnRgConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbIraLog)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelDinamcLg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(panelSign2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelDinamcLg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSign2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRgCondTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgCondTxtMouseEntered
        btnRgConductor.setBackground(new Color(175, 86, 209));
    }//GEN-LAST:event_btnRgCondTxtMouseEntered

    private void btnRgCondTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRgCondTxtMouseExited
        btnRgConductor.setBackground(new Color(162, 57, 202));
    }//GEN-LAST:event_btnRgCondTxtMouseExited

    private void jbIraLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbIraLogMouseEntered
        panelSign2.add(jbIraLog, "align center, wrap");
        jbIraLog.setForeground(new Color(204, 255, 255));
        jbIraLog.setText("<html><u>¿Ya tienes una cuenta? Iniciar sesión!</u></html>");
    }//GEN-LAST:event_jbIraLogMouseEntered

    private void jbIraLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbIraLogMouseExited
        jbIraLog.setForeground(new Color(3, 96, 190));
        jbIraLog.setText("¿Ya tienes una cuenta? Iniciar sesión!");
    }//GEN-LAST:event_jbIraLogMouseExited

    private void jtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNumeroKeyTyped
        // Obtiene el carácter que el usuario ha ingresado o presionado.
        char c = evt.getKeyChar();
        // Verifica si el carácter ingresado NO es un dígito, tecla de retroceso o eliminar.
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            // Ignorar el carácter no numérico
            evt.consume();
        }
    }//GEN-LAST:event_jtNumeroKeyTyped

    private void jcMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMarcaActionPerformed
        String marcaSeleccionada = (String) jcMarca.getSelectedItem();
        jcModelo.removeAllItems(); // Limpiar modelos

        if (modelosPorMarca.containsKey(marcaSeleccionada)) {
            for (String modelo : modelosPorMarca.get(marcaSeleccionada)) {
                jcModelo.addItem(modelo);
            }
        } else {
            jcModelo.addItem("Seleccione una marca");
        }
    }//GEN-LAST:event_jcMarcaActionPerformed

    private void jtColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtColorMouseClicked
        Color nuevoColor = JColorChooser.showDialog(
                this,
                "Seleccionar el Color del Auto",
                colorSeleccionado
        );
        if (nuevoColor != null) {
            colorSeleccionado = nuevoColor; // guarda el nuevo color para usarlo después
            String colorHex = String.format("#%02x%02x%02x",
                    nuevoColor.getRed(),
                    nuevoColor.getGreen(),
                    nuevoColor.getBlue());

            jtColor.setText(colorHex);
            jtColor.setBackground(nuevoColor);
        }
    }//GEN-LAST:event_jtColorMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnRgCondTxt;
    private com.finalprojectp1.view.signin.swing.PanelRound btnRgConductor;
    private javax.swing.JLabel image3;
    private javax.swing.JLabel jbIraLog;
    private javax.swing.JComboBox<String> jcAno;
    private javax.swing.JComboBox<String> jcMarca;
    private javax.swing.JComboBox<String> jcModelo;
    private javax.swing.JPasswordField jpContrasena;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtColor;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPlaca;
    private com.finalprojectp1.view.signin.swing.PanelRound panelDinamcLg;
    private com.finalprojectp1.view.signin.swing.PanelRound panelSign2;
    private javax.swing.JLabel titlelg;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getJbIraLog() {
        return jbIraLog;
    }

    public javax.swing.JPasswordField getJpContrasena() {
        return jpContrasena;
    }

    public javax.swing.JTextField getJtApellido() {
        return jtApellido;
    }

    public javax.swing.JTextField getJtColor() {
        return jtColor;
    }

    public javax.swing.JTextField getJtCorreo() {
        return jtCorreo;
    }

    public javax.swing.JTextField getJtNombre() {
        return jtNombre;
    }

    public javax.swing.JTextField getJtNumero() {
        return jtNumero;
    }

    public javax.swing.JTextField getJtPlaca() {
        return jtPlaca;
    }

    public javax.swing.JComboBox<String> getJcMarca() {
        return jcMarca;
    }

    public javax.swing.JComboBox<String> getJcAno() {
        return jcAno;
    }

    public javax.swing.JComboBox<String> getJcModelo() {
        return jcModelo;
    }

}
