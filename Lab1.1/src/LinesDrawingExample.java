

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LinesDrawingExample extends JFrame {

    private static final long serialVersionUID = 3775690273871048733L;

    private DrawingPanel drawingPanel;

    public LinesDrawingExample() {
        super("Lines Drawing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Octagon Octagon = new Octagon(new Point(300, 300), 150);

        drawingPanel = new DrawingPanel(Octagon);
        add(drawingPanel);

        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinesDrawingExample();
            }
        });
    }

    public class DrawingPanel extends JPanel {
        private static final long serialVersionUID = 5701311351092275287L;

        private Octagon Octagon;

        public DrawingPanel(Octagon Octagon) {
            this.Octagon = Octagon;
            this.setPreferredSize(new Dimension(600, 600));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.drawPolygon(Octagon.getOctagon());
        }
    }

    public class Octagon {
        private final int radius;

        private final Point center;

        private final Polygon Octagon;

        public Octagon(Point center, int radius) {
            this.center = center;
            this.radius = radius;
            this.Octagon = createOctagon();
        }

        private Polygon createOctagon() {
            Polygon polygon = new Polygon();

            for (int i = 0; i < 8; i++) {
                int xval = (int) (center.x + radius
                        * Math.cos(i * 2 * Math.PI / 8D));
                int yval = (int) (center.y + radius
                        * Math.sin(i * 2 * Math.PI / 8D));
                polygon.addPoint(xval, yval);
            }

            return polygon;
        }

        public int getRadius() {
            return radius;
        }

        public Point getCenter() {
            return center;
        }

        public Polygon getOctagon() {
            return Octagon;
        }

    }
}
