
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import java.lang.Math.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NBDrawApp1 extends JFrame {

    // GUI Component dimentsions.
    private final int CANVAS_INITIAL_WIDTH = 800;
    private final int CANVAS_INITIAL_HEIGHT = 640;
    private final int CONTROL_PANEL_WIDTH = 200;
    private final int MESSAGE_AREA_HEIGHT = 100;
    private final int MAX_FREEHAND_PIXELS = 1000;
    private final int MAX_ITEMS = 10;

    private Color[] freehandColour = new Color[MAX_FREEHAND_PIXELS];
    private int[][] fxy = new int[MAX_FREEHAND_PIXELS][3];

    private Color[] rectanglecolour = new Color[MAX_ITEMS];
    private int[][] rec = new int[MAX_ITEMS][4];

    private Color[] ovalcolour = new Color[MAX_ITEMS];
    private int[][] oval = new int[MAX_ITEMS][4];

    private Color[] linecolour = new Color[MAX_ITEMS];
    private int[][] line = new int[MAX_ITEMS][4];

    private int freehandPixelsCount = 0;
    private int rectanglesCount = 0;
    private int ovalsCount = 0;
    private int linesCount = 0;
    private int x1;
    private int y1;
    private int y2;
    private int x2;
    
    Animate animator = new Animate();
    Timer animationTimer = new Timer(200, animator);

    // Drawing area class (inner class).
    class Canvas extends JPanel {

        // Called every time there is a change in the canvas contents.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
    } // end inner class Canvas

    //
    class Animate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
          for (int i = 0; i < ovalsCount; i++) {
          if(oval[i][3] <= canvas.getHeight())
          {    
            int speed = 10;
              oval[i][1] = oval[i][1] + speed ;
              oval[i][3] = oval[i][3] + speed ;
            
          }
          }
          //this piece of code makes the rectangle moves using the y - axis 
          //and makes the the animation stop at the bottom of the canvas using
          //the if statement <= the canvas hgeight
          for (int i = 0; i < rectanglesCount; i++) {
          if(rec[i][3] <= canvas.getHeight())
          {    
            int speed = 10;
              rec[i][1] = rec[i][1] + speed ;
              rec[i][3] = rec[i][3] + speed ;
            
          }
          }
            
            canvas.repaint();        
        }

    }
    
    class CanvasMouseMotionListener implements MouseMotionListener {

        public void mouseMoved(MouseEvent event) {
            String mouse = String.format("%04dpix, %04dpix", event.getX(), event.getY());
            coordinatesLabel.setText(mouse);

        }

        public void mouseDragged(MouseEvent event) {
            drawThings(event);
        }

    }
