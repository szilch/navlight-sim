package de.szilch.leuchtfeuer.logic;

import de.szilch.leuchtfeuer.model.api.NavLight;
import javafx.concurrent.Task;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Created by szilch on 08.09.16.
 * Executor that is implemented as {@link Task}.
 * It executes the configured {@link NavLight} by {@link #call()}
 */
public class NavLightExecutor extends Task<Boolean>{


    private Shape lightElement;

    private NavLight navLightModel;

    public NavLightExecutor(Shape lightElement, NavLight navLightModel) {
        this.lightElement = lightElement;
        this.navLightModel = navLightModel;
        lightElement.setFill(Paint.valueOf(navLightModel.getColor().getHexValue()));
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }

    @Override
    protected Boolean call() throws Exception {
        while (!isCancelled()) {
            navLightModel.getCharacter().forEach(lm -> {
                if (isCancelled()) {
                    return;
                }
                lightElement.setVisible(lm.isOn());
                try {
                    Thread.sleep(lm.getMillis());
                } catch (InterruptedException e) {
                    //interrupt is allowed here and will be fired inherited Task-Class
                }
            });
        }
        return true;
    }
}
