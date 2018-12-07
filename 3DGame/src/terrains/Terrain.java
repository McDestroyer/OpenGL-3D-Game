package terrains;

import models.RawModel;
import renderEngine.Loader;
import textures.ModelTexture;

public class Terrain {
	
	private static final float SIZE = 800;
	private static final float VERTEX_COUNT = 128;
	
	private float x;
	private float z;
	private RawModel model;
	private ModelTexture texture;
	
	public Terrain(int gridX, int gridZ, Loader loader, ModelTexture texture) {
		this.texture = texture;
		this.x = gridX * SIZE;
		this.z = gridZ * SIZE;
		this.model = generateTerrain(loader);
	}
	
	
	
	public float getX() {
		return x;
	}



	public float getZ() {
		return z;
	}



	public RawModel getModel() {
		return model;
	}



	public ModelTexture getTexture() {
		return texture;
	}



	private RawModel generateTerrain(Loader loader) {
		int count = (int) (VERTEX_COUNT * VERTEX_COUNT);
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count * 2];
		int[] indices = new int[(int) (6 * (VERTEX_COUNT - 1) * (VERTEX_COUNT * 1))];
		int vertexPointer = 0;
		for(int i = 0; i < VERTEX_COUNT; i++) {
			for(int j = 0; j < VERTEX_COUNT; j++) {
				vertices[vertexPointer * 3] = -(float) j / ((float) VERTEX_COUNT - 1) * SIZE;
				vertices[vertexPointer * 3 + 1] = 0;;
				vertices[vertexPointer * 3 + 2] = -(float) i / ((float) VERTEX_COUNT - 1) * SIZE;
				normals[vertexPointer * 3] = 0;
				normals[vertexPointer * 3 + 1] = 1;
				normals[vertexPointer * 3 + 2] = 0;
				vertices[vertexPointer * 2] = -(float) j / ((float) VERTEX_COUNT - 1);
				vertices[vertexPointer * 2 + 1] = -(float) i / ((float) VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		return loader.loadToVAO(vertices, textureCoords, normals, indices);
	}

}
