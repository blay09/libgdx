package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.MathUtils;

public class TextureArrayAttribute extends Attribute {

	public TextureDescriptor<TextureArray> textureDescription = new TextureDescriptor<TextureArray>();
	public float offsetU;
	public float offsetV;
	public float scaleU = 1f;
	public float scaleV = 1f;
	public int uvIndex;

	public TextureArrayAttribute(long type) {
		super(type);
	}

	public TextureArrayAttribute(long type, TextureDescriptor<TextureArray> textureDescription) {
		this(type);
		this.textureDescription.set(textureDescription);
	}

	public TextureArrayAttribute(long type, TextureDescriptor<TextureArray> textureDescription, float offsetU, float offsetV, float scaleU, float scaleV, int uvIndex) {
		this(type, textureDescription);
		this.offsetU = offsetU;
		this.offsetV = offsetV;
		this.scaleU = scaleU;
		this.scaleV = scaleV;
		this.uvIndex = uvIndex;
	}

	public TextureArrayAttribute(long type, TextureArray texture) {
		this(type);
		textureDescription.texture = texture;
	}

	public TextureArrayAttribute(TextureArrayAttribute copyFrom) {
		this(copyFrom.type, copyFrom.textureDescription);
	}

	@Override
	public Attribute copy() {
		return new TextureArrayAttribute(this);
	}

	@Override
	public int compareTo(Attribute other) {
		if (type != other.type) return (type < other.type) ? -1 : 1;
		TextureArrayAttribute o = (TextureArrayAttribute) other;
		int c = textureDescription.compareTo(o.textureDescription);
		if (c != 0) return c;
		if (uvIndex != o.uvIndex) return uvIndex - o.uvIndex;
		if (!MathUtils.isEqual(scaleU, o.scaleU)) return (scaleU > o.scaleU) ? 1 : -1;
		if (!MathUtils.isEqual(scaleV, o.scaleV)) return (scaleV > o.scaleV) ? 1 : -1;
		if (!MathUtils.isEqual(offsetU, o.offsetU)) return (offsetU > o.offsetU) ? 1 : -1;
		if (!MathUtils.isEqual(offsetV, o.offsetV)) return (offsetV > o.offsetV) ? 1 : -1;
		return 0;
	}

	public static final String DiffuseAlias = "diffuseTextureArray";
	public static final long Diffuse = Attribute.register(DiffuseAlias);
	public static final String SpecularAlias = "specularTextureArray";
	public static final long Specular = Attribute.register(SpecularAlias);
	public static final String BumpAlias = "bumpTextureArray";
	public static final long Bump = Attribute.register(BumpAlias);
	public static final String NormalAlias = "normalTextureArray";
	public static final long Normal = Attribute.register(NormalAlias);
	public static final String AmbientAlias = "ambientTextureArray";
	public static final long Ambient = Attribute.register(AmbientAlias);
	public static final String EmissiveAlias = "emissiveTextureArray";
	public static final long Emissive = Attribute.register(EmissiveAlias);
	public static final String ReflectionAlias = "reflectionTextureArray";
	public static final long Reflection = Attribute.register(ReflectionAlias);

	public static TextureArrayAttribute createDiffuse(TextureArray texture) {
		return new TextureArrayAttribute(Diffuse, texture);
	}

	public static TextureArrayAttribute createSpecular(TextureArray texture) {
		return new TextureArrayAttribute(Specular, texture);
	}

	public static TextureArrayAttribute createNormal(TextureArray texture) {
		return new TextureArrayAttribute(Normal, texture);
	}

	public static TextureArrayAttribute createBump(TextureArray texture) {
		return new TextureArrayAttribute(Bump, texture);
	}

	public static TextureArrayAttribute createAmbient(TextureArray texture) {
		return new TextureArrayAttribute(Ambient, texture);
	}

	public static TextureArrayAttribute createEmissive(TextureArray texture) {
		return new TextureArrayAttribute(Emissive, texture);
	}

	public static TextureArrayAttribute createReflection(TextureArray texture) {
		return new TextureArrayAttribute(Reflection, texture);
	}

}
