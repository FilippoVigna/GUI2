package com.phil.GUI1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Screen extends JFrame{
    private JPanel TopPanel;
    private JPanel RightPanel;
    private JPanel LeftPanel;
    private JList listPeople;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textNumber;
    private JTextField textAddress;
    private JLabel LabelAge;
    private JTextField textBirth;
    private JLabel Birth;
    private JPanel Maine;
    private ArrayList<Person> people;
    private DefaultListModel listPeopleModel;

    Screen(){
        super("My fancy contacts projects");
        this.setContentPane(this.Maine);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        people = new ArrayList<Person>();
        listPeopleModel = new DefaultListModel();
        listPeople.setModel(listPeopleModel);
        buttonSave.setEnabled(false);

        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p = new Person(
                        textName.getText(),
                        textEmail.getText(),
                        textNumber.getText(),
                        textBirth.getText());
                people.add(p);
                refreshPeopleList();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  int personNumber = listPeople.getSelectedIndex();
                if (personNumber >= 0);
                Person p = people.get(personNumber);
                p.setName(textName.getText());
                p.setEmail(textEmail.getText());
                p.setPhonenumber(textNumber.getText());
                p.setDateofbirth(textBirth.getText());
                refreshPeopleList();


            }
        });
        listPeople.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int personNumber = listPeople.getSelectedIndex();
                if (personNumber >= 0) {
                    Person p = people.get(personNumber);
                textName.setText(p.getName());
                textEmail.setText(p.getEmail());
                textNumber.setText(p.getPhonenumber());
                textBirth.setText(p.getDateofbirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                LabelAge.setText( Integer.toString(p.getAge()) +" years");
                buttonSave.setEnabled(true);
                } else
                    buttonSave.setEnabled(false);
            }
        });



    }
    public void refreshPeopleList() {
        listPeopleModel.removeAllElements();
        System.out.println("Removing people");
        for (Person p : people) {
            System.out.println("Adding person to list" + p.getName());
            listPeopleModel.addElement(p.getName());
        }
    }
    public void addPerson (Person p) {
        people.add(p);
        refreshPeopleList();
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);

        Person sheldon = new Person("Sheldon Lee Cooper", "sheldon@gmail.com", "555 0001", "26/02/1980");
        Person howard = new Person("Howard Joel Wolowitz", "howard@gmail.com", "555 0002", "01/03/1981");
        Person bernadette = new Person("Bernadette Rostenkowski-Wolowitz", "bernadette@gmail.com", "555 0002",
                "01/01/1984");
        Person raj = new Person("Rajesh Ramayan Koothrappali", "raj@gmail.com", "555 0003", "06/10/1981");
        Person penny = new Person("Penny Hofstadter", "penny@gmail.com", "555 0004", "02/12/1985");
        Person leonard = new Person("Leonard Hofstadter", "leonard@gmail.com", "555 0004", "17/05/1980");
        Person amy = new Person("Amy Farrah Fowler", "amy@gmail.com", "555 0005", "17/12/1979");

        screen.addPerson(sheldon);
        screen.addPerson(howard);
        screen.addPerson(bernadette);
        screen.addPerson(raj);
        screen.addPerson(penny);
        screen.addPerson(leonard);
        screen.addPerson(amy);
    }
}
