package com.marche1os.cybergame.stages;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PlayStage extends Stage {

    public PlayStage(ScreenViewport screenViewport) {
        super(screenViewport);
    }

    // Прослушивает события нажатия клавиш пользователем
    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACK) {
            if (getHardKeyListener() != null)
                getHardKeyListener().onHardKey(keyCode, 1);
        }
        return super.keyDown(keyCode);
    }

    @Override
    public boolean keyUp(int keyCode) {
        if (keyCode == Input.Keys.BACK){
            if (getHardKeyListener() != null)
                getHardKeyListener().onHardKey(keyCode, 0);
        }
        return super.keyUp(keyCode);
    }

    public interface OnHardKeyListener {
        public abstract void onHardKey(int keyCode, int state);
    }
    private OnHardKeyListener _HardKeyListener = null;
    public void setHardKeyListener(OnHardKeyListener HardKeyListener) {
        _HardKeyListener = HardKeyListener;
    }
    public OnHardKeyListener getHardKeyListener() {
        return _HardKeyListener;
    }
}
