/**
 * WSImpServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class WSImpServiceLocator extends org.apache.axis.client.Service implements ws.WSImpService {

    public WSImpServiceLocator() {
    }


    public WSImpServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSImpServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSImpPort
    private java.lang.String WSImpPort_address = "http://localhost:8080/MailWebService/MailWS";

    public java.lang.String getWSImpPortAddress() {
        return WSImpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSImpPortWSDDServiceName = "WSImpPort";

    public java.lang.String getWSImpPortWSDDServiceName() {
        return WSImpPortWSDDServiceName;
    }

    public void setWSImpPortWSDDServiceName(java.lang.String name) {
        WSImpPortWSDDServiceName = name;
    }

    public ws.WS getWSImpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSImpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSImpPort(endpoint);
    }

    public ws.WS getWSImpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.WSImpPortBindingStub _stub = new ws.WSImpPortBindingStub(portAddress, this);
            _stub.setPortName(getWSImpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSImpPortEndpointAddress(java.lang.String address) {
        WSImpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.WS.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.WSImpPortBindingStub _stub = new ws.WSImpPortBindingStub(new java.net.URL(WSImpPort_address), this);
                _stub.setPortName(getWSImpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSImpPort".equals(inputPortName)) {
            return getWSImpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "WSImpService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "WSImpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSImpPort".equals(portName)) {
            setWSImpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
