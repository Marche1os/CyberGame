package com.marche1os.cybergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.marche1os.cybergame.objects.BackgroundActor;
import com.marche1os.cybergame.screens.MainMenuScreen;
import com.marche1os.cybergame.screens.ShelterScreen;

public class CyberGame extends Game {
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    public BackgroundActor backgroundActor;

    public BitmapFont font;

    @Override
    public void create() {
        backgroundActor = new BackgroundActor();
        backgroundActor.setPosition(0, 0);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/russoone.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();

        param.size = Gdx.graphics.getHeight() / 18;
        param.characters = FONT_CHARACTERS;
        param.size = Gdx.graphics.getHeight() / 20;

        font = generator.generateFont(param);
        font.setColor(Color.WHITE);

        generator.dispose();

        setScreen(new MainMenuScreen(this));
    }

    public void navigateTo(final Screen screen) {
        setScreen(screen);
    }

    @Override
    public void render() {
        super.render();
    }
}
