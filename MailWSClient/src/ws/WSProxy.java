package ws;

public class WSProxy implements ws.WS {
  private String _endpoint = null;
  private ws.WS wS = null;
  
  public WSProxy() {
    _initWSProxy();
  }
  
  public WSProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSProxy();
  }
  
  private void _initWSProxy() {
    try {
      wS = (new ws.WSImpServiceLocator()).getWSImpPort();
      if (wS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS != null)
      ((javax.xml.rpc.Stub)wS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.WS getWS() {
    if (wS == null)
      _initWSProxy();
    return wS;
  }
  
  public int checkTime(java.util.Calendar clientTime) throws java.rmi.RemoteException{
    if (wS == null)
      _initWSProxy();
    return wS.checkTime(clientTime);
  }
  
  public boolean sendEmailBatch(java.lang.String[] arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (wS == null)
      _initWSProxy();
    return wS.sendEmailBatch(arg0, arg1);
  }
  
  public boolean sendEmail(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (wS == null)
      _initWSProxy();
    return wS.sendEmail(arg0, arg1);
  }
  
  public boolean validateEmailAddress(java.lang.String arg0) throws java.rmi.RemoteException{
    if (wS == null)
      _initWSProxy();
    return wS.validateEmailAddress(arg0);
  }
  
  
}