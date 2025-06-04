package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter
{
    private static final int TILE_SIZE = 16;
    private static final int WORLD_WIDTH = 25;

    //orthographic tiled map

    Texture grassTexture;
    SpriteBatch batch;

    OrthographicCamera camera;

    @Override
    public void create()
    {
        grassTexture = new Texture(("temp_grass_texture.png"));
        batch = new SpriteBatch();

        camera = new OrthographicCamera(800, 600);
        camera.position.set(
            WORLD_WIDTH * TILE_SIZE / 2f,
            WORLD_WIDTH * TILE_SIZE / 2f,
            0
        );
        camera.update();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clearing the openGl buffer so we don't have weird smearing artefacts.
        //Let's begin drawing!

        HandleCameraMovement();

        batch.begin();

        float camLeft = camera.position.x - camera.viewportWidth / 2f;
        float camTop = camera.position.y + camera.viewportHeight / 2f;
        float camRight = camera.position.x + camera.viewportWidth / 2f;
        float camBottom = camera.position.y + camera.viewportHeight / 2f;

        batch.end();
    }

    private void HandleCameraMovement()
    {
        float deltaTime = Gdx.graphics.getDeltaTime();
        float speed = 50 * deltaTime;

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            camera.position.y += speed;
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            camera.position.y -= speed;
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            camera.position.x -= speed;
        if(Gdx.input.isKeyPressed(Input.Keys.D))
            camera.position.x += speed;

        camera.update();
    }

    @Override
    public void dispose()
    {
        grassTexture.dispose();
        batch.dispose();
    }
}
