import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main implements ActionListener {
    // arrays
    final Integer[] sizesOfArray = {10, 100, 1000};
    final String[] namesOfSorters = {"Bubble Sort", "Selection Sort", "Quick Sort", "Merge Sort"};
    final String[] sortingOrders = {"Ascending", "Descending"};

    // border to use consistently
    final Border blackline = BorderFactory.createLineBorder(Color.black);

    // font of all the text
    final Font myFont = new Font("Times New Roman", Font.BOLD, 18);

    // buttons
    JButton startButton = new JButton();
    JButton resetButton = new JButton();
    JButton closeButton = new JButton();

    // comboxboxes
    JComboBox<Integer> boxOfSizesOfArray = new JComboBox<>(sizesOfArray);
    JComboBox<String> boxOfSortingMethods = new JComboBox<>(namesOfSorters);
    JComboBox<String> boxOfSortingOrders = new JComboBox<>(sortingOrders);

    // frame
    JFrame frame = new JFrame();

    // labels
    JLabel messSizeOfArray = new JLabel();
    JLabel messTypeOfSort = new JLabel();
    JLabel messSortingOrder = new JLabel();
    JLabel durationOfBubbleSort = new JLabel();
    JLabel durationOfSelectionSort = new JLabel();
    JLabel durationOfQuickSort = new JLabel();
    JLabel durationOfMergeSort = new JLabel();

    // panels
    JPanel optionPanel = new JPanel();
    JPanel durationPanel = new JPanel();
    JPanel arrayPanel = new JPanel();

    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    QuickSort quick = new QuickSort();

    public Main() {
        // set up frame - DONE
        frame.setTitle("Sorting Efficiency");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        // set up labels for the option panel - DONE
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

        // set up start button - DONE
        startButton.setFont(myFont);
        startButton.setBounds(150, 160, 100, 25);
        startButton.setText("Start");
        startButton.addActionListener(this);

        // set up reset button - DONE
        resetButton.setFont(myFont);
        resetButton.setBounds(70, 160, 100, 25);
        resetButton.setText("Reset");
        resetButton.addActionListener(this);

        // set up reset button - DONE
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
        durationPanel.setSize(400, 356);
        durationPanel.setLocation(2, 202);
        durationPanel.setBorder(blackline);
        durationPanel.setLayout(null);

        // basic setup of panel for arrays (unsorted and sorted)
        arrayPanel.setSize(796, 558);
        arrayPanel.setLocation(404, 0);
        arrayPanel.setBorder(blackline);

        // add components to the frame - DONE
        frame.add(optionPanel);
        frame.add(durationPanel);
        frame.add(arrayPanel);

        // make frame visible - DONE
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    // buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            disableComboboxes();

            proccedSorting();

            setupDurationPanel();

            optionPanel.repaint(); // update panel
            optionPanel.remove(startButton);
            optionPanel.add(resetButton);
            optionPanel.add(closeButton);
            
        }

        if (e.getSource() == resetButton) {
            frame.dispose();
            new Main();
        }

        if (e.getSource() == closeButton) {
            System.exit(0);
        }
    }

    // generate an array with random numbers - DONE
    public static int[] arrayGenerator(int size) {
        Random rd = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(20000) - 10000;
        }

        return arr;
    }

    // choose between sorting methods - DONE
    public int[] sort(int[] arr, String sorter, String order) {
        switch(sorter) {
            case "Bubble Sort":
                selection.sort(arr, order);
                quick.sort(arr, order);
                return bubble.sort(arr, order);
            case "Selection Sort":
                bubble.sort(arr, order);
                quick.sort(arr, order);
                return selection.sort(arr, order);
            case "Quick Sort":
                bubble.sort(arr, order);
                selection.sort(arr, order);
                return quick.sort(arr, order);
            default:
                bubble.sort(arr, order);
                selection.sort(arr, order);
                quick.sort(arr, order);
                return arr;
        }
    }

    // proceed the sorting
    public void proccedSorting() {
        // get the items from the comboboxes - DONE
        int arraySize = (int)boxOfSizesOfArray.getSelectedItem();
        String sorter = String.valueOf(boxOfSortingMethods.getSelectedItem());
        String sortOrder = String.valueOf(boxOfSortingOrders.getSelectedItem());

        // create an array - DONE
        int[] unsortedArr = arrayGenerator(arraySize);

        // sort the array - DONE
        int[] sortedArr = sort(unsortedArr, sorter, sortOrder);

        displayUnsortedArray(unsortedArr);
        displaySortedArray(sortedArr);
    }

    // add labels to duration panel
    public void setupDurationPanel() {
        // duration of bubble sort as output - DONE
        durationOfBubbleSort.setFont(myFont);
        durationOfBubbleSort.setText(bubble.stringForGUI());
        durationOfBubbleSort.setBounds(20, 20, 250, 90);
        
        // duration of selection sort as output - DONE
        durationOfSelectionSort.setFont(myFont);
        durationOfSelectionSort.setText(selection.stringForGUI());
        durationOfSelectionSort.setBounds(20, 100, 250, 90);

        // duration of quick sort as output - DONE
        durationOfQuickSort.setFont(myFont);
        durationOfQuickSort.setText(quick.stringForGUI());
        durationOfQuickSort.setBounds(20, 180, 250, 90);

        // TEMPORARY FOR MERGE SORT
        durationOfMergeSort.setFont(myFont);
        durationOfMergeSort.setText(bubble.stringForGUI()); // change bubble to merge
        durationOfMergeSort.setBounds(20, 260, 250, 90);

        durationPanel.repaint(); // update panel

        // add labels to the panel
        durationPanel.add(durationOfBubbleSort);
        durationPanel.add(durationOfSelectionSort);
        durationPanel.add(durationOfQuickSort);
        durationPanel.add(durationOfMergeSort);
    }

    // add unsorted array into panel
    public void displayUnsortedArray(int[] arr) {
        String s = "{";

        for (int i = 0; i < arr.length - 1; i++) {
            s += arr[i] + ", ";
        }
        s += arr[arr.length - 1] + "}";
        System.out.println(s);
    }

    // add sorted array into panel
    public void displaySortedArray(int[] arr) {
        String s = "{";

        for (int i = 0; i < arr.length - 1; i++) {
            s += arr[i] + ", ";
        }
        s += arr[arr.length - 1] + "}";
        System.out.println(s);
    }

    // disable comboboxes - DONE
    public void disableComboboxes() {
        boxOfSizesOfArray.setEnabled(false);
        boxOfSortingMethods.setEnabled(false);
        boxOfSortingOrders.setEnabled(false);
    }
}