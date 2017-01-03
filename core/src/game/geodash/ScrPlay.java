package game.geodash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static game.geodash.GamGeoDash.bPlayerDead;

/**
 * Created by hafiz on 12/13/2016.
 */

public class ScrPlay implements Screen {
    private GamGeoDash game;
    Map map;
    Player player;
    SpriteBatch batch;
    ContactListener1 contactListener;

    public ScrPlay(GamGeoDash game) {
        this.game = game;
        map = new Map("map.tmx", game.world);
        player = new Player(new Vector2(150, 200), 32, this.game.world, "geoDash.png");
        batch = game.batch;
        contactListener = new ContactListener1();
        this.game.world.setContactListener(contactListener);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(46/255f, 210/255f, 255/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        map.draw(game.camera);
        batch.begin();
        player.draw(batch);
        batch.end();
        batch.begin();
        player.draw(batch);
        batch.end();
        if (bPlayerDead == true) {
            player.reset();
            bPlayerDead = false;
        }
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
        map.getMap().dispose();
        map.getTiledMapRenderer().dispose();
    }
}
