/**
 * WSImpService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface WSImpService extends javax.xml.rpc.Service {
    public java.lang.String getWSImpPortAddress();

    public ws.WS getWSImpPort() throws javax.xml.rpc.ServiceException;

    public ws.WS getWSImpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
