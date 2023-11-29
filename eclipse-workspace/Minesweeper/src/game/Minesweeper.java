package game;

import javax.swing.JFrame;

public class Minesweeper extends JFrame {
	private static final long serialVersionUID = 1L;
	private MenuScreen MenuScreen;
	private Board Board;
	private SettingsScreen Settings;
	private ThemesScreen Themes;
	private int MinesChosen = 40;
	private String currentTheme = "Classic";

    public Minesweeper() {
        MenuScreen = new MenuScreen(this, currentTheme);
        add(MenuScreen);
        setResizable(false);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void goToBoard() {
    	remove(MenuScreen);
    	Board = new Board(this, MinesChosen, currentTheme);
    	add(Board);
    	revalidate();
    }
    
    public void goToSettings() {
    	remove(MenuScreen);
    	Settings = new SettingsScreen(this, MinesChosen, currentTheme);
    	add(Settings);
    	revalidate();
    }
    
    public void goToThemes() {
    	remove(MenuScreen);
    	Themes = new ThemesScreen(this, currentTheme);
    	add(Themes);
    	revalidate();
    }
    
    public void leaveBoard() {
    	remove(Board);
    	MenuScreen = new MenuScreen(this, currentTheme);
    	add(MenuScreen);
    	revalidate();
    }
    
    public void leaveSetting(int MinesChosen) {
    	this.MinesChosen=MinesChosen;
    	remove(Settings);
    	MenuScreen = new MenuScreen(this, currentTheme);
    	add(MenuScreen);
    	revalidate();
    }
    
    public void leaveThemes(String currentTheme) {
    	this.currentTheme=currentTheme;
    	remove(Themes);
    	MenuScreen = new MenuScreen(this, currentTheme);
    	add(MenuScreen);
    	revalidate();
    }


    public static void main(String[] args) {
     	Minesweeper ms = new Minesweeper();
    	ms.setVisible(true);
    }
}
