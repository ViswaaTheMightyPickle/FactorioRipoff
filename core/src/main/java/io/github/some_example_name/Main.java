package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter
{

    Texture grassTexture;
    SpriteBatch batch;

    @Override
    public void create()
    {
        grassTexture = new Texture(("temp_grass_texture.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clearing the openGl buffer so we don't have weird smearing artefacts.
        //Let's begin drawing!
        batch.begin();
        batch.draw(grassTexture,0,0, 200, 200); //first we specify the texture, then the position.
        // then we specify the scale of the texture!
        batch.end();
    }

    @Override
    public void dispose()
    {
        grassTexture.dispose();
        batch.dispose();
    }
}
