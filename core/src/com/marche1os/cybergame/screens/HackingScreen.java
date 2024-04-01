package com.marche1os.cybergame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.marche1os.cybergame.CyberGame;
import com.marchelos.player.skill.Skill;
import com.marchelos.player.skill.SkillName;
import com.marchelos.quest.MissionStore;
import com.marchelos.quest.mission.Mission;
import com.marchelos.quest.mission.MissionId;

public class HackingScreen extends BaseScreen {
    private Label missionTitle;
    private Table table;
    private Mission mission;

    public HackingScreen(CyberGame game, final MissionId missionId) {
        super(game);
        mission = MissionStore.INSTANCE.readBy(missionId.getValue());
    }

    @Override
    public void show() {
        super.show();
        showViews();
    }

    public void showViews() {
        table = new Table();
        table.setFillParent(true);

        final Skin skin = new Skin();
        final TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("images/images.pack"));
        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

        skin.addRegions(buttonAtlas);

        textButtonStyle.font = cyberGame.font;
        textButtonStyle.up = skin.getDrawable("button-up");
        textButtonStyle.down = skin.getDrawable("button-down");

        showTitle();
        createAndPlaceButtons(textButtonStyle);
        createApplySkillButton(textButtonStyle);

        stage.addActor(table);
    }

    private void showTitle() {
        final Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = cyberGame.font;

        missionTitle = new Label("Миссия № " + mission.getAttrs().id(), labelStyle);
        table.add(missionTitle);

        mission.getAttrs().getTimer().addListener(value -> missionTitle.setText("Осталось секунд на взлом: " + value));
    }

    private void createAndPlaceButtons(final TextButton.TextButtonStyle style) {
        final TextButton startHacking = new TextButton("Начать взлом", style);
        table.row();
        table.add(startHacking);

        final ClickListener listener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Thread thread = new Thread(() -> mission.getAttrs().getTimer().startTimer());
                thread.start();
            }
        };

        startHacking.addListener(listener);
    }

    private void createApplySkillButton(final TextButton.TextButtonStyle style) {
        final Skill skill = hero.getSkillBy("ReduceTimeSkill");
        final String skillName = skill.name();
        final TextButton applySkillButton = new TextButton("Применить навык " + skillName, style);
        table.row();
        table.add(applySkillButton);

        final ClickListener listener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.input.vibrate(20);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                mission.applySkill(skill);
            }
        };

        applySkillButton.addListener(listener);
    }
}
