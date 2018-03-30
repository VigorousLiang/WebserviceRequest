package com.vigorous.network.converter;

import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;
import com.vigorous.network.data.webservice.response.login.LoginRespBody;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.ElementException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
/**
 * Created by vigorousliang
 * Created on 2018/3/29
 */

public class XmlResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> cls;
    private final Serializer serializer;
    private final boolean strict;

    XmlResponseBodyConverter(Class<T> cls, Serializer serializer, boolean strict) {
        this.cls = cls;
        this.serializer = serializer;
        this.strict = strict;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        try {
            T read = serializer.read(cls, value.charStream(), strict);
            if (read == null) {
                throw new IllegalStateException("Could not deserialize body as " + cls);
            }
            return read;
        } catch (RuntimeException | IOException e) {
            throw e;
        } catch (ElementException e){
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            value.close();
        }
    }
}
