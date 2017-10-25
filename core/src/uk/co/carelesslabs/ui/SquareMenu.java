package uk.co.carelesslabs.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import uk.co.carelesslabs.Media;
import java.util.ArrayList;

public class SquareMenu {
    public Menu menu;
    BuildMenu build;
    SettingsMenu SettingsScreen;

    public SquareMenu(){
        // MAIN MENU
        menu = new Menu(0, 0, 2, Media.squareMenu);
        //menu.addButtons(3, 2, 2, Media.pinkButton, 2);
        menu.addButton(3, 0, 0, Media.pauseButton, 2);
        menu.addButton(3, 0, 1, Media.settingsButton, 2);
        menu.addButton(3, 1, 0, Media.invButton, 2);
        menu.addButton(3, 1, 1, Media.quitButton, 2);
        menu.buttons.get(0).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(Button b) {
                        build.menu.toggleActive();
                    }
                });
        menu.buttons.get(1).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(Button b) {
                        menu.changeButton(1, 3, 0, 1, Media.pinkButton, 2);
                       // menu.buttons.remove(menu.buttons.get(1));
                        //menu.buttons = ArrayUtils.removeElement(menu.buttons, menu.buttons.get(1));
                    }
                });

        menu.buttons.get(2).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(Button b) {
                        System.out.println("Boop 2!");
                    }
                });

        menu.buttons.get(3).setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(Button b) {
                        // Maybe add a "are you sure" screen.
                        Gdx.app.exit();
                    }
                });


        LoadSettings();
        LoadInv();

    }

    private void LoadSettings(){
        // Settings
        SettingsScreen = new SettingsMenu();
        SettingsScreen.menu = new Menu(menu.pos.x + menu.width, 0, 2, Media.mainBack);
        SettingsScreen.menu.addButtons(3, 3, 2, Media.pinkButton, 2);
        SettingsScreen.menu.setInactive();
    }

    private void LoadInv(){
        // BUILDING
        build = new BuildMenu();
        build.menu = new Menu(menu.pos.x + menu.width, 0, 2, Media.mainBack);
        build.menu.addButtons(3, 14, 2, Media.pinkButton, 2);
        build.menu.setInactive();
    }

    public void draw(SpriteBatch batch){
        menu.draw(batch);
        build.menu.draw(batch);
    }

    public boolean checkClick(Vector2 pos, boolean processedClick) {
        return menu.checkClick(pos, processedClick);
    }
}