package com.marche1os.cybergame.screens;

import static com.badlogic.gdx.Input.Keys.BACK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.marche1os.cybergame.CyberGame;

public class MainMenuScreen implements Screen {
    final CyberGame cyberGame;

    private Stage stage;
    private TextButton start, exit;
    private Table table;

    public MainMenuScreen(final CyberGame cyberGame) {
        this.cyberGame = cyberGame;

        stage = new Stage(new ScreenViewport());
        stage.addActor(cyberGame.backgroundActor);

        final Skin skin = new Skin();
        final TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("images/images.pack"));
        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

        skin.addRegions(buttonAtlas);

        textButtonStyle.font = cyberGame.font;
        textButtonStyle.up = skin.getDrawable("button-up");
        textButtonStyle.down = skin.getDrawable("button-down");
        textButtonStyle.checked = skin.getDrawable("button-up");

        createAndPlaceButtons(textButtonStyle);

        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(BACK, true);
    }

    private void createAndPlaceButtons(final TextButton.TextButtonStyle style) {
        initPlayScreen(style);
        initExitButton(style);

        table = new Table();
        table.setFillParent(true);
        table.add(start);
        table.row();
        table.add(exit);
    }

    private void initPlayScreen(final TextButton.TextButtonStyle style) {
        start = new TextButton("Начать игру", style);
        final ClickListener clickListener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                cyberGame.setScreen(new ShelterScreen(cyberGame));
            }
        };
        start.addListener(clickListener);
    }

    private void initExitButton(final TextButton.TextButtonStyle style) {
        exit = new TextButton("Выйти", style);
        final ClickListener clickListener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                dispose();
            }
        };
        exit.addListener(clickListener);
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
        stage.dispose();
        cyberGame.dispose();
    }
}
