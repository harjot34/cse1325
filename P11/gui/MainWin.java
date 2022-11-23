//credit given to Professor George Rice - https://github.com/prof-rice/cse1325-prof/blob/main/12/code_from_slides/nim/MainWin.java
package gui;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
// import javax.imageio.ImageIO;

// import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.BorderLayout;
import java.awt.Font;

import java.io.File;
// import java.io.IOException;

// import product.Item;
import product.Container;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Order;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;
import product.Serving;
import person.Customer;
import emporium.Emporium;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;

public class MainWin extends JFrame {

    private final String NAME = "MICE";
    private final String EXTENSION = "mice";
    private final String VERSION = "0.3";
    private final String FILE_VERSION = "1.0";
    private final String MAGIC_COOKIE = "Mice";

    public MainWin() {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1124, 600);

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu view = new JMenu("View");
        JMenuItem viewCustomers = new JMenuItem("Customers");
        JMenuItem viewICF = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMIF = new JMenuItem("Mix In Flavor");
        JMenuItem viewContainer = new JMenuItem("Containers");
        JMenuItem viewOrders = new JMenuItem("Orders");

        JMenu create = new JMenu("Create");
        JMenuItem createCustomer = new JMenuItem("Customer");
        JMenuItem createICF = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMIF = new JMenuItem("Mix In Flavor");
        JMenuItem createCon = new JMenuItem("Container");
        JMenuItem createOrder = new JMenuItem("Order");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        open.addActionListener(event -> onOpenClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        quit.addActionListener(event -> onQuitClick());

        viewCustomers.addActionListener(event -> view(Screen.CUSTOMER));
        viewICF.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMIF.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewContainer.addActionListener(event -> view(Screen.CONTAINERS));
        viewOrders.addActionListener(event -> view(Screen.ORDERS));

        createCustomer.addActionListener(event -> onCreateCustomerClick());
        createCon.addActionListener(event -> onCreateContainerClick());
        createICF.addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF.addActionListener(event -> onCreateMixInFlavorClick());
        createOrder.addActionListener(event -> onCreateOrderClick());

        about.addActionListener(event -> onAboutClick());

        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);

        view.add(viewCustomers);
        view.add(viewICF);
        view.add(viewMIF);
        view.add(viewContainer);
        view.add(viewOrders);

        create.add(createCustomer);
        create.add(createICF);
        create.add(createMIF);
        create.add(createCon);
        create.add(createOrder);

        help.add(about);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Mice Controls");

        // Add a New Emporium icon
        saveButton = new JButton(new ImageIcon("gui/save.png"));
        saveButton.setActionCommand("Save data to default file");
        saveButton.setToolTipText("Save data to default file");
        saveButton.addActionListener(event -> onSaveClick());
        toolbar.add(saveButton);

        saveAsButton = new JButton(new ImageIcon("gui/save_as.png"));
        saveAsButton.setActionCommand("Save data to selected file");
        saveAsButton.setToolTipText("Save data to selected file");
        saveAsButton.addActionListener(event -> onSaveAsClick());
        toolbar.add(saveAsButton);

