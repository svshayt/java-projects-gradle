package com.svshayt.stream_lambda_method_ref;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Тривиальный пользовательский интерфейс на Swing
public class MyGUI extends JFrame {
    private JTextField name = new JTextField("Please enter your name");
    private JTextField response = new JTextField("Greeting");
    private JButton button = new JButton("Say Hi");

    public MyGUI() {
        // ... не относящийся к GUI код инициализации ...
        String greeting = "Hello, %s!"; // Локальная переменная
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                response.setText(
                        String.format(greeting, name.getText())); // Доступ к локальной переменной и атрибутам
            // greeting = "Anything else"; // Модификация локальной переменной (не компилируется)
            }
        });

        // Прослушиватель в виде лямбда-выражения
        //String greeting = "Hello, %s!";
        //button.addActionListener(e ->
        //response.setText(String.format(greeting,name.getText())));
    }
}
