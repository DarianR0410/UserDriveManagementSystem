// Este codigo es un recurso externo tomado del canal de youtube RA VEN
// Se utiliza para agregar un Toggle Button personalizado a tu codigo 
package com.finalprojectp1.view.signin.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.Interpolator;

/**
 *
 * @author RAVEN
 */
//Toggle personalizado con animación y eventos.
public class SwitchButton extends javax.swing.JPanel {

    // Métodos getter y setter para el color del switch cuando está apagado
    public Color getSwitchOffColor() {
        return switchOffColor;
    }

    public void setSwitchOffColor(Color switchOffColor) {
        this.switchOffColor = switchOffColor;
        repaint(); // Redibuja el componente
    }

    // Métodos getter y setter para el color del switch cuando está encendido
    public Color getSwitchColor() {
        return switchColor;
    }

    public void setSwitchColor(Color switchColor) {
        this.switchColor = switchColor;
        repaint();
    }

    // Métodos para el color cuando el componente está deshabilitado
    public Color getDisableColor() {
        return disableColor;
    }

    public void setDisableColor(Color disableColor) {
        this.disableColor = disableColor;
        repaint();
    }

    // Obtiene y establece el tamaño del borde del botón
    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        repaint();
    }

    // Espacio entre el borde y el switch
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
        repaint();
    }

    // Nivel de redondeado del borde y switch
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    // Estado actual del interruptor (encendido o apagado)
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
        runEvent(); // Ejecuta eventos asociados al cambio
        if (on) {
            animate = 0;
        } else {
            animate = 1;
        }
        repaint();
    }

    // Cambia el estado con opción de animación
    public void setOn(boolean on, boolean animate) {
        if (animate) {
            start(on); // Inicia animación
        } else {
            setOn(on); // Cambia directamente
        }
    }

    // Agrega un listener para detectar cuando cambia el estado del switch
    public void addEventSwitchSelected(SwitchListener event) {
        events.add(event);
    }

    // Variables internas de configuración y estado
    private Color switchColor = new Color(22, 160, 255);
    private Color switchOffColor = new Color(190, 190, 190);
    private Color disableColor = new Color(190, 190, 190);
    private int borderSize = 2;
    private int space = 2;
    private int round = 5;
    private boolean on = true;
    private Animator animator;
    private float animate;
    private boolean mouseHover;
    private final List<SwitchListener> events = new ArrayList<>();

    // Constructor del botón
    public SwitchButton() {
        initComponents(); // Inicializa los componentes de la interfaz
        init(); // Inicializa propiedades y eventos
    }

    // Configuración inicial del componente
    private void init() {
        setOpaque(false);
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(220, 220, 220));
        initAnimator(); // Configura animación
        initMouseEvent(); // Agrega eventos de mouse
    }

    // Configura los eventos del mouse
    private void initMouseEvent() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseHover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseHover = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled() && SwingUtilities.isLeftMouseButton(e)) {
                    if (mouseHover) {
                        setOn(!on, true); // Cambia el estado al hacer clic
                        runEvent(); // Ejecuta listeners
                    }
                }
            }

        };
        addMouseListener(mouseAdapter); // Agrega el adaptador de mouse
    }

    // Configura la animación del switch
    private void initAnimator() {
        animator = new Animator(1000, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (!on) {
                    animate = fraction;
                } else {
                    animate = 1f - fraction;
                }
                repaint();
            }
        });
        animator.setResolution(0);
        animator.setInterpolator(new Interpolator() {
            @Override
            public float interpolate(float f) {
                return easeOutBounce(f); // Aplica efecto de rebote
            }
        });
    }

    // Función para crear el efecto de rebote en la animación
    private float easeOutBounce(float x) {
        double n1 = 7.5625;
        double d1 = 2.75;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        return (float) v;
    }

    // Ejecuta los eventos registrados cuando cambia el estado del switch
    private void runEvent() {
        for (SwitchListener event : events) {
            event.selectChange(on);
        }
    }

    // Inicia la animación para cambiar el estado
    private void start(boolean isOn) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            float t = 1f - f;
            if (t > 1) {
                t = 1;
            } else if (t < 0) {
                t = 0;
            }
            animator.setStartFraction(t);
        } else {
            animator.setStartFraction(0f);
        }
        on = isOn;
        animator.start(); // Comienza animación

    }

    // Método para pintar el componente (bordes y switch)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        //  Create Border
        createBorder(g2, width, height);
        //  Create switch
        createSwitch(g2, width, height);
        g2.dispose();
    }

    // Dibuja el borde del botón
    private void createBorder(Graphics2D g2, int width, int height) {
        int r = round == 999 ? height : round;
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, r, r));
        r = round == 999 ? height - borderSize * 2 : round;
        area.subtract(new Area(new RoundRectangle2D.Double(borderSize, borderSize, width - borderSize * 2, height - borderSize * 2, r, r)));
        g2.setColor(isEnabled() ? EvaluatorColor.evaluate(switchColor, switchOffColor, animate) : disableColor);
        g2.fill(area);
        // Efecto visual tipo pastel para indicar posición
        double size = Math.max(width, height);
        size += size * 0.5f;
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        area.intersect(new Area(new Arc2D.Double(x, y, size, size, -90, (1f - animate) * 360, Arc2D.PIE)));
        g2.fill(area);
    }

    // Dibuja el switch que se mueve
    private void createSwitch(Graphics2D g2, int width, int height) {
        int size = width / 2;
        int spaceSize = borderSize + space;
        int r = round == 999 ? height - spaceSize * 2 : round;
        Area area = new Area(new RoundRectangle2D.Double(spaceSize + size * animate, spaceSize, size - spaceSize * 2, height - spaceSize * 2, r, r));
        area.intersect(new Area(new RoundRectangle2D.Double(borderSize, borderSize, width - borderSize * 2, height - borderSize * 2, r, r)));
        g2.setColor(isEnabled() ? EvaluatorColor.evaluate(switchColor, switchOffColor, animate) : disableColor);
        g2.fill(area);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbOn = new javax.swing.JLabel();
        lbOff = new javax.swing.JLabel();

        lbOn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOn.setText("Pasajero");

        lbOff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOff.setText("Conductor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lbOn, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbOff, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbOff, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(lbOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Sobrescribe el color de los labels al cambiar el color del componente
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (lbOn != null) {
            lbOn.setForeground(fg);
            lbOff.setForeground(fg);
        }
    }

    // Sobrescribe la fuente de los labels
    @Override
    public void setFont(Font font) {
        super.setFont(font);
        if (lbOn != null) {
            lbOn.setFont(font);
            lbOff.setFont(font);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbOff;
    private javax.swing.JLabel lbOn;
    // End of variables declaration//GEN-END:variables
}