// draws the pixels on the canvas

    void drawThings(MouseEvent event) {
        //       lineRadioButton, ovalRadioButton, rectangleRadioButton, freehandRadioButton;
        
        if (freehandRadioButton.isSelected()) {
            freehandColour[freehandPixelsCount] = selectedColour;
            fxy[freehandPixelsCount][0] = event.getX();
            fxy[freehandPixelsCount][1] = event.getY();
            fxy[freehandPixelsCount][2] = freehandThickness;

            freehandPixelsCount++;
            System.out.println(freehandPixelsCount);
            messageArea.append("Ink Left: " + (MAX_FREEHAND_PIXELS - freehandPixelsCount) + "\n");
        }

        if (rectangleRadioButton.isSelected()) {
            rec[rectanglesCount][2] = event.getX();
            rec[rectanglesCount][3] = event.getY();
        }

        if (lineRadioButton.isSelected()) {
            line[linesCount][2] = event.getX();
            line[linesCount][3] = event.getY();
        }
        if (ovalRadioButton.isSelected()) {
            oval[ovalsCount][2] = event.getX();
            oval[ovalsCount][3] = event.getY();
        }

        canvas.repaint();
    }

    class CanvasMouseListener implements MouseListener {

        public void mousePressed(MouseEvent event) {
            animationTimer.stop();
            if (rectangleRadioButton.isSelected()) {
                rectanglecolour[rectanglesCount] = selectedColour;
                rec[rectanglesCount][0] = event.getX();
                rec[rectanglesCount][1] = event.getY();
                rec[rectanglesCount][2] = event.getX();
                rec[rectanglesCount][3] = event.getY();
            }

            if (lineRadioButton.isSelected()) {
                linecolour[linesCount] = selectedColour;
                line[linesCount][0] = event.getX();
                line[linesCount][1] = event.getY();
                line[linesCount][2] = event.getX();
                line[linesCount][3] = event.getY();
            }

            if (ovalRadioButton.isSelected()) {
                ovalcolour[ovalsCount] = selectedColour;
                oval[ovalsCount][0] = event.getX();
                oval[ovalsCount][1] = event.getY();
                oval[ovalsCount][2] = event.getX();
                oval[ovalsCount][3] = event.getY();
            }

            drawThings(event);

        }

        public void mouseReleased(MouseEvent event) {;
            if (rectangleRadioButton.isSelected()) {
                rec[rectanglesCount][2] = event.getX();
                rec[rectanglesCount][3] = event.getY();
                rectanglesCount++;
                System.out.println(rectanglesCount);
                messageArea.append("Rectangles Left: " + (MAX_ITEMS - rectanglesCount) + "\n");
            }

            if (lineRadioButton.isSelected()) {
                line[linesCount][2] = event.getX();
                line[linesCount][3] = event.getY();
                linesCount++;
                System.out.println(linesCount);
                messageArea.append("Lines Left: " + (MAX_ITEMS - linesCount) + "\n");
            }

            if (ovalRadioButton.isSelected()) {
                oval[ovalsCount][2] = event.getX();
                oval[ovalsCount][3] = event.getY();
                ovalsCount++;
                System.out.println(ovalsCount);
                messageArea.append("Ovals Left: " + (MAX_ITEMS - ovalsCount) + "\n");
            }

            canvas.repaint();
        }
        
        // Dont add code here.
        public void mouseClicked(MouseEvent event) {

        }
        public void mouseEntered(MouseEvent event) {

        }      
        public void mouseExited(MouseEvent event) {

        }
    }

    class ColorAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JColorChooser colourChooser = new JColorChooser(selectedColour);
            Color newColour = colourChooser.showDialog(null, "Choose new drawing colour", selectedColour);
            selectedColour = newColour;
            colourButton.setBackground(selectedColour);

        }
    }

    class AnimateButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            animationTimer.start();
        }
    }

    class Clear implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            animationTimer.stop();
            freehandPixelsCount = 0;
            linesCount = 0;
            ovalsCount = 0;
            rectanglesCount = 0;

            canvas.repaint();

        }
    }

    class MyCheckBoxesListener implements ChangeListener {

        public void stateChanged(ChangeEvent event) {
            animationTimer.stop();
            canvas.repaint();
        }
    }

    //freehandslider listner
    class FreehandSliderListener implements ChangeListener {

        public void stateChanged(ChangeEvent event) {
            freehandThickness = freehandSizeSlider.getValue();

            //System.out.println("I've been changed");
        }
    }

    class fileSaveMenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                FileOutputStream fos = new FileOutputStream("drawing");
                ObjectOutputStream fo = new ObjectOutputStream(fos);

                fo.writeObject(fxy);
                fo.writeObject(linecolour);
                fo.writeObject(linesCount);
                fo.writeObject(rec);
                fo.writeObject(rectanglecolour);
                fo.writeObject(rectanglesCount);
                fo.writeObject(oval);
                fo.writeObject(ovalcolour);
                fo.writeObject(ovalsCount);
                fo.writeObject(freehandColour);
                fo.writeObject(freehandPixelsCount);

                fo.close();

            } catch (IOException error) {
                System.out.println(error.toString());
            }
        }
    }

    //load action performed all draws load back or restored
    class fileLoadMenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                FileInputStream fis = new FileInputStream("drawing");
                ObjectInputStream fi = new ObjectInputStream(fis);

                fxy = (int[][]) fi.readObject();
                linecolour = (Color[]) fi.readObject();
                linesCount = (Integer) fi.readObject();
                rec = (int[][]) fi.readObject();
                rectanglecolour = (Color[]) fi.readObject();
                rectanglesCount = (Integer) fi.readObject();
                oval = (int[][]) fi.readObject();
                ovalcolour = (Color[]) fi.readObject();
                ovalsCount = (Integer) fi.readObject();
                freehandColour = (Color[]) fi.readObject();
                freehandPixelsCount = (Integer) fi.readObject();

                fi.close();

            } catch (IOException error) {
                System.out.println(error.toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NBDrawApp1.class.getName()).log(Level.SEVERE, null, ex);
            }
            canvas.repaint();
        }
    }

    //Exit listiner which closes the program
    class fileExitMenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    //Dialog message listiner
    class helpAboutMenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
                    canvas,
                    "Welcome to paint what ....", "Drawing Application", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private Canvas canvas;
    private JPanel controlPanel;
    private JLabel coordinatesLabel;
    private JRadioButton lineRadioButton, ovalRadioButton, rectangleRadioButton, freehandRadioButton;
    private JSlider freehandSizeSlider;
    private JCheckBox fineCheckBox, coarseCheckBox;
    private JButton colourButton, clearButton, animateButton;
    private int freehandThickness;
    private JTextArea messageArea;
    private Color selectedColour = new Color(0.0F, 0.0F, 0.0F);

    private JMenuBar menuBar;

    /**
     * ***************************************************************
     *
     * Constructor method starts here ... and goes on for quite a few lines of
     * code
     */
    public NBDrawApp1() throws IOException {

        setTitle("Drawing Application (da1)");
        setLayout(new BorderLayout());  // Layout manager for the frame.

        // Canvas
        canvas = new Canvas();
        canvas.setBorder(new TitledBorder(new EtchedBorder(), "Canvas"));
        canvas.setPreferredSize(new Dimension(CANVAS_INITIAL_WIDTH, CANVAS_INITIAL_HEIGHT));
        // next line changes the cursor's rendering whenever the mouse drifts onto the canvas
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        CanvasMouseMotionListener listenerObj = new CanvasMouseMotionListener();
        canvas.addMouseMotionListener(listenerObj);
        CanvasMouseListener listenerObj2 = new CanvasMouseListener();
        canvas.addMouseListener(listenerObj2);
        add(canvas, BorderLayout.CENTER);
        add(canvas, BorderLayout.CENTER);

        // Menu bar
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem fileSaveMenuItem = new JMenuItem("Save");
        fileSaveMenuItem.addActionListener(new fileSaveMenuItemListener());
        fileMenu.add(fileSaveMenuItem);

        JMenuItem fileLoadMenuItem = new JMenuItem("Load");
        fileMenu.add(fileLoadMenuItem);
        fileMenu.addSeparator();
        fileLoadMenuItem.addActionListener(new fileLoadMenuItemListener());
        fileMenu.add(fileLoadMenuItem);

        JMenuItem fileExitMenuItem = new JMenuItem("Exit");
        fileMenu.add(fileExitMenuItem);
        fileExitMenuItem.addActionListener(new fileExitMenuItemListener());
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpAboutMenuItem = new JMenuItem("About");
        helpMenu.add(helpAboutMenuItem);
        helpAboutMenuItem.addActionListener(new helpAboutMenuItemListener());
        menuBar.add(helpMenu);
        add(menuBar, BorderLayout.PAGE_START);

        // Control Panel
        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Control Panel"));
        controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, CANVAS_INITIAL_HEIGHT));
        // the following two lines put the control panel in a scroll pane (nicer?).      
        JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        controlPanelScrollPane.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH + 30, CANVAS_INITIAL_HEIGHT));
        add(controlPanelScrollPane, BorderLayout.LINE_START);

        // Control Panel contents are specified in the next section eg: 
        //    mouse coords panel; 
        //    shape tools panel; 
        //    trace-slider panel; 
        //    grid panel; 
        //    colour choice panel; 
        //    "clear" n "animate" buttons
        // Mouse Coordinates panel
        JPanel coordinatesPanel = new JPanel();
        coordinatesPanel.setBorder(new TitledBorder(new EtchedBorder(), "Drawing Position"));
        coordinatesPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 60));
        coordinatesLabel = new JLabel();
        coordinatesPanel.add(coordinatesLabel);
        controlPanel.add(coordinatesPanel);

        // Drawing tools panel
        JPanel drawingToolsPanel = new JPanel();
        drawingToolsPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 140));
        drawingToolsPanel.setLayout(new GridLayout(0, 1));
        drawingToolsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Drawing Tools"));
        ButtonGroup group = new ButtonGroup();
        freehandRadioButton = new JRadioButton("Freehand");
        freehandRadioButton.setSelected(true);
        rectangleRadioButton = new JRadioButton("Rectangle");
        lineRadioButton = new JRadioButton("Line");
        ovalRadioButton = new JRadioButton("Oval");
        group.add(freehandRadioButton);
        group.add(rectangleRadioButton);
        group.add(lineRadioButton);
        group.add(ovalRadioButton);
        drawingToolsPanel.add(freehandRadioButton);
        drawingToolsPanel.add(rectangleRadioButton);
        drawingToolsPanel.add(lineRadioButton);
        drawingToolsPanel.add(ovalRadioButton);
        controlPanel.add(drawingToolsPanel);

        // Freehand trace size slider
        JPanel freehandSliderPanel = new JPanel();
        freehandSliderPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 90));
        drawingToolsPanel.setLayout(new GridLayout(0, 1));
        freehandSliderPanel.setBorder(new TitledBorder(new EtchedBorder(), "Freehand Size"));
        controlPanel.add(freehandSliderPanel);

        freehandSizeSlider = new JSlider(0, 20, 1);
        freehandSizeSlider.setMajorTickSpacing(5);
        freehandSizeSlider.setMinorTickSpacing(1);
        freehandSizeSlider.setPaintTicks(true);
        freehandSizeSlider.setPaintLabels(true);
        freehandSizeSlider.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 30, 50));

        FreehandSliderListener listenerObj3 = new FreehandSliderListener();
        freehandSizeSlider.addChangeListener(listenerObj3);

        freehandSliderPanel.add(freehandSizeSlider);
        freehandThickness = freehandSizeSlider.getValue();

        // Grid Panel
        JPanel gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 80));
        gridPanel.setLayout(new GridLayout(0, 1));
        gridPanel.setBorder(new TitledBorder(new EtchedBorder(), "Grid"));
        fineCheckBox = new JCheckBox("Fine");
        gridPanel.add(fineCheckBox);
        fineCheckBox.addChangeListener(new MyCheckBoxesListener());
        coarseCheckBox = new JCheckBox("Coarse");
        gridPanel.add(coarseCheckBox);
        coarseCheckBox.addChangeListener(new MyCheckBoxesListener());
        controlPanel.add(gridPanel);

        // Colour Panel
        JPanel colourPanel = new JPanel();
        colourPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 90));
        colourPanel.setBorder(new TitledBorder(new EtchedBorder(), "Colour"));
        colourButton = new JButton();
        colourButton.setBackground(selectedColour);
        colourButton.setPreferredSize(new Dimension(50, 50));
        colourPanel.add(colourButton);
        controlPanel.add(colourPanel);
        ActionListener listenerObj4 = new ColorAction();
        colourButton.addActionListener(listenerObj4);

        // Clear button
        clearButton = new JButton("Clear Canvas");
        clearButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 50));
        clearButton.addActionListener(new Clear());
        controlPanel.add(clearButton);

        // Animate button 
        animateButton = new JButton("Animate");
        animateButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 50));
        animateButton.addActionListener(new AnimateButtonListener());
        controlPanel.add(animateButton);

        // that completes the control panel section
        // Message area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setBackground(canvas.getBackground());
        JScrollPane textAreaScrollPane = new JScrollPane(messageArea);
        textAreaScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Message Area"));
        textAreaScrollPane.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH + CANVAS_INITIAL_WIDTH, MESSAGE_AREA_HEIGHT));
        add(textAreaScrollPane, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);

    }  // end of the NBDrawApp1 constructor method

    // Called by the canvas' paintComponent method
    void draw(Graphics g) {

        int fine = 10;
        int Coarse = 50;

        int width = getSize().width;
        int height = getSize().height;
        int fg1 = width / (fine);
        // draw the rows

        if (fineCheckBox.isSelected()) {
            g.setColor(new Color(0.8F, 0.8F, 0.8F));
            for (int i = 0; i < fg1; i++) {
                g.drawLine(1, i * fine, width + 1, i * fine);
            }
            //draws cols
            g.setColor(new Color(0.8F, 0.8F, 0.8F));
            int fg = height / (Coarse);
            for (int i = 0; i < fg1; i++) {
                g.drawLine(i * fine, 9, i * fine, height);
            }
        }

        if (coarseCheckBox.isSelected()) {
            g.setColor(new Color(0.6F, 0.6F, 0.6F));
            for (int i = 0; i < fg1; i++) {
                g.drawLine(1, i * Coarse, width, i * Coarse);
            }

            //draws cols
            g.setColor(new Color(0.6F, 0.6F, 0.6F));
            for (int i = 0; i < fg1; i++) {
                g.drawLine(i * Coarse, 9, i * Coarse, height);
            }
        }
        // read about arrays multi dimes..

        // create actlistn for the clear canvas and set free hand pixel 0 then clear the act listner
        for (int i = 0; i < freehandPixelsCount; i++) {
            g.setColor(freehandColour[i]);
            g.fillRect(fxy[i][0], fxy[i][1], fxy[i][2], fxy[i][2]);
        }

        //draws rec
        for (int i = 0; i < rectanglesCount; i++) {
            g.setColor(rectanglecolour[i]);
            g.drawRect(rec[i][0],
                    rec[i][1],
                    rec[i][2] - rec[i][0],
                    rec[i][3] - rec[i][1]
            );
        }
        //draws line
        for (int i = 0; i < linesCount; i++) {
            g.setColor(linecolour[i]);
            g.drawLine(line[i][0],
                    line[i][1],
                    line[i][2],
                    line[i][3]
            );
        }
        for (int i = 0; i < ovalsCount; i++) {
            g.setColor(ovalcolour[i]);
            g.drawOval(oval[i][0],
                    oval[i][1],
                    oval[i][2] - oval[i][0],
                    oval[i][3] - oval[i][1]
            );
        }
//         g.drawOval(600, 100, 100, 100);
    } // end draw method   

    public static void main(String args[]) throws IOException {
        NBDrawApp1 NBDrawApp1Instance = new NBDrawApp1();
    } // end main method

} // end of NBDrawApp1 class
