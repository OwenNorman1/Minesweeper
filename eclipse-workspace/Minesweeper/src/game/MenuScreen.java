package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int CELL_SIZE = 32;
    private final int N_ROWS = 16;
    private final int N_COLS = 16;
    private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
    private final int BOARD_HEIGHT = (N_ROWS+2) * CELL_SIZE + 1;
    private BufferedImage Menu;
    private boolean started=false;
	private Minesweeper ms;
    
	public MenuScreen(Minesweeper ms, String ThemeChosen) {
		this.ms=ms;
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		addMouseListener(new MenuAdapter());
		try {
			Menu = ImageIO.read(getClass().getResourceAsStream("/Sprites/Theme"+ThemeChosen+"/MenuScreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}  
		repaint();
    }
	
	@Override
    public void paintComponent(Graphics g) {
		g.drawImage(Menu, 0,0,this);
	}
	
	public boolean getStarted() {
		return this.started;
	}
	
	private class MenuAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
        	int x = e.getX();
            int y = e.getY();
            if (x >= 86 && y >= 166 && x <= 426 && y <= 230) {
            	ms.goToBoard();
            	return;
            }
            if (x >= 86 && y >= 241 && x <= 426 && y <= 305) {
            	ms.goToSettings();
            	return;
            }
            if (x >= 86 && y >= 316 && x <= 426 && y <= 380) {
            	ms.goToThemes();
            	return;
            }
        }
    }
}
