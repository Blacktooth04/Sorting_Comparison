/*
 * Russell Lilljedahl
 * Sorting Algorithm Comparisons
 * 9 April 2018
 */
package sortingapplication;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Russell Lilljedahl
 */
public class GUI {
    
    static JFrame mainFrame;
    static JPanel mainPanel;
    static int dataSets;
    static boolean pressOn;
    

/* this screen will be shown on startup
*/
    public static void MainDisplay() {
        
        CreateData create = new CreateData();
        
        mainFrame = new JFrame("Sorting Comparisons");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // may change this later on
        mainFrame.setLocationRelativeTo(null); // Center the frame on the screen   
        mainFrame.setSize(500, 500);
        
        JPanel sortPanel = new JPanel(new FlowLayout());
        
        // sorting radio choices
        // bubble, insertion, selection, merge, shell, quick
        JPanel sortRadios = new JPanel(new GridLayout(4, 1));
        ButtonGroup radioGroup1 = new ButtonGroup();
        JRadioButton bubbleRadio = new JRadioButton("Bubble Sort");
        sortRadios.add(bubbleRadio);
        radioGroup1.add(bubbleRadio);
        bubbleRadio.setSelected(true);
        JRadioButton insertionRadio = new JRadioButton("Insertion Sort");
        sortRadios.add(insertionRadio);
        radioGroup1.add(insertionRadio);
        JRadioButton selectionRadio = new JRadioButton("Selection Sort");
        sortRadios.add(selectionRadio);
        radioGroup1.add(selectionRadio);
        JRadioButton shellRadio = new JRadioButton("Shell Sort");
        sortRadios.add(shellRadio);
        radioGroup1.add(shellRadio);
        sortPanel.add(sortRadios);

        // second set of sorting radio choices
        // bubble, insertion, selection, merge, shell, quick
        JPanel sortRadios2 = new JPanel(new GridLayout(4, 1));
        ButtonGroup radioGroup2 = new ButtonGroup();
        JRadioButton bubbleRadio2 = new JRadioButton("Bubble Sort");
        sortRadios2.add(bubbleRadio2);
        radioGroup2.add(bubbleRadio2);
        JRadioButton insertionRadio2 = new JRadioButton("Insertion Sort");
        sortRadios2.add(insertionRadio2);
        radioGroup2.add(insertionRadio2);
        insertionRadio2.setSelected(true);
        JRadioButton selectionRadio2 = new JRadioButton("Selection Sort");
        sortRadios2.add(selectionRadio2);
        radioGroup2.add(selectionRadio2);
        JRadioButton shellRadio2 = new JRadioButton("Shell Sort");
        sortRadios2.add(shellRadio2);
        radioGroup2.add(shellRadio2);
        sortPanel.add(sortRadios2);
                
        // panel for button
        // TODO maybe an input for data sets
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JLabel numberOfDataSetsLabel = new JLabel("Number of data sets:");
        JTextField numberOfDataSets = new JTextField(3);
        JButton clickToSort = new JButton("Click to Sort");
        buttonPanel.add(numberOfDataSetsLabel);
        buttonPanel.add(numberOfDataSets);
        buttonPanel.add(clickToSort);
        
        mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(sortPanel);
        mainPanel.add(buttonPanel);
        
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        
        // action listener for sort button
        clickToSort.addActionListener((ActionEvent ae) -> {

            String out1 = "", out2 = "";
            pressOn = true;

            if (bubbleRadio.isSelected()) {
                out1 = "bubble";
            } else if(insertionRadio.isSelected()){
                out1 = "insertion";
            } else if(selectionRadio.isSelected()){
                out1 = "selection";
            } else if(shellRadio.isSelected()){
                out1 = "shell";
            } else {
                // shouldn't happen since it has default selection
                JOptionPane.showMessageDialog(null, "Nothing from first column selected.");
                pressOn = false;
            }

            if (bubbleRadio2.isSelected()) {
                out2 = "bubble";
            } else if(insertionRadio2.isSelected()){
                out2 = "insertion";
            } else if(selectionRadio2.isSelected()){
                out2 = "selection";
            } else if(shellRadio2.isSelected()){
                out2 = "shell";
            } else {
                // shouldn't happen since it has default selection
                JOptionPane.showMessageDialog(null, "Nothing from second column selected.");
                pressOn = false;
            }

            // TODO need to get data set number, create the data sets, then
            // pass to appropriate sorts. 
            dataSets = Integer.parseInt(numberOfDataSets.getText());
            System.out.println("Comparing " + out1 + " and " + out2 + " with " + dataSets + " data sets.");

            // if anything set pressOn to false, do nothing
            if (pressOn) {

                // create the data
                create.CreateData(dataSets, out1, out2);

                mainPanel.setVisible(false);
                DisplayGUI(dataSets, out1, out2);
            }

        }); // end Search Button Action Listener    
    } // end main gui
    
