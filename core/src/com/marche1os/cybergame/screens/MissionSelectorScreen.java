package com.marche1os.cybergame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.marche1os.cybergame.CyberGame;
import com.marchelos.quest.MissionStore;
import com.marchelos.quest.mission.Mission;
import com.marchelos.quest.mission.MissionId;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MissionSelectorScreen extends BaseScreen {
    private Table table;

    public MissionSelectorScreen(CyberGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        showViews();
    }

    public void showViews() {
        final Skin skin = new Skin();
        final TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("images/images.pack"));
        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

        skin.addRegions(buttonAtlas);

        textButtonStyle.font = cyberGame.font;
        textButtonStyle.up = skin.getDrawable("button-up");
        textButtonStyle.down = skin.getDrawable("button-down");

        createAndPlaceButtons(textButtonStyle);

        stage.addActor(table);
    }

    private void createAndPlaceButtons(final TextButton.TextButtonStyle style) {
        table = new Table();
        table.setFillParent(true);

        MissionStore.Generator.INSTANCE.generate();
        final Map<MissionId, Mission> missions = MissionStore.INSTANCE.readAll();

        missions.forEach((missionId, mission) -> {
            final TextButton button = new TextButton("Миссия " + missionId.getValue(), style);
            addClickListener(button, missionId);

            table.add(button);
            table.row();
        });
    }

    private void addClickListener(final TextButton button, final MissionId missionId) {
        final ClickListener clickListener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                onMissionClick(missionId);
            }
        };

        button.addListener(clickListener);
    }

    private void onMissionClick(final MissionId missionId) {
        Logger.getGlobal().log(Level.INFO, "Clicked " + missionId.getValue());
        navigateTo(new HackingScreen(cyberGame, missionId));
    }
}
