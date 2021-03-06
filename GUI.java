// GUI class. This is contains the display, the buttons, and the actionPerformed ActionListener method to detect user actions. Non-GUI related code is run via methods from a SorterHelper instance and an ArrayHelper instance

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class GUI implements ActionListener {

    // Helper classes
    SorterHelper sortingHelp;
    ArrayHelper arrayHelp;

    // arrays
    final Integer[] sizesOfArray = {10, 100, 1000, 5000};
    final String[] namesOfSorters = {"Bubble Sort", "Selection Sort", "Quick Sort", "Merge Sort"};
    final String[] sortingOrders = {"Ascending", "Descending"};

    // border to use consistently
    final Border blackline = BorderFactory.createLineBorder(Color.black);

    // font of all the text
    final Font myFont = new Font("Times New Roman", Font.BOLD, 14);

    // buttons
    JButton startButton = new JButton();
    JButton resetButton = new JButton();
    JButton closeButton = new JButton();

    // combo boxes
    JComboBox<Integer> boxOfSizesOfArray = new JComboBox<>(sizesOfArray);
    JComboBox<String> boxOfSortingMethods = new JComboBox<>(namesOfSorters);
    JComboBox<String> boxOfSortingOrders = new JComboBox<>(sortingOrders);

    // frame
    JFrame frame = new JFrame();

    // labels

    // Labels where the user chooses sorting options
    JLabel messSizeOfArray = new JLabel();
    JLabel messTypeOfSort = new JLabel();
    JLabel messSortingOrder = new JLabel();

    // Labels for output of the times and comparisons for each sort
    JLabel durationOfBubbleSort = new JLabel();
    JLabel durationOfSelectionSort = new JLabel();
    JLabel durationOfQuickSort = new JLabel();
    JLabel durationOfMergeSort = new JLabel();

    // Labels for outputting the arrays
    JLabel unsortedArr = new JLabel();
    JLabel sortedArr = new JLabel();
    JLabel cannotOutputArr = new JLabel();

    // panels
    JPanel optionPanel = new JPanel();
    JPanel durationPanel = new JPanel();
    JPanel arrayPanel = new JPanel();

    public GUI(SorterHelper sortingHelp, ArrayHelper arrayHelp) {
        
        // set up helpers
        this.sortingHelp = sortingHelp;
        this.arrayHelp = arrayHelp;

        // set up frame
        frame.setTitle("Sorting Efficiency");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        // set up labels for the option panel
        messSizeOfArray.setFont(myFont);
        messSizeOfArray.setText("Select the size of your array: ");
        messSizeOfArray.setBounds(20, 20, 1000, 20);

        messTypeOfSort.setFont(myFont);
        messTypeOfSort.setText("Select a sorting method: ");
        messTypeOfSort.setBounds(20, 65, 1000, 20);

        messSortingOrder.setFont(myFont);
        messSortingOrder.setText("Select an order: ");
        messSortingOrder.setBounds(20, 110, 1000, 20);

        // set up comboboxes
        boxOfSizesOfArray.setFont(myFont);
        boxOfSizesOfArray.setBounds(255, 19, 70, 25);
        boxOfSizesOfArray.addActionListener(this);

        boxOfSortingMethods.setFont(myFont);
        boxOfSortingMethods.setBounds(220, 64, 150, 25);
        boxOfSortingMethods.addActionListener(this);

        boxOfSortingOrders.setFont(myFont);
        boxOfSortingOrders.setBounds(155, 109, 140, 25);
        boxOfSortingOrders.addActionListener(this);

        // set up start button
        startButton.setFont(myFont);
        startButton.setBounds(150, 160, 100, 25);
        startButton.setText("Start");
        startButton.addActionListener(this);

        // set up reset button
        resetButton.setFont(myFont);
        resetButton.setBounds(70, 160, 100, 25);
        resetButton.setText("Reset");
        resetButton.addActionListener(this);

        // set up reset button
        closeButton.setFont(myFont);
        closeButton.setBounds(220, 160, 100, 25);
        closeButton.setText("Close");
        closeButton.addActionListener(this);

        // basic setup of panel for options
        optionPanel.setSize(400, 199);
        optionPanel.setLocation(2, 0);
        optionPanel.setBorder(blackline);
        optionPanel.setLayout(null);
        optionPanel.add(boxOfSizesOfArray);
        optionPanel.add(boxOfSortingMethods);
        optionPanel.add(boxOfSortingOrders);
        optionPanel.add(messSizeOfArray);
        optionPanel.add(messTypeOfSort);
        optionPanel.add(messSortingOrder);
        optionPanel.add(startButton);
        
        // basic setup of panel for durations and comparisons
        durationPanel.setSize(400, 360);
        durationPanel.setLocation(2, 202);
        durationPanel.setBorder(blackline);
        durationPanel.setLayout(null);

        // basic setup of panel for arrays (unsorted and sorted)
        arrayPanel.setSize(796, 562);
        arrayPanel.setLocation(404, 0);
        arrayPanel.setBorder(blackline);
        arrayPanel.setLayout(null);
        arrayPanel.add(unsortedArr);
        arrayPanel.add(sortedArr);
        arrayPanel.add(cannotOutputArr);

        // add components to the frame
        frame.add(optionPanel);
        frame.add(durationPanel);
        frame.add(arrayPanel);

        // make frame visible
        frame.setVisible(true);
    }

    // buttons
    @Override
    public void actionPerformed(ActionEvent e) {
		    // start button
        if (e.getSource() == startButton) {
            disableComboboxes();

            proccedSorting();

            setupDurationPanel();

            optionPanel.repaint(); // update panel
            optionPanel.remove(startButton); // remove start button
            optionPanel.add(resetButton);
            optionPanel.add(closeButton);

            try {
                createTwoTextFiles();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }

		    // reset button
        if (e.getSource() == resetButton) {
            frame.dispose();
            new GUI(new SorterHelper(), new ArrayHelper());
        }

		    // close button
        if (e.getSource() == closeButton) {
            System.exit(0);
        }
    }

    // proceed the sorting
    public void proccedSorting() {
        // get the items from the comboboxes
        int arraySize = (int)boxOfSizesOfArray.getSelectedItem();
        String sorter = String.valueOf(boxOfSortingMethods.getSelectedItem());
        String sortOrder = String.valueOf(boxOfSortingOrders.getSelectedItem());

        // create an array
        arrayHelp.setUnsortedArray(arrayHelp.generateArray(arraySize));

        // sort the array
        arrayHelp.setSortedArray(sortingHelp.sort(arrayHelp.getUnsortedArray(), sorter, sortOrder));

        addArraysToPanel(arraySize, arrayHelp.arrayToString(arrayHelp.getUnsortedArray()), arrayHelp.arrayToString(arrayHelp.getSortedArray()));
    }

    // add labels to duration panel
    public void setupDurationPanel() {
        // duration of bubble sort as output
        durationOfBubbleSort.setFont(myFont);
        durationOfBubbleSort.setText(sortingHelp.getExecutionDetails("Bubble Sort"));
        durationOfBubbleSort.setBounds(20, 20, 250, 90);
        
        // duration of selection sort as output
        durationOfSelectionSort.setFont(myFont);
        durationOfSelectionSort.setText(sortingHelp.getExecutionDetails("Selection Sort"));
        durationOfSelectionSort.setBounds(20, 100, 250, 90);

        // duration of quick sort as output
        durationOfQuickSort.setFont(myFont);
        durationOfQuickSort.setText(sortingHelp.getExecutionDetails("Quick Sort"));
        durationOfQuickSort.setBounds(20, 180, 250, 90);

        // duration of merge sort as output
        durationOfMergeSort.setFont(myFont);
        durationOfMergeSort.setText(sortingHelp.getExecutionDetails("Merge Sort")); // change bubble to merge
        durationOfMergeSort.setBounds(20, 260, 250, 90);
        
        // update panel
        durationPanel.repaint();

        // add labels to the panel
        durationPanel.add(durationOfBubbleSort);
        durationPanel.add(durationOfSelectionSort);
        durationPanel.add(durationOfQuickSort);
        durationPanel.add(durationOfMergeSort);
    }

    // add arrays to panel
    public void addArraysToPanel(int size, String unsortedArray, String sortedArray) {
        arrayPanel.repaint();
        
        // If there are too many numbers for the panel to hold
        if (size >= 1000) {
            String mess = "You really think you can output thousands of numbers in side this little panel? Close this program and check the two text files in your folder!";
            cannotOutputArr.setFont(myFont);
            cannotOutputArr.setBounds(20, 20, 740, 300);
            cannotOutputArr.setText("<html><p style=\"width:550px\">" + mess + "</p></html>");
            cannotOutputArr.setVerticalAlignment(SwingConstants.TOP);
        }
        else {
            unsortedArr.setFont(myFont);
            unsortedArr.setBounds(10, 10, 775, 300);
            unsortedArr.setText("<html>Unsorted Array<br/><br/><p style=\"width:570px\">"+unsortedArray+"</p></html>");
            unsortedArr.setVerticalAlignment(SwingConstants.TOP);

            sortedArr.setFont(myFont);
            sortedArr.setBounds(10, 250, 775, 300);
            sortedArr.setText("<html>Sorted Array<br/><br/><p style=\"width:570px\">"+sortedArray+"</p></html>");
            sortedArr.setVerticalAlignment(SwingConstants.TOP);
        }
    }

    // create two txt file
    public void createTwoTextFiles() throws IOException {
        try {
            // writers
            PrintWriter fout1 = new PrintWriter(new FileWriter("Unsorted Array.txt"));
            PrintWriter fout2 = new PrintWriter(new FileWriter("Sorted Array.txt"));

            // loop through elements and write them in the text file
            for (int i = 0; i < arrayHelp.getUnsortedArray().length; i++) {
                fout1.println(arrayHelp.getUnsortedArray()[i]);
                fout2.println(arrayHelp.getSortedArray()[i]);
            }

            // close writers
            fout1.close();
            fout2.close();
        }

        // exceptions
        catch(FileNotFoundException e) {
            throw e;
        }
        catch(IOException e) {
            throw e;
        }
    }

    // disable comboboxes
    public void disableComboboxes() {
        boxOfSizesOfArray.setEnabled(false);
        boxOfSortingMethods.setEnabled(false);
        boxOfSortingOrders.setEnabled(false);
    }
}

