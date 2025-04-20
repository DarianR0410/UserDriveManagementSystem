// Este codigo es un recurso externo tomado del canal de youtube RA VEN
// Se utiliza para agregar un JPanel personalizado a tu código con esquinas redondeadas
package com.finalprojectp1.view.signin.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author RAVEN
 */
// Clase personalizada que extiende JPanel para permitir bordes redondeados
// independientes por cada esquina (superior/izquierda, superior/derecha, etc.).
public class PanelRound extends JPanel {

    // Esquina superior izquierda
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint(); // Redibuja el panel con el nuevo redondeado
    }

    // Esquina superior derecha
    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    // Esquina inferior izquierda
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    // Esquina inferior derecha
    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    // Valores de redondez para cada esquina, inicializados en 0 (sin redondeo)
    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    // Constructor: se desactiva la opacidad para poder pintar con transparencia o formas personalizadas
    public PanelRound() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        // Convierte el objeto Graphics a Graphics2D para usar formas avanzadas
        Graphics2D g2 = (Graphics2D) grphcs.create();
        // Activa el suavizado de bordes (antialiasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Establece el color de fondo (que se usa para pintar la figura)
        g2.setColor(getBackground());
        // Crea el área inicial usando la forma correspondiente a la esquina superior izquierda
        Area area = new Area(createRoundTopLeft());
        // Interseca con las otras esquinas si su valor es mayor a 0
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        // Pinta la forma final sobre el panel
        g2.fill(area);
        g2.dispose(); // Libera recursos del gráfico
        // Llama a la implementación original de JPanel (por si hay otros componentes hijos)
        super.paintComponent(grphcs);
    }

    // Crea forma redondeada para esquina superior izquierda
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        // Calcula radio máximo posible sin salir del panel
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        // Crea área con esquina superior izquierda redondeada
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        // Ajustes para mantener las otras esquinas cuadradas
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    // Crea forma redondeada para esquina superior derecha
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    // Crea forma redondeada para esquina inferior izquierda
    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    // Crea forma redondeada para esquina inferior derecha
    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
