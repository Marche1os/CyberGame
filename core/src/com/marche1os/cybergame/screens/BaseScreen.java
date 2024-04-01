package com.marche1os.cybergame.screens;

import static com.badlogic.gdx.Input.Keys.BACK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.marche1os.cybergame.CyberGame;
import com.marchelos.player.hero.Hero;
import com.marchelos.player.hero.HeroImpl;

import java.util.Stack;

public class BaseScreen implements Screen {
    public final CyberGame cyberGame;
    public final Stage stage;
    public final Hero hero;

    private static final Stack<Screen> screenStack = new Stack<>();

    public BaseScreen(final CyberGame game) {
        cyberGame = game;
        stage = new Stage(new ScreenViewport());
        hero = HeroImpl.Factory.create();
        addBackClickListener();
    }

    public void addBackClickListener() {
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == BACK && screenStack.size() > 1) {
                    screenStack.pop();
                    cyberGame.setScreen(screenStack.peek());
                    return true;
                }

                if (keycode == BACK) {
                    screenStack.clear();
                    Gdx.app.exit();
                    return true;
                }

                return false;
            }
        });
    }

    public void navigateTo(final Screen screen) {
        screenStack.add(screen);
        cyberGame.setScreen(screen);
    }

    @Override
    public void show() {
        stage.addActor(cyberGame.backgroundActor);
        handleInput();
    }

    protected void handleInput() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(BACK, true);
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
        stage.dispose();
        cyberGame.dispose();
    }
}
