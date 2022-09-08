package ru.vulfert.homework.task.window;

import ru.vulfert.homework.task.service.ReplaceService;
import ru.vulfert.homework.task.service.impl.ReplaceServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private final ReplaceService service = new ReplaceServiceImpl();
    private final JTextArea inputText = new JTextArea(4, 50);
    private final JTextArea inputWordForSearch = new JTextArea(4, 50);
    private final JTextArea inputWordForReplace = new JTextArea(4, 50);

    public Window() {
        super("Replace text");
        this.setBounds(400, 400, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputText.setLineWrap(true);
        inputWordForSearch.setLineWrap(true);
        inputWordForReplace.setLineWrap(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 1, 2, 2));
        JLabel labelInputText = new JLabel("Input text: ");
        container.add(labelInputText);
        container.add(inputText);
        JLabel labelInputWordForSearch = new JLabel("Input word for search: ");
        container.add(labelInputWordForSearch);
        container.add(inputWordForSearch);
        JLabel labelInputWordForReplace = new JLabel("Input word for replace: ");
        container.add(labelInputWordForReplace);
        container.add(inputWordForReplace);
        JButton buttonReplace = new JButton("Replace");
        buttonReplace.addActionListener(new ButtonEventListenerForReplace());
        container.add(buttonReplace);
    }

    class ButtonEventListenerForReplace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String stringBuilder = inputText.getText() + "\n" +
                    "Word for search: " + "\n" + inputWordForSearch.getText() + "\n" +
                    "Word for replace: " + "\n" + inputWordForReplace.getText() + "\n" +
                    "Result after replace: " +
                    "\n" +
                    service.replace(inputText.getText(), inputWordForSearch.getText(), inputWordForReplace.getText());
            JOptionPane.showMessageDialog(null, stringBuilder, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
