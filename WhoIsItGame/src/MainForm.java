import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton startButton;

    public MainForm() {
        setTitle("WHO IS IT Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        startButton = new JButton("Start Game");
        panel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        add(panel);
    }

    private void startGame() {
        // Oyun başladığında ikinci formu oluşturun ve görünür yapın
        GameForm gameForm = new GameForm();
        gameForm.setVisible(true);

        // Şu anki formu gizle
        setVisible(false);
    }
}
