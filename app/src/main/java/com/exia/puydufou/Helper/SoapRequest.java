package com.exia.puydufou.Helper;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketTimeoutException;

public class SoapRequest
{
    //http://www.thomas-bayer.com/axis2/services/BLZService

    private SoapSerializationEnvelope _soapEnvelope = null;
    private HttpTransportSE _ht = null;

    public SoapRequest(String namespace, String methodName, String url)
    {
        SoapObject so = new SoapObject(namespace, methodName);

        _soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        _soapEnvelope.implicitTypes = true;
        _soapEnvelope.setAddAdornments(false);
        _soapEnvelope.setOutputSoapObject(so);

        _ht = new HttpTransportSE(Proxy.NO_PROXY, url, 5000);
        _ht.debug = true;
        _ht.setXmlVersionTag("<!--?xml version=\"1.0\" encoding= \"UTF-8\" ?-->");

    }

    public SoapObject SendRequest(String action)
    {
        try
        {
            _ht.call(action, _soapEnvelope);

            return (SoapObject)_soapEnvelope.getResponse();
        }
        catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
