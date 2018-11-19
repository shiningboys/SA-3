/**
 * WS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface WS extends java.rmi.Remote {
    public int checkTime(java.util.Calendar clientTime) throws java.rmi.RemoteException;
    public boolean sendEmailBatch(java.lang.String[] arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean sendEmail(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean validateEmailAddress(java.lang.String arg0) throws java.rmi.RemoteException;
}
