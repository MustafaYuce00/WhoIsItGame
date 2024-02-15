import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class GameForm extends JFrame {
    private List<String> questions;
    private JLabel[] imageLabels;
    private List<ImageIcon> images;
    private JButton[] questionButtons;
    private JLabel questionLabel;

    public GameForm() {
        setTitle("WHO IS IT - Game");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questions = new ArrayList<>();
        questions.add("Is the person wearing glasses?");
        questions.add("Is the person smiling?");
        questions.add("Is the person male?");

        Collections.shuffle(questions);

        images = new ArrayList<>();
        images.add(new ImageIcon("D:/eclipse-java/resim/resim1.png"));
        // Add other images

        // Belirli boyutta resimleri göstermek için ImageIcons oluşturun
        for (int i = 0; i < images.size(); i++) {
            Image img = images.get(i).getImage();
            Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            images.set(i, new ImageIcon(newImg));
        }

        Collections.shuffle(images);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel imagePanel = new JPanel(new GridLayout(2, 5));
        imageLabels = new JLabel[images.size()];

        for (int i = 0; i < images.size(); i++) {
            imageLabels[i] = new JLabel(images.get(i));
            imageLabels[i].setOpaque(true); // Arkaplan rengini ayarlamak için opak olmalı
            imagePanel.add(imageLabels[i]);
        }

        JPanel buttonPanel = new JPanel();
        questionButtons = new JButton[3];

        for (int i = 0; i < 3; i++) {
            questionButtons[i] = new JButton("Question " + (i + 1));
            buttonPanel.add(questionButtons[i]);

            final int index = i;
            questionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    askQuestion(index);
                }
            });
        }

        questionLabel = new JLabel();
        buttonPanel.add(questionLabel);

        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        showImages();
    }

    private void showImages() {
        for (JLabel label : imageLabels) {
            label.setVisible(true);
        }
    }

    private void hideImages() {
        for (JLabel label : imageLabels) {
            label.setVisible(false);
        }
    }

    private void askQuestion(int questionIndex) {
        String question = questions.get(questionIndex);
        questionLabel.setText("Question: " + question);
        Collections.shuffle(questions);
        checkImage(images.get(new Random().nextInt(images.size())));
    }

    private void checkImage(ImageIcon selectedImage) {
        if (selectedImage.getDescription().contains("gozluklu")) {
            for (JLabel label : imageLabels) {
                if (!((ImageIcon) label.getIcon()).getDescription().contains("gozluklu")) {
                    label.setBackground(new Color(220, 220, 220));
                }
            }
        } else {
            for (JLabel label : imageLabels) {
                label.setBackground(null);
            }
        }
    }
}
