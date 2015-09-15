import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp implements ActionListener, ItemListener {

    public String type; //Is it Length, Liquid Volume, Mass or Temperature conversion?
    public String length_convert_from, length_convert_to, liquidvolume_convert_from, liquidvolume_convert_to, mass_convert_from, mass_convert_to, temperature_convert_from, temperature_convert_to;
    public String inputvalue; //Store the value typed into the input text field
    TextField length_inputtextfield, liquidvolume_inputtextfield, mass_inputtextfield, temperature_inputtextfield;
    TextField length_displayoutput, liquidvolume_displayoutput, mass_displayoutput, temperature_displayoutput;
    TextField length_displayinput, liquidvolume_displayinput, mass_displayinput, temperature_displayinput;
    JButton length_convertbutton, liquidvolume_convertbutton, mass_convertbutton, temperature_convertbutton;
    JComboBox length_fromlist, liquidvolume_fromlist, mass_fromlist, temperature_fromlist;
    JComboBox length_tolist, liquidvolume_tolist, mass_tolist, temperature_tolist;

    //CREATING THE WINDOW//
    public MainApp() {
        JFrame window = new JFrame();
        window.setTitle("Converter");


        window.setContentPane(getPanelWithButtonsAndWidgets());
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);


    }

    //CONVERSION ALGORITHMS//
    public static double lengthconversion(double input, String from, String to) {
        double value = 0;
        //FROM IMPERIAL//
        //INCH -> METRIC//
        if (from.equals("Inch") && to.equals("millimetres/mm")) {
            return input * 1000 * 0.0254;
        }
        if (from.equals("Inch") && to.equals("centimetres/cm")) {
            return input * 100 * 0.0254;
        }
        if (from.equals("Inch") && to.equals("metres/m")) {
            return input * 0.0254;
        }
        if (from.equals("Inch") && to.equals("kilometres/km")) {
            return (input * 0.0254) / 1000;
        }

        //INCH -> IMPERIAL//
        if (from.equals("Inch") && to.equals("Inch")) {
            return input;
        }
        if (from.equals("Inch") && to.equals("Foot")) {
            return input / ((30.48 / 100) / (25.4 / 1000));
        }
        if (from.equals("Inch") && to.equals("Yard")) {
            return input / ((0.9144) / (25.4 / 1000));
        }
        if (from.equals("Inch") && to.equals("Mile")) {
            return input / ((1609) / (25.4 / 1000));
        }


        //FOOT -> METRIC//
        if (from.equals("Foot") && to.equals("millimetres/mm")) {
            return input * 1000 * 0.3048;
        }
        if (from.equals("Foot") && to.equals("centimetres/cm")) {
            return input * 100 * 0.3048;
        }
        if (from.equals("Foot") && to.equals("metres/m")) {
            return input * 0.3048;
        }
        if (from.equals("Foot") && to.equals("kilometres/km")) {
            return (input * 0.3048) / 1000;
        }

        //FOOT -> IMPERIAL//
        if (from.equals("Foot") && to.equals("Inch")) {
            return input / ((0.0254) / (0.3048));
        }
        if (from.equals("Foot") && to.equals("Foot")) {
            return input / ((0.3048) / (0.3048));
        }
        if (from.equals("Foot") && to.equals("Yard")) {
            return input / ((0.9144) / (0.3048));
        }
        if (from.equals("Foot") && to.equals("Mile")) {
            return input / ((1609) / (0.3048));
        }


        //YARD -> METRIC//
        if (from.equals("Yard") && to.equals("millimetres/mm")) {
            return input * 1000 * 0.9144;
        }
        if (from.equals("Yard") && to.equals("centimetres/cm")) {
            return input * 100 * 0.9144;
        }
        if (from.equals("Yard") && to.equals("metres/m")) {
            return input * 0.9144;
        }
        if (from.equals("Yard") && to.equals("kilometres/km")) {
            return (input * 0.9144) / 1000;
        }

        //Yard -> IMPERIAL//
        if (from.equals("Yard") && to.equals("Inch")) {
            return input / ((0.0254) / (0.9144));
        }
        if (from.equals("Yard") && to.equals("Foot")) {
            return input / ((0.3048) / (0.9144));
        }
        if (from.equals("Yard") && to.equals("Yard")) {
            return input / ((0.9144) / (0.9144));
        }
        if (from.equals("Yard") && to.equals("Mile")) {
            return input / ((1609) / (0.9144));
        }


        //Mile -> METRIC//
        if (from.equals("Mile") && to.equals("millimetres/mm")) {
            return input * 1000 * 1609;
        }
        if (from.equals("Mile") && to.equals("centimetres/cm")) {
            return input * 100 * 1609;
        }
        if (from.equals("Mile") && to.equals("metres/m")) {
            return input * 1609;
        }
        if (from.equals("Mile") && to.equals("kilometres/km")) {
            return (input * 1609) / 1000;
        }

        //Mile -> IMPERIAL//
        if (from.equals("Mile") && to.equals("Inch")) {
            return input / ((0.0254) / (1609));
        }
        if (from.equals("Mile") && to.equals("Foot")) {
            return input / ((0.3048) / (1609));
        }
        if (from.equals("Mile") && to.equals("Yard")) {
            return input / ((0.9144) / (1609));
        }
        if (from.equals("Mile") && to.equals("Mile")) {
            return input;
        }

//TO IMPERIAL//
        if ((from.equals("millimetres/mm") || from.equals("centimetres/cm") || from.equals("metres/m") || from.equals("kilometres/km")) && (to.equals("Inch") || to.equals("Foot") || to.equals("Yard") || to.equals("Mile"))) {
            //TO INCH//
            if (to.equals("Inch")) {
                value = input / 0.0254;
                if (from.equals("millimetres/mm")) {
                    return value / 1000;
                }
                if (from.equals("centimetres/cm")) {
                    return value / 100;
                }
                if (from.equals("metres/m")) {
                    return value;
                }
                if (from.equals("kilometres/km")) {
                    return value * 1000;
                }
            }
            //TO FOOT//
            if (to.equals("Foot")) {
                value = input / 0.3048;
                if (from.equals("millimetres/mm")) {
                    return value / 1000;
                }
                if (from.equals("centimetres/cm")) {
                    return value / 100;
                }
                if (from.equals("metres/m")) {
                    return value;
                }
                if (from.equals("kilometres/km")) {
                    return value * 1000;
                }
            }

            //TO YARD//
            if (to.equals("Yard")) {
                value = input / 0.9144;
                if (from.equals("millimetres/mm")) {
                    return value / 1000;
                }
                if (from.equals("centimetres/cm")) {
                    return value / 100;
                }
                if (from.equals("metres/m")) {
                    return value;
                }
                if (from.equals("kilometres/km")) {
                    return value * 1000;
                }
            }

            //TO MILE//
            if (to.equals("Mile")) {
                value = input / 1609;
                if (from.equals("millimetres/mm")) {
                    return value / 1000;
                }
                if (from.equals("centimetres/cm")) {
                    return value / 100;
                }
                if (from.equals("metres/m")) {
                    return value;
                }
                if (from.equals("kilometres/km")) {
                    return value * 1000;
                }
            }
        }
//METRIC TO METRIC//
        if ((from.equals("millimetres/mm") || from.equals("centimetres/cm") || from.equals("metres/m") || from.equals("kilometres/km")) && (to.equals("millimetres/mm") || to.equals("centimetres/cm") || to.equals("metres/m") || to.equals("kilometres/km"))) {
            //FROM MILLIMETRES//
            if (from.equals("millimetres/mm")) {
                if (to.equals("millimetres/mm")) {
                    return input;
                }
                if (to.equals("centimetres/cm")) {
                    return input / 100;
                }
                if (to.equals("metres/m")) {
                    return input / 1000;
                }
                if (to.equals("kilometres/km")) {
                    return input / (1000 * 1000);
                }
            }
            //FROM CENTIMETRES//
            if (from.equals("centimetres/cm")) {
                if (to.equals("millimetres/mm")) {
                    return input * 10;
                }
                if (to.equals("centimetres/cm")) {
                    return input;
                }
                if (to.equals("metres/m")) {
                    return input / 100;
                }
                if (to.equals("kilometres/km")) {
                    return input / (100 * 1000);
                }
            }
            //FROM METRES//
            if (from.equals("metres/m")) {
                if (to.equals("millimetres/mm")) {
                    return input * 1000;
                }
                if (to.equals("centimetres/cm")) {
                    return input * 100;
                }
                if (to.equals("metres/m")) {
                    return input;
                }
                if (to.equals("kilometres/km")) {
                    return input / 1000;
                }
            }
            //FROM KILOMETRES//
            if (from.equals("kilometres/km")) {
                if (to.equals("millimetres/mm")) {
                    return input * 1000000;
                }
                if (to.equals("centimetres/cm")) {
                    return input * 100000;
                }
                if (to.equals("metres/m")) {
                    return input * 1000;
                }
                if (to.equals("kilometres/km")) {
                    return input;
                }
            }

        }
        return 0.00000;
    }

    public static double liquidvolumeconversion(double input, String from, String to) {
        double value;
        //FROM IMPERIAL//
        //Fluid Ounce -> METRIC//
        if (from.equals("Fluid Ounce") && to.equals("millilitres/ml")) {
            return input * 1000 * 0.02841;
        }
        if (from.equals("Fluid Ounce") && to.equals("centilitres/cl")) {
            return input * 100 * 0.02841;
        }
        if (from.equals("Fluid Ounce") && to.equals("litres/l")) {
            return input * 0.02841;
        }

        //Fluid Ounce -> IMPERIAL//
        if (from.equals("Fluid Ounce") && to.equals("Fluid Ounce")) {
            return input;
        }
        if (from.equals("Fluid Ounce") && to.equals("Pint")) {
            return input / ((0.568) / (0.02841));
        }
        if (from.equals("Fluid Ounce") && to.equals("Quart")) {
            return input / ((1.14) / (0.02841));
        }
        if (from.equals("Fluid Ounce") && to.equals("Gallon")) {
            return input / ((4.54) / (0.02841));
        }


        //Pint -> METRIC//
        if (from.equals("Pint") && to.equals("millilitres/ml")) {
            return input * 1000 * 0.568;
        }
        if (from.equals("Pint") && to.equals("centilitres/cl")) {
            return input * 100 * 0.568;
        }
        if (from.equals("Pint") && to.equals("litres/l")) {
            return input * 0.568;
        }

        //Pint -> IMPERIAL//
        if (from.equals("Pint") && to.equals("Fluid Ounce")) {
            return input / ((0.02841) / (0.568));
        }
        if (from.equals("Pint") && to.equals("Pint")) {
            return input / ((0.568) / (0.568));
        }
        if (from.equals("Pint") && to.equals("Quart")) {
            return input / ((1.14) / (0.568));
        }
        if (from.equals("Pint") && to.equals("Gallon")) {
            return input / ((4.54) / (0.568));
        }


        //Quart -> METRIC//
        if (from.equals("Quart") && to.equals("millilitres/ml")) {
            return input * 1000 * 1.14;
        }
        if (from.equals("Quart") && to.equals("centilitres/cl")) {
            return input * 100 * 1.14;
        }
        if (from.equals("Quart") && to.equals("litres/l")) {
            return input * 1.14;
        }

        //Quart -> IMPERIAL//
        if (from.equals("Quart") && to.equals("Fluid Ounce")) {
            return input / ((0.02841) / (1.14));
        }
        if (from.equals("Quart") && to.equals("Pint")) {
            return input / ((0.568) / (1.14));
        }
        if (from.equals("Quart") && to.equals("Quart")) {
            return input / ((1.14) / (1.14));
        }
        if (from.equals("Quart") && to.equals("Gallon")) {
            return input / ((4.54) / (1.14));
        }


        //Gallon -> METRIC//
        if (from.equals("Gallon") && to.equals("millilitres/ml")) {
            return input * 1000 * 4.54;
        }
        if (from.equals("Gallon") && to.equals("centilitres/cl")) {
            return input * 100 * 4.54;
        }
        if (from.equals("Gallon") && to.equals("litres/l")) {
            return input * 4.54;
        }

        //Gallon -> IMPERIAL//
        if (from.equals("Gallon") && to.equals("Fluid Ounce")) {
            return input / ((0.02841) / (4.54));
        }
        if (from.equals("Gallon") && to.equals("Pint")) {
            return input / ((0.568) / (4.54));
        }
        if (from.equals("Gallon") && to.equals("Quart")) {
            return input / ((1.14) / (4.54));
        }
        if (from.equals("Gallon") && to.equals("Gallon")) {
            return input / ((4.54) / (4.54));
        }

//TO IMPERIAL//
        if ((from.equals("millilitres/ml") || from.equals("centilitres/cl") || from.equals("litres/l")) && (to.equals("Fluid Ounce") || to.equals("Pint") || to.equals("Quart") || to.equals("Gallon"))) {
            //TO Fluid Ounce//
            if (to.equals("Fluid Ounce")) {
                value = input / 0.02841;
                if (from.equals("millilitres/ml")) {
                    return value / 1000;
                }
                if (from.equals("centilitres/cl")) {
                    return value / 100;
                }
                if (from.equals("litres/l")) {
                    return value;
                }
            }
            //TO Pint//
            if (to.equals("Pint")) {
                value = input / 0.568;
                if (from.equals("millilitres/ml")) {
                    return value / 1000;
                }
                if (from.equals("centilitres/cl")) {
                    return value / 100;
                }
                if (from.equals("litres/l")) {
                    return value;
                }
            }

            //TO Quart//
            if (to.equals("Quart")) {
                value = input / 1.14;
                if (from.equals("millilitres/ml")) {
                    return value / 1000;
                }
                if (from.equals("centilitres/cl")) {
                    return value / 100;
                }
                if (from.equals("litres/l")) {
                    return value;
                }
            }

            //TO Gallon//
            if (to.equals("Gallon")) {
                value = input / 4.54;
                if (from.equals("millilitres/ml")) {
                    return value / 1000;
                }
                if (from.equals("centilitres/cl")) {
                    return value / 100;
                }
                if (from.equals("litres/l")) {
                    return value;
                }
            }
        }
//METRIC TO METRIC//
        if ((from.equals("millilitres/ml") || from.equals("centilitres/cl") || from.equals("litres/l")) && (to.equals("millilitres/ml") || to.equals("centilitres/cl") || to.equals("litres/l"))) {
            //FROM MILLILITRES//
            if (from.equals("millilitres/ml")) {
                if (to.equals("millilitres/ml")) {
                    return input;
                }
                if (to.equals("centilitres/cl")) {
                    return input / 100;
                }
                if (to.equals("litres/l")) {
                    return input / 1000;
                }
            }
            //FROM CENTILITRES//
            if (from.equals("centilitres/cl")) {
                if (to.equals("millilitres/ml")) {
                    return input * 10;
                }
                if (to.equals("centilitres/cl")) {
                    return input;
                }
                if (to.equals("litres/l")) {
                    return input / 100;
                }
            }
            //FROM LITRES//
            if (from.equals("litres/l")) {
                if (to.equals("millilitres/ml")) {
                    return input * 1000;
                }
                if (to.equals("centilitres/cl")) {
                    return input * 100;
                }
                if (to.equals("litres/l")) {
                    return input;
                }
            }

        }
        return 0.00000;
    }

    public static double massconversion(double input, String from, String to) {
        double value;
        //FROM IMPERIAL//
        //Ounce -> METRIC//
        if (from.equals("Ounce") && to.equals("grammes/g")) {
            return input * 1000 * 0.02835;
        }
        if (from.equals("Ounce") && to.equals("kilogrammes/kg")) {
            return input * 0.02835;
        }
        if (from.equals("Ounce") && to.equals("metric tonnes/mT")) {
            return input * (0.02835 / 1000);
        }

        //Ounce -> IMPERIAL//
        if (from.equals("Ounce") && to.equals("Ounce")) {
            return input;
        }
        if (from.equals("Ounce") && to.equals("Pound")) {
            return input / ((0.4536) / (0.02835));
        }
        if (from.equals("Ounce") && to.equals("Stone")) {
            return input / ((6.3503) / (0.02835));
        }
        if (from.equals("Ounce") && to.equals("Long ton")) {
            return input / ((1016) / (0.02835));
        }


        //Pound -> METRIC//
        if (from.equals("Pound") && to.equals("grammes/g")) {
            return input * 1000 * 0.4536;
        }
        if (from.equals("Pound") && to.equals("kilogrammes/kg")) {
            return input * 0.4536;
        }
        if (from.equals("Pound") && to.equals("metric tonnes/mT")) {
            return input * (0.4536 / 1000);
        }

        //Pound -> IMPERIAL//
        if (from.equals("Pound") && to.equals("Ounce")) {
            return input / ((0.02835) / (0.4536));
        }
        if (from.equals("Pound") && to.equals("Pound")) {
            return input / ((0.4536) / (0.4536));
        }
        if (from.equals("Pound") && to.equals("Stone")) {
            return input / ((6.3503) / (0.4536));
        }
        if (from.equals("Pound") && to.equals("Long ton")) {
            return input / ((1016) / (0.4536));
        }


        //Stone -> METRIC//
        if (from.equals("Stone") && to.equals("grammes/g")) {
            return input * 1000 * 6.3503;
        }
        if (from.equals("Stone") && to.equals("kilogrammes/kg")) {
            return input * 6.3503;
        }
        if (from.equals("Stone") && to.equals("metric tonnes/mT")) {
            return input * (6.3503 / 1000);
        }

        //Stone -> IMPERIAL//
        if (from.equals("Stone") && to.equals("Ounce")) {
            return input / ((0.02835) / (6.3503));
        }
        if (from.equals("Stone") && to.equals("Pound")) {
            return input / ((0.4536) / (6.3503));
        }
        if (from.equals("Stone") && to.equals("Stone")) {
            return input / ((6.3503) / (6.3503));
        }
        if (from.equals("Stone") && to.equals("Long ton")) {
            return input / ((1016) / (6.3503));
        }


        //Long ton -> METRIC//
        if (from.equals("Long ton") && to.equals("grammes/g")) {
            return input * 1000 * 1016;
        }
        if (from.equals("Long ton") && to.equals("kilogrammes/kg")) {
            return input * 1016;
        }
        if (from.equals("Long ton") && to.equals("metric tonnes/mT")) {
            return input * 1.016;
        }

        //Long ton -> IMPERIAL//
        if (from.equals("Long ton") && to.equals("Ounce")) {
            return input / ((0.02835) / (1016));
        }
        if (from.equals("Long ton") && to.equals("Pound")) {
            return input / ((0.4536) / (1016));
        }
        if (from.equals("Long ton") && to.equals("Stone")) {
            return input / ((6.3503) / (1016));
        }
        if (from.equals("Long ton") && to.equals("Long ton")) {
            return input;
        }

//TO IMPERIAL//
        if ((from.equals("grammes/g") || from.equals("kilogrammes/kg") || from.equals("metric tonnes/mT")) && (to.equals("Ounce") || to.equals("Pound") || to.equals("Stone") || to.equals("Long ton"))) {
            //TO Ounce//
            if (to.equals("Ounce")) {
                value = input / 0.02835;
                if (from.equals("grammes/g")) {
                    return value / 1000;
                }
                if (from.equals("kilogrammes/kg")) {
                    return value;
                }
                if (from.equals("metric tonnes/mT")) {
                    return value * 1000;
                }
            }
            //TO Pound//
            if (to.equals("Pound")) {
                value = input / 0.4536;
                if (from.equals("grammes/g")) {
                    return value / 1000;
                }
                if (from.equals("kilogrammes/kg")) {
                    return value;
                }
                if (from.equals("metric tonnes/mT")) {
                    return value * 1000;
                }
            }

            //TO Stone//
            if (to.equals("Stone")) {
                value = input / 6.3503;
                if (from.equals("grammes/g")) {
                    return value / 1000;
                }
                if (from.equals("kilogrammes/kg")) {
                    return value;
                }
                if (from.equals("metric tonnes/mT")) {
                    return value * 1000;
                }
            }

            //TO Long ton//
            if (to.equals("Long ton")) {
                value = input / 1016;
                if (from.equals("grammes/g")) {
                    return value / 1000;
                }
                if (from.equals("kilogrammes/kg")) {
                    return value;
                }
                if (from.equals("metric tonnes/mT")) {
                    return value * 1000;
                }
            }
        }
//METRIC TO METRIC//
        if ((from.equals("grammes/g") || from.equals("kilogrammes/kg") || from.equals("metric tonnes/mT")) && (to.equals("grammes/g") || to.equals("kilogrammes/kg") || to.equals("metric tonnes/mT"))) {
            //FROM GRAMMES//
            if (from.equals("grammes/g")) {
                if (to.equals("grammes/g")) {
                    return input;
                }
                if (to.equals("kilogrammes/kg")) {
                    return input / 1000;
                }
                if (to.equals("metric tonnes/mT")) {
                    return input / 1000000;
                }
            }
            //FROM KILOGRAMMES//
            if (from.equals("kilogrammes/kg")) {
                if (to.equals("grammes/g")) {
                    return input * 1000;
                }
                if (to.equals("kilogrammes/kg")) {
                    return input;
                }
                if (to.equals("metric tonnes/mT")) {
                    return input / 1000;
                }
            }
            //FROM METRIC TONNES//
            if (from.equals("metric tonnes/mT")) {
                if (to.equals("grammes/g")) {
                    return input * 1000000;
                }
                if (to.equals("kilogrammes/kg")) {
                    return input * 1000;
                }
                if (to.equals("metric tonnes/mT")) {
                    return input;
                }
            }

        }
        return 0.00000;
    }

    public static double temperatureconversion(double input, String from, String to) {
//CELSIUS -> FAHRNHEIT//
        if (from.equals("celsius/tC") && to.equals("fahrnheit/tF")) {
            return 9 * input / 5 + 32;
        }
//CELSIUS -> CELSIUS or FAHRNHEIT -> FAHRNHEIT//
        if ((from.equals("celsius/tC") && to.equals("celsius/tC")) || (from.equals("fahrnheit/tF") && to.equals("fahrnheit/tF"))) {
            return input;
        }
//FAHRNHEIT -> CELSIUS//
        if (from.equals("fahrnheit/tF") && to.equals("celsius/tC")) {
            return (input - 32) * 5 / 9;
        }

        return 0.00000;
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true); //Little decorations to the GUI
        MainApp app = new MainApp();
    }

    public static void main(String[] args) {
        //Program will run these commands when the whole program is executed
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    private JPanel getPanelWithButtonsAndWidgets() {
        JPanel panel = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();

        //Creating 4 different panels for 4 different tabs
        JPanel layouttab1 = new JPanel(new GridLayout(6, 1));
        JPanel layouttab2 = new JPanel(new GridLayout(6, 1));
        JPanel layouttab3 = new JPanel(new GridLayout(6, 1));
        JPanel layouttab4 = new JPanel(new GridLayout(6, 1));

        //List of convertable units for length, liquid, mass and temperature
        String[] lengthcombo = {"Inch", "Foot", "Yard", "Mile", "millimetres/mm", "centimetres/cm", "metres/m", "kilometres/km"};
        String[] liquidvolumecombo = {"Fluid Ounce", "Pint", "Quart", "Gallon", "millilitres/ml", "centilitres/cl", "litres/l"};
        String[] masscombo = {"Ounce", "Pound", "Stone", "Long ton", "grammes/g", "kilogrammes/kg", "metric tonnes/mT"};
        String[] temperaturecombo = {"celsius/tC", "fahrnheit/tF"};


        //LENGTH//
        //From Length Combo Box//

        length_fromlist = new JComboBox(lengthcombo);
        length_fromlist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("From"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        length_fromlist.setSelectedIndex(0);
        length_fromlist.addItemListener(this);

        //To Length Combo Box//

        length_tolist = new JComboBox(lengthcombo);
        length_tolist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("To"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        length_tolist.setSelectedIndex(4);
        length_tolist.addItemListener(this);


        //INPUT TEXTFIELD//
        JPanel length_inputPane = new JPanel();
        length_inputPane.setLayout(new FlowLayout());
        length_inputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input Panel (Hit Enter After Input)"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        length_inputtextfield = new TextField(50);
        length_inputtextfield.addActionListener(this);
        length_inputPane.add(length_inputtextfield);


        //CONVERT BUTTON//
        JPanel length_convertPane = new JPanel();
        length_convertPane.setLayout(new FlowLayout());
        length_convertbutton = new JButton("Convert!");
        length_convertbutton.setPreferredSize(new Dimension(230, 30));
        length_convertbutton.addActionListener(this);
        length_convertPane.add(length_convertbutton);
        length_convertbutton.setEnabled(false);

        //INPUTDISPLAY TEXTFIELD//
        JPanel length_inputdisplayPane = new JPanel();
        length_inputdisplayPane.setLayout(new FlowLayout());
        length_inputdisplayPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Input"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        length_displayinput = new TextField(50);
        length_displayinput.setEditable(false);
        length_displayinput.addActionListener(this);
        length_inputdisplayPane.add(length_displayinput);

        //OUTPUT TEXTFIELD//
        JPanel length_outputPane = new JPanel();
        length_outputPane.setLayout(new FlowLayout());
        length_outputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Output"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        length_displayoutput = new TextField(50);
        length_displayoutput.setEditable(false);
        length_outputPane.add(length_displayoutput);


        //LIQUID VOLUME//
        //From Liquid Volume Combo Box//

        liquidvolume_fromlist = new JComboBox(liquidvolumecombo);
        liquidvolume_fromlist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("From"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        liquidvolume_fromlist.setSelectedIndex(0);
        liquidvolume_fromlist.addItemListener(this);

        //To liquidvolume Combo Box//

        liquidvolume_tolist = new JComboBox(liquidvolumecombo);
        liquidvolume_tolist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("To"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        liquidvolume_tolist.setSelectedIndex(4);
        liquidvolume_tolist.addItemListener(this);


        //INPUT TEXTFIELD//
        JPanel liquidvolume_inputPane = new JPanel();
        liquidvolume_inputPane.setLayout(new FlowLayout());
        liquidvolume_inputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input Panel (Hit Enter After Input)"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        liquidvolume_inputtextfield = new TextField(50);
        liquidvolume_inputtextfield.addActionListener(this);
        liquidvolume_inputPane.add(liquidvolume_inputtextfield);

        //CONVERT BUTTON//
        JPanel liquidvolume_convertPane = new JPanel();
        liquidvolume_convertPane.setLayout(new FlowLayout());
        liquidvolume_convertbutton = new JButton("Convert!");
        liquidvolume_convertbutton.setPreferredSize(new Dimension(230, 30));
        liquidvolume_convertbutton.addActionListener(this);
        liquidvolume_convertPane.add(liquidvolume_convertbutton);
        liquidvolume_convertbutton.setEnabled(false);

        //INPUTDISPLAY TEXTFIELD//
        JPanel liquidvolume_inputdisplayPane = new JPanel();
        liquidvolume_inputdisplayPane.setLayout(new FlowLayout());
        liquidvolume_inputdisplayPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Input"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        liquidvolume_displayinput = new TextField(50);
        liquidvolume_displayinput.setEditable(false);
        liquidvolume_displayinput.addActionListener(this);
        liquidvolume_inputdisplayPane.add(liquidvolume_displayinput);

        //OUTPUT TEXTFIELD//
        JPanel liquidvolume_outputPane = new JPanel();
        liquidvolume_outputPane.setLayout(new FlowLayout());
        liquidvolume_outputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Output"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        liquidvolume_displayoutput = new TextField(50);
        liquidvolume_displayoutput.setEditable(false);
        liquidvolume_displayoutput.addActionListener(this);
        liquidvolume_outputPane.add(liquidvolume_displayoutput);

        //MASS//
        //From Mass Combo Box//

        mass_fromlist = new JComboBox(masscombo);
        mass_fromlist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("From"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mass_fromlist.setSelectedIndex(0);
        mass_fromlist.addItemListener(this);

        //To mass Combo Box//

        mass_tolist = new JComboBox(masscombo);
        mass_tolist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("To"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mass_tolist.setSelectedIndex(4);
        mass_tolist.addItemListener(this);


        //INPUT TEXTFIELD//
        JPanel mass_inputPane = new JPanel();
        mass_inputPane.setLayout(new FlowLayout());
        mass_inputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input Panel (Hit Enter After Input)"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mass_inputtextfield = new TextField(50);
        mass_inputtextfield.addActionListener(this);
        mass_inputPane.add(mass_inputtextfield);

        //CONVERT BUTTON//
        JPanel mass_convertPane = new JPanel();
        mass_convertPane.setLayout(new FlowLayout());
        mass_convertbutton = new JButton("Convert!");
        mass_convertbutton.setPreferredSize(new Dimension(230, 30));
        mass_convertbutton.addActionListener(this);
        mass_convertPane.add(mass_convertbutton);
        mass_convertbutton.setEnabled(false);

        //INPUTDISPLAY TEXTFIELD//
        JPanel mass_inputdisplayPane = new JPanel();
        mass_inputdisplayPane.setLayout(new FlowLayout());
        mass_inputdisplayPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Input"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mass_displayinput = new TextField(50);
        mass_displayinput.setEditable(false);
        mass_displayinput.addActionListener(this);
        mass_inputdisplayPane.add(mass_displayinput);

        //OUTPUT TEXTFIELD//
        JPanel mass_outputPane = new JPanel();
        mass_outputPane.setLayout(new FlowLayout());
        mass_outputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Output"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mass_displayoutput = new TextField(50);
        mass_displayoutput.setEditable(false);
        mass_displayoutput.addActionListener(this);
        mass_outputPane.add(mass_displayoutput);

        //TEMPERATURE//
        //From temperature Combo Box//

        temperature_fromlist = new JComboBox(temperaturecombo);
        temperature_fromlist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("From"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        temperature_fromlist.setSelectedIndex(0);
        temperature_fromlist.addItemListener(this);

        //To temperature Combo Box//

        temperature_tolist = new JComboBox(temperaturecombo);
        temperature_tolist.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("To"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        temperature_tolist.setSelectedIndex(1);
        temperature_tolist.addItemListener(this);


        //INPUT TEXTFIELD//
        JPanel temperature_inputPane = new JPanel();
        temperature_inputPane.setLayout(new FlowLayout());
        temperature_inputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Input Panel (Hit Enter After Input)"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        temperature_inputtextfield = new TextField(50);
        temperature_inputtextfield.addActionListener(this);
        temperature_inputPane.add(temperature_inputtextfield);
        //CONVERT BUTTON//
        JPanel temperature_convertPane = new JPanel();
        temperature_convertPane.setLayout(new FlowLayout());
        temperature_convertbutton = new JButton("Convert!");
        temperature_convertbutton.setPreferredSize(new Dimension(230, 30));
        temperature_convertbutton.addActionListener(this);
        temperature_convertPane.add(temperature_convertbutton);
        temperature_convertbutton.setEnabled(false);

        //INPUTDISPLAY TEXTFIELD//
        JPanel temperature_inputdisplayPane = new JPanel();
        temperature_inputdisplayPane.setLayout(new FlowLayout());
        temperature_inputdisplayPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Input"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        temperature_displayinput = new TextField(50);
        temperature_displayinput.setEditable(false);
        temperature_displayinput.addActionListener(this);
        temperature_inputdisplayPane.add(temperature_displayinput);

        //OUTPUT TEXTFIELD//
        JPanel temperature_outputPane = new JPanel();
        temperature_outputPane.setLayout(new FlowLayout());
        temperature_outputPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Display Output"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        temperature_displayoutput = new TextField(50);
        temperature_displayoutput.setEditable(false);
        temperature_displayoutput.addActionListener(this);
        temperature_outputPane.add(temperature_displayoutput);

        //Adding all the tabs to panel!//
        //length tab//
        layouttab1.add(length_inputPane);
        layouttab1.add(length_fromlist);
        layouttab1.add(length_tolist);
        layouttab1.add(length_convertPane);
        layouttab1.add(length_inputdisplayPane);
        layouttab1.add(length_outputPane);

        //liquid volume tab//
        layouttab2.add(liquidvolume_inputPane);
        layouttab2.add(liquidvolume_fromlist);
        layouttab2.add(liquidvolume_tolist);
        layouttab2.add(liquidvolume_convertPane);
        layouttab2.add(liquidvolume_inputdisplayPane);
        layouttab2.add(liquidvolume_outputPane);

        //mass tab//
        layouttab3.add(mass_inputPane);
        layouttab3.add(mass_fromlist);
        layouttab3.add(mass_tolist);
        layouttab3.add(mass_convertPane);
        layouttab3.add(mass_inputdisplayPane);
        layouttab3.add(mass_outputPane);

        //temperature tab//
        layouttab4.add(temperature_inputPane);
        layouttab4.add(temperature_fromlist);
        layouttab4.add(temperature_tolist);
        layouttab4.add(temperature_convertPane);
        layouttab4.add(temperature_inputdisplayPane);
        layouttab4.add(temperature_outputPane);


        tabbedPane.addTab("Length", layouttab1);
        tabbedPane.addTab("Liquid Volume", layouttab2);
        tabbedPane.addTab("Mass", layouttab3);
        tabbedPane.addTab("Temperature", layouttab4);
        panel.add(tabbedPane);
        return panel;

    }

    public void actionPerformed(ActionEvent event) throws NumberFormatException {
        String c = event.getActionCommand();

//ENABLE CONVERT BUTTON//
        //Run these commands when something is typed into the length textfield & pressed return
        if ((length_inputtextfield.getText()).equals(c)) {
            //Resetting the input display textfields to avoid confusions
            liquidvolume_displayinput.setText("");
            mass_displayinput.setText("");
            temperature_displayinput.setText("");

            //Displaying the input item from Input Panel into the input display text field
            length_displayinput.setText(length_inputtextfield.getText());

            //Reset the Input Panel textfields to avoid confusions
            length_inputtextfield.setText("");
            liquidvolume_inputtextfield.setText("");
            mass_inputtextfield.setText("");
            temperature_inputtextfield.setText("");

            //Set the length convert button clickable
            length_convertbutton.setEnabled(true);

            //Set other convert buttons to non-clickable
            liquidvolume_convertbutton.setEnabled(false);
            mass_convertbutton.setEnabled(false);
            temperature_convertbutton.setEnabled(false);

            //Resetting the combo box of liquid volume, mass, temp back to default
            liquidvolume_fromlist.setSelectedIndex(0);
            liquidvolume_tolist.setSelectedIndex(4);
            mass_fromlist.setSelectedIndex(0);
            mass_tolist.setSelectedIndex(4);
            temperature_fromlist.setSelectedIndex(0);
            temperature_tolist.setSelectedIndex(1);

            //Resetting the output display of liq volume, mass, temp to avoid confusion
            liquidvolume_displayoutput.setText("");
            mass_displayoutput.setText("");
            temperature_displayoutput.setText("");

            //Setting the convert type variable "type" to length
            type = "length";

        }

        //Run these commands when something is typed into the liquid volume textfield & pressed return
        if ((liquidvolume_inputtextfield.getText()).equals(c)) {

            //Resetting the input display textfields to avoid confusions
            length_displayinput.setText("");
            mass_displayinput.setText("");
            temperature_displayinput.setText("");

            //Displaying the input item from Input Panel into the input display text field
            liquidvolume_displayinput.setText(liquidvolume_inputtextfield.getText());

            //Reset the Input Panel textfields to avoid confusions
            length_inputtextfield.setText("");
            liquidvolume_inputtextfield.setText("");
            mass_inputtextfield.setText("");
            temperature_inputtextfield.setText("");

            //Set the liquid volume convert button clickable
            liquidvolume_convertbutton.setEnabled(true);

            //Set other convert buttons to non-clickable
            length_convertbutton.setEnabled(false);
            mass_convertbutton.setEnabled(false);
            temperature_convertbutton.setEnabled(false);

            //Resetting the combo box of length, mass, temp back to default
            length_fromlist.setSelectedIndex(0);
            length_tolist.setSelectedIndex(4);
            mass_fromlist.setSelectedIndex(0);
            mass_tolist.setSelectedIndex(4);
            temperature_fromlist.setSelectedIndex(0);
            temperature_tolist.setSelectedIndex(1);

            //Resetting the output display of length, mass, temp to avoid confusion
            length_displayoutput.setText("");
            mass_displayoutput.setText("");
            temperature_displayoutput.setText("");

            //Setting the convert type variable "type" to liquid volume
            type = "liquidvolume";
        }

        //Run these commands when something is typed into the mass textfield & pressed return
        if ((mass_inputtextfield.getText()).equals(c)) {

            //Resetting the input display textfields to avoid confusions
            liquidvolume_displayinput.setText("");
            length_displayinput.setText("");
            temperature_displayinput.setText("");

            //Displaying the input item from Input Panel into the input display text field
            mass_displayinput.setText(mass_inputtextfield.getText());

            //Reset the Input Panel textfields to avoid confusions
            length_inputtextfield.setText("");
            liquidvolume_inputtextfield.setText("");
            mass_inputtextfield.setText("");
            temperature_inputtextfield.setText("");

            //Set the mass convert button clickable
            mass_convertbutton.setEnabled(true);

            //Set other convert buttons to non-clickable
            length_convertbutton.setEnabled(false);
            liquidvolume_convertbutton.setEnabled(false);
            temperature_convertbutton.setEnabled(false);

            //Resetting the combo box of length liquid volume, temp back to default
            liquidvolume_fromlist.setSelectedIndex(0);
            liquidvolume_tolist.setSelectedIndex(4);
            length_fromlist.setSelectedIndex(0);
            length_tolist.setSelectedIndex(4);
            temperature_fromlist.setSelectedIndex(0);
            temperature_tolist.setSelectedIndex(1);

            //Resetting the output display of length, liquid volume, temp to avoid confusion
            liquidvolume_displayoutput.setText("");
            length_displayoutput.setText("");
            temperature_displayoutput.setText("");

            //Setting the convert type variable "type" to mass
            type = "mass";
        }

        //Run these commands when something is typed into the temperature textfield & pressed return
        if ((temperature_inputtextfield.getText()).equals(c)) {

            //Resetting the input display textfields to avoid confusions
            liquidvolume_displayinput.setText("");
            mass_displayinput.setText("");
            length_displayinput.setText("");

            //Displaying the input item from Input Panel into the input display text field
            temperature_displayinput.setText(temperature_inputtextfield.getText());

            //Reset the Input Panel textfields to avoid confusions
            length_inputtextfield.setText("");
            liquidvolume_inputtextfield.setText("");
            mass_inputtextfield.setText("");
            temperature_inputtextfield.setText("");

            //Set the temperature convert button clickable
            temperature_convertbutton.setEnabled(true);

            //Set other convert buttons to non-clickable
            length_convertbutton.setEnabled(false);
            liquidvolume_convertbutton.setEnabled(false);
            mass_convertbutton.setEnabled(false);

            //Resetting the combo box of length, liquid volume, mass back to default
            liquidvolume_fromlist.setSelectedIndex(0);
            liquidvolume_tolist.setSelectedIndex(4);
            mass_fromlist.setSelectedIndex(0);
            mass_tolist.setSelectedIndex(4);
            length_fromlist.setSelectedIndex(0);
            length_tolist.setSelectedIndex(4);

            //Resetting the output display of length,liquid volume, mass to avoid confusion
            liquidvolume_displayoutput.setText("");
            mass_displayoutput.setText("");
            length_displayoutput.setText("");

            //Setting the convert type variable "type" to temperature
            type = "temperature";
        }
//END ENABLE CONVERT BUTTON//


//CLICK CONVERT BUTTON//
        if (("Convert!").equals(c)) { //When the convert button is pressed...

            if (type.equals("length")) {
                //When the convert button is clicked, if the type is "length", do the following commands
                if (length_convert_from != "Inch" && length_convert_from != "Foot" && length_convert_from != "Yard" && length_convert_from != "Mile" && length_convert_from != "millimetres/mm" && length_convert_from != "centimetres/cm" && length_convert_from != "metres/m" && length_convert_from != "kilometres/km") {
                    length_convert_from = "Inch"; //Setting default if the combo box is not touched
                }
                if (length_convert_to != "Inch" && length_convert_to != "Foot" && length_convert_to != "Yard" && length_convert_to != "Mile" && length_convert_to != "millimetres/mm" && length_convert_to != "centimetres/cm" && length_convert_to != "metres/m" && length_convert_to != "kilometres/km") {
                    length_convert_to = "millimetres/mm"; //Setting default if the combo box is not touched
                }

                //Catching the NumberFormatException when user is trying to convert non-numerical inputs
                try {
                    length_displayoutput.setText(String.valueOf(lengthconversion(Double.parseDouble(length_displayinput.getText()), length_convert_from, length_convert_to)));
                } catch (NumberFormatException e) {
                    length_displayoutput.setText("Input Error, Numerical Input Only.");
                }
            }

            if (type.equals("liquidvolume")) {
                //When the convert button is clicked, if the type is "liquidvolume", do the following commands
                System.out.println(liquidvolume_convert_from + "   " + liquidvolume_convert_to);
                if (liquidvolume_convert_from != "Fluid Ounce" && liquidvolume_convert_from != "Pint" && liquidvolume_convert_from != "Quart" && liquidvolume_convert_from != "Gallon" && liquidvolume_convert_from != "millilitres/ml" && liquidvolume_convert_from != "centilitres/cl" && liquidvolume_convert_from != "litres/l") {
                    liquidvolume_convert_from = "Fluid Ounce"; //Setting default if the combo box is not touched
                }
                if (liquidvolume_convert_to != "Fluid Ounce" && liquidvolume_convert_to != "Pint" && liquidvolume_convert_to != "Quart" && liquidvolume_convert_to != "Gallon" && liquidvolume_convert_to != "millilitres/ml" && liquidvolume_convert_to != "centilitres/cl" && liquidvolume_convert_to != "litres/l") {
                    liquidvolume_convert_to = "millilitres/ml"; //Setting default if the combo box is not touched
                }
                //Catching the NumberFormatException when user is trying to convert non-numerical inputs
                try {
                    liquidvolume_displayoutput.setText(String.valueOf(liquidvolumeconversion(Double.parseDouble(liquidvolume_displayinput.getText()), liquidvolume_convert_from, liquidvolume_convert_to)));
                } catch (NumberFormatException e) {
                    liquidvolume_displayoutput.setText("Input Error, Numerical Input Only.");
                }

            }

            if (type.equals("mass")) {
                //When the convert button is clicked, if the type is "mass", do the following commands
                if (mass_convert_from != "Ounce" && mass_convert_from != "Pound" && mass_convert_from != "Stone" && mass_convert_from != "Long ton" && mass_convert_from != "grammes/g" && mass_convert_from != "kilogrammes/kg" && mass_convert_from != "metric tonnes/mT") {
                    mass_convert_from = "Ounce"; //Setting default if the combo box is not touched
                }
                if (mass_convert_to != "Ounce" && mass_convert_to != "Pound" && mass_convert_to != "Stone" && mass_convert_to != "Long ton" && mass_convert_to != "grammes/g" && mass_convert_to != "kilogrammes/kg" && mass_convert_to != "metric tonnes/mT") {
                    mass_convert_to = "grammes/g"; //Setting default if the combo box is not touched
                }
                //Catching the NumberFormatException when user is trying to convert non-numerical inputs
                try {
                    mass_displayoutput.setText(String.valueOf(massconversion(Double.parseDouble(mass_displayinput.getText()), mass_convert_from, mass_convert_to)));
                } catch (NumberFormatException e) {
                    mass_displayoutput.setText("Input Error, Numerical Input Only.");
                }

            }

            if (type.equals("temperature")) {
                //When the convert button is clicked, if the type is "temperature", do the following commands
                if (temperature_convert_from != "celsius/tC" && temperature_convert_from != "fahrnheit/tF") {
                    temperature_convert_from = "celsius/tC"; //Setting default if the combo box is not touched
                }
                if (temperature_convert_to != "celsius/tC" && temperature_convert_to != "fahrnheit/tF") {
                    temperature_convert_to = "fahrnheit/tF"; //Setting default if the combo box is not touched
                }
                //Catching the NumberFormatException when user is trying to convert non-numerical inputs
                try {
                    temperature_displayoutput.setText(String.valueOf(temperatureconversion(Double.parseDouble(temperature_displayinput.getText()), temperature_convert_from, temperature_convert_to)));
                } catch (NumberFormatException e) {
                    temperature_displayoutput.setText("Input Error, Numerical Input Only.");
                }
            }
        }
    }

    //ITEMLISTENERS//
    public void itemStateChanged(ItemEvent event) {
        //ITEM LISTENERS FOR LENGTH, SETTING LENGTH_CONVERT_FROM & LENGTH_CONVERT_TO TO THE CONVERSION UNIT//
        if (event.getSource() == length_fromlist && event.getStateChange() == ItemEvent.SELECTED) {
            length_convert_from = (String) length_fromlist.getSelectedItem();
        }
        if (event.getSource() == length_tolist && event.getStateChange() == ItemEvent.SELECTED) {
            length_convert_to = (String) length_tolist.getSelectedItem();
        }

        //ITEM LISTENERS FOR LIQUIDVOLUME, SETTING LIQUIDVOLUME_CONVERT_FROM & LIQUIDVOLUME_CONVERT_TO TO THE CONVERSION UNIT//
        if (event.getSource() == liquidvolume_fromlist && event.getStateChange() == ItemEvent.SELECTED) {
            liquidvolume_convert_from = (String) liquidvolume_fromlist.getSelectedItem();
        }
        if (event.getSource() == liquidvolume_tolist && event.getStateChange() == ItemEvent.SELECTED) {
            liquidvolume_convert_to = (String) liquidvolume_tolist.getSelectedItem();
        }

        //ITEM LISTENERS FOR MASS, SETTING MASS_CONVERT_FROM & MASS_CONVERT_TO TO THE CONVERSION UNIT//
        if (event.getSource() == mass_fromlist && event.getStateChange() == ItemEvent.SELECTED) {
            mass_convert_from = (String) mass_fromlist.getSelectedItem();
        }
        if (event.getSource() == mass_tolist && event.getStateChange() == ItemEvent.SELECTED) {
            mass_convert_to = (String) mass_tolist.getSelectedItem();
        }

        //ITEM LISTENERS FOR TEMPERATURE, SETTING TEMPERATURE_CONVERT_FROM & TEMPERATURE_CONVERT_TO TO THE CONVERSION UNIT//
        if (event.getSource() == temperature_fromlist && event.getStateChange() == ItemEvent.SELECTED) {
            temperature_convert_from = (String) temperature_fromlist.getSelectedItem();
        }
        if (event.getSource() == temperature_tolist && event.getStateChange() == ItemEvent.SELECTED) {
            temperature_convert_to = (String) temperature_tolist.getSelectedItem();
        }
    }

}
