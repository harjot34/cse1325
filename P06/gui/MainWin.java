import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

//credit given to Professor Rice - https://github.com/prof-rice/cse1325-prof/blob/main/12/code_from_slides/nim/MainWin.java
public class MainWin extends JFrame implements ActionListener {

    // private Emporium emporium;
    private JLabel display;

    private JLabel sticks; // Display of sticks on game board
    private JLabel msg; // Status message display
    private JButton button1; // Button to select 1 stick
    private JButton button2; // Button to select 2 sticks
    private JButton button3; // Button to select 3 sticks
    private JToggleButton computerPlayer; // Button to enable robot

    public MainWin() {

        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        // // /////// ////////////////////////////////////////////////////////////////
        // // M E N U
        // // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        file.add(quit);
        menubar.add(file);

        JMenu view = new JMenu("View");
        JMenuItem iceFlv = new JMenuItem("Ice Cream Flavor");
        JMenuItem mixFlv = new JMenuItem("Mix In Flavor");
        JMenuItem scoop = new JMenuItem("Scoop");
        view.add(iceFlv);
        view.add(mixFlv);
        view.add(scoop);
        menubar.add(view);

        JMenu create = new JMenu("Create");
        JMenuItem createIceFlv = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixFlv = new JMenuItem("Mix In Flavor");
        JMenuItem createScoop = new JMenuItem("Scoop");
        create.add(createIceFlv);
        create.add(createMixFlv);
        create.add(createScoop);
        menubar.add(create);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        menubar.add(help);

        setJMenuBar(menubar);

        about.addActionListener(event -> onAboutClick());
        quit.addActionListener(event -> onQuitClick());
        iceFlv.addActionListener(event -> onCreateIceCreamFlavorClick());
        mixFlv.addActionListener(event -> onCreateMixinFlavorClick());
        scoop.addActionListener(event -> onCreateScoopClick());

    }

    public void onQuitClick() {
        System.exit(0);
    }

    public void onCreateIceCreamFlavorClick() {

        String name = JOptionPane.showInputDialog("Name?");
        String description = JOptionPane.showInputDialog("Description?");
        String price = JOptionPane.showInputDialog("Price?");
        String cost = JOptionPane.showInputDialog("Cost?");

    }

    public void onCreateMixinFlavorClick() {

        String name = JOptionPane.showInputDialog("Name?");
        String description = JOptionPane.showInputDialog("Description?");
        String price = JOptionPane.showInputDialog("Price?");
        String cost = JOptionPane.showInputDialog("Cost?");

    }

    public void onCreateScoopClick() {

        String name = JOptionPane.showInputDialog("Name?");
        String description = JOptionPane.showInputDialog("Description?");
        String price = JOptionPane.showInputDialog("Price?");
        String cost = JOptionPane.showInputDialog("Cost?");
    }

    public static void main(String[] args) {
        MainWin myApp = new MainWin();
        myApp.setVisible(true);
    }

    public void onAboutClick() {
        Dialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporium");

        // image credit from anitafiana at freepik,
        // https://www.freepik.com/premium-vector/ice-cream-logo-design-illustration_10395024.htm#query=ice%20cream%20cone%20logo&position=25&from_view=keyword
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui\\icee.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch (IOException e) {
        }

        JLabel title = new JLabel("");
        about.add(title);

        JLabel artists = new JLabel(
                "<html>"
                        + "<p>Mavs Ice Cream Emporium</p>"
                        + "<p>Version 0.2</p>"
                        + "<p>Copyright 2022 by Harjot Kaur Virk</p>"
                        + "<p>Licensed under Gnu GPL 3.0</p>"
                        + "<p>Logo by Anitafiana, licensed under CC BY-SA 3.0</p>"
                        + "<p>https://www.freepik.com/premium-vector/ice-cream-logo-design-illustration_10395024.htm#query=ice%20cream%20cone%20logo&position=25&from_view=keyword</p>"
                        + "<p>Robot by FreePik.com, licensed for personal</p>"
                        + "<p>and commercial purposes with attribution</p>"
                        + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);

        about.setSize(1200, 600);
        about.setVisible(true);

    }

    private void view(Screen screen) {

    }

}
