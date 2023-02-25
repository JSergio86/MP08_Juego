package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Player extends Actor {
    Rectangle bounds;
    AssetManager manager;
    float speedy, gravity;

    Player(){
        setX(200);
        setY(280 / 2 - 64 / 2);
        setSize(64,45);
        bounds = new Rectangle();
        speedy = 0;
        gravity = 850f;
    }

    @Override
    public void act(float delta) {
        // Obtiene la instancia de Input
        Input input = Gdx.input;

        // Verifica si se ha tocado la pantalla
        if (input.isTouched()) {
            // Obtiene la posición del toque
            float touchX = input.getX();
            float touchY = input.getY();

            // Convierte la posición del toque a unidades de juego
            float gameHeight = 800;
            float touchYInGame = touchY / Gdx.graphics.getHeight() * gameHeight;

            // Mueve la imagen del coche hacia arriba o hacia abajo
            if (touchYInGame < gameHeight / 2) {
                moveBy(0, 5);
            } else {
                moveBy(0, -5);
            }
        }

        // Actualiza la posición del jugador con la velocidad vertical
        bounds.set(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(manager.get("coche.png", Texture.class),
                getX(), getY());
    }

    void impulso() {
        speedy = 400f;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setManager(AssetManager manager) {
        this.manager = manager;
    }
}