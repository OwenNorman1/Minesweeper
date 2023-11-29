package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class SettingsScreen extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final int CELL_SIZE = 32;
    private final int N_ROWS = 16;
    private final int N_COLS = 16;
    private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
    private final int BOARD_HEIGHT = (N_ROWS+2) * CELL_SIZE + 1;
    private int minesChosen;
    private BufferedImage Settings;
	private Minesweeper ms;
	private Image[] sevenSegs;
	
	public SettingsScreen(Minesweeper ms, int minesChosen, String themeChosen) {
		this.ms=ms;
		this.minesChosen=minesChosen;
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		addMouseListener(new SettingsAdapter());
		try {
			Settings = ImageIO.read(getClass().getResourceAsStream("/Sprites/Theme"+ themeChosen +"/SettingsScreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		sevenSegs = new Image[10];
        for (int i = 0; i<10; i++) {
        	var path = "src/Sprites/SevenSegs/" + i + ".png";
            sevenSegs[i] = (new ImageIcon(path)).getImage().getScaledInstance(
            		16, 30, Image.SCALE_DEFAULT);
        }
		repaint();
	}
	
	@Override
    public void paintComponent(Graphics g) {
		g.drawImage(Settings, 0,0,this);
		int digit;
        int counting=minesChosen;
        for (int i = 0; i<3; i++) {
        	digit=counting%10;
        	g.drawImage(sevenSegs[digit], 305-(20*i), 209, this);
        	counting=counting/10;
        }
	}
	
	private class SettingsAdapter extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
            int y = e.getY();
            boolean doRepaint = false;
            if (x >= 452 && y >= 12 && x <= 500 && y <= 60) {
            	ms.leaveSetting(minesChosen);
            	return;
            }
            if (x >= 384 && y >= 200 && x <= 432 && y <= 248) {
            	if (minesChosen != 100) {
            		minesChosen++;
            		doRepaint=true;
            	}
            } 
            if (x >= 435 && y >= 200 && x <= 483 && y <= 248) {
            	if (minesChosen != 1) {
            		minesChosen--;
            		doRepaint=true;
            	}
            }
            if (doRepaint) {
            	repaint();
            }
		}
	}

}
