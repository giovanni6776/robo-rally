package edu.chl.roborally.view;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.utilities.EventTram;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener, MouseListener{

    //Butons
    private JButton newGameButton;
    private JButton optionsButton;
    private JButton exitButton;
    private JButton chooseNbrOfPlayers;
    private JButton startGameBtn;
    private JButton chooseMapButton;

    private JLabel mapName;
    private JLabel mapDifficulty;
    private JLabel mapPlayers;
    private Button mapIcon;
    private JSpinner chooser;
    private JPanel mapInfo;

    private BufferedImage bi;

    private DefaultListModel<String> listModel;
    private JList<String> mapList;
    private ArrayList<GameBoard> maps;

    private int mapIndex;

    public StartPanel(){

        this.setLayout(null);

        try {
            bi = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
        }catch(java.io.IOException | NullPointerException e){
            System.out.println("Image could not be read");
        }

        JPanel buttonPanel= new StyledJPanel(new GridLayout(0,1,0,5));
        buttonPanel.setSize(200,200);
        newGameButton = new Button("start_btn.png", "start_btn_hover.png");
        newGameButton.addActionListener(this);
        optionsButton = new Button("options_btn.png","options_btn_hover.png");
        optionsButton.addActionListener(this);
        exitButton = new Button("exit_btn.png", "exit_btn_hover.png");
        exitButton.addActionListener(this);

        buttonPanel.add(newGameButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);
        buttonPanel.setLocation(400, 250);
    }

    public void nbrOfPlayers() {
        this.removeAll();
        JPanel nbrPanel= new StyledJPanel(new GridLayout(3,0));
        nbrPanel.setSize(200,200);
        nbrPanel.add(new JLabel("Choose Number of Players"));
        chooser = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        nbrPanel.add(chooser);
        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        nbrPanel.add(chooseNbrOfPlayers);
        this.add(nbrPanel);
        nbrPanel.setLocation(400,250);
        this.repaint();
        this.revalidate();
    }

    public void chooseMap(ArrayList<GameBoard> maps) {
        this.removeAll();
        this.maps=maps;
        JPanel mapChooser = new StyledJPanel(new GridLayout(1,2));
        mapChooser.setSize(400,200);

        //Create the List with maps
        JPanel listHolder = new JPanel(new BorderLayout());
        listHolder.setOpaque(false);
       // listHolder.setSize(100,400);

        listModel = new DefaultListModel<>();
        for (GameBoard map : maps) {
            listModel.addElement(map.getName());
        }

        JList<String> mapList = new JList<>(listModel);

        mapList.addMouseListener(this);

        listHolder.add(mapList);
        mapChooser.add(listHolder);

        //Create the mapInfo

        mapInfo = new JPanel(new FlowLayout());
        mapInfo.setOpaque(false);

        mapName = new JLabel(maps.get(mapIndex).getName());
        mapDifficulty = new JLabel(maps.get(mapIndex).getDifficulty());
        mapPlayers = new JLabel(maps.get(mapIndex).getNbrOfPlayers());
        mapIcon = new Button("dhuai");
        chooseMapButton = new JButton("Choose Map");
        chooseMapButton.addActionListener(this);


        mapInfo.add(mapName);
        mapInfo.add(mapDifficulty);
        mapInfo.add(mapPlayers);
        mapInfo.add(chooseMapButton);
        mapChooser.add(mapInfo);
        this.add(mapChooser);
        mapChooser.setLocation(300,250);

        repaint();
        revalidate();
    }

    public void summary(ArrayList<String> names, String mapName) {
        this.removeAll();
        JPanel sumPanel = new StyledJPanel(new GridLayout(5,0));
        sumPanel.setSize(200,200);
        sumPanel.add(new JLabel("We are now ready for this game!!!"));
        for (String s : names) {
            sumPanel.add(new JLabel(s));
        }
        sumPanel.add(new JLabel(mapName));
        startGameBtn = new Button("start_btn.png", "start_btn_hover.png");
        startGameBtn.addActionListener(this);
        sumPanel.add(startGameBtn);
        this.add(sumPanel);
        sumPanel.setLocation(400, 250);
        this.repaint();
        this.revalidate();
    }

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newGameButton)) {
            EventTram.getInstance().publish(EventTram.Event.SELECT_PLAYERS, null, null);
        } else if(e.getSource().equals(optionsButton)) {

        } else if (e.getSource().equals(exitButton)) {
            System.exit(1);
        } else if (e.getSource() == chooseNbrOfPlayers) {
            EventTram.getInstance().publish(EventTram.Event.SET_NBR_OF_ROBOTS, chooser.getValue(), null);

        } else if (e.getSource() == chooseMapButton) {
            EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapIndex, null);
        } else if (e.getSource() == startGameBtn) {
            EventTram.getInstance().publish(EventTram.Event.RUN_GAME, null, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JList list = (JList) e.getSource();
        if (e.getClickCount() == 1) {
            mapIndex = list.locationToIndex(e.getPoint());
            mapName.setText(maps.get(mapIndex).getName());
            mapDifficulty.setText(maps.get(mapIndex).getDifficulty());
            mapPlayers.setText(maps.get(mapIndex).getNbrOfPlayers());
            mapInfo.repaint();
            mapInfo.revalidate();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public class StyledJPanel extends JPanel {
        public StyledJPanel(LayoutManager layoutManager) {
            this.setLayout(layoutManager);
            this.setOpaque(true);
            this.setBackground(Color.DARK_GRAY);
            this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        }
    }
}
