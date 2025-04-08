import java.util.List;

import javax.swing.JFrame;

public class FenêtreFigures extends JFrame {

    private static final long serialVersionUID = 152948767613356624L;

    public FenêtreFigures(List<FigureFermée> figures) {
        this.setTitle("essais de tracés");
        this.setContentPane(new PanneauFigures(figures));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 500);
    }
}