        JButton openButton = new JButton(new ImageIcon("gui/open.png"));
        openButton.setActionCommand("Load data from selected file");
        openButton.setToolTipText("Load data from selected file");
        openButton.addActionListener(event -> onOpenClick());
        toolbar.add(openButton);

        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));

        // Create the product buttons using the icons provided

        JButton createCustomerButton = new JButton(new ImageIcon("gui/createCustomer.png"));
        createCustomerButton.setActionCommand("Create Customer");
        createCustomerButton.setToolTipText("Create Customer");
        toolbar.add(createCustomerButton);
        createCustomerButton.addActionListener(event -> onCreateCustomerClick());

        JButton createIceCreamFlavorButton = new JButton(new ImageIcon("gui/createIceCreamFlavorButton.png"));
        createIceCreamFlavorButton.setActionCommand("Create New Ice Cream Flavor");
        createIceCreamFlavorButton.setToolTipText("Create New Ice Cream Flavor");
        toolbar.add(createIceCreamFlavorButton);
        createIceCreamFlavorButton.addActionListener(event -> onCreateIceCreamFlavorClick());

        JButton createMixInFlavorButton = new JButton(new ImageIcon("gui/createMixInFlavorButton.png"));
        createMixInFlavorButton.setActionCommand("Create New MixIn Flavor");
        createMixInFlavorButton.setToolTipText("Create New MixIn Flavor");
        toolbar.add(createMixInFlavorButton);
        createMixInFlavorButton.addActionListener(event -> onCreateMixInFlavorClick());

        JButton createContainerButton = new JButton(new ImageIcon("gui/createContainerButton.png"));
        createContainerButton.setActionCommand("Create New Container");
        createContainerButton.setToolTipText("Create New Container");
        toolbar.add(createContainerButton);
        createContainerButton.addActionListener(event -> onCreateContainerClick());

        JButton createOrderButton = new JButton(new ImageIcon("gui/createScoopButton.png"));
        createOrderButton.setActionCommand("Create New Order");
        createOrderButton.setToolTipText("Create New Order");
        toolbar.add(createOrderButton);
        createOrderButton.addActionListener(event -> onCreateOrderClick());

        toolbar.add(Box.createHorizontalStrut(25));

        JButton viewCustomerButton = new JButton(new ImageIcon("gui/customer.png"));
        viewCustomerButton.setActionCommand("View Customer");
        viewCustomerButton.setToolTipText("View Customer");
        toolbar.add(viewCustomerButton);
        viewCustomerButton.addActionListener(event -> view(Screen.CUSTOMER));

        JButton viewIceCreamFlavorsButton = new JButton(new ImageIcon("gui/viewIceCreamFlavorsButton.png"));
        viewIceCreamFlavorsButton.setActionCommand("View Ice Cream Flavors");
        viewIceCreamFlavorsButton.setToolTipText("View Ice Cream Flavors");
        toolbar.add(viewIceCreamFlavorsButton);
        viewIceCreamFlavorsButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));

        JButton viewMixInFlavorsButton = new JButton(new ImageIcon("gui/viewMixInFlavorsButton.png"));
        viewMixInFlavorsButton.setActionCommand("View MixIn Flavors");
        viewMixInFlavorsButton.setToolTipText("View MixIn Flavors");
        toolbar.add(viewMixInFlavorsButton);
        viewMixInFlavorsButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        JButton viewContainerButton = new JButton(new ImageIcon("gui/viewContainerButton.png"));
        viewContainerButton.setActionCommand("View Container");
        viewContainerButton.setToolTipText("View Container");
        toolbar.add(viewContainerButton);
        viewContainerButton.addActionListener(event -> view(Screen.CONTAINERS));

        JButton viewOrdersButton = new JButton(new ImageIcon("gui/viewScoopsButton.png"));
        viewOrdersButton.setActionCommand("View Orders");
        viewOrdersButton.setToolTipText("View Orders");
        toolbar.add(viewOrdersButton);
        viewOrdersButton.addActionListener(event -> view(Screen.ORDERS));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        // /////////////////////////// ////////////////////////////////////////////
        // M A I N D I S P L A Y
        // Provide a text entry box to show data
        display = new JLabel();
        display.setVerticalAlignment(JLabel.TOP);
        display.setFont(new Font("Courier New", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        // S T A T U S B A R D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        // msg = new JLabel();
        // add(msg, BorderLayout.PAGE_END);

        // Make everything in the JFrame visible
        setVisible(true);

        // Start a new emporium
        emporium = new Emporium();
        filename = new File("untitled." + EXTENSION);
        setDirty(false); // disables Save when no new data exists
        // setScoopAvailable(); // disables new Scoop when no ice cream flavors exist
        view(Screen.ICE_CREAM_FLAVORS);
    }

    // Listeners
    protected void onQuitClick() {
        System.exit(0);
    } // Exit the game

    protected void onCreateCustomerClick() {
        try {
            Customer customer = new Customer(
                    JOptionPane.showInputDialog(this, "Name?", "New Customer",
                            JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(this, "Phone?", "Add Phone",
                            JOptionPane.QUESTION_MESSAGE));

            // if (!(emporium.getFavoriteServings(customer) == null) &&
            // if (!(emporium.getFavoriteServings(customer) == null)) {
            // Serving servin = (Serving) JOptionPane.showInputDialog(this, "Container?",
            // "Select favorite servings?",
            // JOptionPane.QUESTION_MESSAGE, null, emporium.getFavoriteServings(customer),
            // null);
            // }

            Order order = new Order();
            Serving serving = onCreateServingClick();
            order.addServing(serving);
            order.addCustomer(customer);
            emporium.addOrder(order);
            Serving servArray[] = new Serving[1];
            servArray[0] = serving;
            emporium.addFavoriteServings(customer, servArray);
            setDirty(true);
            view(Screen.ORDERS);

        } catch (Exception e) {
            System.err.println("onCreateOrder()" + e);
        }
    }

    protected void onCreateIceCreamFlavorClick() {
        try {
            emporium.addIceCreamFlavor(new IceCreamFlavor(
                    JOptionPane.showInputDialog(this, "Name?", "Create Ice Cream Flavor",
                            JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(this, "Description?", "Create Ice Cream Flavor",
                            JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Ice Cream Flavor",
                            JOptionPane.QUESTION_MESSAGE)),
                    Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Ice Cream Flavor",
                            JOptionPane.QUESTION_MESSAGE))));
        } catch (Exception e) {
        }
        try {
            setDirty(true);
            view(Screen.ICE_CREAM_FLAVORS);
        } catch (Exception e) {
            System.err.println("onCreateIceCreamFlavorClick exception: " + e);
        }
    }

    protected void onCreateMixInFlavorClick() {
        try {
            emporium.addMixInFlavor(new MixInFlavor(
                    JOptionPane.showInputDialog(this, "Name?", "Create Mix In Flavor",
                            JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(this, "Description?", "Create Mix In Flavor",
                            JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Mix In Flavor",
                            JOptionPane.QUESTION_MESSAGE)),
                    Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Mix In Flavor",
                            JOptionPane.QUESTION_MESSAGE))));
            setDirty(true);
            view(Screen.MIX_IN_FLAVORS);
        } catch (Exception e) {
            System.err.println("onCreateMixInFlavorClick exception: " + e);
        }
    }

    protected void onCreateOrderClick() {
        try {
            Customer cust = null;
            ArrayList<Order> ordlst = new ArrayList(Arrays.asList(emporium.orders()));
            if (ordlst != null && !ordlst.isEmpty()) {
                int sz = ordlst.size();
                cust = ordlst.get(sz - 1).getCustomer();
            } else {
                cust = new Customer("", "");
            }
            Order order = new Order();
            Serving serving = onCreateServingClick();
            order.addServing(serving);
            order.addCustomer(cust);
            emporium.addOrder(order);
            Serving servArray[] = new Serving[1];
            servArray[0] = serving;
            emporium.addFavoriteServings(cust, servArray);
            setDirty(true);
            view(Screen.ORDERS);
        } catch (Exception e) {
            System.err.println("onCreateOrder()" + e);
        }
    }

    protected Serving onCreateServingClick() {
        Serving serving = null;
        try {
            Container container = (Container) JOptionPane.showInputDialog(this, "Container?", "New Order",
                    JOptionPane.QUESTION_MESSAGE, null, emporium.containers(), null);
            if (container != null) {
                serving = new Serving(container);
                if (container != null) {
                    int maxScoop = container.maxScoops();
                    while (maxScoop-- > 0) {
                        Scoop scoop = onCreateScoop();
                        serving.addScoop(scoop);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("onCreateScoop exception: " + e);
        }
        return serving;
    }

    protected void onCreateContainerClick() {
        try {
            emporium.addContainer(new Container(
                    JOptionPane.showInputDialog(this, "Name?", "Create Name of Container",
                            JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(this, "Description?", "Create Description of Container",
                            JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(this, "maxScoops?", "Create MaxScoops of Container",
                            JOptionPane.QUESTION_MESSAGE))));
            setDirty(true);
            view(Screen.CONTAINERS);
        } catch (Exception e) {
            System.err.println("onCreateContainerClick exception: " + e);
        }
    }

    protected Scoop onCreateScoop() {
        Scoop scoop = null;
        try {
            IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, "Ice Cream Flavor?", "New Scoop",
                    JOptionPane.QUESTION_MESSAGE, null, emporium.iceCreamFlavors(), null);
            if (icf != null) {
                scoop = new Scoop(icf);
                if (emporium.mixInFlavors().length > 0) {
                    String prompt = "<html>Add a mix in?</html>";
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt,
                            "Add Mix In",
                            JOptionPane.QUESTION_MESSAGE, null, emporium.mixInFlavors(), null);
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt,
                            "Add Mix In Amount",
                            JOptionPane.QUESTION_MESSAGE, null, MixInAmount.values(),
                            MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                }
            }
        } catch (Exception e) {
            System.err.println("onCreateScoop exception: " + e);
        }

        return scoop;
    }

    // File I/O Methods

    protected void onOpenClick() {
        final JFileChooser fc = new JFileChooser(filename); // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles); // Add "Mice file" filter
        fc.setFileFilter(miceFiles); // Show Mice files only by default

        int result = fc.showOpenDialog(this); // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile(); // Obtain the selected File object

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if (!magicCookie.equals(MAGIC_COOKIE))
                    throw new RuntimeException("Not a MICE file");
                String fileVersion = br.readLine();
                if (!fileVersion.equals(FILE_VERSION))
                    throw new RuntimeException("Incompatible MICE file format");

                // emporium = new Emporium(br); // Open a new emporium
                // view(Screen.SCOOPS); // Update the user interface
                // setScoopAvailable();
                setDirty(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unable to load " + filename + '\n' + e,
                        "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            // emporium.save(bw);
            setDirty(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to write " + filename + '\n' + e,
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename); // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles); // Add "MICE file" filter
        fc.setFileFilter(miceFiles); // Show MICE files only by default

        int result = fc.showSaveDialog(this); // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile(); // Obtain the selected File object
            if (!filename.getAbsolutePath().endsWith("." + EXTENSION)) // Ensure it ends with ".mice"
                filename = new File(filename.getAbsolutePath() + "." + EXTENSION);
            onSaveClick(); // Delegate to Save method
        }
    }

    // About and miscellaneous

    protected void onAboutClick() { // Display About dialog
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        /*
         * try {
         * BufferedImage myPicture = ImageIO.read(new File("gui/logo.png"));
         * JLabel logo = new JLabel(new ImageIcon(myPicture));
         * about.add(logo);
         * } catch(IOException e) {
         * }
         */
        Canvas logo = new Canvas("gui/logo.png", "gui/spiropic.txt");
        logo.setAlignmentX(Canvas.LEFT_ALIGNMENT);
        about.add(logo);

        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("<html>"
                + "<br/><p><font size=+4>" + NAME + "</font></p>"
                + "</html>", JLabel.CENTER);
        text.add(title);

        JLabel subTitle = new JLabel("<html>"
                + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
                + "</html>", JLabel.CENTER);
        text.add(subTitle);

        JLabel artists = new JLabel("<html>"
                + "<br/><p> Version " + VERSION + "</p>"
                + "<p>Copyright 2022 by Harjot Virk </p>"
                + "<p>Licensed under Gnu GPL 3.0</p>"
                + "Logo by Schmidsi, per the Pixabay License"
                + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
                + "<p>Ice cream icons created by Freepik - Flaticon</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
                + "<p>File icons created by Pixel perfect - Flaticon</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icons/direct-download</font></p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icons/file-upload</font></p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icons/ui</font></p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
                + "<br/></html>", JLabel.CENTER);
        text.add(artists);
        about.add(text);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);

        about.add(Box.createVerticalStrut(10));

        about.pack();
        about.setVisible(true);
    }

    // private enum Screen {
    // ICE_CREAM_FLAVORS, MIX_IN_FLAVORS
    // }

    private void view(Screen screen) {
        String title = "";
        StringBuilder s = new StringBuilder();
        switch (screen) {
            case ICE_CREAM_FLAVORS:
                title = "Ice Cream Flavors";
                for (var t : emporium.iceCreamFlavors())
                    s.append(t.toString() + "<br/>");
                break;
            case MIX_IN_FLAVORS:
                title = "Mix In Flavors";
                for (var t : emporium.mixInFlavors())
                    s.append(t.toString() + "<br/>");
                break;
            case CONTAINERS:
                title = "Containers";
                for (var t : emporium.containers())
                    s.append(t.toString() + "<br/>");
                break;
            case ORDERS:
                title = "Orders";
                int i = 1;
                for (var t : emporium.orders()) {
                    Order ord = (Order) t;
                    s.append("Order " + i + " $ " + ord.getPrice() + " For " + ord.getCustomer().getName() + " <br/>");
                    s.append(ord.toString() + "<br/>");
                    i++;
                }
                break;
            case CUSTOMER:
                title = "Customers";
                for (var t : emporium.customers())
                    s.append(t.toString() + "<br/>");
                break;
            default:
                display.setText("PANIC: Invalid Displays type: " + display);
        }
        display.setText(
                "<html><font size=+4>" + title + "<br/></font><font size=+2>" + s.toString()
                        + "</font></html>");
    }

    private void setDirty(boolean isDirty) {
        save.setEnabled(isDirty);
        saveAs.setEnabled(isDirty);
        saveButton.setEnabled(isDirty);
        saveAsButton.setEnabled(isDirty);
    };

    private void setScoopAvailable() {
        boolean scoopIsAvailable = (emporium.iceCreamFlavors().length > 0);
        // createScoop.setEnabled(scoopIsAvailable); // until an ice cream flavor is
        // createScoopButton.setEnabled(scoopIsAvailable);
    }

    private Emporium emporium;
    private File filename;
    private JLabel display; // Main data display

    private JMenuItem save;
    private JMenuItem saveAs;
    private JButton saveButton;
    private JButton saveAsButton;

    // private JLabel msg; // Status message display
}