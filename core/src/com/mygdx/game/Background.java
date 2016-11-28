package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by alex on 24.11.16.
 */
public class Background {
    class Star{                                     //Звезда
        private Vector2 position;
        private float speed;

        public Star(){
            speed = 1.0f + (float) Math.random() * 5.0f;        //делает скорость каждой звезды индивидуальной
            position = new Vector2((float)Math.random() * 1280, (float)Math.random() * 720);
        }

        public void update(){
            position.x -= speed;
            if(position.x < -40){
                position.x = 1300;
                position.y = (float)Math.random() * 720;
            }
        }
    }


    private Texture texture;
    private Texture textureStar;
    private final int STARS_COUNT = 100;
    private Star[] stars;

    public Background(){                            //Конструктор
        texture = new Texture("bg.png");
        textureStar = new Texture("star12.tga");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < STARS_COUNT; i++){
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch){          //Отрисовывает фон
        batch.draw(texture, 0, 0);
        for (int i = 0; i < STARS_COUNT; i++){
            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);
        }
    }

    public void update(){
        for (int i = 0; i < STARS_COUNT; i++){
            stars[i].update();
        }
    }

}
