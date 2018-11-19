package ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * WebServiceʵ����
 * 
 * @author Johness
 * 
 */
@WebService(endpointInterface = "ws.WS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WSImp implements WS {

	@Override
	public int CheckTime(Date clientTime) {
		// ��ȷ����
		String dateServer = new java.sql.Date(System.currentTimeMillis()).toString() + " "
				+ new java.sql.Time(System.currentTimeMillis());
		String dateClient = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(clientTime);
		return dateServer.equals(dateClient) ? 1 : 0;
	}

	@Override
	public boolean sendEmail(String url, String body) {
		// TODO Auto-generated method stub
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIQqvnfwmJdMKX",
				"gXDgeiqTkyTimMco30TygotKJns9jo");
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		{
			try {
				request.setAccountName("mail.liji@liji.live");
				request.setFromAlias("LiJi");
				request.setAddressType(1);
				request.setTagName("����̨�����ı�ǩ");
				request.setReplyToAddress(true);
				request.setToAddress(url);
				// ���Ը�����ռ��˷����ʼ����ռ���֮���ö��ŷֿ����������Ž���ʹ��BatchSendMailRequest��ʽ
				// request.setToAddress("����1,����2");
				request.setSubject("Message");
				request.setHtmlBody(body);
				SingleSendMailResponse httpResponse = client.getAcsResponse(request);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean sendEmailBatch(String[] url, String body) {
		// TODO Auto-generated method stub
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIQqvnfwmJdMKX",
				"gXDgeiqTkyTimMco30TygotKJns9jo");
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		{
			try {
				request.setAccountName("mail.liji@liji.live");
				request.setFromAlias("LiJi");
				request.setAddressType(1);
				request.setTagName("����̨�����ı�ǩ");
				request.setReplyToAddress(true);
				int n = url.length;
				String urls = "";
				String a = null;
				for (int i = 0; i <n; i++) {
					if (i != n-1) {
						url[i]+=",";
					}
			    urls+=url[i];
				}
				
				request.setToAddress(urls);
				// ���Ը�����ռ��˷����ʼ����ռ���֮���ö��ŷֿ����������Ž���ʹ��BatchSendMailRequest��ʽ
				// request.setToAddress("����1,����2");
				request.setSubject("");
				request.setHtmlBody(body);
				SingleSendMailResponse httpResponse = client.getAcsResponse(request);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean validateEmailAddress(String url) {
		// TODO Auto-generated method stub
		String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		// ������ʽ��ģʽ ����������ʽ
		Pattern p = Pattern.compile(RULE_EMAIL);
		// ������ʽ��ƥ����
		Matcher m = p.matcher(url);
		// ��������ƥ��\
		return m.matches();

	}
}