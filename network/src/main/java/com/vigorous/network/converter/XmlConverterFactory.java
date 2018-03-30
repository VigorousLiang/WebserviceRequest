package com.vigorous.network.converter;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/**
 * Created by vigorousliang
 * Created on 2018/3/29
 */

/**
 * A {@linkplain Converter.Factory converter} which uses Simple Framework for XML.
 * <p>
 * This converter only applies for class types. Parameterized types (e.g., {@code List<Foo>}) are
 * not handled.
 */
public final class XmlConverterFactory extends Converter.Factory {
    /** Create an instance using a default {@link Persister} instance for conversion. */
    public static XmlConverterFactory create() {
        return create(new Persister());
    }

    /** Create an instance using {@code serializer} for conversion. */
    public static XmlConverterFactory create(Serializer serializer) {
        return new XmlConverterFactory(serializer, true);
    }

    /** Create an instance using a default {@link Persister} instance for non-strict conversion. */
    public static XmlConverterFactory createNonStrict() {
        return createNonStrict(new Persister());
    }

    /** Create an instance using {@code serializer} for non-strict conversion. */
    public static XmlConverterFactory createNonStrict(Serializer serializer) {
        return new XmlConverterFactory(serializer, false);
    }

    private final Serializer serializer;
    private final boolean strict;

    private XmlConverterFactory(Serializer serializer, boolean strict) {
        if (serializer == null) throw new NullPointerException("serializer == null");
        this.serializer = serializer;
        this.strict = strict;
    }

    public boolean isStrict() {
        return strict;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        Class<?> cls = (Class<?>) type;
        return new XmlResponseBodyConverter<>(cls, serializer, strict);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new XmlRequestBodyConverter<>(serializer);
    }
}
