package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter
{
    private static final int TILE_SIZE = 16;
    private static final int IN_WORLD_SIZE_PER_TILE = 25;

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
            IN_WORLD_SIZE_PER_TILE * TILE_SIZE / 2f,
            IN_WORLD_SIZE_PER_TILE * TILE_SIZE / 2f,
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
        //batch.draw(grassTexture,0,0, 200, 200); //first we specify the texture, then the position.
        // then we specify the scale of the texture!
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
