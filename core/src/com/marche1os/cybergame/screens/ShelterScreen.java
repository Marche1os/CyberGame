package com.marche1os.cybergame.screens;

import static com.badlogic.gdx.Input.Keys.BACK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.marche1os.cybergame.CyberGame;

public class ShelterScreen implements Screen {
    final CyberGame cyberGame;
    final Stage stage;

    public ShelterScreen(final CyberGame game) {
        cyberGame = game;
        stage = new Stage(new ScreenViewport());
        stage.addActor(cyberGame.backgroundActor);

        createTerminal();

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(BACK, true);
    }

    private void createTerminal() {
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
                cyberGame.setScreen(new MissionSelectorScreen(cyberGame));
            }
        });

        stage.addActor(terminalImage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
