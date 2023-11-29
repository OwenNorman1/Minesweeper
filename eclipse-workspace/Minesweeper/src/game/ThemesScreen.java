package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ThemesScreen extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final int CELL_SIZE = 32;
    private final int N_ROWS = 16;
    private final int N_COLS = 16;
    private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
    private final int BOARD_HEIGHT = (N_ROWS+2) * CELL_SIZE + 1;
    private BufferedImage Themes;
	private Minesweeper ms;
	private String currentTheme;

	public ThemesScreen(Minesweeper ms, String currentTheme) {
		this.ms=ms;
		this.currentTheme=currentTheme;
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		addMouseListener(new ThemesAdapter());
		try {
			Themes = ImageIO.read(getClass().getResourceAsStream("/Sprites/Theme"+currentTheme+"/ThemesScreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}  
		repaint();
	}
	
	@Override
    public void paintComponent(Graphics g) {
		try {
			Themes = ImageIO.read(getClass().getResourceAsStream("/Sprites/Theme"+currentTheme+"/ThemesScreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		g.drawImage(Themes, 0,0,this);
	}
	
	private class ThemesAdapter extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
            int y = e.getY();
            boolean doRepaint = false;
			if (x >= 452 && y >= 12 && x <= 500 && y <= 60) {
            	ms.leaveThemes(currentTheme);
            	return;
            }
			if (x >= 356 && y >= 99 && x <= 404 && y <= 147) {
				currentTheme = "Classic";
				doRepaint=true;
			}
			if (x >= 356 && y >= 173 && x <= 404 && y <= 221) {
				currentTheme = "Dark";
				doRepaint=true;
			}
			if (x >= 356 && y >= 247 && x <= 404 && y <= 295) {
				currentTheme = "Ice";
				doRepaint=true;
			}
			if (x >= 356 && y >= 321 && x <= 404 && y <= 369) {
				currentTheme = "Earth";
				doRepaint=true;
			}
			if (x >= 356 && y >= 395 && x <= 404 && y <= 443) {
				currentTheme = "Fire";
				doRepaint=true;
			}
			if (x >= 356 && y >= 469 && x <= 404 && y <= 517) {
				currentTheme = "Water";
				doRepaint=true;
			}
			if (doRepaint) {
				repaint();
			}
		}
	}
}
