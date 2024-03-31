package com.marche1os.cybergame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.marche1os.cybergame.CyberGame;
import com.marchelos.accessories.ShelterAccessories;

public class ShelterScreen extends BaseScreen {


    public ShelterScreen(final CyberGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        showViews();
    }

    private void showViews() {
        final Texture terminalTexture = new Texture("images/terminal.jpeg");
        final Image terminalImage = new Image(terminalTexture);

        terminalImage.setPosition((float) Gdx.graphics.getWidth() / 2, 180);
        terminalImage.setSize(220, 220);

        terminalImage.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                navigateTo(new MissionSelectorScreen(cyberGame));
            }
        });

        stage.addActor(terminalImage);
    }
}
