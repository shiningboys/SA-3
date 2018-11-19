package ws;

import java.rmi.RemoteException;

public class client {
	public static void main(String[] args) throws RemoteException {
		WSProxy ws = new WSProxy();
		//ws.sendEmail("3233899303@qq.com","hh");
		String[] urls= {"3233899303@qq.com","1760079613@qq.com"};
		ws.sendEmailBatch(urls, "333");
	}
}