    private static void DisplayGUI(int dataSets, String selection1, String selection2) {
        
        CreateData create = new CreateData();
        
        // add main panel, all other panels go here
        mainPanel = new JPanel(new GridLayout((dataSets + 3),1)); // 3 for information
        javax.swing.border.Border border = LineBorder.createBlackLineBorder();
        
        // create place to display calculations
        JPanel outputPanel = new JPanel(new GridLayout(1,3));
        JTextArea dataSet = new JTextArea("Data Set Size n");
        dataSet.setWrapStyleWord(true);
        dataSet.setLineWrap(true);
        dataSet.setBorder(border);
        JTextArea firstSelection = new JTextArea(selection1);
        firstSelection.setWrapStyleWord(true);
        firstSelection.setLineWrap(true);
        firstSelection.setBorder(border);
        JTextArea secondSelection = new JTextArea(selection2);
        secondSelection.setWrapStyleWord(true);
        secondSelection.setLineWrap(true);
        secondSelection.setBorder(border);
        outputPanel.add(dataSet);
        outputPanel.add(firstSelection);
        outputPanel.add(secondSelection);
        mainPanel.add(outputPanel);
        
        // more detailed parameters
        JPanel moreInfo = new JPanel(new GridLayout(1,3));
        JTextArea blank = new JTextArea();
        blank.setBorder(border);
        JTextArea avgTime1 = new JTextArea("Average execution time");
        avgTime1.setWrapStyleWord(true);
        avgTime1.setLineWrap(true);
        avgTime1.setBorder(border);
        JTextArea avgTime2 = new JTextArea("Average execution time");
        avgTime2.setWrapStyleWord(true);
        avgTime2.setLineWrap(true);
        avgTime2.setBorder(border);
        moreInfo.add(blank);
        moreInfo.add(avgTime1);
        moreInfo.add(avgTime2);
        mainPanel.add(moreInfo);             
        
        // completed data panel
        // get data first
        JPanel finalData = new JPanel(new GridLayout(1,3));
        JLabel dataSetSizeN = new JLabel();
        dataSetSizeN.setBorder(border);
        long aET1 = create.getExecutionTime1();
        JLabel avgET1 = new JLabel(String.valueOf(aET1) + " ns");
        avgET1.setBorder(border);
        long aET2 = create.getExecutionTime2();
        JLabel avgET2 = new JLabel(String.valueOf(aET2) + " ns");
        avgET2.setBorder(border);
        finalData.add(dataSetSizeN);
        finalData.add(avgET1);
        finalData.add(avgET2);
        mainPanel.add(finalData);        
        
        // now add datasets information
        // number of rows is equal to how many datasets are needed
        JPanel[] panel = new JPanel[dataSets]; // array of JPanels based upon data set size
        JLabel[] dataSetSizeLabel = new JLabel[dataSets]; // show data set size
        JLabel[] time1 = new JLabel[dataSets]; // to display the number of counts per data set
        JLabel[] time2 = new JLabel[dataSets];
        
        for (int i = 0; i < dataSets; i++) {
            panel[i] = new JPanel(new GridLayout(1,9));
            
            int value = create.getDataSetSize(i);
            dataSetSizeLabel[i] = new JLabel(String.valueOf(value));
            dataSetSizeLabel[i].setBorder(border);
            panel[i].add(dataSetSizeLabel[i]);
            
            long t1 = create.getTime1(i);
            time1[i] = new JLabel("Time: " + String.valueOf(t1));
            time1[i].setBorder(border);
            panel[i].add(time1[i]);
            
            long t2 = create.getTime2(i);
            time2[i] = new JLabel("Time: " + String.valueOf(t2));
            time2[i].setBorder(border);
            panel[i].add(time2[i]);
            
            mainPanel.add(panel[i]);
        } // end for loop        outputPanel.add(outputArea);
   
        JScrollPane scroll = new JScrollPane(mainPanel);
        mainFrame.add(scroll);
        mainFrame.setVisible(true);
        
    }
    
} // end GUI Class
