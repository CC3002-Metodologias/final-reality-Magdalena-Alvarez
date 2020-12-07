package com.github.cc3002.finalreality.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyHandler implements PropertyChangeListener {

    private final GameController controller;

    public EnemyHandler(GameController controller) {
        this.controller = controller;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.deadEnemy();
    }
}
